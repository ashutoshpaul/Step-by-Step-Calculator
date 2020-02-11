import java.math.*;

import Equation.Node;

import javafx.application.Application;

import java.io.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.*;
import javafx.scene.effect.*;
import javafx.scene.control.Alert.AlertType;

import java.text.DateFormat;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import javafx.animation.TranslateTransition;

public class Equation {
	Node head = null;			//permanent (first node(header))
	Node tail = null;			//permanent (last node(tail))
	Node starting_pointer = null;	//temporary (points to '[({' opening)
	Node stoping_pointer = null;		//temporary (points to '])}' closing)
	
	Node symbol = null;				//points to +,-,*,/
	
	static int lineNum = 1;
	
	class Node {
		boolean isSymbol = false;
		double number = 0.0;
		
		char symbol = '\0';
		String function = null;		//sin(...) , cos(...) , log(...) etc.	isSymbol = true
		
		Node next = null;
		Node prev = null;
		
		boolean isActive = false;
		boolean isJustSolved = false;
		
		public Node(int number) {
			this.isSymbol = false;
			this.number = Double.parseDouble(Integer.toString(number));
		}
		public Node(double number) {
			this.isSymbol = false;
			this.number = number;
		}
		public Node(char symbol) {
			this.isSymbol = true;
			this.symbol = symbol;
		}
		public Node(String function) {
			this.isSymbol = true;
			this.function = function;
		}
	}
	
	public Equation addDigit(Equation equation , int number) {
		return add("digit" , equation , Integer.toString(number).trim());
	}
	public Equation addDouble(Equation equation , double number) {
		return add("double" , equation , Double.toString(number).trim());
	}
	public Equation addSymbol(Equation equation , char symbol) {
		return add("symbol" , equation , Character.toString(symbol).trim());
	}
	public Equation addFunction(Equation equation , String function) {
		return add("function" , equation , function.trim());
	}
	
	//add
	public Equation add(String type , Equation equation , String value) {
		Node new_node;
		if(type.equalsIgnoreCase("digit") == true) {
			new_node = new Node(Integer.parseInt(value));
		}else if(type.equalsIgnoreCase("double") == true) {
			new_node = new Node(Double.parseDouble(value));
		}else if(type.equalsIgnoreCase("symbol") == true) {
			new_node = new Node(value.charAt(0));
		}else {		//function
			new_node = new Node(value);
		}
		
		if(equation.head == null) {
			//first node
			equation.head = new_node;
			equation.starting_pointer = new_node;
			equation.symbol = new_node;
		}else {
			//add at the end
			Node curr = equation.head;
			while(curr.next != null) {
				curr = curr.next;
			}
			new_node.prev = curr;
			curr.next = new_node;
		}
		return equation;
	}
	
	//call this function, pass equation as parameter, and get the header of the equation linked list as return value
	public static Equation transformToNodes(String inputEquation) {
		inputEquation = "[" + inputEquation.trim()
										   .toLowerCase()
			     					       .replace(" " , "")
			     					       .concat("]");
		Equation eqn = new Equation();
		
		//send one by one
		int index = 0;
		String buffer = "";
		int numDot = 0;
		while(index < inputEquation.length()) {
			
			char ch = inputEquation.charAt(index);
			if(ch == 'π') {
				eqn = eqn.addFunction(eqn, "π"); //function
			}else if(Character.isDigit(ch) == true) {		//exception: log10()
				do {
					buffer += ch;
					ch = inputEquation.charAt(++index);
					if(Character.isDigit(ch) != true && ch != '.') {
						--index;
						break;
					}
					if(ch == '.') {
						numDot++;
						if(numDot > 1) {
							numDot = 0;
							try {
								Driver.solvedStatus.setText("ERROR");
								Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
								Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
										+ "Incorrect Number"
										+ "</span>";
								int errorGenerator = 10/0;
							}catch(Exception e) {}
							
						}
					}
				}while(true);
				
				if(buffer.contains(".") == true) {
					eqn = eqn.addDouble(eqn, Double.parseDouble(buffer.trim()));
				}else {
					eqn = eqn.addDigit(eqn, Integer.parseInt(buffer.trim()));
				}
			}else if(Character.isLetter(ch) == true) {		//including e (Exponential)
				do {
					buffer += ch;
					ch = inputEquation.charAt(++index);
					if(Character.isLetter(ch) != true) {
						--index;
						break;
					}
				}while(true);
				eqn = eqn.addFunction(eqn, buffer);
			}else if(ch == '√' || ch == '!' || ch == '^' || ch == '/' || ch == '%' || ch == '*' || ch == '+' || ch == '-') {
				buffer += ch;
				eqn = eqn.addSymbol(eqn, ch);
			}else if(ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}') {
				buffer += ch;
				eqn = eqn.addSymbol(eqn, ch);
			}
			buffer = "";
			numDot = 0;
			index++;
		}
		return eqn;
	}
	
	//print
	public void displayNodes(Equation eqn) {
		if(eqn.head == null) {
			//empty condition
		}else {
			if(eqn.head.next.next == eqn.tail) {
				Driver.entireContent += "<p>" + "     = " 
										 + "<span style=\"color:red;\" font-family: \"Ariel\";><b>"
										 + Double.toString(eqn.head.next.number) + " Ans.</b>"
										 + "</span><p>";
				
				Driver.numSteps.setText(this.lineNum + "");
				Driver.numSteps.setVisible(true);
				Driver.solvedStatus.setText("SOLVED");
				Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'darkgreen';");
				Driver.solvedStatus.setVisible(true);
				//Example: [45] Answer
				this.lineNum = 1;
				return;
			}
			
			Node curr = eqn.head.next;
			this.lineNum++;
			Driver.entireContent += "<p><span style=\"color:black,\" font-family: \"Ariel\";>      = </span>";
			
			while(curr != null) {
				
				if(curr.isSymbol == false) {
					
					//modify number
					int integer = (int)curr.number;
					if(curr.number == 0.0) {
						//zero value
						if(curr.prev.isSymbol == false && curr.isSymbol == false) {
							if(curr.number < 0) {
								if(curr.prev.isJustSolved != true)
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>- </span>";
								else {
									Driver.entireContent += "<span style=\"color:blue;\" font-family: \"Ariel\";>- </span>";
								}
								integer = integer * -1;
							}else {
								if(curr.prev.isJustSolved != true)
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>+ </span>";
								else {
									Driver.entireContent += "<span style=\"color:blue;\" font-family: \"Ariel\";>+ </span>";
								}
							}
						}
						if(curr.isJustSolved != true)
							Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>"
												+ Integer.toString(integer) + " "
												+ "</span>";
						else {
							curr.isJustSolved = false;
							Driver.entireContent += "<span style=\"color:blue;\" font-family: \"Ariel\";>"
									+ Integer.toString(integer) + " "
									+ "</span>";
						}
						
					}else if(curr.number % integer == 0) {
						//no decimal value
						if(curr.prev.isSymbol == false && curr.isSymbol == false) {
							if(curr.number < 0) {
								if(curr.isJustSolved != true)
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>- </span>";
								else {
									curr.isJustSolved = false;
									Driver.entireContent += "<span style=\"color:blue;\" font-family: \"Ariel\";>- </span>";
								}
								integer = integer * -1;
							}else {
								if(curr.isJustSolved != true)
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>+ </span>";
								else {
									curr.isJustSolved = false;
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>+ </span>";
								}
							}
						}
						Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>"
												+ Integer.toString(integer) + " "
												+ "</span>";
						
					}else {
						//decimal value
						if(curr.prev.isSymbol == false && curr.isSymbol == false) {
							if(curr.number < 0.0d) {
								if(curr.isJustSolved != true)
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>- </span>";
								else {
									curr.isJustSolved = false;
									Driver.entireContent += "<span style=\"color:blue;\">- </span>";
								}
							}else {
								if(curr.isJustSolved != true)
									Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>+ </span>";
								else {
									curr.isJustSolved = false;
									Driver.entireContent += "<span style=\"color:blue;\";>+ </span>";
								}
							}
						}
						double pseudoPositive = Double.parseDouble(Double.toString(curr.number).replace("-", ""));
						if(curr.isJustSolved != true)
							Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>"
												+ Double.toString(pseudoPositive) + " "
												+ "</span>";
						else {
							curr.isJustSolved = false;
							Driver.entireContent += "<span style=\"color:blue;\" font-family: \"Ariel\";>"
									+ Double.toString(pseudoPositive) + " "
									+ "</span>";
						}
					}
				}else {
					if(curr.symbol != '\0') {
						if(!(this.lineNum == 2 && curr.symbol == ']')) {
							Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>"
													+ curr.symbol + " "
													+ "</span>";
							
						}
					}else {
						Driver.entireContent += "<span style=\"color:black,\" font-family: \"Ariel\";>"
												+ curr.function + " "
												+ "</span>";
						
					}
				}
				
				curr.isActive = false;
				curr = curr.next;
				if(curr == eqn.tail)
					break;
			}
			Driver.entireContent += "</p>";
			
		}
	}
	
	//reassign
	public static Equation reassign(Equation complete_eqn , Node starting_pointer, Node stoping_pointer , double result) {
		if(starting_pointer.prev != null) {
			starting_pointer = starting_pointer.prev;
		}
		if(stoping_pointer.next != null) {
			stoping_pointer = stoping_pointer.next;
		}
		result = Double.parseDouble(Solver.format.format(result));
		
		Node new_node = complete_eqn.new Node(result);
		
		while(true) {
			if(starting_pointer != null) {
				if(starting_pointer.isSymbol == true) {
					if(starting_pointer.symbol == '\0'){
						
						result = Math.toRadians(result);
						if(starting_pointer.function.equalsIgnoreCase("sin")) {
							result = Math.sin(result);
						}else if(starting_pointer.function.equalsIgnoreCase("cos")) {
							result = Math.cos(result);
						}else if(starting_pointer.function.equalsIgnoreCase("tan")) {
							result = Math.tan(result);
						}else if(starting_pointer.function.equalsIgnoreCase("sec")) {
							result = 1/Math.sin(result);
						}else if(starting_pointer.function.equalsIgnoreCase("cosec")) {
							result = 1/Math.cos(result);
						}else if(starting_pointer.function.equalsIgnoreCase("cot")) {
							result = 1/Math.tan(result);
						}else if(starting_pointer.function.equalsIgnoreCase("log")) {
							result = Math.log(result);		//natural
						}else if(starting_pointer.function.equalsIgnoreCase("log10")) {
							result = Math.log10(result);	//base 10
						}
						result = Double.parseDouble(Solver.format.format(result));
						new_node.number = result;
						
						starting_pointer = starting_pointer.prev;
						break;
					}else {		//symbols(+,-,*,/ etc)
						break;
					}
				}else {			//number Example: 4() , 3() MULTIPLICATION
					new_node = complete_eqn.new Node('*');
					
					new_node.next = starting_pointer.next;
					starting_pointer.next.prev = new_node;
					new_node.prev = starting_pointer;
					starting_pointer.next = new_node;
					
					return complete_eqn;
				}
			}else {
				break;
			}
		}
		starting_pointer.next = new_node;
		new_node.prev = starting_pointer;
		stoping_pointer.prev = new_node;
		new_node.next = stoping_pointer;
		
		if(complete_eqn.head.next.next != complete_eqn.tail) {
			complete_eqn.displayNodes(complete_eqn);
		}
		return complete_eqn;
	}
	
}

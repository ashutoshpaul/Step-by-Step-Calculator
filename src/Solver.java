import java.text.DecimalFormat;
import java.util.Scanner;

public class Solver {
	
	public static DecimalFormat format;
	
	public static double solveAtom(Equation eqn , Equation.Node numOne , Equation.Node numTwo , Equation.Node symbol) throws NullPointerException {
		//Input Format: x + y
		//Output Format: Z Answer to SolveBlock
		
		numOne.isJustSolved = numTwo.isJustSolved = symbol.isJustSolved = true;
		
		double result = 0.0;
		double numberOne = 0.0;
		double numberTwo = 0.0;
		char sign = '\0';
		
		try {
			numberOne = Double.parseDouble(Double.toString(numOne.number));
			numberTwo = Double.parseDouble(Double.toString(numTwo.number));
			sign = symbol.symbol;
		}catch(Exception e) {
			Driver.solvedStatus.setText("ERROR");
			Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
			Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
					+ "Something went wrong!"
					+ "</span>";
			eqn.head = eqn.tail;
		}
		
		if(sign == '^') {
			result = Math.pow(numberOne, numberTwo);
		}else if(sign == '!') {
			double fact = 1.0;
			int i = (int)numberOne;
			boolean isNegative = false;
			if(i > 0 != true) {
				isNegative = true;
				i = Math.abs(i);
			}
			while(i >= 1) {
				fact *= i;
				i--;
			}
			if(isNegative == true) {
				fact *= -1;
			}
			result = fact;
		}else {
			switch(sign) {
			case '+':
				result = numberOne + numberTwo;
				break;
			case '-':
				result = numberOne - numberTwo;
				break;
			case '*':
				result = numberOne * numberTwo;
				break;
			case '/':
				result = numberOne / numberTwo;
				break;
			case '%':
				result = numberOne % numberTwo;
				break;
			default:
				Driver.solvedStatus.setText("ERROR");
				Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
				Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
						+ "Unknown symbol found: " + sign + " in Solver.solveAtom()."
						+ "</span>";
				eqn.head = eqn.tail;
			}
			
		}
		return result;
	}
	
	public static double solveBlock(Equation eqn , Equation.Node startingPointer , Equation.Node stopingPointer) throws NullPointerException {
		//Input Format: [x + y - i *v ^ q  / d]
		//Output Format: X Answer
		double result = 0.0;
		
		format = new DecimalFormat(".####");
		
		Equation.Node numOne = startingPointer;
		Equation.Node numTwo = startingPointer;
		Equation.Node symbol = startingPointer;
		
		Equation.Node temp = null;
		Equation.Node curr = startingPointer;
		
		//TODO convert PI, E
		boolean isPI_E = false;
		curr = startingPointer;
		while(curr != stopingPointer) {
			String characterE_PI = (curr.function == null)? null : curr.function;
			if(curr.isSymbol == true) {
				if(characterE_PI != null) {		//E or PI
					if(characterE_PI.equalsIgnoreCase("e")) {
						isPI_E = true;
						curr.number = Double.parseDouble(format.format(Math.E));
						curr.isSymbol = false;
						curr.symbol = '\0';
						curr.function = null;
						curr.isJustSolved = true;
					}else if(characterE_PI.equalsIgnoreCase("π")) {		//PI 'π'
						isPI_E = true;
						curr.number = Double.parseDouble(format.format(Math.PI));
						curr.isSymbol = false;
						curr.symbol = '\0';
						curr.function = null;
						curr.isJustSolved = true;
					}
					if(characterE_PI.equalsIgnoreCase("e") || characterE_PI.equalsIgnoreCase("π")) {
						if(curr.prev.isSymbol == false) {
							Equation.Node new_node = eqn.new Node('*');
							curr.prev.next = new_node;
							new_node.prev = curr.prev;
							curr.prev = new_node;
							new_node.next = curr;
							new_node.isJustSolved = true;
						}
					}
					
				}
			}
			curr = curr.next;
		}
		if(isPI_E == true) {
			isPI_E = false;
			eqn.displayNodes(eqn);
		}
		
		//making atomic
		curr = startingPointer;
		char sign = '\0';
		while(curr!= stopingPointer) {
			if(curr.isSymbol) {
				sign = curr.symbol;
				temp = curr.prev;
				curr = curr.next;
				if(temp != null && curr != null && curr.isSymbol == false) {
					if(curr.prev.symbol == '-' || curr.prev.symbol == '+') {
						if(sign == '-') {
							curr.number = -1 * curr.number;
						}
						temp.next = curr;
						curr.prev = temp;
					}
				}
				continue;
			}
			curr = curr.next;
		}
		
		//solving for square root
		curr = startingPointer;
		while(curr != stopingPointer) {
			if(curr.isSymbol == true) {
				if(curr.symbol == (char)8730) {			//'√'
					if(curr.next.isSymbol == true) {
						curr = curr.next;
						continue;
					}
					curr.next.number = Double.parseDouble(format.format(Math.sqrt(curr.next.number)));
					curr.next.isJustSolved = true;
					
					if(curr.prev.isSymbol == false) {
						Equation.Node new_node = eqn.new Node('*');
						curr.prev.next = new_node;
						new_node.prev = curr.prev;
						curr.prev = new_node;
						new_node.next = curr;
						new_node.isJustSolved = true;
					}
					
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
				}
			}
			curr = curr.next;
		}
		eqn.displayNodes(eqn);
		
		//solving according to BODMAS
		char[] array = {'!','^','/','*'};
		int pointer = 0;
		char pointingAt = '!';
		curr = startingPointer;
		while(curr != stopingPointer) {
			if(curr.isSymbol == true) {
				
				if(curr.symbol == '!') {
					numOne = curr.prev;
					symbol = curr;
					if(numOne == null || numOne.isSymbol == true) {
						Driver.solvedStatus.setText("ERROR");
						Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
						Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
								+ "Operand missing for factorial."
								+ "</span>";
						eqn.head = eqn.tail;
					}
					result = Solver.solveAtom(eqn, numOne, numOne, symbol);
					result = Double.parseDouble(format.format(result));
					Equation.Node new_node = eqn.new Node(result);
					
					if(numOne.prev != null && curr.next != null) {
						new_node.next = curr.next;
						curr.next.prev = new_node;
						new_node.prev = numOne.prev;
						numOne.prev.next = new_node;
					}
					
					eqn.displayNodes(eqn);
				}else {
					if(curr.symbol == pointingAt) {
						numOne = curr.prev;
						numTwo = curr.next;
						symbol = curr;
						if(numOne == null || numTwo == null || numOne.isSymbol == true || numTwo.isSymbol == true) {
							Driver.solvedStatus.setText("ERROR");
							Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
							Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
									+ "Operand(s) missing for " + pointingAt + "."
									+ "</span>";
							eqn.head = eqn.tail;
						}
						result = Solver.solveAtom(eqn, numOne, numTwo, symbol);
						result = Double.parseDouble(format.format(result));
						Equation.Node new_node = eqn.new Node(result);
						
						//eqn.displayNodes(eqn);
						
						curr = numTwo;
						new_node.next = curr.next;
						curr.next.prev = new_node;
						new_node.prev = numOne.prev;
						numOne.prev.next = new_node;
						
						eqn.displayNodes(eqn);
					}
				}
			}
			curr = curr.next;
			if(curr == stopingPointer) {
				if(pointer < array.length - 1) {
					pointingAt = array[++pointer];
					curr = startingPointer;
				}else {
					break;
				}
			}
		}
		
		//solving for not atomic +,-
		curr = startingPointer;
		while(curr != stopingPointer) {
			if(curr.isSymbol == true) {
				if(curr.symbol == '+' || curr.symbol == '-') {
					numOne = curr.prev;
					numTwo = curr.next;
					symbol = curr;
					if(numOne == null || numTwo == null || numOne.isSymbol == true || numTwo.isSymbol == true) {
						Driver.solvedStatus.setText("ERROR");
						Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
						Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
								+ "Cannot add number in +/-."
								+ "</span>";
						eqn.head = eqn.tail;
					}
					result = Solver.solveAtom(eqn, numOne, numTwo, symbol);
					result = Double.parseDouble(format.format(result));
					Equation.Node new_node = eqn.new Node(result);
					
					curr = numTwo;
					new_node.next = curr.next;
					curr.next.prev = new_node;
					new_node.prev = numOne.prev;
					numOne.prev.next = new_node;
					
					eqn.displayNodes(eqn);
				}
			}
			curr = curr.next;
		}
		
		//solve for +,-
		curr = startingPointer;
		while(curr != stopingPointer) {
			if(curr.isSymbol == false) {
				numOne = curr;
				numTwo = curr.next;
				if(numTwo != null && numTwo.isSymbol == false) {
					try {
						result = numOne.number + numTwo.number;
						
						result = Double.parseDouble(format.format(result));
						
						numTwo.number = result;
						
						numOne.prev.next = numTwo;
						numTwo.prev = numOne.prev;
						
						eqn.displayNodes(eqn);
					}catch(Exception e) {
						Driver.solvedStatus.setText("ERROR");
						Driver.solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'red';");
						Driver.entireContent += "<span style=\"color:red,\" font-family: \"Ariel\";>"
								+ "Cannot add numbers in +/-."
								+ "</span>";
						eqn.head = eqn.tail;
					}
				}
				else {		//only one operand left
					result = numOne.number;
					break;
				}
			}
			curr = curr.next;
		}
		return result;
	}
	
	public void solveTheEquation(Equation eqn) {
		//assigning
		eqn.starting_pointer = eqn.head;
		eqn.symbol = eqn.head;
		
		Equation.Node curr = eqn.head;
		while(curr.next != null) {
			curr = curr.next;
		}
		eqn.tail = curr;
		eqn.stoping_pointer = curr;
		
		//send brackets to inner loop to get solved
		curr = eqn.head;
		char openingType = '\0' , closingType = '\0';
		while(curr != null) {
			
			if(eqn.head == eqn.tail) {
				break;
			}else if(eqn.head.next.next == eqn.tail) {
				return;
			}
			
			if(curr.symbol == '[' || curr.symbol == '(' || curr.symbol == '{') {
				eqn.starting_pointer = curr;
				openingType = curr.symbol;
			}else if(curr.symbol == ']' || curr.symbol == ')' || curr.symbol == '}') {
				eqn.stoping_pointer = curr;
				closingType = curr.symbol;
				
				if((openingType == '[' && closingType == ']')||(openingType == '(' && closingType == ')')||(openingType == '{' && closingType == '}')) {
					
					eqn = Equation.reassign(eqn, eqn.starting_pointer, eqn.stoping_pointer , Solver.solveBlock(eqn , eqn.starting_pointer, eqn.stoping_pointer));
					openingType = closingType = '\0';
					curr = eqn.head;
					continue;
				}
			}
			curr = curr.next;
		}
	}
	
	public static void main(String args[]) {
		//'π','√'
		Scanner sc = new Scanner(System.in);
		String input = "(3+1)! +log(100)^(√(9e)+√(120 + 2π - 2* e) *45.9876543)+{√(10+6)- 6*3+15.7+[3^2]^2-(3)*1[7]-1-20/4 +150/5*10 + sin(45 + 25)}";
		
		input = "36+√(6-2)*100e+5π";
		
		Solver solve = new Solver();
		Equation eqn = Equation.transformToNodes(input);
		
		solve.solveTheEquation(eqn);
		
		
		
	}
}

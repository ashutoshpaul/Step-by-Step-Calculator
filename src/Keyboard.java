import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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


public class Keyboard {
	public Button num1 = new Button("1");
	public Button num2 = new Button("2");
	public Button num3 = new Button("3");
	public Button num4 = new Button("4");
	public Button num5 = new Button("5");
	public Button num6 = new Button("6");
	public Button num7 = new Button("7");
	public Button num8 = new Button("8");
	public Button num9 = new Button("9");
	public Button num0 = new Button("0");
	
	public Button dot = new Button(".");
	
	public Button sin = new Button("sin()");
	public Button cos = new Button("cos()");
	public Button tan = new Button("tan()");
	public Button sec = new Button("sec()");
	public Button cosec = new Button("cosec()");
	public Button cot = new Button("cot()");
	
	public Button log = new Button("log()");
	public Button log10 = new Button("log10()");
	
	public Button add = new Button("+");
	public Button sub = new Button("-");
	public Button mul = new Button("*");
	public Button mod = new Button("%");
	public Button div = new Button("/");
	
	public Button e = new Button("e");
	public Button pi = new Button("π");
	public Button sqrt = new Button("√");
	public Button fact = new Button("!");
	public Button pow = new Button("^");
	
	public Button openBracket = new Button("[");
	public Button openParenthesis = new Button("(");
	public Button openBraces = new Button("{");
	public Button closeBracket = new Button("]");
	public Button closeParenthesis = new Button(")");
	public Button closeBraces = new Button("}");
	
	public Button backspace = new Button("Backspace");
	public Button space = new Button("\t\tSpace\t\t");
	
	Button navigateKeyboard = new Button("⬇");
	AnchorPane keyboard = new AnchorPane();
	
	public Keyboard() {
		keyboard.setStyle("-fx-background-color: '#99b3ff';");
		keyboard.setPrefHeight(160.0);
		keyboard.setPrefWidth(2000.0);
		
		
		HBox box0 = new HBox();
		
		num1.setMaxWidth(300.0);
		HBox.setHgrow(num1, Priority.ALWAYS);
		num2.setMaxWidth(300.0);
		HBox.setHgrow(num2, Priority.ALWAYS);
		num3.setMaxWidth(300.0);
		HBox.setHgrow(num3, Priority.ALWAYS);
		num4.setMaxWidth(300.0);
		HBox.setHgrow(num4, Priority.ALWAYS);
		num5.setMaxWidth(300.0);
		HBox.setHgrow(num5, Priority.ALWAYS);
		num6.setMaxWidth(300.0);
		HBox.setHgrow(num6, Priority.ALWAYS);
		num7.setMaxWidth(300.0);
		HBox.setHgrow(num7, Priority.ALWAYS);
		num8.setMaxWidth(300.0);
		HBox.setHgrow(num8, Priority.ALWAYS);
		num9.setMaxWidth(300.0);
		HBox.setHgrow(num9, Priority.ALWAYS);
		num0.setMaxWidth(300.0);
		HBox.setHgrow(num0, Priority.ALWAYS);
		dot.setMaxWidth(300.0);
		HBox.setHgrow(dot, Priority.ALWAYS);
		navigateKeyboard.setMaxWidth(300.0);
		HBox.setHgrow(navigateKeyboard, Priority.ALWAYS);
		
		Button sep0 = getSepBtn();
		Button sep1 = getSepBtn();
		Button sep2 = getSepBtn();
		Button sep3 = getSepBtn();
		Button sep4 = getSepBtn();
		Button sep5 = getSepBtn();
		Button sep6 = getSepBtn();
		Button sep7 = getSepBtn();
		Button sep8 = getSepBtn();
		Button sep9 = getSepBtn();
		Button sep10 = getSepBtn();
		Button sep11 = getSepBtn();
		Button sep12 = getSepBtn();
		Button sep13 = getSepBtn();
		
		box0.getChildren().addAll(sep0 , num1 , sep2 , num2 , sep3 , num3 , sep4 , num4 , sep5 , num5 , 
						sep6 , num6 , sep7 , num7 , sep8 , num8 , sep9 , num9 , sep10 , num0 , 
						sep11 , dot , sep13 , navigateKeyboard , sep12);
		
		HBox box1 = new HBox();
		
		add.setMaxWidth(300.0);
		HBox.setHgrow(add, Priority.ALWAYS);
		sub.setMaxWidth(300.0);
		HBox.setHgrow(sub, Priority.ALWAYS);
		mul.setMaxWidth(300.0);
		HBox.setHgrow(mul, Priority.ALWAYS);
		div.setMaxWidth(300.0);
		HBox.setHgrow(div, Priority.ALWAYS);
		mod.setMaxWidth(300.0);
		HBox.setHgrow(mod, Priority.ALWAYS);
		e.setMaxWidth(300.0);
		HBox.setHgrow(e, Priority.ALWAYS);
		pi.setMaxWidth(300.0);
		HBox.setHgrow(pi, Priority.ALWAYS);
		sqrt.setMaxWidth(300.0);
		HBox.setHgrow(sqrt, Priority.ALWAYS);
		fact.setMaxWidth(300.0);
		HBox.setHgrow(fact, Priority.ALWAYS);
		pow.setMaxWidth(300.0);
		HBox.setHgrow(pow, Priority.ALWAYS);
		
		Button sep14 = getSepBtn();
		Button sep15 = getSepBtn();
		Button sep16 = getSepBtn();
		Button sep17 = getSepBtn();
		Button sep18 = getSepBtn();
		Button sep19 = getSepBtn();
		Button sep20 = getSepBtn();
		Button sep21 = getSepBtn();
		Button sep22 = getSepBtn();
		Button sep23 = getSepBtn();
		Button sep221 = getSepBtn();
		
		box1.getChildren().addAll(sep14 , add , sep15 , sub , sep16 , mul , sep17 , div , sep18 , mod , 
				sep19 , e , sep20 , pi , sep21 , sqrt , sep22 , pow , sep221 , fact , sep23);

		HBox box2 = new HBox();
		
		sin.setMaxWidth(300.0);
		HBox.setHgrow(sin, Priority.ALWAYS);
		cos.setMaxWidth(300.0);
		HBox.setHgrow(cos, Priority.ALWAYS);
		tan.setMaxWidth(300.0);
		HBox.setHgrow(tan, Priority.ALWAYS);
		sec.setMaxWidth(300.0);
		HBox.setHgrow(sec, Priority.ALWAYS);
		cosec.setMaxWidth(300.0);
		HBox.setHgrow(cosec, Priority.ALWAYS);
		cot.setMaxWidth(300.0);
		HBox.setHgrow(cot, Priority.ALWAYS);
		log.setMaxWidth(300.0);
		HBox.setHgrow(log, Priority.ALWAYS);
		log10.setMaxWidth(300.0);
		HBox.setHgrow(log10, Priority.ALWAYS);
		
		Button sep24 = getSepBtn();
		Button sep25 = getSepBtn();
		Button sep26 = getSepBtn();
		Button sep27 = getSepBtn();
		Button sep28 = getSepBtn();
		Button sep29 = getSepBtn();
		Button sep30 = getSepBtn();
		Button sep31 = getSepBtn();
		Button sep32 = getSepBtn();
		
		box2.getChildren().addAll(sep24 , sin , sep25 , cos , sep26 , tan , sep27 , sec , sep28 , cosec , 
				sep29 , cot , sep30 , log , sep31 , log10 , sep32);
		
		HBox box3 = new HBox();
		
		openBracket.setMaxWidth(300.0);
		HBox.setHgrow(openBracket, Priority.ALWAYS);
		openParenthesis.setMaxWidth(300.0);
		HBox.setHgrow(openParenthesis, Priority.ALWAYS);
		openBraces.setMaxWidth(300.0);
		HBox.setHgrow(openBraces, Priority.ALWAYS);
		closeBraces.setMaxWidth(300.0);
		HBox.setHgrow(closeBraces, Priority.ALWAYS);
		closeParenthesis.setMaxWidth(300.0);
		HBox.setHgrow(closeParenthesis, Priority.ALWAYS);
		closeBracket.setMaxWidth(300.0);
		HBox.setHgrow(closeBracket, Priority.ALWAYS);
		space.setMaxWidth(300.0);
		HBox.setHgrow(space, Priority.ALWAYS);
		backspace.setMaxWidth(300.0);
		HBox.setHgrow(backspace, Priority.ALWAYS);
		
		Button sep33 = getSepBtn();
		Button sep34 = getSepBtn();
		Button sep35 = getSepBtn();
		Button sep36 = getSepBtn();
		Button sep37 = getSepBtn();
		Button sep38 = getSepBtn();
		Button sep39 = getSepBtn();
		Button sep40 = getSepBtn();
		Button sep41 = getSepBtn();
		
		box3.getChildren().addAll(sep33 , openBraces , sep34 , openParenthesis , sep35 , 
					openBracket , sep36 , closeBracket , sep37 , closeParenthesis , 
				sep38 , closeBraces , sep39 , space , sep40 , backspace , sep41);
		
		//box0
		AnchorPane.setLeftAnchor(box0, 0.0);
		AnchorPane.setRightAnchor(box0, 0.0);
		AnchorPane.setBottomAnchor(box0, 10.0);
		//box1
		AnchorPane.setLeftAnchor(box1, 0.0);
		AnchorPane.setRightAnchor(box1, 0.0);
		AnchorPane.setBottomAnchor(box1, 35.0 + 9.0);
		//box2
		AnchorPane.setLeftAnchor(box2, 0.0);
		AnchorPane.setRightAnchor(box2, 0.0);
		AnchorPane.setBottomAnchor(box2, 60.0 + 9.0 * 2);
		//box3
		AnchorPane.setLeftAnchor(box3, 0.0);
		AnchorPane.setRightAnchor(box3, 0.0);
		AnchorPane.setBottomAnchor(box3, 85.0 + 9.0 * 3);
		
		keyboard.getChildren().addAll(box0 , box1 , box2 , box3);
		
		num1.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num2.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num3.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num4.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num5.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num6.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num7.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num8.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num9.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		num0.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		dot.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		
		sin.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		cos.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		tan.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		sec.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		cosec.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		cot.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		log.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		log10.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		
		add.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		sub.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		mul.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		div.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		mod.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		sqrt.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		pow.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		fact.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		e.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		pi.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		
		openBraces.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		openBracket.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		openParenthesis.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		closeBraces.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		closeBracket.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		closeParenthesis.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		
		space.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		backspace.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;");
		
		navigateKeyboard.setStyle("-fx-background-color: 'white';");
		
		num1.setOnMouseEntered(e -> num1.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num1.setOnMousePressed(e -> num1.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num1.setOnMouseReleased(e -> num1.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num1.setOnMouseExited(e -> num1.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num2.setOnMouseEntered(e -> num2.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num2.setOnMousePressed(e -> num2.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num2.setOnMouseReleased(e -> num2.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num2.setOnMouseExited(e -> num2.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num3.setOnMouseEntered(e -> num3.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num3.setOnMousePressed(e -> num3.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num3.setOnMouseReleased(e -> num3.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num3.setOnMouseExited(e -> num3.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num4.setOnMouseEntered(e -> num4.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num4.setOnMousePressed(e -> num4.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num4.setOnMouseReleased(e -> num4.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num4.setOnMouseExited(e -> num4.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num5.setOnMouseEntered(e -> num5.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num5.setOnMousePressed(e -> num5.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num5.setOnMouseReleased(e -> num5.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num5.setOnMouseExited(e -> num5.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num6.setOnMouseEntered(e -> num6.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num6.setOnMousePressed(e -> num6.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num6.setOnMouseReleased(e -> num6.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num6.setOnMouseExited(e -> num6.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num7.setOnMouseEntered(e -> num7.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num7.setOnMousePressed(e -> num7.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num7.setOnMouseReleased(e -> num7.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num7.setOnMouseExited(e -> num7.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num8.setOnMouseEntered(e -> num8.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num8.setOnMousePressed(e -> num8.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num8.setOnMouseReleased(e -> num8.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num8.setOnMouseExited(e -> num8.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num9.setOnMouseEntered(e -> num9.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num9.setOnMousePressed(e -> num9.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num9.setOnMouseReleased(e -> num9.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num9.setOnMouseExited(e -> num9.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num0.setOnMouseEntered(e -> num0.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num0.setOnMousePressed(e -> num0.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		num0.setOnMouseReleased(e -> num0.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		num0.setOnMouseExited(e -> num0.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		dot.setOnMouseEntered(e -> dot.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		dot.setOnMousePressed(e -> dot.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		dot.setOnMouseReleased(e -> dot.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		dot.setOnMouseExited(e -> dot.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		navigateKeyboard.setOnMouseEntered(e -> navigateKeyboard.setStyle("-fx-background-color: '#4d79ff';" + "-fx-font-weight: bold;" + "-fx-text-fill: 'white';"));
		navigateKeyboard.setOnMousePressed(e -> navigateKeyboard.setStyle("-fx-background-color: '#4d79ff';" + "-fx-font-weight: bold;" + "-fx-text-fill: 'white';"));
		navigateKeyboard.setOnMouseReleased(e -> navigateKeyboard.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;" + "-fx-text-fill: 'black';"));
		navigateKeyboard.setOnMouseExited(e -> navigateKeyboard.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;" + "-fx-text-fill: 'black';"));
		
		add.setOnMouseEntered(e -> add.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		add.setOnMousePressed(e -> add.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		add.setOnMouseReleased(e -> add.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		add.setOnMouseExited(e -> add.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		sub.setOnMouseEntered(e -> sub.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sub.setOnMousePressed(e -> sub.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sub.setOnMouseReleased(e -> sub.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		sub.setOnMouseExited(e -> sub.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		mul.setOnMouseEntered(e -> mul.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		mul.setOnMousePressed(e -> mul.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		mul.setOnMouseReleased(e -> mul.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		mul.setOnMouseExited(e -> mul.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		div.setOnMouseEntered(e -> div.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		div.setOnMousePressed(e -> div.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		div.setOnMouseReleased(e -> div.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		div.setOnMouseExited(e -> div.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		mod.setOnMouseEntered(e -> mod.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		mod.setOnMousePressed(e -> mod.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		mod.setOnMouseReleased(e -> mod.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		mod.setOnMouseExited(e -> mod.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		e.setOnMouseEntered(e -> this.e.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		e.setOnMousePressed(e -> this.e.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		e.setOnMouseReleased(e -> this.e.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		e.setOnMouseExited(e -> this.e.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		pi.setOnMouseEntered(e -> pi.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		pi.setOnMousePressed(e -> pi.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		pi.setOnMouseReleased(e -> pi.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		pi.setOnMouseExited(e -> pi.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		sqrt.setOnMouseEntered(e -> sqrt.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sqrt.setOnMousePressed(e -> sqrt.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sqrt.setOnMouseReleased(e -> sqrt.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		sqrt.setOnMouseExited(e -> sqrt.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		pow.setOnMouseEntered(e -> pow.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		pow.setOnMousePressed(e -> pow.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		pow.setOnMouseReleased(e -> pow.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		pow.setOnMouseExited(e -> pow.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		fact.setOnMouseEntered(e -> fact.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		fact.setOnMousePressed(e -> fact.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		fact.setOnMouseReleased(e -> fact.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		fact.setOnMouseExited(e -> fact.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		openBraces.setOnMouseEntered(e -> openBraces.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		openBraces.setOnMousePressed(e -> openBraces.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		openBraces.setOnMouseReleased(e -> openBraces.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		openBraces.setOnMouseExited(e -> openBraces.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		openParenthesis.setOnMouseEntered(e -> openParenthesis.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		openParenthesis.setOnMousePressed(e -> openParenthesis.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		openParenthesis.setOnMouseReleased(e -> openParenthesis.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		openParenthesis.setOnMouseExited(e -> openParenthesis.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		openBracket.setOnMouseEntered(e -> openBracket.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		openBracket.setOnMousePressed(e -> openBracket.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		openBracket.setOnMouseReleased(e -> openBracket.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		openBracket.setOnMouseExited(e -> openBracket.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		closeBraces.setOnMouseEntered(e -> closeBraces.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		closeBraces.setOnMousePressed(e -> closeBraces.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		closeBraces.setOnMouseReleased(e -> closeBraces.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		closeBraces.setOnMouseExited(e -> closeBraces.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		closeParenthesis.setOnMouseEntered(e -> closeParenthesis.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		closeParenthesis.setOnMousePressed(e -> closeParenthesis.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		closeParenthesis.setOnMouseReleased(e -> closeParenthesis.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		closeParenthesis.setOnMouseExited(e -> closeParenthesis.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		closeBracket.setOnMouseEntered(e -> closeBracket.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		closeBracket.setOnMousePressed(e -> closeBracket.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		closeBracket.setOnMouseReleased(e -> closeBracket.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		closeBracket.setOnMouseExited(e -> closeBracket.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		space.setOnMouseEntered(e -> space.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		space.setOnMousePressed(e -> space.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		space.setOnMouseReleased(e -> space.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		space.setOnMouseExited(e -> space.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		backspace.setOnMouseEntered(e -> backspace.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		backspace.setOnMousePressed(e -> backspace.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		backspace.setOnMouseReleased(e -> backspace.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		backspace.setOnMouseExited(e -> backspace.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		sin.setOnMouseEntered(e -> sin.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sin.setOnMousePressed(e -> sin.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sin.setOnMouseReleased(e -> sin.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		sin.setOnMouseExited(e -> sin.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		cos.setOnMouseEntered(e -> cos.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		cos.setOnMousePressed(e -> cos.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		cos.setOnMouseReleased(e -> cos.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		cos.setOnMouseExited(e -> cos.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		tan.setOnMouseEntered(e -> tan.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		tan.setOnMousePressed(e -> tan.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		tan.setOnMouseReleased(e -> tan.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		tan.setOnMouseExited(e -> tan.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		sec.setOnMouseEntered(e -> sec.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sec.setOnMousePressed(e -> sec.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		sec.setOnMouseReleased(e -> sec.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		sec.setOnMouseExited(e -> sec.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		cosec.setOnMouseEntered(e -> cosec.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		cosec.setOnMousePressed(e -> cosec.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		cosec.setOnMouseReleased(e -> cosec.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		cosec.setOnMouseExited(e -> cosec.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		cot.setOnMouseEntered(e -> cot.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		cot.setOnMousePressed(e -> cot.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		cot.setOnMouseReleased(e -> cot.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		cot.setOnMouseExited(e -> cot.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		log.setOnMouseEntered(e -> log.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		log.setOnMousePressed(e -> log.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		log.setOnMouseReleased(e -> log.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		log.setOnMouseExited(e -> log.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		log10.setOnMouseEntered(e -> log10.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		log10.setOnMousePressed(e -> log10.setStyle("-fx-background-color: '#d9d9d9';" + "-fx-font-weight: bold;"));
		log10.setOnMouseReleased(e -> log10.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		log10.setOnMouseExited(e -> log10.setStyle("-fx-background-color: 'white';" + "-fx-font-weight: bold;"));
		
		num1.setFocusTraversable(false);
		num2.setFocusTraversable(false);
		num3.setFocusTraversable(false);
		num4.setFocusTraversable(false);
		num5.setFocusTraversable(false);
		num6.setFocusTraversable(false);
		num7.setFocusTraversable(false);
		num8.setFocusTraversable(false);
		num9.setFocusTraversable(false);
		num0.setFocusTraversable(false);
		
		dot.setFocusTraversable(false);
		navigateKeyboard.setFocusTraversable(false);
		
		add.setFocusTraversable(false);
		sub.setFocusTraversable(false);
		mul.setFocusTraversable(false);
		div.setFocusTraversable(false);
		mod.setFocusTraversable(false);
		e.setFocusTraversable(false);
		pi.setFocusTraversable(false);
		sqrt.setFocusTraversable(false);
		pow.setFocusTraversable(false);
		fact.setFocusTraversable(false);
		
		sin.setFocusTraversable(false);
		cos.setFocusTraversable(false);
		tan.setFocusTraversable(false);
		sec.setFocusTraversable(false);
		cosec.setFocusTraversable(false);
		cot.setFocusTraversable(false);
		log.setFocusTraversable(false);
		log10.setFocusTraversable(false);
		
		openBracket.setFocusTraversable(false);
		openParenthesis.setFocusTraversable(false);
		openBraces.setFocusTraversable(false);
		closeBracket.setFocusTraversable(false);
		closeParenthesis.setFocusTraversable(false);
		closeBraces.setFocusTraversable(false);
		space.setFocusTraversable(false);
		backspace.setFocusTraversable(false);
		
		backspace.setFocusTraversable(false);
		backspace.setOnAction(e -> Driver.inputField.deletePreviousChar());
		

		num1.setOnAction(e -> keyPressed(num1 , "1"));
		num2.setOnAction(e -> keyPressed(num2 , "2"));
		num3.setOnAction(e -> keyPressed(num3 , "3"));
		num4.setOnAction(e -> keyPressed(num4 , "4"));
		num5.setOnAction(e -> keyPressed(num5 , "5"));
		num6.setOnAction(e -> keyPressed(num6 , "6"));
		num7.setOnAction(e -> keyPressed(num7 , "7"));
		num8.setOnAction(e -> keyPressed(num8 , "8"));
		num9.setOnAction(e -> keyPressed(num9 , "9"));
		num0.setOnAction(e -> keyPressed(num0 , "0"));
		
		dot.setOnAction(e -> keyPressed(dot , "."));
		add.setOnAction(e -> keyPressed(add , "+"));
		sub.setOnAction(e -> keyPressed(sub , "-"));
		mul.setOnAction(e -> keyPressed(mul , "*"));
		div.setOnAction(e -> keyPressed(div , "/"));
		mod.setOnAction(e -> keyPressed(mod , "%"));
		e.setOnAction(e -> keyPressed(this.e , "e"));
		pi.setOnAction(e -> keyPressed(pi , "π"));
		sqrt.setOnAction(e -> keyPressed(sqrt , "√"));
		pow.setOnAction(e -> keyPressed(pow , "^"));
		fact.setOnAction(e -> keyPressed(fact , "!"));
		
		sin.setOnAction(e -> keyPressed(sin , "sin()"));
		cos.setOnAction(e -> keyPressed(cos , "cos()"));
		tan.setOnAction(e -> keyPressed(tan , "tan()"));
		sec.setOnAction(e -> keyPressed(sec , "sec()"));
		cosec.setOnAction(e -> keyPressed(cosec , "cosec()"));
		cot.setOnAction(e -> keyPressed(cot , "cot()"));
		log.setOnAction(e -> keyPressed(log , "log()"));
		log10.setOnAction(e -> keyPressed(log10 , "log10()"));
		
		openBraces.setOnAction(e -> keyPressed(openBraces , "{"));
		openBracket.setOnAction(e -> keyPressed(openBracket , "["));
		openParenthesis.setOnAction(e -> keyPressed(openParenthesis , "("));
		closeBraces.setOnAction(e -> keyPressed(closeBraces , "}"));
		closeBracket.setOnAction(e -> keyPressed(closeBracket , "]"));
		closeParenthesis.setOnAction(e -> keyPressed(closeParenthesis , ")"));
		
		space.setOnAction(e -> keyPressed(space , " "));
	}
	
	public void keyPressed(Button btn , String key) {
		
            KeyEvent ke = new KeyEvent(KeyEvent.KEY_TYPED, key, "", KeyCode.UNDEFINED, false, false, false, false);
            Driver.inputField.fireEvent(ke);
            
            if(key.equalsIgnoreCase("sin()") ||key.equalsIgnoreCase("cos()") ||key.equalsIgnoreCase("tan()") ||key.equalsIgnoreCase("sec()") ||key.equalsIgnoreCase("cosec()") ||key.equalsIgnoreCase("cot()") ||key.equalsIgnoreCase("log()") ||key.equalsIgnoreCase("log10()")) {
            	Driver.inputField.deletePreviousChar();
            }
            
        
	}
	
	public static Button getSepBtn() {
		Button sep = new Button();
		sep.setOpacity(0.0);
		sep.setPrefWidth(15.0);
		return sep;
	}
	
	
}

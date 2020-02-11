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

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Driver extends Application{
    int width = 900;
	int height = 500;
	
	MenuItem clear = new MenuItem("Clear");
	MenuItem exit = new MenuItem("Exit");
	
	MenuItem about = new MenuItem("About the App");
	MenuItem howToUse = new MenuItem("How to use?");
	MenuItem developer = new MenuItem("Developer");
	
	Menu options = new Menu("File");
	Menu help = new Menu("Help");
	
	MenuBar menuBar = new MenuBar();
	
	static TextField inputField = new TextField();
	Button solve = new Button("Solve");
	Button clearBtn = new Button("Clear");
	
	static Label solvedStatus = new Label("EMPTY");
	static Label numSteps = new Label("0");
	
	Keyboard keyboard = new Keyboard();
	static VBox middle = new VBox();	//contains solutionLabel, scrollPane
	
	TranslateTransition showKeyboard = new TranslateTransition();
	
	static TextArea area = new TextArea();
	
	static WebView mainArea = new WebView();
	
	public Driver() throws Exception{
		options.getItems().addAll(clear , exit);
		help.getItems().addAll(about , howToUse , developer);
		menuBar.getMenus().addAll(options , help);
		
		inputField.setPromptText("Paste or write equation here");
		area.setStyle("-fx-font-size: 16px;" + "-fx-text-fill: 'black';");
		area.setEditable(false);
		solvedStatus.setVisible(false);
		numSteps.setVisible(false);
	}
	
	
	static String entireContent = "";
	String lineContent = "";
	
	@Override
	public void start(Stage s) throws Exception{
		menuBar.setStyle("-fx-background-color: '#4d79ff';");
		
		Button back = new Button();
		back.setStyle("-fx-background-color: '#99b3ff';");
		back.setPrefHeight(100.0);
		
		Button bottom = new Button();
		bottom.setStyle("-fx-background-color: '#b3c6ff';");
		bottom.setPrefHeight(50.0);
		
		solve.setPrefWidth(150.0);
		solve.setStyle("-fx-background-color: '#4d79ff';" + "-fx-font-weight: bold;" + "-fx-text-fill: 'white';");
		
		clearBtn.setPrefWidth(100.0);
		clearBtn.setStyle("-fx-background-color: '#3385ff';" + "-fx-font-weight: bold;" + "-fx-text-fill: 'white';");
		
		Label statusLabel = new Label("Status:");
		statusLabel.setStyle("-fx-font-size: 14px;");
		Label noOfSteps = new Label("Number of step(s):");
		noOfSteps.setStyle("-fx-font-size: 14px;");
		
		Label solutionLabel = new Label("        Solution");
		solutionLabel.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'green';");
		
		solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'blue';");
		numSteps.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;");
		
		AnchorPane white = new AnchorPane();
		white.setStyle("-fx-background-color: 'white';");
		white.setPrefHeight(35.0);
		white.getChildren().add(solutionLabel);
		
		AnchorPane.setTopAnchor(solutionLabel, 10.0);
		middle.getChildren().addAll(keyboard.keyboard , white);
		showKeyboard.setNode(middle);
		
		Solver solveClass = new Solver();
		solve.setOnAction(e -> {
			area.clear();
			numSteps.setText("");
			Equation.lineNum = 1;
			//mainArea.getEngine().loadContent("");
			entireContent = "";
			mainArea.getEngine().loadContent(entireContent);
			
			if(inputField.getText().equals("") == false) {
				solveClass.solveTheEquation(Equation.transformToNodes(inputField.getText().trim()));
				mainArea.getEngine().loadContent("");
				mainArea.getEngine().loadContent(entireContent);
			}
		});
		clearBtn.setOnAction(e -> {
			solvedStatus.setText("EMPTY");
			solvedStatus.setVisible(false);
			solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'blue';");
			numSteps.setText("0");
			numSteps.setVisible(false);
			mainArea.getEngine().loadContent("");
			entireContent = "<p>";
			lineContent = "";
			
			inputField.setText("");
			area.clear();
		});
		clear.setOnAction(e -> {
			solvedStatus.setText("EMPTY");
			solvedStatus.setVisible(false);
			solvedStatus.setStyle("-fx-font-size: 14.5px;" + "-fx-font-weight: bold;" + "-fx-text-fill: 'blue';");
			numSteps.setText("0");
			numSteps.setVisible(false);
			mainArea.getEngine().loadContent("");
			entireContent = "<p>";
			lineContent = "";
			
			inputField.setText("");
			area.clear();
		});
		exit.setOnAction(e -> System.exit(0));
		keyboard.navigateKeyboard.setOnAction(e -> {
			if(keyboard.navigateKeyboard.getText().equalsIgnoreCase("⬇")) {
				keyboard.navigateKeyboard.setText("⬆");			//move down (show)
				showKeyboard.setByY(100.0);
				keyboard.navigateKeyboard.setDisable(true);
				showKeyboard.play();
			}else {
				keyboard.navigateKeyboard.setText("⬇");		//move up (hide)
				showKeyboard.setByY(-100.0);
				keyboard.navigateKeyboard.setDisable(true);
				AnchorPane.setTopAnchor(mainArea, 180.0);
				showKeyboard.play();
			}
		});
		showKeyboard.setOnFinished(e -> {
			keyboard.navigateKeyboard.setDisable(false);
			if(keyboard.navigateKeyboard.getText().equalsIgnoreCase("⬆")) {
				AnchorPane.setTopAnchor(mainArea, 280.0);
			}
		});
		
		AnchorPane root = new AnchorPane();
		//back
		AnchorPane.setTopAnchor(back, 0.0);
		AnchorPane.setLeftAnchor(back, 0.0);
		AnchorPane.setRightAnchor(back, 0.0);
		//inputField
		AnchorPane.setTopAnchor(inputField, 50.0);
		AnchorPane.setLeftAnchor(inputField, 30.0);
		AnchorPane.setRightAnchor(inputField, 200.0);
		//solve
		AnchorPane.setTopAnchor(solve, 50.0);
		AnchorPane.setRightAnchor(solve, 30.0);
		//bottom
		AnchorPane.setLeftAnchor(bottom, 0.0);
		AnchorPane.setRightAnchor(bottom, 0.0);
		AnchorPane.setBottomAnchor(bottom, 0.0);
		//clearBtn
		AnchorPane.setRightAnchor(clearBtn, 20.0);
		AnchorPane.setBottomAnchor(clearBtn, 12.0);
		//statusLabel
		AnchorPane.setLeftAnchor(statusLabel, 15.0);
		AnchorPane.setBottomAnchor(statusLabel, 17.0);
		//noOfSteps
		AnchorPane.setLeftAnchor(noOfSteps, 400.0);
		AnchorPane.setBottomAnchor(noOfSteps, 17.0);
		//solvedStatus
		AnchorPane.setLeftAnchor(solvedStatus, 62.0);
		AnchorPane.setBottomAnchor(solvedStatus, 16.5);
		//numSteps
		AnchorPane.setLeftAnchor(numSteps, 520.0);
		AnchorPane.setBottomAnchor(numSteps, 16.5);
		//middle
		AnchorPane.setTopAnchor(middle, -18.0);
		AnchorPane.setLeftAnchor(middle, -3.0);
		AnchorPane.setRightAnchor(middle, -3.0);
		//mainArea
		AnchorPane.setTopAnchor(mainArea, 180.0);
		AnchorPane.setLeftAnchor(mainArea, 15.0);
		AnchorPane.setRightAnchor(mainArea, 0.0);
		AnchorPane.setBottomAnchor(mainArea, 50.0 + 10.0);
		
		root.getChildren().addAll(mainArea , middle , back , menuBar , inputField , solve  ,
					bottom , clearBtn , statusLabel , noOfSteps , solvedStatus , numSteps);
		
		
		Scene scene = new Scene(root , width , height);
		menuBar.setPrefWidth(5000.0);
		s.setTitle("Step By Step Calculator");
		s.setResizable(true);
		s.setMinHeight(450.0);
		s.setMinWidth(750.0);
		s.setScene(scene);
		s.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}

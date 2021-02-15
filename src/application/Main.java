package application;
import javafx.application.Application;
import javafx.event.*;
import static javafx.geometry.HPos.RIGHT;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.*; 


/**
 * Main Class which is responsible for the ship maps(one chosen randomly,
 * one specified by user input) initialization.
 * The UI for this part is the first Stage implemented below(FirstScene method).
 * @author KosPsych
 */
public class Main extends Application {
    	
public Stage PStage;	
TextField userTextField;
Initialization Enemy_obj;
Initialization Player_obj;

/**
 * Constraint Check
 * @author KosPsych
 * @param String int - input file specified by user(example : player_default)
 */
 public void Check(String in) {
	 
	 File file = new File("C:\\Users\\Lezz\\Javafxx\\BattleshipProj\\src\\application\\PlayerFiles\\"+in+".txt");
	 boolean IsValid;
	  try {
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  Player_obj = new Initialization ();
		  IsValid = Player_obj.contstraint_check(br);
		  Enemy_obj = new Initialization ();
		  br=Initialization.Choose_enemy();
		  Enemy_obj.contstraint_check(br);
		  
		  if (IsValid == true) {
			userTextField.clear();
			Game game_obj= new Game(Player_obj.ship_grid,Enemy_obj.ship_grid,Player_obj. GridInit(true),Enemy_obj. GridInit(false));
			game_obj.SecondScene(PStage); 
			  
		  }
		  } 
	  catch (FileNotFoundException e) {
		    AlertBox.display("FileNotFoundException","There is no such file");
			
		  }
	    	  
    }

 
 
	public void FirstScene(Stage primaryStage) {
		primaryStage.setTitle("MediaLab Battleship");
        BorderPane grid = new BorderPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        Text scenetitle = new Text("Welcome to Battleship");
        scenetitle.setId("welcome-text");
        BorderPane.setAlignment(scenetitle, Pos.CENTER);
        grid.setTop(scenetitle);
        GridPane middle = new GridPane();
        middle.setAlignment(Pos.CENTER);
        middle.setHgap(8);
        middle.setVgap(8);
        middle.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle2 = new Text("Insert board initialization filename");
        scenetitle2.setId("insert-text");
        middle.add(scenetitle2, 0, 0, 2, 1);
        userTextField = new TextField();
        middle.add(userTextField, 1, 1);
        Button btn = new Button("Start Game");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        btn.setOnAction(e -> {
        	Check(userTextField.getText());
		});

        Button btn2 = new Button("Exit Game");
        hbBtn.getChildren().add(btn2);
        middle.add(hbBtn, 1, 4);
        btn2.setOnAction(e -> primaryStage.close());
        Text insert = new Text("Insert board initialization filename");
        insert.setId("insert-text");
        grid.setCenter(middle);
        grid.setStyle("-fx-background-color: DarkGrey");
        Scene scene = new Scene(grid, 500, 300);        
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("Scene1.css").toExternalForm());
        primaryStage.show();
		
	}
	
	
    @Override
    public void start(Stage primaryStage) {
    	PStage=primaryStage;
    	FirstScene(primaryStage);
    }
    
 public static void main(String[] args) {
        launch(args);
    }
    
       

}
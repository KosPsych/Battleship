package application;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar	;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.Scene;
import java.util.List; 
import javafx.util.Pair;

/**
 * This class is responsible for the Battleship game after the initialization.
 * 
 * <p> For Testing purposes number of rounds can be changed using the int rounds variable 
 * @author KosPsych
 */

public class Game {
	
	public int[][] player_ship_grid = new int[10][10];  
	public int[][] computer_ship_grid = new int[10][10];  
	public double accuracy;
	public int accurate_hits=0;
	public int computer_accurate_hits=0;
	public int rounds=2,GoesFirst;    
	GridPane EnemyPane;
	GridPane PlayerPane;
	Button Hit,restart;	
	TextField InputCell ;
	Text roundsText;
	Text PointsText;
	Text EnemyPointsText,EnemyAliveships,EnemyAccuracy,UserAliveships,UserAccuracy;
	Button EnemyHit;	
	Stage SecondStage;
	public int [] EnemyHitResult=new int [2];
	Stage PStage;
	MenuItem EnemyShips,PlayerShots,EnemyShots,RestartItem,ExitItem;
	
	/**
	 * Class constructor.
	 * @author KosPsych
	 * @param player_ship_grid 
	 * @param computer_ship_grid
	 */
	public Game (int [][] player_ship_grid ,int [][] computer_ship_grid,GridPane PlayerPane,GridPane EnemyPane){
	    this.player_ship_grid=player_ship_grid;
	    this.computer_ship_grid=computer_ship_grid;
	    this.EnemyPane=EnemyPane;
        this.PlayerPane=PlayerPane;	    
	}
	
	/**
	 * UI for the Battleship game's second Stage.
	 * @author KosPsych
	 * @param PStage = Primary(First) Stage
	 * @see Stage 
	 */
	public void SecondScene(Stage PStage) {
		 PStage.close();
		 this.PStage=PStage;
		 SecondStage = new Stage();
		 SecondStage.setTitle("MediaLab Battleship");
		 HBox Top_Pane1 = new HBox(250);
         VBox Top_Pane2 = new VBox(15);
         VBox Top_Pane3 = new VBox(15);
         Top_Pane1.setPadding(new Insets(25, 25, 25, 25));
         
         PointsText = new Text("Your Points : 0");
	     PointsText.setId("user-top-text");
	     
	     UserAccuracy = new Text("Your Accuracy : 0.0 %");
	     UserAccuracy .setId("user-top-text");
	     
	     UserAliveships = new Text("Your ships alive : 5");
	     UserAliveships .setId("user-top-text");
	     
	     Top_Pane2.getChildren().add(PointsText);
	     Top_Pane2.getChildren().add(UserAccuracy);
	     Top_Pane2.getChildren().add(UserAliveships);
	     
	     EnemyPointsText = new Text("Enemy Points : 0");
	     EnemyPointsText .setId("enemy-top-text");
	     
	     EnemyAccuracy = new Text("Enemy Accuracy : 0.0 %");
	     EnemyAccuracy .setId("enemy-top-text");
	     
	     EnemyAliveships = new Text("Enemy ships alive : 5");
	     EnemyAliveships .setId("enemy-top-text");
	     
	     
	     Top_Pane3.getChildren().add(EnemyPointsText );
	     Top_Pane3.getChildren().add(EnemyAccuracy);
	     Top_Pane3.getChildren().add(EnemyAliveships);
	     
	     VBox Top_Pane4 = new VBox(15);
	     
		 Top_Pane1.getChildren().add(Top_Pane2);
		 Top_Pane1.getChildren().add(Top_Pane4);
		 Top_Pane1.getChildren().add(Top_Pane3);
		 
		 
	     GridPane Pane = new GridPane();
	     Pane .setAlignment(Pos.CENTER);
		 Pane .setHgap(8);
		 Pane .setVgap(8);
		 Pane .setPadding(new Insets(25, 25, 25, 25));
		 
	     Text Bottomtitle= new Text("Insert (X,Y) Cell to hit");
	     Bottomtitle.setId("bottom-text");
	     Pane.add(Bottomtitle, 0, 0, 2, 1);
	     InputCell = new TextField();
	     Pane.add(InputCell, 1, 1);
	     GridPane Pane2 = new GridPane();
	     Pane2 .setAlignment(Pos.CENTER);

	     Hit = new Button("Hit");
	     Hit.setId("hit");
	     
	     Pane2.add(Hit, 0, 0);
	     Pane.add(Pane2, 1, 3);
	     
	     VBox Pane3 = new VBox(15);
	     Pane3 .setPadding(new Insets(25, 25, 25, 25));
	     Pane3 .setAlignment(Pos.TOP_CENTER);
	     roundsText = new Text("Rounds : 0");
	     roundsText.setId("bottom-text");
	     Pane3.getChildren().add(roundsText);
	     EnemyHit = new Button("Enemy hit");
	     EnemyHit.setId("hit");
	     
	     Menu DetailsMenu = new Menu("Details");
	     EnemyShips = new MenuItem("Enemy ships");
	     PlayerShots = new MenuItem("Player shots");
	     EnemyShots = new MenuItem("Enemy shots");
	     DetailsMenu.getItems().add(EnemyShips);
	     DetailsMenu.getItems().add(PlayerShots);
	     DetailsMenu.getItems().add(EnemyShots);
	     
	     Menu ControlsMenu = new Menu("Controls");
	     RestartItem = new MenuItem("Restart");
	     ExitItem = new MenuItem("Exit");
	     ControlsMenu.getItems().add(RestartItem);
	     ControlsMenu.getItems().add(ExitItem );
	     
	     
	     RestartItem.setOnAction(e -> {
				SecondStage.close();
				PStage.show();			
			});
	     
	     ExitItem.setOnAction(e -> {
				SecondStage.close();
			});
	     
	     MenuBar mb = new MenuBar();
	     mb.getMenus().addAll(DetailsMenu);
	     mb.getMenus().addAll(ControlsMenu);
	     Pane3.getChildren().add(mb);
	     Pane3.getChildren().add(EnemyHit);
	     
		 BorderPane BPane = new BorderPane();
		 BPane.setStyle("-fx-background-color: DarkGrey");
		 BPane.setTop(Top_Pane1);
		 BPane.setRight(EnemyPane);
		 BPane.setLeft(PlayerPane);
		 BPane.setBottom(Pane);
		 BPane.setCenter(Pane3);
	     Scene scene2 = new Scene(BPane,1000,600);
	     SecondStage.setScene(scene2);
	     scene2.getStylesheets().add(Main.class.getResource("Scene2.css").toExternalForm());
	     SecondStage.show();
		 Battleship_Game();
		   
	 }
	
	/**
	 * Getter for a cell in a ship map.
	 * @author KosPsych
	 * @param gridPane = ship map
	 * @param col = column variable
	 * @param row = row variable
	 * @return Node cell = return the cell specified by (col,row) from the Ship Map
	 * @see GridPane
	 */

	public Node getCell(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	            return node;
	        }
	    }
	    return null;
	}
	
	
	/**
	 * Check if the game has ended.
	 * 
	 * <p>The game has ended if all 40 rounds are spent or if the 
	 * user or the computer has  reached 5200 points,which is the
	 * maximum possible after sinking all ships.
	 * 
	 * @author KosPsych
	 * @param enemy = Enemy class Object
	 * @param player = Player class Object
	 * @see Enemy
	 * @see Player
	 */
	
	public void CheckEnd(Enemy enemy,Player player) {
		
		if(rounds==1 ||enemy.points==5200 || player.points==5200) {
			SecondStage.close();
			if(player.points > enemy.points) {
				End end = new End("won");
				end.endscene(PStage);	
			}
			else if(player.points < enemy.points){
				End end = new End("lost");
				end.endscene(PStage);
			    }
			else {
				End end = new End("draw");
				end.endscene(PStage);
				
			}
			
			}	
       }
	
	/**
	 * Backend method for the  Battleship game .
	 * 
	 * <p>This method implements the switch between computer
	 * and user moves during the battleship game. 
	 * 
	 * <p>This method randomly chooses who goes first either a computer.
	 * After,depending on which button is hit it performs the user or 
	 * computer hit action updating their statistics and displaying 
	 * them on the UI.
	 * 
	 * @author KosPsych
	 * @throws Exception
	 * @see Enemy
	 * @see Player
	 */
	
	public void Battleship_Game() {

		Player player = new Player(computer_ship_grid);
		Enemy enemy = new Enemy(player_ship_grid);
		
		Random rand = new Random();
		List<Pair> PlayerQueue  = new LimitedQueue<>(5);
		GoesFirst = rand.nextInt(2);
		if(GoesFirst==1) {
			EnemyHit.setDisable(true);
		}
		else {
			Hit.setDisable(true);
			
		}
		EnemyHit.setOnAction(e -> {
			enemy.move();
			Node hit= getCell(PlayerPane,enemy.result[1],enemy.result[0]);
			Button hit2= (Button) hit;
			if(player_ship_grid[enemy.result[0]][enemy.result[1]]!=0) {
				hit2.setStyle("-fx-background-color:red");
				computer_accurate_hits +=1;
			}
			else {
				hit2.setStyle("-fx-background-color:black");
			}
			
			String Concat1= "Your ships alive : " + Integer.toString(enemy.ships_alive);
			UserAliveships.setText(Concat1);			   
			accuracy=(double)computer_accurate_hits/(double)(41-rounds);
            accuracy=accuracy*100.0;
			String s = String.valueOf(accuracy).substring(0,Math.min(String.valueOf(accuracy).length(), 4));
			String Concat3 = "Enemy Accuracy : " +s+" %";
			EnemyAccuracy.setText(Concat3);			
			String Concat2=Integer.toString(enemy.points);
			Concat2="Enemy Points : "+Concat2;
			EnemyPointsText.setText(Concat2);
									
			if(GoesFirst==1) {
				CheckEnd(enemy,player);
				rounds -=1;
				String Concat=Integer.toString(40-rounds);
				Concat="Rounds : "+Concat;
				roundsText.setText(Concat);
				
				}
			EnemyHit.setDisable(true);
			Hit.setDisable(false);
			
		});
		
		
		
		Hit.setOnAction(e -> {
			
			try {
			String Input = InputCell.getText();
			int [] numbers = Arrays.stream(Input.split(",")).mapToInt(Integer::parseInt).toArray();
			InputCell.clear();
			Pair PlayerMove = new Pair(numbers[0],numbers[1]);
			PlayerQueue.add(PlayerMove);
			Node hit= getCell(EnemyPane,numbers[1],numbers[0]);
			Button hit2= (Button) hit;
			if(computer_ship_grid[numbers[0]][numbers[1]]!=0) {
			 accurate_hits+=1;
			 hit2.setStyle("-fx-background-color:red");
			 player.update(computer_ship_grid[numbers[0]][numbers[1]]);
			 String Concat2=Integer.toString(player.points);
			 Concat2="Your Points : "+Concat2;
			 PointsText.setText(Concat2);
				
			}
			else {
			 hit2.setStyle("-fx-background-color:black");
				
			}
			
		   String Concat1= "Enemy ships alive : " + Integer.toString(player.ships_alive);
		   EnemyAliveships.setText(Concat1);
		   accuracy=(double)accurate_hits/(double)(41-rounds);
		   accuracy=accuracy*100.0;
		   String s = String.valueOf(accuracy).substring(0,Math.min(String.valueOf(accuracy).length(), 4));
		   String Concat3 = "Your Accuracy : " +s+" %";
		   UserAccuracy.setText(Concat3);
		   EnemyHit.setDisable(false);
		   Hit.setDisable(true);
			if(GoesFirst==0) {
				CheckEnd(enemy,player);
				rounds -=1;
				String Concat=Integer.toString(40-rounds);
				Concat="Rounds : "+Concat;
				roundsText.setText(Concat);
				}
			}
			catch(Exception ex){
				AlertBox.display("Failed!","Wrong Input");
			}
		});
		
		EnemyShots.setOnAction(e -> {	    	 
		    PopUpBox.display("Enemy Shots",null,1,enemy.EnemyQueue,player_ship_grid);
		     });
		
			
		PlayerShots.setOnAction(e -> {	    	 
	    PopUpBox.display("Player Shots",null,1,PlayerQueue,computer_ship_grid);
	     });	


       EnemyShips.setOnAction(e -> {	    	 
	    	 PopUpBox.display("Enemy Ships",player.SStatus,0,null,null);
 
	     });	
		
	}
	
}

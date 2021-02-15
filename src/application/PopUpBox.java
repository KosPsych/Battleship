package application;
import java.util.List;
import javafx.util.Pair;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.util.Pair;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PopUpBox {
	
	public static String [] ShipTypes= {"0","Carrier","Battleship","Cruiser","Submarine","Destroyer"};
	
    public static void display(String title,int [] status , int select,List<Pair> Queue,int [][] ship_grid) {
    	
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setTitle(title);
    	
    	VBox SList = new VBox(15);
    	
        if(select==0) {
        	Text CarrierStatus = new Text();
        	CarrierStatus.setId("insert-text");
        	 if(status[1]==0) {
        		 
        		 CarrierStatus.setText("Carrier : intact"); 
        		 SList.getChildren().add(CarrierStatus);
        	 }
        	 else if(status[1]==5) {
        		 
        		 CarrierStatus.setText("Carrier : sunk"); 
        		 SList.getChildren().add(CarrierStatus); 
        	 }
        	 else {
        		 CarrierStatus.setText("Carrier : beaten"); 
        		 SList.getChildren().add(CarrierStatus); 
        	 }
        	 
        	 Text BattleshipStatus = new Text();
        	 BattleshipStatus.setId("insert-text");
        	 
        	 if(status[2]==0) {
        		BattleshipStatus.setText("Battleship : intact"); 
        		SList.getChildren().add(BattleshipStatus);
        	 }
        	 else if(status[2]==4) {
        		 BattleshipStatus.setText("Battleship : sunk"); 
        		 SList.getChildren().add(BattleshipStatus); 
        	 }
        	 else {
        		 BattleshipStatus.setText("Battleship : beaten"); 
        		 SList.getChildren().add(BattleshipStatus); 
        	 }
        	 
        	 Text CruiserStatus = new Text();
        	 CruiserStatus .setId("insert-text");
        	 
        	 if(status[3]==0) {
        		 CruiserStatus .setText("Cruiser : intact"); 
        		SList.getChildren().add(CruiserStatus );
        	 }
        	 else if(status[3]==3) {
        		 CruiserStatus .setText("Cruiser : sunk"); 
        		 SList.getChildren().add(CruiserStatus ); 
        	 }
        	 else {
        		 CruiserStatus .setText("Cruiser : beaten"); 
        		 SList.getChildren().add(CruiserStatus ); 
        	 }
        	 
        	 
        	 Text SubmarineStatus = new Text();
        	 SubmarineStatus.setId("insert-text");
        	 
        	 if(status[4]==0) {
        		SubmarineStatus.setText("Submarine : intact"); 
        		SList.getChildren().add(SubmarineStatus);
        	 }
        	 else if(status[4]==3) {
        		 SubmarineStatus.setText("Submarine : sunk"); 
        		 SList.getChildren().add(SubmarineStatus); 
        	 }
        	 else {
        		 SubmarineStatus.setText("Submarine : beaten"); 
        		 SList.getChildren().add(SubmarineStatus); 
        	 }
        	 
        	 
        	 Text DestroyerStatus = new Text();
        	 DestroyerStatus.setId("insert-text");
        	 
        	 if(status[5]==0) {
        		 DestroyerStatus.setText("Destroyer: intact"); 
        		SList.getChildren().add(DestroyerStatus);
        	 }
        	 else if(status[5]==2) {
        		 DestroyerStatus.setText("Destroyer : sunk"); 
        		 SList.getChildren().add(DestroyerStatus); 
        	 }
        	 else {
        		 DestroyerStatus.setText("Destroyer : beaten"); 
        		 SList.getChildren().add(DestroyerStatus); 
        	 }
        	 
        	
        }
        else {

        	for(int i=0;i<Queue.size(); i++) {
        		Pair Move = Queue.get(i);
        		String ShotResult;
        		int cell=ship_grid[(int)Move.getKey()][(int)Move.getValue()];
        		if(cell==0) {
        			ShotResult="miss";	
        		}
        		else {
        			ShotResult="hit "+ShipTypes[cell];	
        		}
        		
        		String concat=Move.getKey().toString()+","+Move.getValue().toString();
        	    Text ShotText = new Text("shot to "+concat+" : "+ShotResult);
        	    ShotText.setId("insert-text");
        	    SList.getChildren().add(ShotText); 
        		
        	}
        }

    	GridPane grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setHgap(8);
    	grid.setVgap(18);
    	grid.add(SList, 0, 0);
    	grid.setStyle("-fx-background-color: DarkGrey");
    	Button btn = new Button("Return");
    	grid.add(btn, 0, 1);
    	grid.setAlignment(Pos.CENTER);
    	btn.setOnAction(e -> window.close());
    	Scene scene = new Scene(grid, 480, 280);
    	window.setScene(scene);
    	window.show();
    	scene.getStylesheets().add(AlertBox.class.getResource("Scene1.css").toExternalForm());
    	
    }
}

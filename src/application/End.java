package application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class End {
	
	public String result;
	public End(String result) {
		this.result=result;
	}
	
	public void endscene(Stage PStage) {
		Stage ThirdStage = new Stage();
		ThirdStage.setTitle("MediaLab Battleship");
		VBox Middle = new VBox(25);
		Text Title = new Text("Battle has ended");
		Middle.setAlignment(Pos.CENTER);
		Title.setId("conclusion");
		Middle.getChildren().add(Title);
		if(result=="won") {
			Text res1 = new Text("You have Won");
			Middle.getChildren().add(res1);
			res1.setId("won");
		}
		else if(result=="lost"){
			Text res2 = new Text("You Lost");
			Middle.getChildren().add(res2);
			res2.setId("lost");
			
		}else {
			Text res3 = new Text("Draw");
			Middle.getChildren().add(res3);
			res3.setId("won");
			
		}
		Button restart = new Button("Play Again");
		Button exit = new Button("Exit");
		restart.setId("hit");
		exit.setId("hit");
		Middle.getChildren().add(restart);
		Middle.getChildren().add(exit);
		exit.setOnAction(e -> {
			ThirdStage.close();	
		});
		
		restart.setOnAction(e -> {
			ThirdStage.close();	
			PStage.show();
		});
		BorderPane BPane = new BorderPane();
		BPane.setStyle("-fx-background-color: DarkGrey");
		BPane.setCenter(Middle);
		BPane.setPadding(new Insets(25, 25, 25, 25)); 
		Scene scene3 = new Scene(BPane,400,400);
		ThirdStage.setScene(scene3);
	    scene3.getStylesheets().add(End.class.getResource("Scene3.css").toExternalForm());
	    ThirdStage.show();
	}

}

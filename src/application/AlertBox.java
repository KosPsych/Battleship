package application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class AlertBox {
	
    public static void display(String title , String message) {
    	
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setTitle(title);
    	Text TitleMessage = new Text(message);
    	TitleMessage.setId("insert-text");
    	GridPane grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setHgap(8);
    	grid.setVgap(18);
    	grid.add(TitleMessage, 0, 0);
    	grid.setStyle("-fx-background-color: DarkGrey");
    	Button btn = new Button("Insert Again");
    	grid.add(btn, 0, 1);
    	grid.setAlignment(Pos.CENTER);
    	btn.setOnAction(e -> window.close());
    	Scene scene = new Scene(grid, 420, 200);
    	window.setScene(scene);
    	window.show();
    	scene.getStylesheets().add(AlertBox.class.getResource("Scene1.css").toExternalForm());
    	
    }
}

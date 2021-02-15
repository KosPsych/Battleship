package application;
import javafx.scene.control.Button;

public class Cell {
	
	public Button button;
	int X,Y;
	public Cell (int X,int Y) {
		this.X=X;
		this.Y=Y;
		button = new Button();			
	}
	public Button get() {
		return button;
	}
	
	

}

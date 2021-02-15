package application;
import javafx.scene.layout.GridPane;
import java.io.*; 
import java.util.Arrays;
import java.util.Scanner; 
import java.util.ArrayList; 
import javafx.geometry.Insets;


/**
 * Initializes the ship grid for both the user and the computer.
 * It checks if the txt file selected as input for both cases throws  
 * exceptions and if not creates the ship Map which will be displayed in the next Scene.
 * @author KosPsych
 */

public class Initialization {
	public  int[][] ship_grid = new int[10][10];
	public String line;
	public int [] numbers;
	public int [] ship_size = {5,4,3,3,2} ;
	public int i;
	public ArrayList<Integer> used_types = new ArrayList<Integer>(4);
	public boolean contstraint_check(BufferedReader br) {	
	boolean IsValid = true;	
	try {
	   for (int count=0;count<5;count++){
		
	   line=br.readLine();
	   numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
	   Oversize_check();
	   Overlap_check();
	   Adjacent_check();
	   InvalidCount_check();
	   place_ship();
	                                  }
	   }
	catch(OversizeException | OverlapTilesException | IOException | AdjacentTilesException | InvalidCountExeception e) {
			IsValid=false;
			set_zero();
			used_types.clear();
			
             }
	finally {
		  return IsValid;
	  }
	   	
	}

	/**
	 * It creates an array of Buttons ,to be used as user or enemy grid
	 * @author KosPsych
	 * @param boolean player - this parameter is used to highlight the ships in player's grid.
	 *                 This should not be done for computer's grid.
	 * @return grid -  Ship Map
	 */
	
	public  GridPane GridInit(boolean player) { 
        GridPane grid = new GridPane(); 
        grid.setPadding(new Insets(30, 30, 10, 10));    
        for(int i=0;i<10;i++) {
     	   for(int j=0;j<10;j++) {
        Cell cell = new Cell(j,i);
        grid.add(cell.get(), j,i);
        cell.button.setStyle("-fx-border-color: Grey; ");
        if(ship_grid[i][j]!=0 && player) {
        cell.button.setStyle("-fx-border-color: Grey;-fx-background-color: darkCyan");
        }
        }}
        return grid;
  	  }

	
	
   public void set_zero (){
			for(int i = 0; i<10; i++)	{
				 for(int j = 0; j<10; j++)
				   {
					ship_grid[i][j]=0;
				  }}  
}	


   /**
	 * It chooses a random text file from EnemyFiles Folder
	 * @author KosPsych
	 * @return BufferedReader 
	 */
   
   public static BufferedReader Choose_enemy() {
	   int rand = (int)(Math.random()*3+1);
	   BufferedReader br = null;
	   File file = new File("C:\\Users\\Lezz\\Javafxx\\BattleshipProj\\src\\application\\EnemyFiles\\enemy_default"+rand+".txt");
	      try {
			    br = new BufferedReader(new FileReader(file));
			  } 
		  catch (FileNotFoundException e) {
				  System.out.println("Error at Creating Enemy board");
				  System.out.println("Exiting Game...");
			      System.exit(0);
			           }
	   return br;	  
			  
	}
   
   /**
	 * If no exception is thrown ship is placed in the map
	 * 
	 * @author KosPsych
	 * 
	 */
   
    public void place_ship(){
      for (i=0; i<ship_size[numbers[0]-1]; i++){ 
	     if (numbers[3]==1){
	     ship_grid[numbers[1]][numbers[2]+i]=numbers[0];
	     }
	     else{
		    ship_grid[numbers[1]+i][numbers[2]]=numbers[0]; 
	     } 
	                                           } 
	    used_types.add(numbers[0]);
	     }


    /**
	 * Checks if more than 1 ships of the same type are in the text file's description
	 * @author KosPsych 
	 * @throws InvalidCountExeception
	 */
    
    public void InvalidCount_check() throws InvalidCountExeception{
		if (used_types.contains(numbers[0])){
			throw new InvalidCountExeception("There are more than one ships of type "+numbers[0]);
		}	
	}


    /**
   	 * Checks if there are adjacent ships in the text file's description
   	 * @author KosPsych
   	 * @throws AdjacentTilesException
   	 */

    public void Adjacent_check() throws AdjacentTilesException{
		for (i=0; i<ship_size[numbers[0]-1]; i++){ 
		  if (numbers[3]==1){
		    if ((numbers[1]+1)<=9){
				if (ship_grid[numbers[1]+1][numbers[2]+i] != 0){
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[1]+1)+","+(numbers[2]+i));
				}
			}
			if ((numbers[1]-1)>=0){
				if (ship_grid[numbers[1]-1][numbers[2]+i] != 0){
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[1]-1)+","+(numbers[2]+i));
				}
			}
			
			if (numbers[2]-1>=0){
				if (ship_grid[numbers[0]][numbers[2]-1] !=0) {
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[0])+","+(numbers[2]-1));
				}
				
			}
			
			if ((numbers[2]+ship_size[numbers[0]-1])<=9 ){
				if (ship_grid[numbers[1]][numbers[2]+ship_size[numbers[0]-1]] !=0) {
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[1])+","+(numbers[2]+ship_size[numbers[0]]+1));
				}}}
		  
		   

		   if (numbers[3]==2){
		    if ((numbers[2]+1)<=9){
				if (ship_grid[numbers[1]+i][numbers[2]+1] != 0){
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[1]+i)+","+(numbers[2]+1));
				}
			}
			if ((numbers[2]-1)>=0){
				if (ship_grid[numbers[1]][numbers[2]-1] != 0){
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[2]+1)+","+(numbers[2]-1));
				}
			}
			
			if (numbers[1]-1>=0){
				if (ship_grid[numbers[1]-1][numbers[2]] !=0) {
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[1]-1)+","+(numbers[2]));
				}
				
			}
			
			if ((numbers[1]+ship_size[numbers[0]-1])<=9 ){
				if (ship_grid[numbers[1]+ship_size[numbers[0]-1]][numbers[2]] !=0) {
					throw new AdjacentTilesException("Adjacent ship in cell "+(numbers[1]+ship_size[numbers[0]-1])+","+numbers[2]) ;
				}}}   
		 
	}}
	
	
    /**
   	 * Checks if there is overlap between ships in the text file's description
   	 * @author KosPsych
   	 * @throws OverlapTilesException
   	 */
	
	public void Overlap_check() throws OverlapTilesException{
           
		   if (numbers[3]==1){
			   for (i=0; i<ship_size[numbers[0]-1];  i++){
				 if(ship_grid[numbers[1]][numbers[2]+i] != 0){
					throw new OverlapTilesException("Overlap between ships in pixel "+numbers[1]+","+(i+numbers[2])); 
				 }}}
		   else{
			   
			   for (i=0; i<ship_size[numbers[0]-1];  i++){
				 if(ship_grid[numbers[1]+i][numbers[2]] != 0){
					throw new OverlapTilesException("Overlap between ships in pixel "+(numbers[1]+i)+","+numbers[2]); 
				 }}}}  
	

	 /**
   	 * Checks if a ship is out of bounds in the text file's description
   	 * @author KosPsych
   	 * @throws OversizeException
   	 */
  
	public void Oversize_check() throws OversizeException{
		 int [] hor_vert={2,1}; 
	     if ( (numbers[1] > 9 || numbers[1] < 0) || (numbers[2] > 9 || numbers[2] < 0) ){
		      throw new OversizeException("Starting cell out of bounds");    
	         }
		     if (numbers[hor_vert[this.numbers[3]-1]]+ship_size[numbers[0]-1] -1 >9 ){
			    throw new OversizeException("Placement of a ship is out of bounds"); 
		     }}

	
	   
}

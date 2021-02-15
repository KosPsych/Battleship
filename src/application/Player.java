package application;
/**
 * Class for User Statistics during the Battleship battle.
 * 
 * <p> This class keeps track of player's points,player's
 * ship status as well as the enemy ships he sunk.These 
 * values are updated each round with every new user's hit.
 * 
 * @author KosPsych
 */
public class Player {
	    
	    public int points=0;
	    public int[][] computer_ship_grid = new int[10][10];  
	    public int hit;
	    public int [] sunkNum = {0,5,4,3,3,2} ; 
	    public int [] point_array = {0,350,250,100,100,50};
	    public int [] sunk_points = {0,1000,500,250,0,0};
	    public int [] SStatus = new int [6]; 
	    public int ships_alive=5;
	    
	    /**
	     * Constructor for Player Class.
	     * @author KosPsych
	     * @param computer_ship_grid
	     */
	    public Player(int [][] computer_ship_grid) {
	    	this.computer_ship_grid=computer_ship_grid;
	    	
	     }
	    
	    /**
	     * Update after every user's hit.
	     * @author KosPsych
	     * @param hit = a (x,y) pair indicating the last 
	     *                   cell the user hit.
	     */
	    public void update(int hit) {
	            if (SStatus[hit]+1 != sunkNum[hit]){    
	                SStatus[hit]=SStatus[hit]+1;
	                points=points + point_array[hit];
	            }
	            else{
	                SStatus[hit] = sunkNum[hit];
	                ships_alive -=1;
	                points=sunk_points[hit] + point_array[hit]+points;

	              }
	    }
	    		    
}

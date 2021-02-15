package application;
import javafx.util.Pair;
import java.util.*;


public class Enemy {
	
	public boolean found=false;
	public boolean second_found=false;
	public boolean second_found_first=false;
	public int ships_alive=5;
	public int [] sunkNum = {0,5,4,3,3,2} ; 
    public int [] point_array = {0,350,250,100,100,50};
    public int [] sunk_points = {0,1000,500,250,0,0};
    public int [] SStatus = new int [6];
    public int points=0;
	public int hit;
	public int[][] player_ship_grid = new int[10][10];  
	public int index1,index2,int_random,index4,index3;
	public int[] result = new int [2];
	public List <Pair> cells;
	public List <Pair> NeighborCells = new ArrayList<Pair>();
	public int direction=0;
	public List<Pair> EnemyQueue  = new LimitedQueue<>(5);
	Pair <Integer,Integer>pr,p1,p2,p3,p4;
	
	
	public Enemy(int [][] player_ship_grid) {
    	this.player_ship_grid=player_ship_grid;
        cells = new ArrayList<Pair>();
    	for (int i=0;i<10;i++) {
    		for (int j=0;j<10;j++) {
    			Pair p = new Pair(i,j);
    			cells.add(p);
    			
    		}}
    	
     }
	
	
	 


	public   void move() {
		if(!found) {
			Random rand = new Random();
			int_random = rand.nextInt(cells.size()); 
			index1= (int)cells.get(int_random).getKey();
			index2= (int)cells.get(int_random).getValue();
			pr = new Pair(index1,index2);
			EnemyQueue.add(pr);
			result[0]=index1;
			result[1]=index2;
			cells.remove(pr);
			if(player_ship_grid[index1][index2] != 0) {
				found=true;
				if(index1+1 <10) {
				p1 = new Pair(index1+1,index2);
				if(cells.contains(p1)) {
					NeighborCells.add(p1);					
				}}
				if(index2+1 <10) {
					p1 = new Pair(index1,index2+1);
					if(cells.contains(p1)) {						
						NeighborCells.add(p1);						
					}}
				if(index1-1 >=0) {					
					p1 = new Pair(index1-1,index2);
					if(cells.contains(p1)) {						
						NeighborCells.add(p1);						
					}}
				
				if(index2-1 >=0) {					
					p1 = new Pair(index1,index2-1);
					if(cells.contains(p1)) {						
						NeighborCells.add(p1);						
					}}						
			}
			
		}
		
			else {
				pr =NeighborCells.get(0);
				index3= (int) pr.getKey();
				index4= (int) pr.getValue();
				result[0]=index3;
				result[1]=index4;
				EnemyQueue.add(pr);
				NeighborCells.remove(pr);
				cells.remove(pr);
			    if(player_ship_grid[index3][index4] != 0) {
			      if(!second_found_first) {
			    	if(index3!=index1) {
			    		p1 = new Pair(index3,index4-1);
			    		p2 = new Pair(index3,index4+1);
			    		cells.remove(p1);
			    		cells.remove(p2);
			    		for (int i=0;i<NeighborCells.size();i++) {
			    			int x = (int) NeighborCells.get(0).getValue();
			    			if(x!=index4) {
			    				cells.remove(NeighborCells.get(0));
			    			}
			    		}
			    	}
			    	else {
			    		p1 = new Pair(index3-1,index4);
			    		p2 = new Pair(index3+1,index4);
			    		cells.remove(p1);
			    		cells.remove(p2);
			    		for (int i=0;i<NeighborCells.size();i++) {
			    			int x = (int) NeighborCells.get(0).getKey();
			    			if(x!=index3) {
			    				cells.remove(NeighborCells.get(0));
			    			}}
			    	}
			    	NeighborCells.clear();
			      }
			    				      
			    	if(index1!=index3) {
			    		direction=1;
			    		
			    		if(index1>index3) {
			    			if(index3-1>0) {
			    			p1 =new Pair(index3-1,index4);
			    			if(cells.contains(p1)) {
			    				NeighborCells.add(p1);
			    				cells.remove(p1);
			    				
			    			}}
			    		if(!second_found_first) {
			    			if(index1+1<10) {
			    			p1 =new Pair(index1+1,index2);
			    			if(cells.contains(p1)) {
			    				NeighborCells.add(p1);
			    				cells.remove(p1);
			    			}} }
			    		}
			    		else {
			    			if(index3+1<10) {
				    			p2 =new Pair(index3+1,index4);
				    			if(cells.contains(p2)) {
				    				NeighborCells.add(p2);
				    				cells.remove(p2);
				    			}}
			    			if(!second_found_first) {
			    			if(index1-1>0) {
				    			p2 =new Pair(index1-1,index2);
				    			if(cells.contains(p2)) {
				    				NeighborCells.add(p2);
				    				cells.remove(p2);	
				    			}}}
			    			
			    		}	
			    	}
			    	else {
			    		direction=2;
			    		if(index2>index4) {
			    			if(index4-1>=0) {
			    				p1 =new Pair(index3,index4-1);
				    			if(cells.contains(p1)) {
				    				NeighborCells.add(p1);
				    				cells.remove(p1);
			    			}}
			    			if(!second_found_first) {
			    			if(index2+1<10) {
			    				p1 =new Pair(index1,index2+1);
				    			if(cells.contains(p1)) {
				    				NeighborCells.add(p1);
				    				cells.remove(p1);

			    			}}}
			    		                   }
			    			
				    			else
				    			{	
				    				if(index4+1<10) {
					    				p1 =new Pair(index3,index4+1);
						    			if(cells.contains(p1)) {
						    				NeighborCells.add(p1);
						    				cells.remove(p1);
					    			}}	
				    				if(!second_found_first) {
				    				 if(index2-1>=0) {
					    				p1 =new Pair(index1,index2-1);
						    			if(cells.contains(p1)) {
						    				NeighborCells.add(p1);
						    				cells.remove(p1);
					    			}	}}
				    			} } 
			    	
			    	second_found_first=true;
			    	if(direction==1) { 
				    	  p2=new Pair(index3,index4-1);
				    	  p3=new Pair(index3,index4+1);
				    	  cells.remove(p2);
				    	  cells.remove(p3);  
				      }
				      else if(direction==2){
				    	  p2=new Pair(index3-1,index4);
				    	  p3=new Pair(index3+1,index4);
				    	  cells.remove(p2);
				    	  cells.remove(p3);  
				    	  
				      } 
			    	
			    	} 
			    
			    
			    
			 
		
			 
			if(NeighborCells.isEmpty()) {
				found=false;
				direction=0;
				second_found_first=false;
			}
			} 
		hit=player_ship_grid[result[0]][result[1]];
		if(hit!=0) {
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
} 


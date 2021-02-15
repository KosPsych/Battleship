package application;

class OverlapTilesException extends Exception{  
	 OverlapTilesException(String s){  
		 AlertBox.display("OverlapTilesException",s);   
	 }  
	} 
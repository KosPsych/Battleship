package application;

class OversizeException extends Exception{  
	 OversizeException(String s){  
		 AlertBox.display("OversizeException",s);  
	 }  
	} 

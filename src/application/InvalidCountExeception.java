package application;

class InvalidCountExeception extends Exception{  
	 InvalidCountExeception(String s){  
		 AlertBox.display("InvalidCountExeception",s);  
	 }  
	} 
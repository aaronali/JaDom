package com.ali.jadom.dom;
 
public enum Direction{
	LTR/**left to right**/,
	RTL;/**right to lef **/
	
	@Override
	public String toString(){
		return this.name().toLowerCase();
	}
}  

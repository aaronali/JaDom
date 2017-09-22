package com.ali.jadom.dom;

public enum Shape{
	CIRCLE,POYLGON,RECTANGLE, DEFAULT;
	
	public String toString(){
		return( String.valueOf(this.name().charAt(0)).toUpperCase() + this.name().substring(1).toLowerCase());
	}
}
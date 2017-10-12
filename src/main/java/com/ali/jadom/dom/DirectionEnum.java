package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;

public enum DirectionEnum implements DOMobject{
	LTR/**left to right**/,
	RTL;/**right to lef **/
	
	@Override
	public String toString(){
		return this.name().toLowerCase();
	}
}  

package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;

public enum ShapeEnum  implements DOMobject{
	CIRCLE,POYLGON,RECTANGLE, DEFAULT;
	
	public String toString(){
		return( String.valueOf(this.name().charAt(0)).toUpperCase() + this.name().substring(1).toLowerCase());
	}
}
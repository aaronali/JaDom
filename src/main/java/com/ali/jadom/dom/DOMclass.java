package com.ali.jadom.dom;

public class DOMclass implements com.ali.jadom.dom.superelements.DOMobject {

	protected String name;  
	public static String STRING_CLASS="class";
	
	public DOMclass(String name) {
		this.name=name;
	}
	public String Name() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
}

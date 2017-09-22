package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("rt")
public class Rt extends DOMelement {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4964027978274911716L;

	public Rt() {
		super(tag(Rt.class)); 
	}
		 
	public Rt( String rubyText) {
		super(tag(Rt.class), rubyText); 
	}
	 
	public Rt(String rubyText, HashMap<String, String> attributes) {
		super(tag(Rt.class), rubyText, attributes);  
	} 
 
	public Rt(String rubyText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Rt.class), rubyText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

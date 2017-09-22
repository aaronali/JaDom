package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("rp")
public class Rp extends DOMelement {
  
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -843160725031013605L;

	public Rp() {
		super(tag(Rp.class)); 
	}
	
	public Rp(String rubyText, HashMap<String, String> attributes) {
		super(tag(Rp.class), rubyText, attributes);  
	}
 
	public Rp(String rubyText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Rp.class), rubyText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

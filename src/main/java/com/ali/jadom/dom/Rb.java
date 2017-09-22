package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("rb")
public class Rb extends DOMelement {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7731371491919954892L;

	public Rb() {
		super(tag(Rb.class)); 
	}

	
	public Rb( String rubyText) {
		super(tag(Rb.class), rubyText); 
	}

	 
	public Rb(String rubyText, HashMap<String, String> attributes) {
		super(tag(Rb.class), rubyText, attributes);  
	}

	 
	
	 
	public Rb(String rubyText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Rb.class), rubyText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

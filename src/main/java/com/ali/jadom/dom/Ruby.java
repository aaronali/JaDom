package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("ruby")
public class Ruby extends DOMelement {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6496887837614904332L;

	public Ruby() {
		super(tag(Ruby.class)); 
	}
	
	public Ruby( String rubyContent) {
		super(tag(Ruby.class), rubyContent); 
	}
	 
	public Ruby(String rubyContent, HashMap<String, String> attributes) {
		super(tag(Ruby.class), rubyContent, attributes);  
	}
	 
	public Ruby(String rubyContent, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Ruby.class), rubyContent, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

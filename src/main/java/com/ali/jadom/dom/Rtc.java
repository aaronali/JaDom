package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("rtc")
public class Rtc extends DOMelement {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 8189690406434989506L;

	public Rtc() {
		super(tag(Rtc.class)); 
	}
  
	public Rtc( String rubyText) {
		super(tag(Rtc.class), rubyText); 
	}

	public Rtc(String rubyText, HashMap<String, String> attributes) {
		super(tag(Rtc.class), rubyText, attributes);  
	} 
	 
	public Rtc(String rubyText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Rtc.class), rubyText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

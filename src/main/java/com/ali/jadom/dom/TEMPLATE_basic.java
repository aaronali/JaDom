package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("div")
public class TEMPLATE_basic extends DOMelement {
 

	
	
	public TEMPLATE_basic( String divHTML) {
		super(tag(TEMPLATE_basic.class), divHTML); 
	}
	
	 
	public TEMPLATE_basic(String divHTML, HashMap<String, String> attributes) {
		super(tag(TEMPLATE_basic.class), divHTML, attributes);  
	}

	 
	 
	public TEMPLATE_basic(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(TEMPLATE_basic.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

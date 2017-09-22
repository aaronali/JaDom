package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent; 

@Tag("wbr")
public class Wbr extends DOMelement implements FlowingContent, PalpableContent {
 
	 
	private static final long serialVersionUID = 1281969110143259595L;

	public Wbr() {
		super(tag(Wbr.class), "nullnodevalue"); 
	}

	 
	public Wbr(HashMap<String, String> attributes) {
		super(tag(Wbr.class), "nullnodevalue", attributes);  
	}

	 
	public Wbr( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Wbr.class), "nullnodevalue", id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have child elements. \n Set ApplicationManager.FORCE_HTML_COMPLIANCE to override"));
		return super.addDomElement(element);
	}
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("dd")
public class Dd extends DOMelement { 
	private static final long serialVersionUID = 6419827636375698839L;
	public Dd(){
		super(tag(Dd.class)); 
	}
	 
	public Dd( String ddHTML) {
		super(tag(Dd.class), ddHTML); 
	}
	 
	public Dd(String ddHTML, HashMap<String, String> attributes) {
		super(tag(Dd.class), ddHTML, attributes);  
	} 
	 
	public Dd(String ddHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Dd.class), ddHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	  
}

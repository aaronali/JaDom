package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.TableElement;

@Tag("colgroup")
public class Colgroup extends DOMelement implements  TableElement{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2897349113896100619L;

	public Colgroup(){
		super(tag(Colgroup.class));
	}
	
	public Colgroup( String divHTML) {
		super(tag(Colgroup.class), divHTML); 
	}

	public Colgroup(String divHTML, HashMap<String, String> attributes) {
		super(tag(Colgroup.class), divHTML, attributes);  
	}

	
	 
	public Colgroup(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Colgroup.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			if (element.isOfType(Span.class) )
				throw new RuntimeException("No other elements can  be add if "+ Span.class.getCanonicalName() + " is present. Override with AppicationManager.FORCE_HTMLCOMPLIANCE");
			if(!element.isOfType(Col.class))
				throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

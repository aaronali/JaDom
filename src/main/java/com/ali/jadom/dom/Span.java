package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("span")
public class Span extends DOMelement  implements PalpableContent, FlowingContent, PhrasingContent { 
	
 
	private static final long serialVersionUID = 1L;

	public Span( ) {
		super(tag(Span.class)); 
	} 
	/**
	 * 
	 * @param code
	 */
	public Span( String code) {
		super(tag(Span.class), code); 
	}
	 /**
	  * 
	  * @param code
	  * @param attributes
	  */
	public Span(String code, HashMap<String, String> attributes) {
		super(tag(Span.class), code, attributes);  
	} 
	 /**
	  * 
	  * @param code
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Span(String code, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Span.class), code, id, domClass, Styles, jsCallout); 
	}

	
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString();  
	} 
}

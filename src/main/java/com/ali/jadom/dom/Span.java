package com.ali.jadom.dom;

import java.util.Collection;
import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

/**
 * HTML span tag
 * @author Aaron Ali
 *
 */
@Tag("span")
public class Span extends DOMelement  implements PalpableContent, FlowingContent, PhrasingContent { 
 
	private static final long serialVersionUID = 1417026522618671534L;
	/**
	 * Creates an empty span tag
	 */
	public Span( ) {
		super(tag(Span.class)); 
	} 
	
	
	public Span(DOMclass domClass) {
		super(tag(Span.class),domClass);  
	}

	
	
	/**
	 * Creates a span with the given classes
	 * @param bootNavClass
	 */
	public Span( Collection<DOMclass> bootNavClass) {
		super(tag(Span.class), bootNavClass); 
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
			super.throwComplianceError(this, element);
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString();  
	} 
}

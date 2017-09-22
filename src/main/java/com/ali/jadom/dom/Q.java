package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("q")
public class Q extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent{
  
	private static final long serialVersionUID = 5195479119795818614L;
	protected String cite;
	
	public Q() {
		super(tag(Q.class)); 
	}
	/**
	 * 
	 * @param quoteText
	 * @param cite
	 */
	public Q( String quoteText, String cite) {
		super(tag(Q.class), quoteText); 
		this.cite=cite;
		addAttribute("cite",cite);
	}
	 /**
	  * 
	  * @param quoteText
	  */
	public Q( String quoteText) {
		super(tag(Q.class), quoteText); 
	}
	 /**
	  *  
	  * @param quoteText
	  * @param attributes
	  */
	public Q(String quoteText, HashMap<String, String> attributes) {
		super(tag(Q.class), quoteText, attributes);  
		cite = this.getAttributes().get("cite");
	} 
	/**
	 * 
	 * @param quoteText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Q(String quoteText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Q.class), quoteText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE  && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element of type ").concat(element.getClass().getCanonicalName()).concat("\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to Override"));
		return super.addDomElement(element);
	}
	
}

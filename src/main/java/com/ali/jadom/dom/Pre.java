package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("pre")
public class Pre extends DOMelement implements FlowingContent, PalpableContent{
 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8084442710953832605L;

	/**
	 * 
	 */
	public Pre() {
		super(tag(Pre.class)); 
	}
	/**
	 * 
	 * @param code
	 */
	public Pre( String code) {
		super(tag(Pre.class), code); 
	}
	/**
	 * 
	 * @param code
	 * @param attributes
	 */
	public Pre(String code, HashMap<String, String> attributes) {
		super(tag(Pre.class), code, attributes);  
	}
	/**
	 * 
	 * @param code
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Pre(String code, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Pre.class), code, id, domClass, Styles, jsCallout); 
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

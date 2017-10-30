package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("u")
public class U extends DOMelement implements FlowingContent, PalpableContent,PhrasingContent{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8544862060838665765L;
	public U() {
		super(tag(U.class), ""); 
	}
	
	/**
	 * 
	 * @param element
	 */
	public U(IDOMelement element){
		super((DOMelement)element);
	}
	/**
	 * 
	 * @param underlinedText
	 */
	public U( String underlinedText) {
		super(tag(U.class), underlinedText); 
	}
 
	/**
	 * 
	 * @param underlinedText
	 * @param attributes
	 */
	public U(String underlinedText, HashMap<String, String> attributes) {
		super(tag(U.class), underlinedText, attributes);  
	}

	/**
	 * 
	 * @param underlinedText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public U(String underlinedText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(U.class), underlinedText, id, domClass, Styles, jsCallout); 
	} 
	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element of type ").concat(element.getClass().getCanonicalName()));
		return super.addDomElement(element);
	}
	
	
}

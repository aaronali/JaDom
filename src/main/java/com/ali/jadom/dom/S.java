package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("s")
public class S extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent{
  
	private static final long serialVersionUID = 3880237947815092335L;

	public S() {
		super(tag(S.class)); 
	}
	/**
	 * 
	 * @param strokedText
	 */
	public S( String strokedText) {
		super(tag(S.class), strokedText); 
	}
	 
	/**
	 * 
	 * @param strokedText
	 * @param attributes
	 */
	public S(String strokedText, HashMap<String, String> attributes) {
		super(tag(S.class), strokedText, attributes);  
	}

	/**
	 * 
	 * @param strokedText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public S(String strokedText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(S.class), strokedText, id, domClass, Styles, jsCallout); 
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

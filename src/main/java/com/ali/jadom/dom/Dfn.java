package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("dfn")
public class Dfn extends DOMelement implements FlowingContent, PhrasingContent, PalpableContent {
  
	private static final long serialVersionUID = -3440552121350014160L;

	/**
	 * 
	 */
	public Dfn() {
		super(tag(Dfn.class)); 
	}
	
	/**
	 * 
	 * @param element
	 */
	public Dfn(DOMelementInterface element){
		super((DOMelement)element);
	}
	
	/**
	 * 
	 * @param dfnHTML
	 */
	public Dfn( String dfnHTML) {
		super(tag(Dfn.class), dfnHTML); 
	}
	 
	/**
	 * 
	 * @param dfnHTML
	 * @param attributes
	 */
	public Dfn(String dfnHTML, HashMap<String, String> attributes) {
		super(tag(Dfn.class), dfnHTML, attributes);  
	}
 
	/**
	 * 
	 * @param dfnHTML
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Dfn(String dfnHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Dfn.class), dfnHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!element.isOfType(PhrasingContent.class) || !element.contains(this.getClass())))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	 
	
}

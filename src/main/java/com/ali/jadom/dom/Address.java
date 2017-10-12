package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.SectioningContent;

@Tag("address")
public class Address extends DOMelement implements  PalpableContent, FlowingContent { 
	 
	private static final long serialVersionUID = 4607074206594683171L;

	/**
	 * 
	 */
	public Address( ) {
		super(tag(Address.class)); 
	}
	
	public Address(IDOMelement element){ 
		super((DOMelement)element);
	}
	
	/**
	 * 
	 * @param addressHtml as String
	 */
	public Address( String addressHtml) {
		super(tag(Address.class), addressHtml); 
	}
	/**
	 * 
	 * @param addressHtml as String
	 * @param attributes as HashMap&ltString,String&gt
	 */
	public Address(String addressHtml, HashMap<String, String> attributes) {
		super(tag(Address.class), addressHtml, attributes);  
	} 
	 
	/**
	 * 
	 * @param addressHtml String
	 * @param id String or null
	 * @param domClass String or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param Styles or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param jsCallout or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 */
	public Address(String addressHtml, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Address.class), addressHtml, id, domClass, Styles, jsCallout); 
	}

	
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(SectioningContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName().concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")));
		return super.addDomElement(element);
	}
	
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

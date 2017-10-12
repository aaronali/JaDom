package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("i")
public class I extends DOMelement implements FlowingContent, PhrasingContent, PalpableContent {
  
	private static final long serialVersionUID = 7421126816685769838L;

	/**
	 * 
	 */
	public I() {
		super(tag(I.class)); 
	}
	/**
	 * 
	 * @param italicText
	 */
	public I( String italicText) {
		super(tag(I.class), italicText); 
	} 
	 
	/**
	 * 
	 * @param element
	 */
	public I(IDOMelement element){
		super((I)element);
	}
	/**
	 * 
	 * @param italicText
	 * @param attributes
	 */
	public I(String italicText, HashMap<String, String> attributes) {
		super(tag(I.class), italicText, attributes);  
	}

	 /**
	  * 
	  * @param italicText
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public I(String italicText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(I.class), italicText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  !element.isOfType(PhrasingContent.class)){ 
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		}
		return super.addDomElement(element);
	}
}

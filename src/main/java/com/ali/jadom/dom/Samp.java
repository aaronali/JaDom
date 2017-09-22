package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("sam")
public class Samp extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent{
  
	private static final long serialVersionUID = 9050319423944089589L;
  /**
   * 
   */
	public Samp() {
		super(tag(Samp.class)); 
	}
	/**
	 * 
	 * @param element
	 */
	public Samp(DOMelementInterface element){
		super((Samp)element);
	}
	/**
	 * 
	 * @param sampleText
	 */
	public Samp( String sampleText) {
		super(tag(Samp.class), sampleText); 
	}
 
	 /**
	  * 
	  * @param sampleText
	  * @param attributes
	  */
	public Samp(String sampleText, HashMap<String, String> attributes) {
		super(tag(Samp.class), sampleText, attributes);  
	} 
	 /**
	  * 
	  * @param sampleText
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Samp(String sampleText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Samp.class), sampleText, id, domClass, Styles, jsCallout); 
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

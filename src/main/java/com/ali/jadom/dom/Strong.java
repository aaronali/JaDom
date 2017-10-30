package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("strong")
public class Strong extends DOMelement   implements PalpableContent, FlowingContent, PhrasingContent  {
 
	 
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public Strong(){
		super(tag(Strong.class)); 
	}
	/**
	 * 
	 * @param strongText
	 */
	public Strong( String strongText) {
		super(tag(Strong.class), strongText); 
	}

	 
	 /**
	  * 
	  * @param strongText
	  * @param attributes
	  */
	public Strong(String strongText, HashMap<String, String> attributes) {
		super(tag(Strong.class), strongText, attributes);  
	}

	 /**
	  * 
	  * @param strongText
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Strong(String strongText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Strong.class), strongText, id, domClass, Styles, jsCallout); 
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

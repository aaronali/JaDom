package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("mark")
public class Mark extends DOMelement  implements FlowingContent, PhrasingContent ,  PalpableContent {
 
	private static final long serialVersionUID = 6933385473300171118L;

	public Mark() {
		super(tag(Mark.class)); 
	}
	
	public Mark(IDOMelement element){
		super((Mark)element); 
	}
	/**
	 * 
	 * @param markText
	 */
	public Mark( String markText) {
		super(tag(Mark.class), markText); 
	} 
	/**
	 * 
	 * @param markText
	 * @param attributes
	 */
	public Mark(String markText, HashMap<String, String> attributes) {
		super(tag(Mark.class), markText, attributes);  
	} 
	/**
	 * 
	 * @param markText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Mark(String markText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Mark.class), markText, id, domClass, Styles, jsCallout); 
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

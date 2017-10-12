package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

@Tag("p")
public class P extends DOMelement implements FlowingContent, PalpableContent{ 
	
	 
	private static final long serialVersionUID = 4219098069225552469L;

	public P() {
		super(tag(P.class)); 	 
	}
		
	/**
	 * 
	 * @param p
	 */
	public P(P p){
		super(p);
	}
	/**
	 * 
	 * @param paragraphText
	 */
	public P( String paragraphText) {
		super(tag(P.class), paragraphText); 
	}

	/**
	 * 
	 * @param paragraphText
	 * @param attributes
	 */
	public P(String paragraphText, HashMap<String, String> attributes) {
		super(tag(P.class), paragraphText, attributes); 
		 
	}
	/**
	 * 
	 * @param paragraphText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public P(String paragraphText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(P.class), paragraphText, id, domClass, Styles, jsCallout); 
	}

	
	public P(String paragraphText, DOMclass doMclass) {
		super(tag(P.class), paragraphText, doMclass);  
	}

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element of type ").concat(element.getClass().getCanonicalName()));
		return super.addDomElement(element);
	}
	
	@Override
	public String toString(){ 
		return super.toString(); 
	}
	 
	
}

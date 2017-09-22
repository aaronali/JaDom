package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
 

@Tag("ul")
public class Ul extends DOMelement implements FlowingContent, PalpableContent{
  
	 
	private static final long serialVersionUID = -5792278634550074687L;

	/**
	 * 
	 */
	public Ul(){
		super(tag(Ul.class), ""); 
	}
	 /**
	  * 
	  * @param ulText
	  */
	public Ul( String ulText) {
		super(tag(Ul.class), ulText); 
	} 
	/**
	 * 
	 * @param ulText
	 * @param attributes
	 */
	public Ul(String ulText, HashMap<String, String> attributes) {
		super(tag(Ul.class), ulText, attributes);  	 
	}

	/**
	 * 
	 * @param ulText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Ul(String ulText,  String id, String domClass, String Styles, String jsCallout) {
		super(tag(Ul.class), ulText, id, domClass, Styles, jsCallout);  
	}
	
	/**
	 * 
	 * @param text
	 */
	public void addLi(String text){
		addDomElement(new Li(text));
	}
	/**
	 * 
	 * @param text
	 * @param domClass
	 */
	public void addLi(String text , String domClass){
		addDomElement(new Li(text,domClass));
	}
	
	@Override
	public String toString(){ 
		return super.toString();  
	} 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!element.isOfType(Li.class) && !element.isOfType(Script.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

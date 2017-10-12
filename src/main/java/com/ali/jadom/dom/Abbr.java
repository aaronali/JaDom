package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

/**
 * A HTML abbreviation tag for abbreviated name.
 * @author aaronali
 * @see PhrasingContent 
 * @see PalpableContent
 * @see FlowingContent
 */
public class Abbr extends DOMelement implements PhrasingContent, PalpableContent, FlowingContent{
  
	private static final long serialVersionUID = -2278343244896450378L;
	protected String title; 
	
	/**
	 * Creates an abbreviation with the ame properties as the given element
	 * @param abbr
	 */
	public Abbr(IDOMelement abbr){
		super((DOMelement)abbr);
		this.title = ((Abbr)abbr).title;
	}
	 
	 /**
	  * 
	  * @param title
	  * @param abbreviation
	  * @param attributes
	  */
	public Abbr(String title, String abbreviation, HashMap<String, String> attributes) {
		super("abbr", title, attributes); 
		this.title = title;
		this.addAttribute("title", title); 
	}
	
	/**
	 * 
	 * @param title
	 * @param abbreviation
	 */
	public Abbr(String title, String abbreviation){
		super("abbr", abbreviation);
		this.title=title;   
		this.addAttribute("title", title); 
	}

	/**
	 * 
	 * @param title
	 * @param abbreviation
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Abbr(String title, String abbreviation, String id, String domClass, String Styles, String jsCallout) {
		super("abbr", abbreviation, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.title = title; 
		this.attributes.put("title", title);
	} 
  
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName().concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){
		return super.toString();
	}
	 
	
}  

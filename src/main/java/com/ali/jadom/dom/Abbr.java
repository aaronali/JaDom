package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.PreferredContructor;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
import com.ali.jadom.exceptions.JaDomComplianceError;

/**
 * A HTML abbreviation tag for abbreviated name.
 * @author Aaron Ali
 * @see PhrasingContent 
 * @see PalpableContent
 * @see FlowingContent
 */
public class Abbr extends DOMelement implements PhrasingContent, PalpableContent, FlowingContent{
   
	 
	private static final long serialVersionUID = 5458461965019288151L;
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
		super(tag(Abbr.class), title, attributes); 
		this.title = title;
		this.addAttribute(ApplicationManager.STRING_TITLE, title); 
	}
	
	/**
	 * 
	 * @param title
	 * @param abbreviation
	 */
	@PreferredContructor
	public Abbr(String title, String abbreviation){
		super(tag(Abbr.class), abbreviation);
		this.title=title;   
		this.addAttribute(ApplicationManager.STRING_TITLE, title); 
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
		super(tag(Abbr.class), abbreviation, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.title = title; 
		this.attributes.put(ApplicationManager.STRING_TITLE, title);
	} 
  
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(new JaDomComplianceError(this,element));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){
		return super.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		if(title==null) 
			this.removeAttribute(ApplicationManager.STRING_TITLE);
		else
			this.addAttribute(ApplicationManager.STRING_TITLE, title);
	}
	 
	
}  

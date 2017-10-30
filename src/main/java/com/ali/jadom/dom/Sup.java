package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("sup")
public class Sup extends DOMelement   implements PalpableContent, FlowingContent, PhrasingContent{
  
	private static final long serialVersionUID = -5614749584025535531L;


	public Sup(){
		super(tag(Sup.class), ""); 
	}
	/**
	 * 
	 * @param superscript
	 */
	public Sup( String superscript) {
		super(tag(Sup.class), superscript); 
	}

	 
	 /**
	  * 
	  * @param superscript
	  * @param attributes
	  */
	public Sup(String superscript, HashMap<String, String> attributes) {
		super(tag(Sup.class), superscript, attributes);  
	}

	 /**
	  * 
	  * @param superscript
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Sup(String superscript, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Sup.class), superscript, id, domClass, Styles, jsCallout); 
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

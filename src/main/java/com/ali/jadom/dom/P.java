package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.PreferredContructor;
import com.ali.jadom.dom.superelements.DOMobject;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

/**
 * HTML P paragraph tag
 * @author AARONAli
 *
 */
@Tag("p")
public class P extends DOMelement implements FlowingContent, PalpableContent{ 
	 
 
	private static final long serialVersionUID = 4906513091736458696L;

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
	@PreferredContructor
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

	
	/**
	 * 
	 * @param paragraphText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public P(String paragraphText, String id, DOMobject domClass, String Styles, String jsCallout) {
		super(tag(P.class), paragraphText, id, domClass!=null?domClass.toString():null, Styles, jsCallout); 
	}

	
	
	/**
	 * Creates a new P tag with the given text and where the classObject.toString() becomes
	 * the object DOM class
	 * @param paragraphText
	 * @param classObject
	 */
	@PreferredContructor
	public P(String paragraphText, DOMobject classObject ) {
		super(tag(P.class), paragraphText, classObject!=null?new DOMclass(classObject.toString()):null);  
	}
	
	 
	/**
	 * Creates a P tag where the class is the domClass.toString()
	 * @param paragraphText
	 * @param id
	 * @param domClass
	 */
	public P(String paragraphText, String id, DOMobject domClass ) {
		super(tag(P.class), paragraphText, domClass!=null?new DOMclass(domClass.toString()):null);  
		if(id!=null) this.addAttribute("id",id);
	}

	public void setText(String text) {
		innerHtml(text);
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

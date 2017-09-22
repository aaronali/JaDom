package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.SectioningContent;
/**
 * HTML aside tag
 * @author aaronali
 *
 */
@Tag("aside")
public class Aside extends DOMelement implements FlowingContent, SectioningContent, PalpableContent {
 
	 
	private static final long serialVersionUID = -3230377462376626078L;

	/**
	 * 
	 */
	public Aside( ) {
		super(tag(Aside.class)); 
	}
	
	/**
	 * 
	 * @param aside Aside
	 */
	public Aside(Aside aside){
		super(aside);
	}
	 
	/**
	 * 
	 * @param asideHTML String
	 */
	public Aside( String asideHTML) {
		super(tag(Aside.class), asideHTML); 
	}
	 
	/**
	 * 
	 * @param asideHTML String
	 * @param attributes HashMap&ltString,String&gt
	 */
	public Aside(String asideHTML, HashMap<String, String> attributes) {
		super(tag(Aside.class), asideHTML, attributes);  
	}
	 
	/**
	 * 
	 * @param asideHTML String
	 * @param id String or Null or ApplicationManager.FORCE_NO_ATTRIBTUE
	 * @param domClass String or Null or ApplicationManager.FORCE_NO_ATTRIBTUE
	 * @param Styles String or Null or ApplicationManager.FORCE_NO_ATTRIBTUE
	 * @param jsCallout String or Null or ApplicationManager.FORCE_NO_ATTRIBTUE
	 */
	public Aside(String asideHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Aside.class), asideHTML, id, domClass, Styles, jsCallout); 
	}
 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  element.isOfType(Main.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName().concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString();  
	}
	  
}

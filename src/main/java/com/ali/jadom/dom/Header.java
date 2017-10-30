package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent; 
 
/**
 * HTML &ltheader&gt
 * @author aaronali
 *
 */
@Tag("header")
public class Header extends DOMelement implements PalpableContent, FlowingContent {
  
	private static final long serialVersionUID = 8856886538448498556L;

	/**
	 * Creates an empty &ltheader&gt tag.
	 */
	public Header() {
		super(tag(Header.class)); 
	}
	 
	/**
	 * Creates an empty header tag with the given element
	 * @param element
	 */
	public Header(DOMelement element){
		super(tag(Header.class),element);
	}
	/**
	 * Creates a Header  tag with the given htmlCode
	 * @param headerCode
	 */
	public Header( String headerCode) {
		super(tag(Header.class), headerCode); 
	}
	
	/**
	 * Creates a header tag with the given attributes
	 * @param headerCode
	 * @param attributes
	 */
	public Header(String headerCode, HashMap<String, String> attributes) {
		super(tag(Header.class), headerCode, attributes);  
	}

	 /**
	  * Creates a header with the given properties
	  * @param headerCode
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Header(String headerCode, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Header.class), headerCode, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&( !element.isOfType(FlowingContent.class) || element.isOfType(Header.class) || element.isOfType(Footer.class)||element.isOfType(Main.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	
}
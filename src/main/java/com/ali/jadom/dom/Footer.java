package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

@Tag("footer")
public class Footer extends DOMelement implements FlowingContent , PalpableContent{
 
	 
	private static final long serialVersionUID = -7432190560103761206L;

	/**
	 * 
	 */
	public Footer(){
		super(tag(Footer.class)); 
	}
	
	public Footer(IDOMelement element){
		super((Footer)element);
	}
	
	
	/**
	 * 
	 * @param code
	 */
	public Footer( String code) {
		super(tag(Footer.class), code); 
	}	
	
	/**
	 * 
	 * @param code
	 * @param attributes
	 */
	public Footer(String code, HashMap<String, String> attributes) {
		super(tag(Footer.class), code, attributes);  
	} 
	
	/**
	 * 
	 * @param code
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Footer(String code, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Footer.class), code, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&(!element.isOfType(FlowingContent.class) || element.isOfType(Header.class) || element.isOfType(Footer.class) || element.isOfType(Main.class)) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	} 
	
}

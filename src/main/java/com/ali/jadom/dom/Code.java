package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("code")
public class Code extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent { 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2870114112325000012L;

	public Code() {
		super(tag(Code.class)); 
	}
	
	public Code(IDOMelement code){
		super((Code)code);
	}

	public Code( String code) {
		super(tag(Code.class), code); 
	}
	
	public Code(String code, HashMap<String, String> attributes) {
		super(tag(Code.class), code, attributes);  
	}
 
	 
	public Code(String code, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Code.class), code, id, domClass, Styles, jsCallout); 
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

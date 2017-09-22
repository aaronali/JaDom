package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.SectioningContent;

@Tag("dt")
public class Dt extends DOMelement {
 
 
	private static final long serialVersionUID = -7655727431987896667L;
	public Dt(){
		super(tag(Dt.class)); 
	}
	 
	public Dt( String dtHTML) {
		super(tag(Dt.class), dtHTML); 
	}	
	 
	public Dt(String dtHTML, HashMap<String, String> attributes) {
		super(tag(Dt.class), dtHTML, attributes);  
	}

	public Dt(String dtHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Dt.class), dtHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&(!element.isOfType(FlowingContent.class)||  element.isOfType(Header.class)|| element.isOfType(Footer.class) || element.isOfType(SectioningContent.class,HeadingContent.class)) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

@Tag("dl")
public class Dl extends DOMelement implements FlowingContent, PalpableContent { 

	private static final long serialVersionUID = 1774673836855902202L;

	public Dl(){
		super(tag(Dl.class)); 
	}
	 
	public Dl( String dlHTML) {
		super(tag(Dl.class), dlHTML); 
	} 
	
	public Dl(String dlHTML, HashMap<String, String> attributes) {
		super(tag(Dl.class), dlHTML, attributes);  
	}

	public Dl(String dlHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Dl.class), dlHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	} 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&(!element.isOfType(Dt.class)|| !element.isOfType(Dd.class)) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

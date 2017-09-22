package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@SuppressWarnings("serial")
@Tag("kbd")
public class Kbd extends DOMelement implements PhrasingContent, FlowingContent,PalpableContent {
 

	public Kbd() {
		super(tag(Kbd.class)); 
	}

	
	public Kbd( String keyboardKeyString) {
		super(tag(Kbd.class), keyboardKeyString); 
	}
 
	 
	public Kbd(String keyboardKeyString, HashMap<String, String> attributes) {
		super(tag(Kbd.class), keyboardKeyString, attributes);  
	}

	 
	public Kbd(String keyboardKeyString, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Kbd.class), keyboardKeyString, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  !element.isOfType(PhrasingContent.class)){ 
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		}
		return super.addDomElement(element);
	}
}

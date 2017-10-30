package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("br")
public class Input extends DOMelement implements PhrasingContent, FlowingContent{ 
	 
	 
	private static final long serialVersionUID = -3203109348022407717L;

	public Input( HashMap<String, String> attributes) {
		super(tag(Input.class), ApplicationManager.NULL_NODE_VALUE, attributes);  
	}

	 
	public Input() {
		super(tag(Input.class),  ApplicationManager.NULL_NODE_VALUE); 
	}

	 
	public Input(String id, String domClass, String Styles, String jsCallout) {
		super(tag(Input.class), ApplicationManager.NULL_NODE_VALUE, id, domClass, Styles, jsCallout); 
	}
 
	
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  element.isOfType(FlowingContent.class, InteractiveContent.class, PalpableContent.class, PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have any child elements. To override set ApplicationManager.FORCE_HTML_COMPLIANCE to false"));
		return super.addDomElement(element);
	}
	
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

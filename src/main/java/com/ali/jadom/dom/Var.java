package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("var")
public class Var extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1223915577519722838L;

	public Var(){
		super(tag(Var.class),"");
	}
	
	public Var( String varText) {
		super(tag(Var.class), varText); 
	}

	 
	 
	public Var(String varText, HashMap<String, String> attributes) {
		super(tag(Var.class), varText, attributes);  
	}

	 
	public Var(String varText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Var.class), varText, id, domClass, Styles, jsCallout); 
	}
	


	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element of type ").concat(element.getClass().getCanonicalName()));
		return super.addDomElement(element);
	}
	
}

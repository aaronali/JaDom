package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

@Tag("div")
public class Div extends DOMelement implements FlowingContent, PalpableContent{
 
	 
	private static final long serialVersionUID = -5178170859535121846L;

	public Div(){
		super(tag(Div.class));
	}
	
	public Div( String divHTML) {
		super(tag(Div.class), divHTML); 
	}

	 
	public Div(String divHTML, HashMap<String, String> attributes) {
		super(tag(Div.class), divHTML, attributes);  
	}

	
	 
	public Div(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Div.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&! element.isOfType(FlowingContent.class) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

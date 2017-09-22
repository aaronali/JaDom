package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.SectioningContent;

@Tag("details")
public class Details extends DOMelement implements SectioningContent, InteractiveContent, FlowingContent, PalpableContent{
 
	 
	private static final long serialVersionUID = -4935084219781787549L;
	protected boolean open;
	
	public Details(){
		super(tag(Details.class));
	}
	
	public Details( String divHTML) {
		super(tag(Details.class), divHTML); 
	}

	 
	public Details(String divHTML, HashMap<String, String> attributes) {
		super(tag(Details.class), divHTML, attributes);  
	}

	
	 
	public Details(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Details.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&(this.getEmbeddedElements()==null && !element.isOfType(Summary.class)) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("summary")
public class Summary extends DOMelement{
  
	private static final long serialVersionUID = -3844791257463157609L;

	public Summary(){
		super(tag(Summary.class));
	}
	
	public Summary( String divHTML) {
		super(tag(Summary.class), divHTML); 
	}

	 
	public Summary(String divHTML, HashMap<String, String> attributes) {
		super(tag(Summary.class), divHTML, attributes);  
	}

	
	 
	public Summary(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Summary.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&( ! element.isOfType(PhrasingContent.class) ||( this.contains(HeadingContent.class) && element.isOfType(HeadingContent.class))))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

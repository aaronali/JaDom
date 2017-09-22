package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 
@Tag("del")
public class Del extends DOMelement implements FlowingContent {
  
	private static final long serialVersionUID = -1329177223378965195L;
	protected String cite;
	protected String datetime;
	
	
	public Del(){ 
		super(tag(Del.class)); 
	}
	
	public Del( String insHTML) {
		super(tag(Del.class), insHTML); 
	}
	
	public Del( String insHTML, String cite, String  datetime) {
		super(tag(Del.class), insHTML); 
		this.cite = cite;
		this.datetime = datetime;
		if(cite!=null)
			addAttribute("cite", cite);
		if(datetime!=null)
			addAttribute("datetime", datetime);
	}
	 
	public Del(String insHTML, HashMap<String, String> attributes) {
		super(tag(Del.class), insHTML, attributes); 
		if(attributes!=null){ 
			if(attributes.get("cite")!=null)
				this.cite = attributes.get("cite"); 
			if(attributes.get("datetime")!=null)
				this.cite = attributes.get("datetime"); 
		}
	}

	 
	 
	public Del(String insHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Del.class), insHTML, id, domClass, Styles, jsCallout); 
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

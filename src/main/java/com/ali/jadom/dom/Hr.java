package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;

@Tag("hr")
public class Hr extends DOMelement implements FlowingContent{ 
	 
	 
	private static final long serialVersionUID = 6827204900631742342L;

	/**
	 * 
	 * @param attributes
	 */
	public Hr( HashMap<String, String> attributes) {
		super(tag(Hr.class),"nullnodevalue", attributes);  
	}

	/**
	 * 
	 * @param element
	 */
	public Hr(DOMelementInterface element){
		super((Hr)element);
	}
	 
	/**
	 * 
	 */
	public Hr() {
		super(tag(Hr.class), "nullnodevalue"); 
	}

	 
	/**
	 * 
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Hr(String id, String domClass, String Styles, String jsCallout) {
		super(tag(Hr.class), "nullnodevalue", id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element").concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	
}

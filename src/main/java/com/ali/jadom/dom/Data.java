package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("data")
public class Data extends DOMelement implements FlowingContent, PhrasingContent, PalpableContent{
  
	private static final long serialVersionUID = -6698027589833417534L;
	public String value;
	
	/**
	 * 
	 * @param element
	 */
	public Data(IDOMelement element){
		super((DOMelement)element);
		this.value =((Data)element).value;
	}
	
	/**
	 * 
	 * @param valueText
	 * @param value
	 */
	public Data( String valueText, String value) {
		super(tag(Data.class), valueText); 
		addAttribute("value", value);
		this.value = value;
	} 
	 
	/**
	 * 
	 * @param valueText
	 * @param attributes
	 */
	public Data(String valueText, HashMap<String, String> attributes) {
		super(tag(Data.class), valueText, attributes);  
	}

	 /**
	  * 
	  * @param valueText
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Data(String valueText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Data.class), valueText, id, domClass, Styles, jsCallout); 
	}
	
	public void setValue(String value, String valueText){
		this.value=value;
		addAttribute("value", value);
		this.nodevalue =  valueText;
	}
	
	public String getValue(){
		return value;
	}


	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	 
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
/**
 * list item tag.
 * @author aaronali
 *
 */
@Tag("li")
public class Li extends DOMelement  {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5932877421911422209L;
	int value ;
	
	 /**
	  * 
	  * @param liText
	  * @param attributes
	  */
	public Li(String liText, HashMap<String, String> attributes) {
		super(tag(Li.class), liText, attributes);  
		if(attributes.get("value")!=null)
			this.value = Integer.valueOf(attributes.get("value"));
	}
	/**
	 * 
	 */
	public Li(){
		super(tag(Li.class)); 
	}
	/**
	 * 
	 * @param text
	 * @param domClass
	 */
	public Li(String text, String domClass){
		super(tag(Li.class),text,null,domClass,null,null);
	}
	 
	public Li(String text, String domClass,int value){
		super(tag(Li.class),text,null,domClass,null,null);
		this.value=value;
		addAttribute("value",value);
				
	}
	 
	
	/**
	 * 
	 * @param liText
	 */
	public Li( String liText) {
		super(tag(Li.class), liText); 
	}
	
	/**
	 * 
	 * @param liText
	 * @param value
	 */
	public Li( String liText, int value) {
		super(tag(Li.class), liText); 
		this.value = value;
		addAttribute("value",value);
	}
	
	/**
	 * 
	 * @param liText
	 * @param value
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Li(String liText, int value, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Li.class), liText, id, domClass, Styles, jsCallout); 
		addAttribute("value",value);
		this.value=value;
	}

	
	/**
	 * 
	 * @return int
	 */
	public synchronized final int getValue() {
		return value;
	}
	/**
	 * 
	 * @param value int
	 */
	public synchronized final void setValue(int value) {
		this.value = value;
	}
	/**
	 * 
	 * @return
	 */
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

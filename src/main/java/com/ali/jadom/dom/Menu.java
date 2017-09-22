package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
 

@Tag("menu")
public class Menu extends DOMelement implements FlowingContent, PalpableContent{
  
	public enum MenuState{
		popup,
		toolbar;
		@Override
		public String toString(){
			return this.name();
		}
	};
	protected String type ="popup";
	protected String label;
	private static final long serialVersionUID = -2096748663051558682L;
	/**
	 * 
	 */
	public Menu(){
		super(tag(Menu.class), ""); 
	}
	 /**
	  * 
	  * @param ulText
	  */
	public Menu( String menuHtml) {
		super(tag(Menu.class), menuHtml); 
	} 
	/**
	 * 
	 * @param ulText
	 * @param attributes
	 */
	public Menu(String ulText, HashMap<String, String> attributes) {
		super(tag(Menu.class), ulText, attributes);  	 
	}

	/**
	 * 
	 * @param ulText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Menu(String ulText,  String id, String domClass, String Styles, String jsCallout) {
		super(tag(Menu.class), ulText, id, domClass, Styles, jsCallout);  
	}
	
	/**
	 * 
	 * @param text
	 */
	public void addLi(String text){
		addDomElement(new Li(text));
	}
	/**
	 * 
	 * @param text
	 * @param domClass
	 */
	public void addLi(String text , String domClass){
		addDomElement(new Li(text,domClass));
	}
	
	
	
	public synchronized final String getType() {
		return type;
	}
	public synchronized final void setType(MenuState type) {
		this.type = type.toString();
		addAttribute("type",type.toString());
	}
	public synchronized final String getLabel() {
		return label;
	}
	public synchronized final void setLabel(String label) {
		this.label = label;
		if(label==null)
			removeAttribute("label");
		else
			addAttribute("label", label);
	}
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString(){ 
		return super.toString();  
	} 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!element.isOfType(Li.class) && !element.isOfType(Script.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

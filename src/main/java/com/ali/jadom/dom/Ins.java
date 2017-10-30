package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 
@Tag("ins")
public class Ins extends DOMelement implements FlowingContent, PhrasingContent ,  PalpableContent {
  
	private static final long serialVersionUID = -1329177223378965195L;
	protected String cite;
	protected String datetime;
	
	/**
	 * 
	 */
	public Ins(){ 
		super(tag(Ins.class)); 
	}
	/**
	 * 
	 * @param insHTML
	 */
	public Ins( String insHTML) {
		super(tag(Ins.class), insHTML); 
	}
	/**
	 * 
	 * @param insHTML
	 * @param cite
	 * @param datetime
	 */
	public Ins( String insHTML, String cite, String  datetime) {
		super(tag(Ins.class), insHTML); 
		this.cite = cite;
		this.datetime = datetime;
		if(cite!=null)
			addAttribute("cite", cite);
		if(datetime!=null)
			addAttribute("datetime", datetime);
	}
	 /**
	  * 
	  * @param insHTML
	  * @param attributes
	  */
	public Ins(String insHTML, HashMap<String, String> attributes) {
		super(tag(Ins.class), insHTML, attributes); 
		if(attributes!=null){ 
			if(attributes.get("cite")!=null)
				this.cite = attributes.get("cite"); 
			if(attributes.get("datetime")!=null)
				this.cite = attributes.get("datetime"); 
		}
	}

	 
	/**
	 * 
	 * @param insHTML
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Ins(String insHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Ins.class), insHTML, id, domClass, Styles, jsCallout); 
	}

	
	
	/**
	 * 
	 * @return
	 */
	public synchronized final String getCite() {
		return cite;
	}
	/**
	 * 
	 * @param cite
	 */
	public synchronized final void setCite(String cite) {
		this.cite = cite;
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final String getDatetime() {
		return datetime;
	}
	/**
	 * 
	 * @param datetime
	 */
	public synchronized final void setDatetime(String datetime) {
		this.datetime = datetime;
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
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  !element.isOfType(PhrasingContent.class)){ 
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		}
		return super.addDomElement(element);
	}
	
}

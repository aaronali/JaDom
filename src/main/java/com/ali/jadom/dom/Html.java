package com.ali.jadom.dom;

import java.util.HashMap;
 
 
@Tag("html")
public class Html extends DOMelement {
  
	private static final long serialVersionUID = 5014174600136364073L;
	protected String lang = ApplicationManager.DEFAULT_HTML_LANG;
	
	/**
	 * 
	 * @param element
	 */
	public Html(DOMelementInterface element){
		super((Html)element);
		this.lang=((Html)element).lang;
	}
	
	/**
	 * 
	 */
	public Html() {
		super(tag(Html.class)); 
		addAttribute("lang",lang);
	}
	
	/**
	 * 
	 * @param html
	 */
	public Html( String html) {
		super(tag(Html.class), html); 
		addAttribute("lang",lang);
	}
	
	 /**
	  * 
	  * @param html
	  * @param attributes
	  */
	public Html(String html, HashMap<String, String> attributes) {
		super(tag(Html.class), html, attributes);
		if(attributes!=null)
			if(attributes.get("lang")!=null)
				this.lang =attributes.get("lang");
			else
				addAttribute("lang", lang);
		
	}

	 	
	/**
	 * 
	 * @param html
	 * @param lang
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Html(String html, String lang,  String id, String domClass, String Styles, String jsCallout) {
		super(tag(Html.class), html, id, domClass, Styles, jsCallout); 
		if(lang!=null) 
			this.lang = lang; 
		addAttribute("lang",lang);
	}
	
	
	/**
	 * 
	 * @param body
	 */
	public void addBody(Body body){
		//addDomElement(body);
		if(this.getEmbeddedElements()==null){
			this.addDomElement(new Head());
			this.addDomElement(body);
			return;
		}else{
			if(this.contains(Body.class)){
				this.removeDomElement(Body.class);
			}
		
		}
		this.addDomElement(body);
	}
	

	/**
	 * 
	 * @param head
	 */
	public void addHeadrt(Head head){
		addDomElement(head);
	}
	


	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&( !element.isOfType(Body.class) || !element.isOfType(Head.class))){
			if(element.isOfType(Body.class) && this.contains(Body.class))
				throw new RuntimeException(this.getClass().getCanonicalName().concat(" can only have one ").concat(element.getClass().getCanonicalName()));
			if(element.isOfType(Head.class) && this.contains(Head.class))
				throw new RuntimeException(this.getClass().getCanonicalName().concat(" can only have one ").concat(element.getClass().getCanonicalName()));
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		}
		return super.addDomElement(element);
	}
	
	
}

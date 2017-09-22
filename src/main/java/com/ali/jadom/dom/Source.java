package com.ali.jadom.dom;

import java.util.HashMap;

@Tag("source")
public class Source extends DOMelement {
  
	private static final long serialVersionUID = 1L;
	protected String src;
	protected String type;
	protected boolean isExternal;
	
	
	/**
	 * 
	 * @param src
	 * @param isExternal
	 * @param type
	 */
	public Source( String src , boolean isExternal, String type) {
		super(tag(Source.class), "nullnodevalue"); 
		this.src = src;
		this.type = type;
		this.isExternal=isExternal;
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
	}
	
	/**
	 * 
	 * @param src
	 * @param isExternal
	 * @param type
	 * @param attributes
	 */
	public Source(String src,  boolean isExternal,String type,  HashMap<String, String> attributes) {
		super(tag(Source.class), "nullnodevalue", attributes);  
		this.src = src;
		this.type = type;
		this.isExternal=isExternal;
		this.attributes =attributes;
		if(attributes!=null){ 
			if(attributes.get("type")!=null)
				this.type = attributes.get("type"); 
		}
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
	}

	 
	 /**
	  * 
	  * @param src
	  * @param isExternal
	  * @param type
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Source(String src,  boolean isExternal,String type,String id, String domClass, String Styles, String jsCallout) {
		super(tag(Source.class), "nullnodevalue", id, domClass, Styles, jsCallout); 
		this.src = src;
		this.type = type;
		this.isExternal=isExternal;
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element \n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	} 
}

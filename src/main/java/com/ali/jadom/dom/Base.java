package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.MetadataContent;
 
/**
 * An html5 &ltbase&gt tag for use in the Head element with no exisiting &ltase&gt tag. The &ltbase&gt tag is used to denote the document base URL. The &ltbase&gt tag must have an href, a target or both.
 * @author aaronali
 *
 */
@Tag("base")
public class Base extends DOMelement implements MetadataContent{
  
	private static final long serialVersionUID = 7613369185561199540L;
	protected String href;
	protected String target = null; 
	protected boolean useLinkManager = false;
	
	/**
	 * Creates &ltbase&gt tag with no given values
	 */
	public Base(){
		super(tag(Base.class), ApplicationManager.NULL_NODE_VALUE); 
	}
	
	/**
	 * Creates &ltbase&gt tag with the same properties as the given element
	 * @param base
	 */
	public Base(Base base) {
		super(base);
		this.href =base.href;
		this.target =base.target;
		this.useLinkManager=base.useLinkManager;
	}
	
	/**
	 *  Creates &ltbas&gt tag with the given attributes
	 * @param href
	 * @param useLinkManager
	 * @param attributes
	 */
	public Base( String href, boolean useLinkManager, HashMap<String, String> attributes) {
		super(tag(Base.class), ApplicationManager.NULL_NODE_VALUE, attributes); 
		this.useLinkManager = useLinkManager;
		this.href = href;
		this.addAttribute("href",(useLinkManager)? href: "Link?page="+href);
		
	} 

	/**
	 * Creates &ltbas&gt tag with the given href value 
	 * @param href
	 * @param useLinkManager
	 */
	public Base( String href, boolean useLinkManager) {
		super(tag(Base.class), ApplicationManager.NULL_NODE_VALUE);
		this.href = href;
		this.useLinkManager = useLinkManager;
		this.addAttribute("href",(!useLinkManager)? href: "Link?page="+href);
	}

	/**
	 * Creates &ltbas&gt tag with the given href value and attributes
	 * @param href
	 * @param useLinkManager
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Base( String href,boolean useLinkManager, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Base.class), ApplicationManager.NULL_NODE_VALUE, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.href =href; 
		this.useLinkManager = useLinkManager;
		this.addAttribute("href",(!useLinkManager)? href: "Link?page="+href);
	}
	
	/**
	 * Gets the current href value
	 * @return String
	 */
	public final String getHref() {
		return href;
	}

	/**
	 * Sets the current href value
	 * @param href String or null
	 */
	public final void setHref(String href) {
		this.href = href;
		if(href!=null)
			addAttribute("href",href);
		else
			removeAttribute("href");
	}

	/**
	 * Gets the current target value
	 * @return String
	 */
	public final String getTarget() {
		return target;
	}

	/**
	 * Sets the current target value
	 * @param target String or null
	 */
	public final void setTarget(String target) {
		this.target = target;
		if(target!=null)
			addAttribute("target",href);
		else
			removeAttribute("target");
	}

	public final boolean isLinkManager() {
		  return this.useLinkManager;
	}

	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Sets the base href value to use the Link servlet manager
	 * @param useLinkManager
	 */
	public final void setExternal(boolean useLinkManager) {
		this.useLinkManager = useLinkManager;
		if(!useLinkManager){
			href = href.replace("Link?page=","");
		}else{
			if(!href.contains("Link"))
				href="Link?page="+href;
		}
		addAttribute("href", href);
	}

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element ").concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return  super.toString();  
	} 
}  

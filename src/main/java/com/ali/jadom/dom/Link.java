package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 

@Tag("link") 
public class Link extends DOMelement  implements MetadataContent, FlowingContent, PhrasingContent{
  
	private static final long serialVersionUID = -7291512713103019496L;
	protected String href;
	protected boolean newTab = false;
	protected boolean isExternal = false;
	protected String crossorgin ; 
	protected String size;
	protected MediaTypes media;   
	protected boolean ismap;
	protected String usemap;
	protected String hreflang;
	protected String type;
	protected RelType rel;
	protected String title;
	
	/**
	 * Creates a &ltlink&gt tag with the given resources
	 * @param href
	 * @param newTab
	 * @param isExternal
	 * @param crossorgin
	 * @param hreflang
	 * @param size
	 * @param media
	 * @param rel
	 * @param type
	 * @param ismap
	 * @param usemap
	 */
	public Link(String href, boolean newTab, boolean isExternal, String crossorgin, String hreflang,
			String size, MediaTypes media, RelType rel, String type, boolean ismap, String usemap) {
		super(tag(Img.class), "nullnodevalue");
		this.href = href;
		this.newTab = newTab;
		this.isExternal = isExternal;
		if(newTab && !isExternal)
			addAttribute("href",href);
		else
			addAttribute("href","Link?page="+href);
		this.crossorgin = crossorgin;
		if(crossorgin!=null)
			addAttribute("crossorgin",crossorgin);
		this.size = size;
		if(size!=null)
			addAttribute("size",size);
		this.media = media;
		if(media!=null) 
			this.media = Enum.valueOf(MediaTypes.class,attributes.get("media"));
		this.ismap = ismap;
		if(ismap)
			addAttribute("ismap",String.valueOf(ismap));
		this.usemap = usemap;
		if(usemap!=null)
			addAttribute("usemap",usemap); 
		this.hreflang = hreflang;
		if(hreflang!=null)
			addAttribute("hreflang",hreflang); 
		this.rel =rel;
		if(rel!=null)
			addAttribute("rel",rel.toString());
		this.type =type;
		if(type!=null)
			addAttribute("type",type);
		this.forceNoId();
	}

	/**
	 * 
	 * @param element DOMelementInterface
	 */
	 public Link(DOMelementInterface element){
		 super((Link)element);
		 this.crossorgin =((Link)element).crossorgin;
		 this.href=((Link)element).href;
		 this.hreflang=((Link)element).hreflang;
		 this.isExternal=((Link)element).isExternal;
		 this.ismap=((Link)element).ismap;
		 this.media=((Link)element).media;
		 this.newTab=((Link)element).newTab;
		 this.rel=((Link)element).rel;
		 this.size=((Link)element).size;
		 this.title=((Link)element).title;
		 this.type=((Link)element).type;
		 this.usemap=((Link)element).usemap;
	 }

	/**
	 * Creates a &ltlink&gt tag with the given resources
	 * @param href
	 * @param isExternal
	 * @param attributes
	 */
	public Link( String href, boolean isExternal, HashMap<String, String> attributes) {
		super(tag(Link.class), "nullnodevalue", attributes); 
		this.isExternal = isExternal;
		this.attributes = attributes;
		this.href = href;
		if(attributes!=null){
			if(attributes.get("hreflang")!=null)
				this.hreflang = attributes.get("hreflang"); 
			if(attributes.get("crossorgin")!=null)
				this.crossorgin = attributes.get("crossorgin"); 
			if(attributes.get("rel")!=null)
				this.rel = Enum.valueOf(RelType.class, attributes.get("rel"));
			if(attributes.get("media")!=null)
				this.media = Enum.valueOf(MediaTypes.class,attributes.get("media"));
			if(attributes.get("size")!=null)
				this.type = attributes.get("size");  
			if(attributes.get("usemap")!=null)
				this.usemap = attributes.get("usemap"); 
			if(attributes.get("ismap")!=null)
				this.ismap = Boolean.valueOf(attributes.get("ismap"));
			if(attributes.get("size")!=null)
				this.size = attributes.get("size");
			if(attributes.get("type")!=null)
				this.size = attributes.get("type");
		}
		this.addAttribute("href",(isExternal)? href: "Link?page="+href);  
		this.forceNoId();
	}
	 
	/**
	 * Creates a &ltlink&gt tag with the given resources
	 * @param href
	 * @param type
	 * @param isExternal
	 */
	public Link( String href,String type, boolean isExternal) {
		super(tag(Link.class), "nullnodevalue");
		this.href = href;
		this.isExternal = isExternal;
		this.addAttribute("href",(!isExternal)? href: "Link?page="+href);
		this.type =type;
		if(type!=null)
			addAttribute("type", type);
		this.forceNoId();
	}


	/**
	 * Creates a &ltlink&gt tag with the given resources
	 * @param href
	 * @param isExternal
	 * @param type
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Link(String href,boolean isExternal, String type, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Link.class), "nullnodevalue", (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.href =href; 
		this.isExternal = isExternal;
		this.addAttribute("href",(isExternal)? href: "Link?page="+href);
		this.type =type;
		if(type!=null)
			addAttribute("type", type);
		this.forceNoId();
	}

	 
	/**
	 * Gets the current href value of the link
	 * @return
	 */
	public final String getHref() {
		return href;
	}

	/**
	 * Sets the current href value of the link
	 * @param href
	 */
	public final void setHref(String href) {
		this.href = href;
		if(this.isExternal)
			addAttribute("href",href);
		else
			addAttribute("hred","Link?page="+href);
	}

	/**
	 * Returns true if the link is pointing to an external web site
	 * @return
	 */
	public final boolean isExternal() {
		return isExternal;
	}

	/**
	 * Lets system know where or not to use internal link manger servlet
	 * This is a special method to be used in conjunction with servlets
	 * @param isExternal
	 */
	public final void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
		if(isExternal){
			href  = href.replace("Link?page=", "");
			addAttribute("href",href);
		}else{
			if(!href.contains("Link?page="))
				href.replace("Link?page=", "");
		}
	}

	/**
	 * Returns the current value of the crossorgin for this link
	 * @return
	 */
	public final String getCrossorgin () {
		return crossorgin ;
	}

	/**
	 * Sets the current links cross orgin text
	 * @param crossorgin
	 */
	public final void setCrossorgin (String crossorgin ) {
		this.crossorgin  = crossorgin ;
		addAttribute("crossorgin ",crossorgin );
	}

	/**
	 * Gets the link relationship to the page
	 * @see RelType
	 * @return
	 */
	public final RelType getRel() {
		return rel;
	}

	/**
	 * Sets the relationship of the link to the page.
	 * @see RelType
	 * @param rel
	 */
	public final void setRel(RelType rel) {
		this.rel = rel;
		addAttribute("rel",rel.toString());
	}

	/**
	 * Returns the media type of the link.
	 * @see MediaTypes
	 * @return
	 */
	public final MediaTypes getMedia() {
		return media;
	}

	/**
	 * Sets the media type of the link.
	 * @see MediaTypes
	 * @param media
	 */
	public final void setMedia(MediaTypes media) {
		this.media = media;
		addAttribute("media", media.toString());
	}

	 /***
	  * Returns the type value of the link.
	  * @return
	  */
	public final String getType() {
		return type;
	}

	/**
	 * Sets the type value of the link.
	 * @param type
	 */
	public final void setType(String type) {
		this.type = type;
		addAttribute("type",type.toString());
	}
  
	/**
	 * Returns the ismap value of the link
	 * @return
	 */
	public final boolean isIsmap() {
		return ismap;
	}


	/**
	 * Sets the ismap value of the link.
	 * @param ismap
	 */
	public final void setIsmap(boolean ismap) {
		this.ismap = ismap; 
		addAttribute("ismap", String.valueOf(ismap));
	}


	/**
	 * Returns the href language of the link.
	 * @return
	 */
	public final String getHreflang() {
		return hreflang;
	}


	/**
	 * Sets the href language of the current link.
	 * @param hreflang
	 */
	public final void setHreflang(String hreflang) {
		this.hreflang = hreflang;
		addAttribute("hreflang",hreflang);
	} 
	
	/**
	 * Returns the size value of the link, to be used when linking icons.
	 * @return
	 */
	public final String getSize() {
		return size;
	}

	/**
	 * Sets the size value of the link, to be used when linking icons.
	 * @param size
	 */
	public final void setSize(String size) {
		this.size = size;
		addAttribute(size, size);
	}

	@Override
	public String toString(){ 
		return "\n"+super.toString();  
	} 

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element").concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}  

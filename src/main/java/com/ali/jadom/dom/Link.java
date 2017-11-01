package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 

/**
 * Html link class
 * @author Aaron Ali 
 */
@Tag("link") 
public class Link extends DOMelement  implements MetadataContent, FlowingContent, PhrasingContent{
   
   
	private static final long serialVersionUID = -2550311026984548961L;
	protected String href;
	protected boolean newTab = false;
	protected boolean isExternal = false;
	protected String crossorgin ; 
	protected String size;
	protected MediaTypesEnum media;   
	protected boolean ismap;
	protected String usemap;
	protected String hreflang;
	protected String type;
	protected RelTypeEnum rel;
	protected String title;
	
	/**
	 * Creates a &ltlink&gt tag with the given resources 
	 * 
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
			String size, MediaTypesEnum media, RelTypeEnum rel, String type, boolean ismap, String usemap) {
		super(tag(Link.class), ApplicationManager.NULL_NODE_VALUE);
		this.href = href;
		this.addAttribute(ApplicationManager.STRING_HREF, href);
		this.newTab = newTab; 
 		this.crossorgin = crossorgin;
		if(crossorgin!=null)
			addAttribute(ApplicationManager.STRING_CROSSORIGIN,crossorgin);
		this.size = size;
		if(size!=null)
			addAttribute(ApplicationManager.STRING_SIZE,size);
		this.media = media;
		if(media!=null) 
			this.media = Enum.valueOf(MediaTypesEnum.class,attributes.get(ApplicationManager.STRING_MEDIA));
		this.ismap = ismap;
		if(ismap)
			addAttribute(ApplicationManager.STRING_ISMAP,String.valueOf(ismap));
		this.usemap = usemap;
		if(usemap!=null)
			addAttribute(ApplicationManager.STRING_USEMAP,usemap); 
		this.hreflang = hreflang;
		if(hreflang!=null)
			addAttribute(ApplicationManager.STRING_HREFLANG,hreflang); 
		this.rel =rel;
		if(rel!=null)
			addAttribute(ApplicationManager.STRING_REL,rel.toString());
		this.type =type;
		if(type!=null)
			addAttribute(ApplicationManager.STRING_TYPE,type);
		this.forceNoId();
	}

	/**
	 * 
	 * @param element DOMelementInterface
	 */
	 public Link(IDOMelement element){
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
		super(tag(Link.class), ApplicationManager.NULL_NODE_VALUE, attributes); 
		this.isExternal = isExternal;
		this.attributes = attributes;
		this.href = href;
		this.addAttribute(ApplicationManager.STRING_HREF, href);
		if(attributes!=null){
			if(attributes.get(ApplicationManager.STRING_HREFLANG)!=null)
				this.hreflang = attributes.get(ApplicationManager.STRING_HREFLANG); 
			if(attributes.get(ApplicationManager.STRING_CROSSORIGIN)!=null)
				this.crossorgin = attributes.get(ApplicationManager.STRING_CROSSORIGIN); 
			if(attributes.get(ApplicationManager.STRING_REL)!=null)
				this.rel = Enum.valueOf(RelTypeEnum.class, attributes.get(ApplicationManager.STRING_REL));
			if(attributes.get(ApplicationManager.STRING_MEDIA)!=null)
				this.media = Enum.valueOf(MediaTypesEnum.class,attributes.get(ApplicationManager.STRING_MEDIA));
			if(attributes.get(ApplicationManager.STRING_SIZE)!=null)
				this.type = attributes.get(ApplicationManager.STRING_SIZE);  
			if(attributes.get(ApplicationManager.STRING_USEMAP)!=null)
				this.usemap = attributes.get(ApplicationManager.STRING_USEMAP); 
			if(attributes.get(ApplicationManager.STRING_ISMAP)!=null)
				this.ismap = Boolean.valueOf(attributes.get(ApplicationManager.STRING_ISMAP));
			if(attributes.get("size")!=null)
				this.size = attributes.get("size");
			if(attributes.get(ApplicationManager.STRING_TYPE)!=null)
				this.size = attributes.get(ApplicationManager.STRING_TYPE);
		}
		this.addAttribute(ApplicationManager.STRING_HREF,href);  
		this.forceNoId();
	}
	 
	/**
	 * Creates a &ltlink&gt tag with the given resources
	 * @param href
	 * @param type
	 * @param isExternal
	 */
	public Link( String href,String type, boolean isExternal) {
		super(tag(Link.class), ApplicationManager.NULL_NODE_VALUE); 
		this.setHref(href);
		this.isExternal = isExternal;
		this.addAttribute(ApplicationManager.STRING_HREF, href);
		this.type =type;
		if(type!=null)
			addAttribute(ApplicationManager.STRING_TYPE, type);
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
		super(tag(Link.class), ApplicationManager.NULL_NODE_VALUE, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.href =href; 
		this.setHref(href);
		this.isExternal = isExternal;
		this.addAttribute(ApplicationManager.STRING_HREF,href);
		this.type =type;
		if(type!=null)
			addAttribute(ApplicationManager.STRING_TYPE, type);
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
		addAttribute(ApplicationManager.STRING_HREF,href); 
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
		addAttribute(ApplicationManager.STRING_CROSSORIGIN,crossorgin );
	}

	/**
	 * Gets the link relationship to the page
	 * @see RelTypeEnum
	 * @return
	 */
	public final RelTypeEnum getRel() {
		return rel;
	}

	/**
	 * Sets the relationship of the link to the page.
	 * @see RelTypeEnum
	 * @param rel
	 */
	public final void setRel(RelTypeEnum rel) {
		this.rel = rel;
		addAttribute(ApplicationManager.STRING_REL,rel.toString());
	}

	/**
	 * Returns the media type of the link.
	 * @see MediaTypesEnum
	 * @return
	 */
	public final MediaTypesEnum getMedia() {
		return media;
	}

	/**
	 * Sets the media type of the link.
	 * @see MediaTypesEnum
	 * @param media
	 */
	public final void setMedia(MediaTypesEnum media) {
		this.media = media;
		addAttribute(ApplicationManager.STRING_MEDIA, media.toString());
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
		addAttribute(ApplicationManager.STRING_TYPE,type.toString());
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
		addAttribute(ApplicationManager.STRING_ISMAP, String.valueOf(ismap));
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
		addAttribute(ApplicationManager.STRING_HREFLANG,hreflang);
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
		return ApplicationManager.STRING_NEWLINE.concat(super.toString());  
	} 

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			super.throwComplianceError(this, element);
		return super.addDomElement(element);
	}
	
	/**
	 * Returns a basic style sheet link for addind styles to your html
	 * @param filename
	 * @return
	 */
	public static Link createStyleLink(String filename) {
			return new Link(filename, false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);	    
	}
}  

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.PreferredContructor;
import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.FormContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
 
/**
 * HTML Img tag
 * @author Aaron Ali
 *
 */
@Tag("img")
public class Img extends DOMelement implements FlowingContent, PhrasingContent, EmbeddedContent, PalpableContent, InteractiveContent, FormContent{
   
 
	private static final long serialVersionUID = -892860380005107135L;
	protected String src;
	protected String alt;
	protected String srcset; 
	protected boolean isExternal = false;
	protected String crossorigin ;  
	protected long width;
	protected long height;
	protected boolean ismap;
	protected String usemap; 
	protected long naturalWidth;
	protected long naturalHeight;
	
	 
	 
	
	
	
	public Img(String src, String alt, boolean isExternal, String crossorgin,
			String sizes, String srcset, int width, int height, boolean ismap, String usemap) {
		super(tag(Img.class),ApplicationManager.NULL_NODE_VALUE);
		this.src = src; 
		this.isExternal = isExternal;
		this.alt=alt;
		if(alt!=null)
			addAttribute(ApplicationManager.STRING_ALT,alt); 
		addAttribute(ApplicationManager.STRING_SRC,src);
		 
		this.crossorigin = crossorgin;
		if(crossorgin!=null)
			addAttribute(ApplicationManager.STRING_CROSSORIGIN,crossorgin); 
		this.srcset = srcset;
		if(srcset!=null)
			addAttribute(ApplicationManager.STRING_SRCSET, srcset);
		this.width = width;
		if(width>0)
			addAttribute(ApplicationManager.STRING_WIDTH,String.valueOf(width)); 
		this.height = height;
		if(height>0)
			addAttribute(ApplicationManager.STRING_HEIGHT,String.valueOf(width)); 
		this.ismap = ismap;
		if(ismap)
			addAttribute(ApplicationManager.STRING_ISMAP,String.valueOf(ismap));
		this.usemap = usemap;
		if(usemap!=null)
			addAttribute(ApplicationManager.STRING_USEMAP,usemap); 
	}


	public Img(String src, String alt, boolean isExternal, HashMap<String, String> attributes) {
		super(tag(Img.class),ApplicationManager.NULL_NODE_VALUE, attributes); 
		this.isExternal = isExternal;
		this.attributes = attributes;
		this.src = src;
		if(attributes!=null){ 
			if(attributes.get(ApplicationManager.STRING_USEMAP)!=null)
				this.usemap = attributes.get(ApplicationManager.STRING_USEMAP);
			if(attributes.get(ApplicationManager.STRING_SRCSET)!=null)
				this.srcset = attributes.get(ApplicationManager.STRING_SRCSET); 
			if(attributes.get(ApplicationManager.STRING_CROSSORIGIN)!=null)
				this.crossorigin = attributes.get(ApplicationManager.STRING_CROSSORIGIN);
			if(attributes.get(ApplicationManager.STRING_ISMAP)!=null)
				this.ismap = Boolean.valueOf(attributes.get(ApplicationManager.STRING_ISMAP));
			if(attributes.get(ApplicationManager.STRING_WIDTH)!=null)
				this.width = Integer.valueOf(attributes.get(ApplicationManager.STRING_WIDTH));			
			if(attributes.get(ApplicationManager.STRING_HEIGHT)!=null)
				this.height = Integer.valueOf(attributes.get(ApplicationManager.STRING_HEIGHT));
				
		}
		this.addAttribute(ApplicationManager.STRING_SRC,src);   
	}
	
	/**
	 * Creates a responsive image tag using the fllwidth class. 
	 * @param src
	 * @param alt
	 * @param isExternal
	 */
	@PreferredContructor
	public Img(String src, String alt, boolean isExternal){
		super(tag(Img.class),ApplicationManager.NULL_NODE_VALUE,null,ApplicationManager.STRING_FULLWIDTH,null,null);
		this.isExternal = isExternal;
		this.src = src;
		this.addAttribute(ApplicationManager.STRING_SRC,src);
		this.alt = alt;
		addAttribute(ApplicationManager.STRING_ALT, alt); 
		//addAttribute("domClass","fullwidth-responsive");
		addAttribute("style", "width:100%;");
	}
 

	public Img(String src, String alt,boolean isExternal, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Img.class),ApplicationManager.NULL_NODE_VALUE, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.src =src; 
		this.isExternal = isExternal;
		this.addAttribute(ApplicationManager.STRING_SRC,src);
	}

	 

	public final String getSrc() {
		return src;
	}

	public final void setSrc(String src) { 
		this.src=src;
		addAttribute(ApplicationManager.STRING_SRC,src); 
	}

	public final boolean isExternal() {
		return isExternal;
	}

	public final void setExternal(boolean isExternal) {
		this.isExternal = isExternal; 
	}

	 
	public final String getSrcset() {
		return srcset;
	}

	public final void setSrcset(String srcset) {
		this.srcset = srcset;
		addAttribute(ApplicationManager.STRING_SRCSET, srcset);
	}
 
	
	public final String getCrossorigin() {
		return crossorigin;
	}

	public final void setCrossorigin(String crossorigin) {
		this.crossorigin = crossorigin;
		addAttribute(ApplicationManager.STRING_CROSSORIGIN, crossorigin);
	}

	 
	

	public final String getAlt() {
		return alt;
	}


	public final long getWidth() {
		return width;
	}


	public final long getHeight() {
		return height;
	}


	public final boolean isIsmap() {
		return ismap;
	}


	public final String getUsemap() {
		return usemap;
	}


	public final void setAlt(String alt) {
		this.alt = alt;
		if(alt==null) removeAttribute(ApplicationManager.STRING_ALT);
		else addAttribute(ApplicationManager.STRING_ALT, alt);
	}


	public final void setWidth(long width) {
		this.width = width;
		if(width<0) removeAttribute(ApplicationManager.STRING_WIDTH);
		else addAttribute(ApplicationManager.STRING_WIDTH, width);
	}


	public final void setHeight(long height) {
		this.height = height;
		if(height<0) removeAttribute(ApplicationManager.STRING_HEIGHT);
		else addAttribute(ApplicationManager.STRING_HEIGHT, height);
	}


	public final void setIsmap(boolean ismap) {
		this.ismap = ismap; 
		addAttribute(ApplicationManager.STRING_ISMAP, ismap);
	}


	public final void setUsemap(String usemap) {
		this.usemap = usemap;
		if(usemap==null) removeAttribute(ApplicationManager.STRING_USEMAP);
		else addAttribute(ApplicationManager.STRING_USEMAP, usemap);
	}


	@Override
	public String toString(){
		return super.toString();
	} 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			this.throwComplianceError(this, element);
		return super.addDomElement(element);
	}
}  

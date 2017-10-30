package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.FormContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
 

@Tag("img")
public class Img extends DOMelement implements FlowingContent, PhrasingContent, EmbeddedContent, PalpableContent, InteractiveContent, FormContent{
 

	private static final long serialVersionUID = 2453715760209284908L;
	protected String src;
	protected String alt;
	protected String srcset; 
	protected boolean isExternal = false;
	protected String crossorgin ; 
	protected String sizes;  
	protected int width;
	protected int height;
	protected boolean ismap;
	protected String usemap;

	 
	 
	
	
	
	public Img(String src, String alt, boolean isExternal, String crossorgin,
			String sizes, String srcset, int width, int height, boolean ismap, String usemap) {
		super(tag(Img.class), "nullnodevalue");
		this.src = src; 
		this.isExternal = isExternal;
		this.alt=alt;
		if(alt!=null)
			addAttribute("alt",alt);
		if(isExternal)
			addAttribute("src",src);
		else
			addAttribute("src","Link?page="+src);
		this.crossorgin = crossorgin;
		if(crossorgin!=null)
			addAttribute("crossorgin",crossorgin);
		this.sizes = sizes;
		if(sizes!=null)
			addAttribute("sizes",sizes);
		this.srcset = srcset;
		if(srcset!=null)
			addAttribute("srcset", srcset);
		this.width = width;
		if(width>0)
			addAttribute("width",String.valueOf(width)); 
		this.height = height;
		if(height>0)
			addAttribute("height",String.valueOf(width)); 
		this.ismap = ismap;
		if(ismap)
			addAttribute("ismap",String.valueOf(ismap));
		this.usemap = usemap;
		if(usemap!=null)
			addAttribute("usemap",usemap); 
	}


	public Img(String src, String alt, boolean isExternal, HashMap<String, String> attributes) {
		super(tag(Img.class), "nullnodevalue", attributes); 
		this.isExternal = isExternal;
		this.attributes = attributes;
		this.src = src;
		if(attributes!=null){ 
			if(attributes.get("usemap")!=null)
				this.usemap = attributes.get("usemap");
			if(attributes.get("srcset")!=null)
				this.srcset = attributes.get("srcset");
			if(attributes.get("sizes")!=null)
				this.sizes = attributes.get("sizes");
			if(attributes.get("crossorgin")!=null)
				this.crossorgin = attributes.get("crossorgin");
			if(attributes.get("ismap")!=null)
				this.ismap = Boolean.valueOf(attributes.get("ismap"));
			if(attributes.get("width")!=null)
				this.width = Integer.valueOf(attributes.get("width"));			
			if(attributes.get("height")!=null)
				this.height = Integer.valueOf(attributes.get("height"));
				
		}
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);   
	}
	
	/**
	 * Creates a responsive image tag using the fllwidth class. 
	 * @param src
	 * @param alt
	 * @param isExternal
	 */
	public Img(String src, String alt, boolean isExternal){
		super(tag(Img.class), "nullnodevalue",null,"fullwidth",null,null);
		this.isExternal = isExternal;
		this.src = src;
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
		this.alt = alt;
		addAttribute("alt", alt); 
		addAttribute("domClass","fullwidth-responsive");
		//addAttribute("style", "-width:100%;");
	}

	 



	public Img(String src, String alt,boolean isExternal, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Img.class), "nullnodevalue", (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.src =src; 
		this.isExternal = isExternal;
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
	}

	
	 

	 
	

	public final String getSrc() {
		return src;
	}

	public final void setSrc(String src) {
		this.src = src;
		if(this.isExternal)
			addAttribute("src",src);
		else
			addAttribute("href","Link?page="+src);
	}

	public final boolean isExternal() {
		return isExternal;
	}

	public final void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
		if(isExternal){
			src  = src.replace("Link?page=", "");
			addAttribute("src",src);
		}else{
			if(!src.contains("Link?page="))
				src.replace("Link?page=", "");
		}
	}

	 
	public final String getSrcset() {
		return srcset;
	}

	public final void setSrcset(String srcset) {
		this.srcset = srcset;
		addAttribute("srcset", srcset);
	}
 
	
	public final String getCrossorgin() {
		return crossorgin;
	}

	public final void setCrossorgin(String crossorgin) {
		this.crossorgin = crossorgin;
		addAttribute("crossorgin", crossorgin);
	}

	public final String getSizes() {
		return sizes;
	}

	public final void setSizes(String sizes) {
		this.sizes = sizes;
		addAttribute(sizes, sizes);
	}
	
	

	public final String getAlt() {
		return alt;
	}


	public final int getWidth() {
		return width;
	}


	public final int getHeight() {
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
		if(alt==null) removeAttribute("alt");
		else addAttribute("alt|", alt);
	}


	public final void setWidth(int width) {
		this.width = width;
		if(width<0) removeAttribute("width");
		else addAttribute("width", width);
	}


	public final void setHeight(int height) {
		this.height = height;
		if(height<0) removeAttribute("height");
		else addAttribute("height", height);
	}


	public final void setIsmap(boolean ismap) {
		this.ismap = ismap; 
		addAttribute("ismap|", ismap);
	}


	public final void setUsemap(String usemap) {
		this.usemap = usemap;
		if(usemap==null) removeAttribute("usemap");
		else addAttribute("usemap", usemap);
	}


	@Override
	public String toString(){
		return super.toString();
	} 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child elemen").concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}  

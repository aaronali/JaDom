package com.ali.jadom.dom;
 

import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("div")
public class Embed extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent, EmbeddedContent, InteractiveContent{
   
	 
	private static final long serialVersionUID = 1L;
	protected String src;
	protected String type; 
    public int width ;
    public int height  ;
	
	public Embed(){
		super(tag(Embed.class));
	}
	/**
	 * 
	 * @param element
	 */
	public Embed(IDOMelement element){ 
		this(((Embed)element).src, ((Embed)element).type,    ((Embed)element).width,   ((Embed)element).height);
	}
	
	/**
	 *  
	 * @param src
	 * @param type
	 * @param width
	 * @param height
	 */
	public Embed(String src, String type,  int width, int height) {
		super(tag(Embed.class));
		this.src = src;
		addAttribute("src", src);
		this.type = type;
		if(type!=null) addAttribute("type", type); 
		this.width = width;
		if(width>=0) 
			addAttribute("width", width);
		this.height = height;
		if(height>=0)
			addAttribute("height", height);
	}
	
	/**
	 * 
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Embed( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Embed.class), "", id, domClass, Styles, jsCallout); 
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final String getSrc() {
		return src;
	}

	/**
	 * 
	 * @param src
	 */
	public synchronized final void setSrc(String src) {
		this.src = src;
		if(src!=null) addAttribute("src", src);
		else removeAttribute("src");
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final String getTypes() {
		return type;
	}
	 /**
	  * 
	  * @param type
	  */
	public synchronized final void setSrcdoc(String type) {
		this.type = type;
		if(type!=null)
			addAttribute("type",type);
		else removeAttribute("type");
	} 
 
	 
	/**
	 * 
	 * @return
	 */
	public synchronized final int getWidth() {
		return width;
	}
	/**
	 * 
	 * @param width
	 */
	public synchronized final void setWidth(int width) {
		this.width = width;
		if(width<0)
			removeAttribute("width");
		else addAttribute("width",width);
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final int getHeight() {
		return height;
	} 
	/**
	 * 
	 * @param height
	 */
	public synchronized final void setHeight(int height) {
		this.height = height;
		if(height<0)
			removeAttribute("height");
		else addAttribute("height",height);
	}
 
	/**
	 * 
	 * @return
	 */
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}


   
}

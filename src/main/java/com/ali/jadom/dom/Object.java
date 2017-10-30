package com.ali.jadom.dom;
 

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.FormAssociated;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.Listed;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
import com.ali.jadom.dom.superelements.Reasscociateable;
import com.ali.jadom.dom.superelements.Submittable;

@Tag("object")
public class Object extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent, EmbeddedContent, InteractiveContent, Listed,Submittable, Reasscociateable, FormAssociated{
   
	 
	private static final long serialVersionUID = 1L;
	protected String data;
	protected String type; 
	protected boolean typemustmatch;
	protected String name;
	protected String usemap;
	protected String form;
    public int width ;
    public int height  ;
	
	public Object(){
		super(tag(Object.class));
	}
	/**
	 * 
	 * @param element
	 */
	public Object(IDOMelement element){ 
		this(((Object)element).data, ((Object)element).type, ((Object)element).typemustmatch,((Object)element).name,((Object)element).usemap,
				((Object)element).form,((Object)element).width,   ((Object)element).height);
	}
	
	/**
	 * 
	 * @param data
	 * @param type
	 * @param typemustmatch
	 * @param name
	 * @param usemap
	 * @param form
	 * @param width
	 * @param height
	 */
	public Object( String data, String type, boolean typemustmatch, String name, String usemap,
			String form, int width, int height) {
		super(tag(Object.class));
		this.data = data;
		if(data!=null)addAttribute("data", data);
		this.type = type;
		if(type!=null) addAttribute("type", type); 
		this.width = width;
		if(width>=0) 
			addAttribute("width", width);
		this.height = height;
		if(height>=0)
			addAttribute("height", height);
	  
		this.typemustmatch = typemustmatch;
		addAttribute("typemustmatch", typemustmatch); 
		this.name = name;
		if(name!=null) addAttribute("name", name); 
		this.usemap = usemap;
		if(usemap!=null) addAttribute("usemap", usemap); 
		this.form = form;
		if(form!=null) addAttribute("form", form); 
	 
	}
	/**
	 * 
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Object( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Object.class), "", id, domClass, Styles, jsCallout); 
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final String getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public synchronized final void setData(String data) {
		this.data = data;
		if(data!=null) addAttribute("data", data);
		else removeAttribute("data");
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final String getType() {
		return type;
	}
	 /**
	  * 
	  * @param type
	  */
	public synchronized final void setType(String type) {
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
	 
	public synchronized final boolean isTypemustmatch() {
		return typemustmatch;
	}
	public synchronized final void setTypemustmatch(boolean typemustmatch) {
		this.typemustmatch = typemustmatch;
		addAttribute("typemustmatch",typemustmatch);
	}
	public synchronized final String getName() {
		return name;
	}
	public synchronized final void setName(String name) {
		this.name = name;
		if(name!=null)
			addAttribute("name",name);
		else removeAttribute("name");
	}
	public synchronized final String getUsemap() {
		return usemap;
	}
	public synchronized final void setUsemap(String usemap) {
		this.usemap = usemap;
		if(usemap!=null)
			addAttribute("usemap",usemap);
		else removeAttribute("usemap");
	}
	public synchronized final String getForm() {
		return form;
	}
	public synchronized final void setForm(String form) {
		this.form = form;
		if(form!=null)
			addAttribute("form",form);
		else removeAttribute("form");
	}
	/**
	 * 
	 * @return
	 */
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(Param.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is only  allowed to have the child elements of type ".concat(Param.class.getCanonicalName()).concat(".\n Set ApplicationManager.FORCE_HTML_COMPLIANCE  to override")));
		return super.addDomElement(element);
	}
	
}

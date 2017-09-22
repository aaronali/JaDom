package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
import com.ali.jadom.dom.superelements.ScriptingElement; 

@Tag("script") 
public class Script extends DOMelement implements FlowingContent, MetadataContent,ScriptingElement, PhrasingContent{
  
	private static final long serialVersionUID = -7291512713103019496L;
	protected String src; 
	protected boolean isExternal = false;
	protected String crossorgin ; 
	protected String charset;  
	protected boolean defer; 
	protected boolean async;
	protected String type; 
	protected String nonce;
	
	
	public Script(String src, boolean isExternal){
		super(tag(Script.class), "");
		this.src = src; 
		this.isExternal = isExternal;
		if( !isExternal)
			addAttribute("src",src);
		else
			addAttribute("src","Link?page="+src);
	}
	
	/**
	 * Creates a &ltscript&gt tag with the given resources 
	 */
	public Script(String src,boolean isExternal, String crossorgin, boolean async,
			String charset,  String type, boolean defer, String nonce) {
		super(tag(Script.class), "");
		this.src = src; 
		this.isExternal = isExternal;
		if( !isExternal)
			addAttribute("src",src);
		else
			addAttribute("src","Link?page="+src);
		this.crossorgin = crossorgin;
		if(crossorgin!=null)
			addAttribute("crossorgin",crossorgin);
		this.charset = charset;
		if(charset!=null)
			addAttribute("charset",charset);
		this.nonce = nonce;
		if(nonce!=null) 
			addAttribute("nonce",nonce);
		this.defer = defer;
		addAttribute("defer",async);  
		this.async = async;
		addAttribute("async",async);  
		this.type =type;
		if(type!=null)
			addAttribute("type",type);
		this.forceNoId();
	}

	 

	/**
	 * Creates a &ltscript&gt tag with the given resources
	 * @param src
	 * @param isExternal
	 * @param attributes
	 */
	public Script( String src, boolean isExternal, HashMap<String, String> attributes) {
		super(tag(Script.class), "", attributes); 
		this.isExternal = isExternal;
		this.attributes = attributes;
		this.src = src;
		if(attributes!=null){
			if(attributes.get("async")!=null)
				this.async = Boolean.valueOf(attributes.get("async")); 
			if(attributes.get("crossorgin")!=null)
				this.crossorgin = attributes.get("crossorgin"); ;
			if(attributes.get("nonce")!=null)
				this.nonce = attributes.get("nonce");
			if(attributes.get("charset")!=null)
				this.type = attributes.get("charset");  
			if(attributes.get("defer")!=null)
				this.defer = Boolean.valueOf(attributes.get("defer"));
			if(attributes.get("charset")!=null)
				this.charset = attributes.get("charset");
			if(attributes.get("type")!=null)
				this.charset = attributes.get("type");
		}
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);  
		this.forceNoId();
	}
	 
	/**
	 * Creates a &ltscript&gt tag with the given resources
	 * @param src
	 * @param type
	 * @param isExternal
	 */
	public Script( String src,String type, boolean isExternal) {
		super(tag(Script.class), "nullnodevalue");
		this.src = src;
		this.isExternal = isExternal;
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
		this.type =type;
		if(type!=null)
			addAttribute("type", type);
		this.forceNoId();
	}


	/**
	 * Creates a &ltscript&gt tag with the given resources
	 * @param src
	 * @param isExternal
	 * @param type
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Script(String src,boolean isExternal, String type, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Script.class), "", (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.src =src; 
		this.isExternal = isExternal;
		this.addAttribute("src",(isExternal)? src: "Link?page="+src);
		this.type =type;
		if(type!=null)
			addAttribute("type", type);
		this.forceNoId();
	}

	 
	/**
	 * Gets the current src value of the link
	 * @return
	 */
	public final String getsrc() {
		return src;
	}

	/**
	 * Sets the current src value of the link
	 * @param src
	 */
	public final void setsrc(String src) {
		this.src = src;
		if(this.isExternal)
			addAttribute("src",src);
		else
			addAttribute("hred","Link?page="+src);
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
			src  = src.replace("Link?page=", "");
			addAttribute("src",src);
		}else{
			if(!src.contains("Link?page="))
				src.replace("Link?page=", "");
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
	 * Returns the defer value of the link
	 * @return
	 */
	public final boolean isdefer() {
		return defer;
	}


	/**
	 * Sets the defer value of the link.
	 * @param defer
	 */
	public final void setdefer(boolean defer) {
		this.defer = defer; 
		addAttribute("defer", String.valueOf(defer));
	}


	/**
	 * Returns the src language of the link.
	 * @return
	 */
	public final boolean getasync() {
		return async;
	}


	/**
	 * Sets the src language of the current link.
	 * @param async
	 */
	public final void setasync(boolean async) {
		this.async = async;
		addAttribute("async",async);
	} 
	
	/**
	 * Returns the charset value of the link, to be used when linking icons.
	 * @return
	 */
	public final String getcharset() {
		return charset;
	}

	/**
	 * Sets the charset value of the link, to be used when linking icons.
	 * @param charset
	 */
	public final void setcharset(String charset) {
		this.charset = charset;
		addAttribute(charset, charset);
	}

	@Override
	public String toString(){ 
		return "\n"+super.toString();  
	} 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element \n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	} 
}  
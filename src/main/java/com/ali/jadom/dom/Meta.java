package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.MetadataContent;

@Tag("meta")
public class Meta extends DOMelement implements MetadataContent{ 
	 
	private static final long serialVersionUID = 1258995033018206530L;
	protected String name;
	protected String httpEquiv;
	protected String content;
	protected String charset; 

	/** 
	 * 
	 */
	public Meta() {
		super(tag(Meta.class),ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE);
		super.forceNoId();
	} 
	
	/**
	 * 
	 * @param attributes
	 */
	public Meta( HashMap<String, String> attributes) {
		super(tag(Meta.class),ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE);
		this.attributes = attributes;
		if(getAttribute("name")!=null) this.name = getAttribute("name");
		if(getAttribute("http-equiv")!=null) this.name = getAttribute("http-equiv");
		if(getAttribute("content")!=null) this.name = getAttribute("content");
		if(getAttribute("charset")!=null) this.name = getAttribute("charset");
			 
	}

	/**
	 * 
	 * @param nodeName
	 * @param name
	 * @param httpEquiv
	 * @param content
	 * @param charset
	 */
	public Meta(String name, String httpEquiv, String content, String charset) {
		super(tag(Meta.class),ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE,ApplicationManager.NULL_NODE_VALUE);
		this.name = name;
		attributes.put(ApplicationManager.STRING_NAME, name);
		this.httpEquiv = httpEquiv;
		attributes.put(ApplicationManager.String_HTTPEQUIV, httpEquiv);
		this.content = content;
		attributes.put(ApplicationManager.STRING_CONTENT, content);
		this.charset = charset;
		attributes.put(ApplicationManager.STRING_CHARSET, charset);
	}


	/**
	 * 
	 * @return
	 */
	public synchronized final String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public synchronized final void setName(String name) {
		this.name = name;
		if(name==null) removeAttribute("name");
		else addAttribute("name", name);
	}

	/**
	 * 
	 * @return
	 */
	public synchronized final String getHttpEquiv() {
		return httpEquiv;
	}

	/**
	 * 
	 * @param httpEquiv
	 */
	public synchronized final void setHttpEquiv(String httpEquiv) {
		this.httpEquiv = httpEquiv;
		if(httpEquiv==null) removeAttribute("http-equiv");
		else addAttribute("http-equiv", httpEquiv);
	}

	/**
	 * 
	 * @return
	 */
	public synchronized final String getContent() {
		return content;
	}

	/**
	 * 
	 * @param content
	 */
	public synchronized final void setContent(String content) {
		this.content = content;
		if(content==null) removeAttribute("content");
		else addAttribute("content", content);
	}

	/**
	 * 
	 * @return
	 */
	public synchronized final String getCharset() {
		return charset;
	}

	/**
	 * 
	 * @param charset
	 */
	public synchronized final void setCharset(String charset) {
		this.charset = charset;
		if(charset==null) removeAttribute("charset");
		else addAttribute("charset", charset);
	}

	@Override
	public void addAttribute(String name, String value){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  ((name!="name" || name!="content" || name!="charset" || name!="http_equiv") && value!=ApplicationManager.NULL_NODE_VALUE) && (value.equals(ApplicationManager.NULL_NODE_VALUE))){
			System.out.println(name+","+value);
			throw new RuntimeException("The only allowed attributes for this element are  'name', 'charset', 'http-equiv', amd 'content'. Sett ApplicationManager.FORCE_HTML_COMPLIANCE to override");
		} 
		super.addAttribute(name, (String)value); 
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
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have any child elements. To override set ApplicationManager.FORCE_HTML_COMPLIANCE to false"));
		return super.addDomElement(element);
	}
	
	
	
	
	
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}

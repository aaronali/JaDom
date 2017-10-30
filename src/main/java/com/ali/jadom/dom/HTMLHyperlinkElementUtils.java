package com.ali.jadom.dom;


import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.Hidden;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
 
 /**
  * 
  * @author AARONAli
  *
  */
//@Tag("")
public class HTMLHyperlinkElementUtils extends DOMelement implements PhrasingContent, InteractiveContent, PalpableContent, FlowingContent{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7397142934813046836L;
	protected String href;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String origin;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String protocol;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String username;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String password;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String host;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String hostname;
	protected String port;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String pathname;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String search;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected String hash;
	
	 
	
	/**
	 * Creates an anchor tag with the same properties as the given element
	 * @param ele DOMelementInterface&ltA&gt
	 */
	public HTMLHyperlinkElementUtils(IDOMelement ele){
		super((DOMelement)ele);
		this.origin =((HTMLHyperlinkElementUtils)ele).origin;
		this.href =((HTMLHyperlinkElementUtils)ele).href;
		this.protocol=((HTMLHyperlinkElementUtils)ele).protocol;
		this.username=((HTMLHyperlinkElementUtils)ele).username;
		this.password = ((HTMLHyperlinkElementUtils)ele).password;
		this.host=((HTMLHyperlinkElementUtils)ele).host;
		this.port = ((HTMLHyperlinkElementUtils)ele).port;
		this.pathname=((HTMLHyperlinkElementUtils)ele).pathname;
		this.search=((HTMLHyperlinkElementUtils)ele).search;
		this.hash=((HTMLHyperlinkElementUtils)ele).hash;
	}
	 
	public HTMLHyperlinkElementUtils(String _class,String   href) {
		super(_class, href);
	}
	public HTMLHyperlinkElementUtils(String _class,String anchorText, String id, String domClass,String styles,String jsCallout){
		super(_class , anchorText, (id!=null)?id:ApplicationManager.getNextId(), domClass, styles, jsCallout);  
	}
	/**
	 * Gets the origin
	 * @return
	 */
	public String getOrigin() {
		return origin; 
	}

	/**
	 * Sets the origin
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
		if(origin!=null)addAttribute("orgin", origin);
	}

	/**
	 * Gets the protocol
	 * @return
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * Sets the protocol
	 * @param protocol
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
		if(protocol!=null)addAttribute("protocol", protocol);
	}

	/**
	 * Gets the username
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
		if(username!=null)addAttribute("username", username);
	}
 
	/**
	 * Gets the password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
 
	/**
	 * Sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
		if(password!=null)addAttribute("password", password);
	}

	/**
	 * Gets the host string
	 * @return
	 */
	public String getHost() {
		return host;
	}
 
	/**
	 * Sets the host string
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
		if(host!=null)addAttribute("host", host);
	}  

	/**
	 * Gets the host name
	 * @return hostname
	 */
	public String getHostname() {
		return hostname;
	} 

	/**
	 * Sets the hostname
	 * @param hostname
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
		if(hostname!=null)addAttribute("hostname", hostname);
	} 

	/**
	 * Gets the port as string
	 * @return port
	 */
	public String getPort() {
		return port;
	} 

	/**
	 * Sets the port string
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
		if(port!=null)addAttribute("port", port);
	} 

	/**
	 * Gets the pathname
	 * @return pathname
	 */
	public String getPathname() {
		return pathname;
	}

	/**
	 * Sets the pathname
	 * @param pathname
	 */
	public void setPathname(String pathname) {
		this.pathname = pathname;
		if(pathname!=null)addAttribute("pathname", pathname);
	}
 
	
	public String getSearch() {
		return search;
	} 


	public void setSearch(String search) {
		this.search = search;
		if(search!=null)addAttribute("search", search);
	}



	public String getHash() {
		return hash;
	}
 

	public void setHash(String hash) {
		this.hash = hash;
		if(hash!=null)addAttribute("hash", hash);
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * Sets the current link href. If the value is null it will be removed.
	 * @param href String
	 */
	public final void setHref(String href){
		this.href = href; 
		addAttribute("href",href); 
		if(href.equals(null))
			removeAttribute("href");
	}
 

	/**
	 * Gets the current href value
	 * @return href String 
	 */
	public String getHref() {
		return href;
	}
 	 
	 
}  

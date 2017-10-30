package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.JadomConfig;
import com.ali.jadom.annotations.Hidden; 
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
import com.ali.jadom.exceptions.JaDomComplianceError;

/**
 * HTML Anchor tag class. This class is used to represent an HTML anchor tag. If the link is set as
 * not external a "Link?page=" will be added to the start if the link. Otherwise if the link is external
 * it will remain untouched. This is primarily designed to let developers know when links are going off site or cross origin.
 * @see com.ibm.ca.MainServlet.LinkServlet
 * @see PhrasingContent
 * @see InteractiveContent
 * @see PalpableContent
 * @see FlowingContent
 * @author Aaron Ali
 *
 */
@Tag("a")
public class A extends HTMLHyperlinkElementUtils implements PhrasingContent, InteractiveContent, PalpableContent, FlowingContent{


	private static final long serialVersionUID = 7573556457100157202L;
	/** url destination **/
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected boolean newTab = false;
	/** Whether link is going to another site or staying on local server **/
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected boolean isExternal = false;
	/** link target value **/
	protected String target;
	/** link relationship to the document **/
	protected RelTypeEnum rel;
	/** href language of the resource**/
	protected String hreflang;
	/** if link is a download then the file name of download **/
	protected String download;
	/** hint for the type of referenced source **/
	protected String type;
	/** The name of the link (equivalent to the anchors innerHtml or the DOMelements nodeValue)**/
	protected String name;
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	public boolean inpage = false;

	/**
	 * Creates an anchor tag with the same properties as the given element
	 * @param ele DOMelementInterface&ltA&gt
	 */
	public A(IDOMelement ele){
		super((DOMelement)ele);
		this.download =((A)ele).download;
		this.href =((A)ele).href;
		this.hreflang=((A)ele).hreflang;
		this.isExternal=((A)ele).isExternal;
		this.name = ((A)ele).name;
		this.newTab=((A)ele).newTab;
		this.rel = ((A)ele).rel;
		this.target=((A)ele).target;
		this.type=((A)ele).type;
	}


	/**
	 * Creates an html anchor tag with the link as the label
	 * @param href
	 * @param isExternal
	 */
	public A( String href, boolean isExternal) {
		super(tag(A.class), href);
		this.setHref(href);
		this.isExternal= isExternal; 
	}	
	/**
	 * Creates a html anchor tag with the given link and label
	 * @param anchorText
	 * @param href
	 * @param isExternal
	 */
	public A(String anchorText, String href, boolean isExternal){
		super(tag(A.class) , href);
		this.nodevalue=anchorText;
		this.isExternal = isExternal;
		this.setHref(href); 
	}

	/**
	 * Creates and anchor tag with the given attributes
	 * @param anchorText
	 * @param href
	 * @param isExternal
	 * @param attributes
	 */
	public A(String anchorText, String href, boolean isExternal, HashMap<String, String> attributes) {
		super(tag(A.class), anchorText); 
		this.isExternal = isExternal;
		if(attributes!=null)
			this.attributes = attributes;
		this.setHref(href);   
		if(this.attributes.get(ApplicationManager.STRING_DOWNLOAD)!=null)
			this.download = attributes.get(ApplicationManager.STRING_DOWNLOAD);
		if(this.attributes.get(ApplicationManager.STRING_REL)!=null)
			this.rel = Enum.valueOf(RelTypeEnum.class, attributes.get(ApplicationManager.STRING_REL));
		if(this.attributes.get(ApplicationManager.STRING_HREFLANG)!=null)
			this.hreflang = attributes.get(ApplicationManager.STRING_HREFLANG);
		if(this.attributes.get(ApplicationManager.STRING_TYPE)!=null)
			this.type = attributes.get(ApplicationManager.STRING_TYPE);  
		if(this.attributes.get(ApplicationManager.STRING_NAME)!=null)
			this.type = attributes.get(ApplicationManager.STRING_NAME);  
	}

	/**
	 * 
	 * @param anchorText
	 * @param href
	 * @param isExternal
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public A(String anchorText, String href,boolean isExternal, String id, String domClass, String Styles, String jsCallout) {
		super(tag(A.class), anchorText, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.setHref(href) ;
		this.isExternal = isExternal;
		this.addAttribute(ApplicationManager.STRING_HREF,href);
	}



	/**
	 * Gets the current links new tab property targert
	 * @return newTab boolean
	 */
	public  final boolean isNewTab() {
		return newTab;		
	}

	/**
	 * Sets the target to a new tab. <br>
	 * <b>Warning :</b><i>Over writes the "target" attribute</i>If the value is null the "target" attribute will be removed.
	 * @param newTab
	 */
	public  final void setNewTab(boolean newTab) {
		this.newTab = newTab;
		if(newTab)
			this.setTarget(JadomConfig.a_new_tab_text);
		else
			this.setTarget(null);
	}


	/**
	 * Returns true if this is an external link
	 * @return isExternal
	 */
	public final boolean isExternal() {
		return isExternal;
	}

	/**
	 * Sets this as an external link not to use the link manager system
	 * @param isExternal
	 */
	public final void setExternal(boolean isExternal) {
		this.isExternal = isExternal;

	}

	/**
	 * Gets the current links target parameter.
	 * @return String
	 */
	public final String getTarget() {
		return target;
	}

	/**
	 * Sets the current links target parameter. if the value is null the attribute will be removed.
	 * @param target
	 */
	public final void setTarget(String target) {
		this.target = target;
		if(target!=null)
			addAttribute(ApplicationManager.STRING_TARGET,target);
		else
			removeAttribute(ApplicationManager.STRING_TARGET);
	}

	/**
	 * Gets the relationship type for the link.
	 * @see RelTypeEnum
	 * @return RelType
	 */
	public final RelTypeEnum getRel() {
		return rel;
	}

	/**
	 * Sets the relationship type for the link. If the value is null it will be removed.
	 * @param rel as RelType
	 */
	public final void setRel(RelTypeEnum rel) {
		this.rel = rel;
		if(rel!=null)
			addAttribute(ApplicationManager.STRING_REL,rel.toString());
		else
			removeAttribute(ApplicationManager.STRING_REL);
	}

	/**
	 * Gets the current links hrefLang parameter.
	 * @return String
	 */
	public final String getHreflang() {
		return hreflang;
	}

	/**
	 * Sets the current links hreflang parameter. If the value is null it will be removed
	 * @param hreflang as String
	 */
	public final void setHreflang(String hreflang) {
		this.hreflang = hreflang;
		if(hreflang!=null)
			addAttribute(ApplicationManager.STRING_HREFLANG, hreflang);
		else
			removeAttribute(ApplicationManager.STRING_HREFLANG);
	}

	/**
	 * Gets the current links download parameter.
	 * @return String
	 */
	public final String getDownload() {
		return download;
	}

	/**
	 * Sets the current links download parameter. If the value is null it will be removed.
	 * @param download as String
	 */
	public final void setDownload(String download) {
		this.download = download;
		if(download!=null)
			addAttribute(ApplicationManager.STRING_DOWNLOAD,download);
		else 
			removeAttribute(ApplicationManager.STRING_DOWNLOAD);
	}

	/**
	 * Gets the current links type parameter.
	 * @return String
	 */
	public final String getType() {
		return type;
	}

	/**
	 * Sets the current links type parameter. If the value is null it will be removed
	 * @param type as String
	 */
	public final void setType(String type) {
		this.type = type;
		if(type!=null)
			addAttribute(ApplicationManager.STRING_TYPE,type.toString());
		else
			removeAttribute(ApplicationManager.STRING_TYPE);
	}


	@SuppressWarnings("unused")
	@Override
	public boolean addDomElement(DOMelement element) { 
		JadomConfig config = JadomConfig.getInstance();
		if(ApplicationManager.FORCE_HTML_COMPLIANCE) {
			if(element.isOfType(FlowingContent.class) && config.get(JadomConfig.a_allow_flowing_content)!=null &&Boolean.valueOf(config.get(JadomConfig.a_allow_flowing_content))) {
				return super.addDomElement(element);
			}else if(element.isOfType(PhrasingContent.class) && config.get(JadomConfig.a_allow_phasing_content)!=null &&Boolean.valueOf(config.get(JadomConfig.a_allow_phasing_content))) {
				return super.addDomElement(element);
			}else if(element.isOfType(PalpableContent.class) && config.get(JadomConfig.a_allow_palpable_content)!=null &&Boolean.valueOf(config.get(JadomConfig.a_allow_palpable_content))) {
				return super.addDomElement(element);
			}else if(element.isOfType(InteractiveContent.class) && config.get(JadomConfig.a_allow_interactive_content)!=null &&Boolean.valueOf(config.get(JadomConfig.a_allow_palpable_content))) {
				return super.addDomElement(element);
			}
			if(!element.getClass().equals(URL.class)) {
				throw new RuntimeException(new JaDomComplianceError(this,element));
			}
		}
		if(element.isOfType(URL.class)) {
			if(this.contains(URL.class)){ 
				if(ApplicationManager.FORCE_HTML_COMPLIANCE || config.get(JadomConfig.a_allow_multiple_urls)==null || (config.get(JadomConfig.a_allow_multiple_urls)!=null&& Boolean.valueOf(config.get(JadomConfig.a_allow_multiple_urls)))) 
					this.removeDomElement(URL.class);
			} 

			this.setNodevalue(ApplicationManager.STRING_EMPTY);
			URL url = (URL)element;
			super.addDomElement(url);
			this.setHref(url.href);

			this.setHost(url.host);
			this.setOrigin(url.origin);
			this.setHostname(url.hostname);
			this.setPassword(url.password);
			this.setPort(url.port);
			this.setPathname(url.pathname);
			this.setProtocol(url.protocol);
			this.setSearch(url.search); 
			return this.contains(URL.class);
		} 
		if(ApplicationManager.FORCE_HTML_COMPLIANCE) {
			return false;
		}
		return super.addDomElement(element);
	}

	public void setAnchorText(String text) {
		this.setNodevalue(text);
	}


	@Override
	public String toString(){  
		String preffix;
		if(isExternal)
			preffix = JadomConfig.getInstance().get(JadomConfig.external_link_preffix);
		else
			preffix = JadomConfig.getInstance().get(JadomConfig.internal_link_preffix);

		String hreff= this.href;
		if(this.contains(URL.class)) {
			for(DOMelement elm :this.getEmbeddedElements()) {
				if(elm.getClass().equals(URL.class)) {
					this.setHref(elm.toString()); 

				}
			}
		} 
		if(preffix!=null) {
			this.setHref(preffix.concat(this.getHref()));
		}
		String s = super.toString(); 
		this.href=hreff;
		return s;
	} 
}  

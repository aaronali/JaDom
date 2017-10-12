package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
 
/**
 * HTML Anchor tag class. This class is used to represent an HTML anchor tag. If the link is set as
 * not external a "Link?page=" will be added to the start if the link. Otherwise if the link is external
 * it will remain untouched. This is primarily designed to let developers know when links are going off site or cross origin.
 * @see com.ibm.ca.MainServlet.LinkServlet
 * @see PhrasingContent
 * @see InteractiveContent
 * @see PalpableContent
 * @see FlowingContent
 * @author aaronali
 *
 */
@Tag("a")
public class A extends DOMelement implements PhrasingContent, InteractiveContent, PalpableContent, FlowingContent{
 
	private static final long serialVersionUID = -8301506784956327153L;
	/** url destination **/
	protected String href;
	/** is to open in new tab **/
	protected boolean newTab = false;
	/** Whether link is going to another site or staying on local server **/
	protected boolean isExternal = false;
	/** link target value **/
	protected String target;
	/** link relationship to the document **/
	protected RelTypeEnum rel;
	/** href language of the resource**/
	protected String hreflang;
	/** if link is a download and the file name of download **/
	protected String download;
	/** hint for the type of referenced source **/
	protected String type;
	/** The name of the link (equivalent to the anchors innerHtml or the DOMelements nodeValue)**/
	protected String name;
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
		this.href = href;
		this.isExternal = isExternal;
		this.addAttribute("href",(isExternal)? href: "Link?page="+href);
		System.out.println("href = " +href);;
	}
	
	/**
	 * Creates a html anchor tag with the given link and label
	 * @param anchorText
	 * @param href
	 * @param isExternal
	 */
	public A(String anchorText, String href, boolean isExternal){
		super(tag(A.class), anchorText);
		this.isExternal = isExternal;
		this.href = href;
		this.addAttribute("href",(isExternal)?"Link?Link=".concat(href) : "Link?page="+href);
	}

	/**
	 * Creates and anchor tag with the given attributes
	 * @param anchorText
	 * @param href
	 * @param isExternal
	 * @param attributes
	 */
	public A(String anchorText, String href, boolean isExternal, HashMap<String, String> attributes) {
		super(tag(A.class), anchorText, attributes); 
		this.isExternal = isExternal;
		this.attributes = attributes;
		this.href = href;
		this.addAttribute("href",(isExternal)? href: "Link?page="+href);  
		if(attributes.get("download")!=null)
			this.download = attributes.get("downlaod");
		if(attributes.get("rel")!=null)
			this.rel = Enum.valueOf(RelTypeEnum.class, attributes.get("rel"));
		if(attributes.get("hreflang")!=null)
			this.hreflang = attributes.get("hreflang");
		if(attributes.get("type")!=null)
			this.type = attributes.get("type");  
		if(attributes.get("name")!=null)
			this.type = attributes.get("name");  
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
		this.href =href; 
		this.isExternal = isExternal;
		this.addAttribute("href",(isExternal)? href: "Link?page="+href);
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
			this.setTarget("new");
		else
			this.setTarget(null);
	}
	
	  
	/**
	 * Gets the current href value
	 * @return href String 
	 */
	public final String getHref() {
		return href;
	}

	/**
	 * Sets the current link href. If the value is null it will be removed.
	 * @param href String
	 */
	public final void setHref(String href) {
		this.href = href;
		if(this.isExternal)
			addAttribute("href",href);
		else
			addAttribute("href","Link?page="+href);
		if(href==null)
			removeAttribute("href");
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
		if(isExternal){
			href  = href.replace("Link?page=", "");
			addAttribute("href",href);
		}else{
			if(!href.contains("Link?page="))
				href.replace("Link?page=", "");
		}
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
			addAttribute("target",target);
		else
			removeAttribute("target");
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
			addAttribute("rel",rel.toString());
		else
			removeAttribute("rel");
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
			addAttribute("hreflang", hreflang);
		else
			removeAttribute("hreflang");
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
			addAttribute("download",download);
		else 
			removeAttribute("downlaod");
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
			addAttribute("type",type.toString());
		else
			removeAttribute("type");
	}

	 
	@Override
	public String toString(){ 
		if(!href.startsWith("#"))
			if(inpage) this.setHref("#".concat(href).replace("Link?", "").replace("page=", ""));
		return super.toString(); 
	} 
}  

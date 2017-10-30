package com.ali.jadom.dom;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.jadom.exceptions.JaDomComplianceError; 

@Tag("title")
public class Title extends DOMelement implements HeadingContent, MetadataContent { 
	private static final long serialVersionUID = -529116677843930199L; 
	public Title(IDOMelement element){
		super((DOMelement)element);
	}
	
	/**
	 * Creates  title tag with the given title text
	 * @param titleText
	 */
	public Title( String titleText) {
		super(tag(Title.class), titleText,ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,null,null); 
		this.forceNoId();
	}
	 
	/**
	 * Creates a title tag with the given parameter.  Thgis should not be used unles the paramters are null
	 * @param titleText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 * @throws JaDomComplianceError 
	 */
	public Title(String titleText, String id, String domClass, String Styles, String jsCallout) throws JaDomComplianceError {
		super(tag(Title.class), titleText); 
		if(ApplicationManager.FORCE_HTML_COMPLIANCE){
			if(domClass!=null || id !=null || styles!=null || jsCallout !=null)
				throw new JaDomComplianceError(JaDomComplianceError.ErrorEnum.NO_ATTRIBUTES_ALLOWED,null,null);
		}
		super.addAttribute("id", id);
		super.addAttribute("domClass", domClass);
		super.addAttribute("style",Styles);
		super.addAttribute("jsCallOut", jsCallout);
	}
	
	private Title(String titleText, String id, String domClass, String Styles, String jsCallout, boolean x) {
		super(tag(Title.class), titleText,ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, Styles, jsCallout); 
		
	}

	@Override
	public String toString(){ 
		return "<".concat(tag(this.getClass())).concat(">").concat(nodevalue).concat("</").concat(tag(this.getClass())).concat(">\n"); 
	}
	@Override
	public void addAttribute(String name, String value){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && value!=ApplicationManager.FORCE_NO_ATTRIBUTE && value!=null)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(ApplicationManager.appManager.getClassNotAllowedAttribute()).concat(ApplicationManager.appManager.getGenericeHelp()));
	
	}
	
	
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(ApplicationManager.appManager.getClassNotAllowedClasses()).concat(ApplicationManager.appManager.getGenericeHelp()));
		return super.addDomElement(element);
	} 
}

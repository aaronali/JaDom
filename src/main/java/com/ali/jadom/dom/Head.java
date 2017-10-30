package com.ali.jadom.dom;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.jadom.dom.superelements.SectioningRoot;

@Tag("head")
public class Head extends DOMelement implements SectioningRoot{


	 
	private static final long serialVersionUID = -7003735549664657691L;

	/**
	 * Creates a html5 head element
	 */
	public Head() {
		super(tag(Head.class), "", ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, null,null);
	} 
	
	/**
	 * Create a html5 head element
	 * @param headHTML
	 */
	public Head( String headHTML) {
		super(tag(Head.class), headHTML, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, null,null);
	} 
	 
	/**
	 * 
	 * @param headHTML
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Head(String headHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Head.class), headHTML, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, Styles, jsCallout); 
	}
	 
	/**
	 * Adds or  updates the title to the head element
	 * @param title
	 */
	public void addTitle(String title){ 
		if(this.getEmbeddedElements()!=null){
			for(int i=0 ; i < this.getEmbeddedElements().length; i++){
				if(this.getEmbeddedElements()[i].isOfType(Title.class)){
					this.getEmbeddedElements()[i].nodevalue =title;
					return;
				} 
			} 
		}
		super.addDomElement(new Title(title)); 
	}

	public void addBase(Base base){
		if(this.getEmbeddedElements()!=null){
			for(int i=0 ; i < this.getEmbeddedElements().length; i++){
				if(this.getEmbeddedElements()[i].getClass().getCanonicalName().equals(Base.class.getCanonicalName())){
					this.getEmbeddedElements()[i] =new Base(base);
					return;
				} 
			} 
		}
		addDomElement(new Base(base)); 
	}
	
	
	@Override
	public boolean addDomElement(DOMelement element){ 
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!element.isOfType(HeadingContent.class) && !element.isOfType(MetadataContent.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat(" \n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")); 
		if(element.isOfType(Title.class)){
			addTitle(((Title)element).nodevalue);
			return true;
		}
		return super.addDomElement(element);
	}
	
	
	@Override
	public String toString(){ 
		String s = super.toString();
		while(s.contains("\n\n")){
			s=s.replace("\n\n", "\n").replace("  ", " ").replace(" \n", "\n").replace("  ", " ").replace("\n\n", "\n").replace("\n\n", "\n");  
		}
		return s;	
		} 
}

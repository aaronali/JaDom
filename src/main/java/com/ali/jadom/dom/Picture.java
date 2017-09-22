package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

 
@Tag("picture")
public class Picture extends DOMelement implements FlowingContent, PhrasingContent, EmbeddedContent{ 
	 
	private static final long serialVersionUID = 4796933415257236206L;
	/**
	 * 
	 */
	public Picture( ) {
		super(tag(Picture.class), ""); 
	} 
	
	public Picture(DOMelementInterface element){
		super((Picture)element);
	}
	/**
	 * 
	 * @param attributes
	 */
	public Picture( HashMap<String, String> attributes) {
		super(tag(Picture.class), "", attributes);  
	} 
	 /**
	  * 
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Picture( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Picture.class), "", id, domClass, Styles, jsCallout); 
	}
	/**
	 * 
	 * @param src
	 * @param type
	 */
	public void addExternalSource(String src, String type){
		Source source = new Source(src, true, type); 
		addDomElement(source); 
	}
	/**
	 * 
	 * @param src
	 * @param type
	 */
	public void addInternalSource(String src, String type){
		Source source = new Source(src, false, type);
		addDomElement(source); 
	}
	/**
	 * 
	 * @param src
	 * @param alt
	 */
	public void addExternalImg(String src, String alt){
		addDomElement(new Img(src,alt,true));
	}
	/**
	 * 
	 * @param src
	 * @param alt
	 */
	public void addInternalImg(String src, String alt){
		addDomElement(new Img(src,alt,false));
	}
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE ){
			if(this.contains(Img.class))
				throw new RuntimeException("You can only have one ".concat(element.getClass().getCanonicalName().concat(" inside the ").concat(this.getClass().getCanonicalName())).concat(" \nSet ApplicationManager.FORCE_HTML_COMPLIANCE to Override"));
			if(this.contains(Img.class) && element.isOfType(Source.class))
				throw new RuntimeException("You can only add source elements to the picture before the img elememt.\n\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to Override");
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element.\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to Override"));
		}
		return super.addDomElement(element);
	}
	
}

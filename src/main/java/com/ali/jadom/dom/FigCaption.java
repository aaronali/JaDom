package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("figcaption")
public class FigCaption extends DOMelement  implements FlowingContent, PhrasingContent,  PalpableContent{
 
	 
	private static final long serialVersionUID = 4144977387494883812L;

	/**
	 * 
	 * @param element
	 */
	public FigCaption(IDOMelement element){
		super((FigCaption)element);
	}
	
	/**
	 * 
	 */
	public FigCaption() {
		super(tag(FigCaption.class)); 
	}
	
	/**
	 * 
	 * @param captionText
	 */
	public FigCaption( String captionText) {
		super(tag(FigCaption.class), captionText); 
	}
	
	/**
	 * 
	 * @param captionText
	 * @param attributes
	 */
	public FigCaption(String captionText, HashMap<String, String> attributes) {
		super(tag(FigCaption.class), captionText, attributes);  
	}
	
	/**
	 * 
	 * @param captionText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public FigCaption(String captionText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(FigCaption.class), captionText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	} 
}

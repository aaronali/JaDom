package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.SectioningContent;

@Tag("figure")
public class Figure extends DOMelement implements FlowingContent, SectioningContent ,  PalpableContent{ 
	
	private static final long serialVersionUID = 6626569957675583895L;
	/**
	 * 
	 * @param element
	 */
	public Figure(DOMelementInterface element){
		super((Figure)element);
	}
	/**
	 * 
	 */
	public Figure() {
		super(tag(Figure.class)); 
	}
	/**
	 * 
	 * @param figureHTML
	 */
	public Figure( String figureHTML) {
		super(tag(Figure.class), figureHTML); 
	}

	 /**
	  * 
	  * @param figureHTML
	  * @param attributes
	  */
	public Figure(String figureHTML, HashMap<String, String> attributes) {
		super(tag(Figure.class), figureHTML, attributes);  
	}

	/**
	 * 
	 * @param figureHTML
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Figure(String figureHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Figure.class), figureHTML, id, domClass, Styles, jsCallout); 
	}
	
	 /**
	  * 
	  * @param captionText
	  */
	public void addCaption(String captionText){
		addDomElement(new FigCaption(captionText));
	}
	
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	} 
}

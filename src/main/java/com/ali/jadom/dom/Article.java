package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.SectioningContent;
 
/**
 * HTML article tag.
 * @author aaronali
 *
 */
@Tag("article")
public class Article extends DOMelement implements FlowingContent, PalpableContent, SectioningContent { 
	private static final long serialVersionUID = -4920499087249206923L;

	/**
	 * 
	 */
	public Article(){
		super(tag(Article.class));
	}
	
	
	/**
	 * 
	 * @param article Article
	 */
	public Article(Article article){
		super(article);
	}
	
	/**
	 * 
	 * @param htmlCode String
	 */
 	public Article(String htmlCode){
		super(tag(Article.class), htmlCode);
	}
	 
 	/**
 	 * 
 	 * @param htmlCode String
 	 * @param attributes HashMap&ltString,String&gt or null
 	 */
	public Article( String htmlCode, HashMap<String, String> attributes) {
		super(tag(Article.class), htmlCode, attributes); 
	} 
	
	/**
	 * 
	 * @param htmlCode String
	 * @param id String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param domClass String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param Styles String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param jsCallout String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 */
	public Article( String htmlCode, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Article.class), htmlCode, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout);  
	} 
 
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName().concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString();
	 
	}
	 
	
}  

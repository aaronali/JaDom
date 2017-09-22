package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 
/**
 * HTML bold tag
 * @author aaronali
 *
 */
@Tag("b")
public class B extends DOMelement implements FlowingContent, PhrasingContent, PalpableContent{
	
 
	private static final long serialVersionUID = 5078778106883641297L;

	/**
	 * Creates an html &ltb&gt&lt/b&gt tag
	 */
	public B() {
		super(tag(B.class)); 
	}
	
	/**
	 * Creates an html &ltb&gt&lt/b&gt tag with the same properties of the given element
	 * @param b B
	 */
	public B(B b){
		super(b);
	}
	
	/**
	 *  Creates an html &ltb&gt&lt/b&gt tag with the given text<br><br>
	 *  &ltb&gtboldText&lt/b&gt
	 * @param boldText String
	 */
	public B( String boldText) {
		super(tag(B.class), boldText); 
	} 
	 
	/**
	 *  Creates an html &ltb&gt&lt/b&gt tag with the given text and the assigned attributes<br><br>
	 *  &ltb&gtboldText&lt/b&gt
	 * @param boldText
	 * @param attributes
	 */
	public B(String boldText, HashMap<String, String> attributes) {
		super(tag(B.class), boldText, attributes);  
	} 
	
	/**
	 *  Creates an html &ltb&gt&lt/b&gt tag with the given text and assigned attributes<br><br>
	 *  &ltb id=id class=domClass styles=styles jsCallout&gtboldText&lt/b&gt
	 * @param boldText
	 * @param id String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param domClass String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param Styles String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param jsCallout String or Null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 */
	public B(String boldText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(B.class), boldText, id, domClass, Styles, jsCallout); 
	}
	
 
 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  element.isOfType(PhrasingContent.class,HeadingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName().concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString();  
	} 
}

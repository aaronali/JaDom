package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("main")
public class Main extends DOMelement  implements FlowingContent, PhrasingContent ,PalpableContent{
  
	private static final long serialVersionUID = -4476259125987493198L;

	/**
	 * 
	 */
	public Main() {
		super(tag(Main.class)); 
	}
	/**
	 * 
	 * @param element
	 */
	public Main(DOMelementInterface element){
		super((Main)element);
	}
	/**
	 * 
	 * @param mainHTML
	 */
	public Main( String mainHTML) {
		super(tag(Main.class), mainHTML); 
	}
	 
	/**
	 * 
	 * @param mainHTML
	 * @param attributes
	 */
	public Main(String mainHTML, HashMap<String, String> attributes) {
		super(tag(Main.class), mainHTML, attributes);  
	}
	/**
	 * 
	 * @param mainHTML
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Main(String mainHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Main.class), mainHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

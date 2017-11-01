package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

/**
 * HTML Main tag
 * @author AARONAli
 *
 */
@Tag("main")
public class Main extends DOMelement  implements FlowingContent, PhrasingContent ,PalpableContent{
   
	
	private static final long serialVersionUID = -5633480074836977529L;


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
	public Main(IDOMelement element){
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
		if(this.getAttribute(ApplicationManager.STRING_ROLE)==null) {
			this.addAttribute(Role.main);
		}
		return super.toString();  
	}
	 

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			super.throwComplianceError(this,element);
		return super.addDomElement(element);
	}
}

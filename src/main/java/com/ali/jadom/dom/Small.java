package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("small")
public class Small extends DOMelement  implements FlowingContent, PalpableContent, PhrasingContent{
  
	private static final long serialVersionUID = 2882582951808320462L;

	public Small(){
		super(tag(Small.class));
	}
	/**
	 * 
	 * @param shortSmallText
	 */
	public Small( String shortSmallText) {
		super(tag(Small.class), shortSmallText); 
	}

	 
	 /**
	  * 
	  * @param shortSmallText
	  * @param attributes
	  */
	public Small(String shortSmallText, HashMap<String, String> attributes) {
		super(tag(Small.class), shortSmallText, attributes);  
	}

	 /**
	  * 
	  * @param shortSmallText
	  * @param id
	  * @param domClass
	  * @param Styles
	  * @param jsCallout
	  */
	public Small(String shortSmallText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Small.class), shortSmallText, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE  && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element of type ").concat(element.getClass().getCanonicalName()).concat("\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to Override"));
		return super.addDomElement(element);
	}
	
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("em")
public class Em extends DOMelement  implements FlowingContent, PhrasingContent,  PalpableContent{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8009550021871905979L;

	public Em( ) {
		super(tag(Em.class)); 
	}

	public Em(DOMelementInterface element){
		super((Em)element);
	}
	
	public Em( String empahizedText) {
		super(tag(Em.class), empahizedText); 
	} 
	
	public Em(String empahizedText, HashMap<String, String> attributes) {
		super(tag(Em.class), empahizedText, attributes);  
	} 
	
	public Em(String empahizedText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Em.class), empahizedText, id, domClass, Styles, jsCallout); 
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

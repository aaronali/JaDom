package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.SectioningRoot;

@Tag("body")
public class Body extends DOMelement implements SectioningRoot { 
	
	private static final long serialVersionUID = 9072240359285309580L;
	protected String bodyHTML;
	
	/**
	 * Creates and empty &lthtml&gt body tag
	 */
	public Body(){
		super(tag(Body.class));
	}
	
	/**
	 * Creates a &lthtml&gt body tag with the given html embedded inside.
	 * @param bodyHTML
	 */
	public Body( String bodyHTML) {
		super(tag(Body.class), bodyHTML); 
	} 
	
	public Body(IDOMelement body){
		super((DOMelement)body);
		this.bodyHTML =((Body)body).bodyHTML;
	}
	
	
	/**
	 * Creates a &lthtml&gt body tag with the given html embedded inside and the given attributes.
	 * @param bodyHTML
	 * @param attributes
	 */
	public Body(String bodyHTML, HashMap<String, String> attributes) {
		super(tag(Body.class), bodyHTML, attributes);  
	}

	/**
	 * 
	 * @param bodyHTML
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Body(String bodyHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Body.class), bodyHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}


	/**
	 * Gets the Body of the &lthtml&gt tag as a string
	 * @return
	 */
	public final String getBodyHTML() {
		return bodyHTML;
	}

	/**
	 * Sets the html code inside of the &lthtml&gt tag
	 * @param bodyHTML
	 */
	public final void setBodyHTML(String bodyHTML) {
		this.bodyHTML = bodyHTML;
		this.nodevalue = bodyHTML;
	}
	 
	
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.PreferredContructor;
import com.ali.jadom.bootstrap.Bootstrap;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.SectioningRoot;

/**
 * HTML body tag
 * @author Aaron Ali
 *
 */
@Tag("body")
public class Body extends DOMelement implements SectioningRoot { 
	
	private static final long serialVersionUID = 9072240359285309580L;
	protected String bodyHTML;
	
	/**
	 * Creates and empty &lthtml&gt body tag
	 */
	@PreferredContructor
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
		Bootstrap strap = null;
		if(this.isBootstrapped()) {
			strap = new Bootstrap();
			strap.getCssIncudes();
		}
		if(strap!=null)
			return super.toString().replace(this.getBasicCloseTag(),strap.getJsInclude()).concat(ApplicationManager.STRING_NEWLINE).concat(this.getBasicCloseTag());
		else 
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
			this.throwComplianceError(this,element);
		return super.addDomElement(element);
	}
	
}

package com.ali.jadom.dom;

import java.util.Collection;
import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.PreferredContructor;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

/**
 * 
 * @author Aaron Ali
 *
 */
@Tag("div")
public class Div extends DOMelement implements FlowingContent, PalpableContent{
 
	 
	private static final long serialVersionUID = -8857726221497834946L;

	/**
	 * Creates an empty Div 
	 */
	@PreferredContructor
	public Div(){
		super(tag(Div.class));
	}
	
	/**
	 * Creates a simple Div  with html as the inner html
	 * @param divHTML
	 */
	@PreferredContructor
	public Div( String divHTML) {
		super(tag(Div.class), divHTML); 
	}
	
	public Div(Collection<DOMclass> domClasses) {
		super(tag(Div.class));
		for(DOMclass c: domClasses) {
			this.addAttribute(DOMclass.class.getSimpleName().toLowerCase(),  c.toString());
		}
	}

	/**
	 * Creates a Div with the given html, id and classes
	 * @param divHTML
	 * @param id
	 * @param domClass
	 */
	@PreferredContructor
	public Div(String divHTML, String id, DOMclass domClass) { 
		super(tag(Div.class),divHTML, id,  domClass!=null ? domClass.toString() : null,   null, null); 
	}
	
	
	 
	 /**
	  * 
	  * @param divHTML
	  * @param attributes
	  */
	public Div(String divHTML, HashMap<String, String> attributes) {
		super(tag(Div.class), divHTML, attributes);  
	}

	/**
	 * 
	 * @param divHTML
	 * @param id
	 * @param domClass
	 * @param Styles or null
	 * @param jsCallout or null
	 */
	public Div(String divHTML, String id, DOMclass domClass, String Styles, String jsCallout) {
		super(tag(Div.class), divHTML, id, domClass.toString(), Styles, jsCallout); 
	}
	 
	/**
	 * 
	 * @param divHTML
	 * @param id
	 * @param domClass
	 * @param Styles or null
	 * @param jsCallout or null
	 */ 
	public Div(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Div.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	/**
	 * Creates a Div with a single class
	 * @param domClass
	 */
	@PreferredContructor
	public Div(DOMclass domClass) {
		super(tag(Div.class));
		this.addAttribute(DOMclass.class.getSimpleName().toLowerCase(),  domClass.toString()); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&! element.isOfType(FlowingContent.class) )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

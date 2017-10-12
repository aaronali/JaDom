package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.SectioningContent;

@Tag("nav")
public class Nav extends DOMelement implements PalpableContent, FlowingContent, SectioningContent{
 
	 
	private static final long serialVersionUID = 4569043272607536805L;
	/**
	 * 
	 * @param element
	 */
	public Nav(IDOMelement element){
		super((Nav)element);
	}
	
	/**
	 * 
	 */
	public Nav(){
		super(tag(Nav.class), ""); 
	}
	
	/**
	 * 
	 * @param headerCode
	 */
	public Nav( String headerCode) {
		super(tag(Nav.class), headerCode); 
	}	
	/**
	 * 
	 * @param headerCode
	 * @param attributes
	 */
	public Nav(String headerCode, HashMap<String, String> attributes) {
		super(tag(Nav.class), headerCode, attributes);  
	}
	/**
	 * 
	 * @param headerCode
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Nav(String headerCode, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Nav.class), headerCode, id, domClass, Styles, jsCallout); 
	}

	public void addLi(String name, String link, Boolean isExternal){
		if(!listStarted){
			ul= new Ul(); 
			Li li = new Li();
			A a = new A(name,link,isExternal);
			li.addDomElement(a);
			ul.addDomElement(li);
			this.addDomElement(ul);
			listStarted=true;
		}else{
			this.getEmbeddedElements();
			for(DOMelement element:this.getEmbeddedElements())
				if(ul.equals(element))
					ul=(Ul)element;
			Li li =new Li();
			li.addDomElement(new A(name,link,isExternal));
			ul.addDomElement(li);
		}
	}
	private boolean listStarted =false;
	private Ul ul;
	
	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!element.isOfType(FlowingContent.class) || element.isOfType(Main.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	 
	
}

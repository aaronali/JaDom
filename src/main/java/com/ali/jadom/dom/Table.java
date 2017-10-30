package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.TableElement;

@Tag("table")
public class Table extends DOMelement implements FlowingContent, PalpableContent ,TableElement{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7603492820407443695L;

	public Table(){
		super(tag(Table.class));
	}
	
	public Table( String divHTML) {
		super(tag(Table.class), divHTML); 
	}

	public Table(String divHTML, HashMap<String, String> attributes) {
		super(tag(Table.class), divHTML, attributes);  
	}

	
	 
	public Table(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Table.class), divHTML, id, domClass, Styles, jsCallout); 
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

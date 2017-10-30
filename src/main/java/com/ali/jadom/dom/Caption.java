package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.TableElement;

@Tag("caprion")
public class Caption extends DOMelement{
 
	 
	private static final long serialVersionUID = -5178170859535121846L;

	public Caption(){
		super(tag(Caption.class));
	}
	
	public Caption( String divHTML) {
		super(tag(Caption.class), divHTML); 
	}

	 
	public Caption(String divHTML, HashMap<String, String> attributes) {
		super(tag(Caption.class), divHTML, attributes);  
	}

	
	 
	public Caption(String divHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Caption.class), divHTML, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  element.isOfType(FlowingContent.class) && !element.isOfType(TableElement.class))
			if(element.isOfType(TableElement.class))
				throw new RuntimeException(this.getClass().getCanonicalName().concat(" can not have any ").concat(Table.class.getCanonicalName()).concat(" elements as childer"));
			else;
		else
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

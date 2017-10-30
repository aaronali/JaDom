package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.TableColElementAbstract;
import com.ali.jadom.dom.superelements.TableElement;

@Tag("col")
public class Col extends TableColElementAbstract implements  TableElement{

	   
	private static final long serialVersionUID = -2915966582371424800L;

	public Col(){
		super(Col.class);
	}
	
	public Col( int span ) {
		super(Col.class,span); 
	}

	public Col(int span, HashMap<String, String> attributes) {
		super(Col.class, span, attributes);  
	}

	public Col(int span, String id, String domClass, String Styles, String jsCallout) {
		super(Col.class ,span, id, domClass, Styles, jsCallout); 
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE )
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element. \n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

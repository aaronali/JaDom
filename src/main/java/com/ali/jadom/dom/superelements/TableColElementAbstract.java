package com.ali.jadom.dom.superelements;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.DOMelement;
import com.ali.jadom.dom.superelements.TableElement;

@SuppressWarnings("serial")
public abstract class TableColElementAbstract extends DOMelement implements  TableElement{

	protected int span = 1; 

	public TableColElementAbstract(Class<?> cls){
		super(tag(cls));
	}
	
	public TableColElementAbstract(Class<?> cls ,int span) {
		super(tag(cls), ApplicationManager.NULL_NODE_VALUE); 
		this.span =span;
	}

	public TableColElementAbstract(Class<?> cls, int span, HashMap<String, String> attributes) {
		super(tag(cls),  ApplicationManager.NULL_NODE_VALUE, attributes);  
		this.span =span;
		}

	
	 
	public TableColElementAbstract(Class<?> cls, int span, String id, String domClass, String Styles, String jsCallout) {
		super(tag(cls),  ApplicationManager.NULL_NODE_VALUE, id, domClass, Styles, jsCallout); 
		this.span =span;
		}

	
	
	
	public synchronized final int getSpan() {
		return span;
	}

	public synchronized final void setSpan(int span) {
		this.span = span;
	}

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
			return super.addDomElement(element);
	}
}

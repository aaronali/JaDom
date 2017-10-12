package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;
import com.ali.jadom.javascript.DomFunction;
import com.ali.jadom.javascript.EventType;

public interface ILocation extends DOMobject {
	
	public void assign(String url);
	public void replace(String url);
	public void reload();
		 

}

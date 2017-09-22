package com.ali.jadom.dom;

public interface DOMelementInterface   {

	final String tag = null;
	/**
	 * Returns the ww3 compliant tag for the object
	 * @return
	 */
	public String tag();
	
	/**
	 * returns the dom element as html
	 * @return
	 */
	public String toString();
}

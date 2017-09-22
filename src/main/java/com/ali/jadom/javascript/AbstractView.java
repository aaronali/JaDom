package com.ali.jadom.javascript;

public abstract class AbstractView {

	/**
	 * The source for which this is an abstract view
	 */
	private DocumentView document = null;
	
	public   AbstractView(){
		super();
	}
	
	public AbstractView(DocumentView defaultDocument){
		document =defaultDocument;
	}
	
	public DocumentView DocuentView(){
		return document;
	}
}

package com.ali.jadom.javascript;

public abstract class DocumentView extends AbstractView{

	/**
	 * The default abstract view for the document
	 */
	private AbstractView abstractView =null;
	
	public DocumentView(){
		super();
	}
	
	
	
	public DocumentView(DocumentView defaultDocument) {
		super(defaultDocument); 
	}
	public DocumentView(DocumentView defaultDocument, AbstractView absractView) {
		super(defaultDocument); 
	}


	public AbstractView AbstractView(){
		return abstractView;
	}
}

package com.ali.jadom.javascript;

public class View extends AbstractView {

	private DocumentView documentView =null;

	public View() {
		super();
	}
	 

	public View(DocumentView defaultDocument) {
		super(defaultDocument); 
	}
	
	public View(DocumentView defaultDocument, DocumentView documentView) {
		super(defaultDocument); 
	}
	
	public View(DocumentView defaultDocument, AbstractView absractView, DocumentView documentView) {
		super(defaultDocument); 
	}
	
	public DocumentView DocumentView(){
		return documentView;
	
	}

}


 
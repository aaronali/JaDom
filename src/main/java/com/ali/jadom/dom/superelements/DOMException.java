package com.ali.jadom.dom.superelements;

import com.ali.jadom.ApplicationManager; 

public abstract class DOMException extends  Exception{

	

	protected String custommessage;
	
	public DOMException(String message) {
		super(message);
		this.custommessage=super.getMessage(); 
	}
	
	
	public DOMException(ErrorEnum error, Object sender, Object object){
		super();
		switch(error){ 
		case NO_ATTRIBUTES_ALLOWED:
			custommessage =sender.getClass().getCanonicalName().concat(ApplicationManager.appManager.getClassNotAllowedAttribute()).concat(ApplicationManager.appManager.getGenericeHelp());
			break;
		default:
			custommessage= " A compliance error has occured";
		}
	}
	
	@Override
	public String getMessage(){
		return this.custommessage;
	}

	public enum ErrorEnum{
		CLASS_NOT_ALLOWED,
		NO_ATTRIBUTES_ALLOWED
	}
}

package com.ali.jadom.exceptions;

import com.ali.jadom.dom.ApplicationManager;

public class JaDomComplianceError extends Exception { 
	private static final long serialVersionUID = 8761116898654039021L;
	String custommessage;
	public JaDomComplianceError(Object parent, Object object){
		super(parent.getClass().getCanonicalName().concat(ApplicationManager.appManager.getClassNotAllowedClass()).concat(object.getClass().getCanonicalName()));
		this.custommessage=super.getMessage();
	}

	public JaDomComplianceError(Error error, Object sender, Object object){
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

	public enum Error{
		CLASS_NOT_ALLOWED,
		NO_ATTRIBUTES_ALLOWED
	}
}

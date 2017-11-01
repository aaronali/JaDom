package com.ali.jadom.dom.superelements;

import com.ali.jadom.ApplicationManager; 

@SuppressWarnings("serial")
public abstract class DOMException extends  Exception{

 	protected String custommessage;
	
	public DOMException(String message) {
		super(message);
		this.custommessage=super.getMessage(); 
	}
	
	@Deprecated
	/**
	 * Use DOMException(String message)
	 * @param error
	 */
	public DOMException(ErrorEnum error) {
		this("",error);
	}
	
	/**
	 * Use DOMException(String message)
	 * @param error
	 */
	@Deprecated
	public DOMException(String message, ErrorEnum error) {
		super(message);
		this.custommessage=super.getMessage();  
		switch(error){ 
		default:
			custommessage= " An error has occured";
		}
	}
	
	
	/**
	 * Use DOMException(String message)
	 * @param error
	 */
	@Deprecated
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

	@Deprecated
	/**
	 * To be removed 
	 */
	public enum ErrorEnum{
		CLASS_NOT_ALLOWED,
		NO_ATTRIBUTES_ALLOWED,
		BOOTSTRAP_CONFIGURATION_ERROR
	}
}

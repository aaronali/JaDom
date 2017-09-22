package com.ali.jadom.javascript;

public class DomEventException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1817714934442609957L;
	final static public short UNSPECIFIED_EVENT_TYPE_ERR     = 0;
	public short code;
	public DomEventException(){
		super("Event Exception Occurred with error code 0");
	}
	
	public DomEventException(short code ){
		super("Event Exception Occurred with error code ".concat(String.valueOf(code)));
		this.code = code;
	}
	
	public DomEventException(short code, String message){
		super("Event Exception Occurred with error code ".concat(String.valueOf(code)).concat("\n").concat(message));
		this.code = code;
	}
	  

}

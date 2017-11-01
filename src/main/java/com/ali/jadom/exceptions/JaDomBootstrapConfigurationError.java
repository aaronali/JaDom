package com.ali.jadom.exceptions; 
import com.ali.jadom.dom.superelements.DOMException; 

public class JaDomBootstrapConfigurationError  extends DOMException {  
	 
	private static final long serialVersionUID = -5683041378083322260L;

	 
	public JaDomBootstrapConfigurationError(String msg){
		super(msg);
	} 
}

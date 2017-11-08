package com.ali.jadom.exceptions;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.DOMException; 

/**
 * JaDomEmptyElementError thrown when a elemet is being created
 * without the required elements
 * @author Aaron Ali
 *
 */
public class JaDomEmptyElementError extends DOMException {  
	
  
	private static final long serialVersionUID = -1769444133638461L;

	/**
	 * Creates the JaDom Exception
	 * @param parent creating the 
	 * @param object
	 */
	public JaDomEmptyElementError(Object object){
		super(ApplicationManager.appManager.getElementCreationError().concat(object.getClass().getCanonicalName()));
	}
 
}

package com.ali.jadom.exceptions;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.DOMException;
import org.w3c.dom.html.*;

public class JaDomComplianceError extends DOMException { 
	private static final long serialVersionUID = 8761116898654039021L; 
	
	
	public JaDomComplianceError(Object parent, Object object){
		super(parent.getClass().getCanonicalName().concat(ApplicationManager.appManager.getClassNotAllowedClass()).concat(object.getClass().getCanonicalName()));
	}

	public JaDomComplianceError(ErrorEnum error, Object sender, Object object){
		super(error,sender,object); 
	}
	
	
 
}

package com.ali.jadom.javascript;
 
public interface EventTarget { 
;
		 public void addEventListener(String type, DomFunction function,  boolean useCapture,String sessionId);
		 public void removeEventListener( String type, DomFunction function,  boolean useCapture,String sessionId);
		 public  boolean dispatchEvent(DomEventAbstract evt) throws DomEventException;
}

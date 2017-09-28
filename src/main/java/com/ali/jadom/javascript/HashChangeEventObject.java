package com.ali.jadom.javascript;
 

public class HashChangeEventObject extends DomEventAbstract implements DomEventInterface, JavaScriptObject{

	private static final long serialVersionUID = 7213196428886593533L;
	public String newURL;//	Returns the URL of the document, after the hash has been changed	
	public String oldURL;//	Returns the URL of the document, before the hash was changed
} 

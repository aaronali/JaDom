package com.ali.jadom.javascript;
 

public interface DomEventInterface  {

	public static enum EventPhase{
     NULL,
	 CAPTURING_PHASE ,
     AT_TARGET ,
     BUBBLING_PHASE
	}

	public void  stopPropagation();
	public  void  preventDefault();
	public void  initEvent(String eventTypeArg,  boolean canBubbleArg,  boolean cancelableArg);
 
}

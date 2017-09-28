package com.ali.jadom.javascript;

import java.util.Date;

import com.ali.jadom.dom.DOMelement; 

public class UiEvent extends DomEventAbstract implements DomEventInterface{ 
 
	 
	private static final long serialVersionUID = 1L;
	private  long detail =0;

	public UiEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UiEvent( long detail){
		super();
		this.detail=detail;
	}

	public UiEvent(boolean bubbles, boolean cancelable, EventTarget currentTarget, boolean defaultPrevented,
			EventPhase eventPhase, boolean isTrusted, EventTarget target, Date timeStamp, String type,
			DOMelement view) {
		super(bubbles, cancelable, currentTarget, defaultPrevented, eventPhase, isTrusted, target, timeStamp, type, view);
		// TODO Auto-generated constructor stub
	}
	
	public void initUIEvent(String typeArg,   boolean canBubbleArg,  boolean cancelableArg, AbstractView viewArg, long detailArg){
		
	};

	public synchronized final long getDetail() {
		return detail;
	}

	public synchronized final void setDetail(long detail) {
		this.detail = detail;
	} 
		 
}

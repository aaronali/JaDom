package com.ali.jadom.javascript;
 
import java.io.Serializable;
import java.util.Date;

import com.ali.jadom.dom.DOMelement; 

@SuppressWarnings("serial")
public abstract class DomEventAbstract implements Serializable, DomEventInterface{

	public boolean bubbles =false;
	public boolean cancelable = false;
	public EventTarget currentTarget =null;
	public boolean defaultPrevented = false;
	public EventPhase eventPhase = EventPhase.NULL;
	public boolean isTrusted = false;
	public EventTarget target = null;
	public Date timeStamp =null;
	public String type = null;
	public DOMelement view = null; 

	public DomEventAbstract(){
		
	}
	
	public DomEventAbstract(boolean bubbles, boolean cancelable, EventTarget currentTarget, boolean defaultPrevented,
			EventPhase eventPhase, boolean isTrusted, EventTarget target, Date timeStamp, String type,
			DOMelement view) {
		super();
		this.bubbles = bubbles;
		this.cancelable = cancelable;
		this.currentTarget = currentTarget;
		this.defaultPrevented = defaultPrevented;
		this.eventPhase = eventPhase;
		this.isTrusted = isTrusted;
		this.target = target;
		this.timeStamp = timeStamp;
		this.type = type;
		this.view = view;
	}

	@Override
	public void preventDefault(){
		this.defaultPrevented = true;
	}
	
	 
	public void stopImmediatePropagation() {
		throw new RuntimeException("Method not implemented");
	}
	
	@Override 
	public void stopPropagation() {
		throw new RuntimeException("Method not implemented");
	}

	@Override
	public void initEvent(String StringArg,  boolean canBubbleArg,  boolean cancelableArg){
		throw new RuntimeException("Method not implemented");
	}
	
	public synchronized final boolean isBubbles() {
		return bubbles;
	}

	public synchronized final void setBubbles(boolean bubbles) {
		this.bubbles = bubbles;
	}

	public synchronized final boolean isCancelable() {
		return cancelable;
	}

	public synchronized final void setCancelable(boolean cancelable) {
		this.cancelable = cancelable;
	}

	public synchronized final EventTarget getCurrentTarget() {
		return currentTarget;
	}

	public synchronized final void setCurrentTarget(EventTarget currentTarget) {
		this.currentTarget = currentTarget;
	}

	public synchronized final boolean isDefaultPrevented() {
		return defaultPrevented;
	}

	public synchronized final void setDefaultPrevented(boolean defaultPrevented) {
		this.defaultPrevented = defaultPrevented;
	}

	public synchronized final EventPhase getEventPhase() {
		return eventPhase;
	}

	public synchronized final void setEventPhase(EventPhase eventPhase) {
		this.eventPhase = eventPhase;
	}

	public synchronized final boolean isTrusted() {
		return isTrusted;
	}

	public synchronized final void setTrusted(boolean isTrusted) {
		this.isTrusted = isTrusted;
	}

	public synchronized final EventTarget getTarget() {
		return target;
	}

	public synchronized final void setTarget(EventTarget target) {
		this.target = target;
	}

	public synchronized final Date getTimeStamp() {
		return timeStamp;
	}

	public synchronized final void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public synchronized final String getType() {
		return type;
	}

	public synchronized final void setType(String type) {
		this.type = type;
	}

	public synchronized final DOMelement getView() {
		return view;
	}

	public synchronized final void setView(DOMelement view) {
		this.view = view;
	}
	
	
}

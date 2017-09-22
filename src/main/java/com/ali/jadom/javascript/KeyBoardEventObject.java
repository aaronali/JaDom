package com.ali.jadom.javascript;

import java.util.Date;

import com.ali.jadom.dom.DOMelement;

public class KeyBoardEventObject extends DomEventAbstract implements DomEventInterface, JavaScriptObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4770417212581663710L;
	protected boolean altKey;
	protected boolean ctrlKey;
	protected String charCode;
	protected boolean metaKey;
	protected String keyValue;
	protected String keyCode;	
	protected int keyLocation;
	protected boolean shiftKey;
	protected String which;
	
	
	public KeyBoardEventObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KeyBoardEventObject(boolean bubbles, boolean cancelable, EventTarget currentTarget, boolean defaultPrevented,
			EventPhase eventPhase, boolean isTrusted, EventTarget target, Date timeStamp, String type,
			DOMelement view) {
		super(bubbles, cancelable, currentTarget, defaultPrevented, eventPhase, isTrusted, target, timeStamp, type, view);
		// TODO Auto-generated constructor stub
	}
	public KeyBoardEventObject(boolean altKey, boolean ctrlKey, String charCode, boolean metaKey, String keyValue,
			String keyCode, int keyLocation, boolean shiftKey, String which) {
		super();
		this.altKey = altKey;
		this.ctrlKey = ctrlKey;
		this.charCode = charCode;
		this.metaKey = metaKey;
		this.keyValue = keyValue;
		this.keyCode = keyCode;
		this.keyLocation = keyLocation;
		this.shiftKey = shiftKey;
		this.which = which;
	}
	public synchronized final boolean isAltKey() {
		return altKey;
	}
	public synchronized final void setAltKey(boolean altKey) {
		this.altKey = altKey;
	}
	public synchronized final boolean isCtrlKey() {
		return ctrlKey;
	}
	public synchronized final void setCtrlKey(boolean ctrlKey) {
		this.ctrlKey = ctrlKey;
	}
	public synchronized final String getCharCode() {
		return charCode;
	}
	public synchronized final void setCharCode(String charCode) {
		this.charCode = charCode;
	}
	public synchronized final boolean isMetaKey() {
		return metaKey;
	}
	public synchronized final void setMetaKey(boolean metaKey) {
		this.metaKey = metaKey;
	}
	public synchronized final String getKeyValue() {
		return keyValue;
	}
	public synchronized final void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public synchronized final String getKeyCode() {
		return keyCode;
	}
	public synchronized final void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public synchronized final int getKeyLocation() {
		return keyLocation;
	}
	public synchronized final void setKeyLocation(int keyLocation) {
		this.keyLocation = keyLocation;
	}
	public synchronized final boolean isShiftKey() {
		return shiftKey;
	}
	public synchronized final void setShiftKey(boolean shiftKey) {
		this.shiftKey = shiftKey;
	}
	public synchronized final String getWhich() {
		return which;
	}
	public synchronized final void setWhich(String which) {
		this.which = which;
	}
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}  
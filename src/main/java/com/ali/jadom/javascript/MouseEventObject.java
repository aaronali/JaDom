package com.ali.jadom.javascript;
 
import java.util.Date;

import com.ali.jadom.dom.DOMelement;


public class MouseEventObject extends DomEventAbstract implements DomEventInterface, JavaScriptObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3896913444997799568L;
	public boolean altKey;//	Returns whether the "ALT" key was pressed when the mouse event was triggered	2
	public String button; //	Returns which mouse button was pressed when the mouse event was triggered
	public String[] buttons = null;//	Returns which mouse buttons were pressed when the mouse event was triggered	
	public int clientX;// Returns the horizontal coordinate of the mouse pointer, relative to the current window, when the mouse event was triggered	2
	public int clientY;//	Returns the vertical coordinate of the mouse pointer, relative to the current window, when the mouse event was triggered
	public boolean ctrlKey;//	Returns whether the "CTRL" key was pressed when the mouse event was triggered
	public int detail;//	Returns a number that indicates how many times the mouse was clicked
	public boolean metaKey;//	Returns whether the "META" key was pressed when an event was triggered
	public EventTarget relatedTarget;//	Returns the element related to the element that triggered the mouse event
	public int screenX;//Returns the horizontal coordinate of the mouse pointer, relative to the screen, when an event was triggered	
	public int screenY;//Returns the vertical coordinate of the mouse pointer, relative to the screen, when an event was triggered
	public boolean shiftKey;//	Returns whether the "SHIFT" key was pressed when an event was triggered	2
	public String which;
	
	
	public MouseEventObject(){ 
	}
	
	
	
	public MouseEventObject(boolean bubbles, boolean cancelable, EventTarget currentTarget, boolean defaultPrevented,
			EventPhase eventPhase, boolean isTrusted, EventTarget target, Date timeStamp, String type,
			DOMelement view, boolean altKey, String button, String[] buttons, int clientX, int clientY, boolean ctrlKey,
			int detail, boolean metaKey, EventTarget relatedTarget, int screenX, int screenY, boolean shiftKey,
			String which) {
		super( bubbles,  cancelable,  currentTarget, defaultPrevented, eventPhase,  isTrusted,  target,  timeStamp,  type, view);
		this.altKey = altKey;
		this.button = button;
		this.buttons = buttons;
		this.clientX = clientX;
		this.clientY = clientY;
		this.ctrlKey = ctrlKey;
		this.detail = detail;
		this.metaKey = metaKey;
		this.relatedTarget = relatedTarget;
		this.screenX = screenX;
		this.screenY = screenY;
		this.shiftKey = shiftKey;
		this.which = which;
	}
	public MouseEventObject(boolean bubbles, boolean cancelable, EventTarget currentTarget, boolean defaultPrevented,
			EventPhase eventPhase, boolean isTrusted, EventTarget target, Date timeStamp, String type,
			DOMelement view) {
		super( bubbles,  cancelable,  currentTarget, defaultPrevented, eventPhase,  isTrusted,  target,  timeStamp,  type , view);
			
	}
	public synchronized final boolean isAltKey() {
		return altKey;
	}
	public synchronized final void setAltKey(boolean altKey) {
		this.altKey = altKey;
	}
	public synchronized final String getButton() {
		return button;
	}
	public synchronized final void setButton(String button) {
		this.button = button;
	}
	public synchronized final String[] getButtons() {
		return buttons;
	}
	public synchronized final void setButtons(String[] buttons) {
		this.buttons = buttons;
	}
	public synchronized final int getClientX() {
		return clientX;
	}
	public synchronized final void setClientX(int clientX) {
		this.clientX = clientX;
	}
	public synchronized final int getClientY() {
		return clientY;
	}
	public synchronized final void setClientY(int clientY) {
		this.clientY = clientY;
	}
	public synchronized final boolean isCtrlKey() {
		return ctrlKey;
	}
	public synchronized final void setCtrlKey(boolean ctrlKey) {
		this.ctrlKey = ctrlKey;
	}
	public synchronized final int getDetail() {
		return detail;
	}
	public synchronized final void setDetail(int detail) {
		this.detail = detail;
	}
	public synchronized final boolean isMetaKey() {
		return metaKey;
	}
	public synchronized final void setMetaKey(boolean metaKey) {
		this.metaKey = metaKey;
	}
	public synchronized final EventTarget getRelatedTarget() {
		return relatedTarget;
	}
	public synchronized final void setRelatedTarget(EventTarget relatedTarget) {
		this.relatedTarget = relatedTarget;
	}
	public synchronized final int getScreenX() {
		return screenX;
	}
	public synchronized final void setScreenX(int screenX) {
		this.screenX = screenX;
	}
	public synchronized final int getScreenY() {
		return screenY;
	}
	public synchronized final void setScreenY(int screenY) {
		this.screenY = screenY;
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
	
	
} 

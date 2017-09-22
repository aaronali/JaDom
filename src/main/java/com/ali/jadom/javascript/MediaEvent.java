package com.ali.jadom.javascript;

import java.util.Date;

import com.ali.jadom.dom.DOMelement;

public class MediaEvent extends DomEventAbstract {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected short readyState; // uses HTMLMediaElement.readyState's values

	protected double buffered;
	protected double seekable;
	protected double duration;
	protected double currentTime;

	protected boolean paused;
	protected String playbackState;
	public MediaEvent() {
		super(); 
	}
	public MediaEvent(boolean bubbles, boolean cancelable, EventTarget currentTarget, boolean defaultPrevented,
			EventPhase eventPhase, boolean isTrusted, EventTarget target, Date timeStamp, String type,
			DOMelement view) {
		super(bubbles, cancelable, currentTarget, defaultPrevented, eventPhase, isTrusted, target, timeStamp, type, view); 
	}
	
	public MediaEvent(short readyState, double buffered, double seekable, double duration, double currentTime,
			boolean paused, String playbackState) {
		super();
		this.readyState = readyState;
		this.buffered = buffered;
		this.seekable = seekable;
		this.duration = duration;
		this.currentTime = currentTime;
		this.paused = paused;
		this.playbackState = playbackState;
	}
	public synchronized final short getReadyState() {
		return readyState;
	}
	public synchronized final void setReadyState(short readyState) {
		this.readyState = readyState;
	}
	public synchronized final double getBuffered() {
		return buffered;
	}
	public synchronized final void setBuffered(double buffered) {
		this.buffered = buffered;
	}
	public synchronized final double getSeekable() {
		return seekable;
	}
	public synchronized final void setSeekable(double seekable) {
		this.seekable = seekable;
	}
	public synchronized final double getDuration() {
		return duration;
	}
	public synchronized final void setDuration(double duration) {
		this.duration = duration;
	}
	public synchronized final double getCurrentTime() {
		return currentTime;
	}
	public synchronized final void setCurrentTime(double currentTime) {
		this.currentTime = currentTime;
	}
	public synchronized final boolean isPaused() {
		return paused;
	}
	public synchronized final void setPaused(boolean paused) {
		this.paused = paused;
	}
	public synchronized final String getPlaybackState() {
		return playbackState;
	}
	public synchronized final void setPlaybackState(String playbackState) {
		this.playbackState = playbackState;
	}
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}


}

package com.ali.jadom.javascript;

import java.io.Serializable;

import com.ali.jadom.dom.ApplicationManager; 

public class EventListener implements  EventListenerInterface , Serializable{

	 
	private static final long serialVersionUID = 2895443946978687463L;
	protected DomFunction function;
	protected DomEventInterface event;
	protected String type;
	protected boolean useCapture; 
	protected String requestUrl;
	protected XMLHttpRequest request;
	
	
	public EventListener(String eventType, DomFunction function){
		super();
		this.type = eventType;
		this.function =function;
	}
	
	
	public EventListener(String type, DomFunction function, boolean useCapture) {
		super();
		this.function =function;
		this.type =type;
		this.useCapture = useCapture;
	}

	public EventListener(String type, DomFunction function, boolean useCapture,String requestRL) {
		super();
		this.function =function; 
		this.request=(XMLHttpRequest) function;
		this.type =type;
		this.useCapture = useCapture;
		this.requestUrl = requestRL;  
		//this.function.body.replace("",)
	}
	public EventListener(EventType type, DomFunction function, boolean useCapture) {
		super();
		this.function=function;
		this.useCapture =useCapture;
		this.type = type.name().trim();
		this.function.addParam("event");
	}
	
	public void bindRequest(XMLHttpRequest request,String sessionId){ 
		this.request=request ;
		this.function=this.request; 
		this.requestUrl=request.getRequestUrl(); 
		ApplicationManager.addEventListener(this, sessionId);
	}
	
	public void unBind(String sessionId){ 
		ApplicationManager.removeEventListener(this,sessionId); 
	}
	
	public String getResponseText(){
		return request.getResponseText();
	}
	
	@Override
	public void handleEvent(DomEventInterface event) {
	 
	}


	public synchronized final DomFunction getFunction() {
		return function;
	}


	public synchronized final void setFunction(DomFunction function) {
		this.function = function;
	}


	public synchronized final DomEventInterface getEvent() {
		return event;
	}


	public synchronized final void setEvent(DomEventInterface event) {
		this.event = event;
	}


	public synchronized final String getType() {
		return type;
	}


	public synchronized final void setType(String type) {
		this.type = type;
	}


	public synchronized final boolean isUseCapture() {
		return useCapture;
	}


	public synchronized final void setUseCapture(boolean useCapture) {
		this.useCapture = useCapture;
	}
	
	public void setRequestUrl(String url){
		this.requestUrl = url;
	}
	
	@Override
	public String toString(){
		DomFunction function = this.function;
		function.addParam("event");;
		String s =".addEventListener(\"".concat(type).concat("\",").concat(request.toString()).concat(");\n");/**.concat(String.valueOf(useCapture).concat(");")**/
			 
		return s;
	}


	public String getRequestUrl() {
		return this.requestUrl;
	}

}
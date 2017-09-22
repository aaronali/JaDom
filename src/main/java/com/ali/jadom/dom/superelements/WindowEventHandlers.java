package com.ali.jadom.dom.superelements;

import com.ali.jadom.javascript.EventListener;

public interface WindowEventHandlers { 
	public void  onafterprint(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onbeforeprint(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public EventListener onbeforeunload(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onhashchange(java.lang.Object object, String methodname,java.lang.Object[] params, String sessionid);
	public void  onlanguagechange(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onmessage(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onoffline(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  ononline(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onpagehide(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onpageshow(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onpopstate(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onstorage(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
	public void  onunload(java.lang.Object objetc, String methodname,java.lang.Object[] params, String sessionid);
};

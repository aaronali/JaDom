package com.ali.jadom.javascript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ali.jadom.dom.ApplicationManager; 

public class XMLHttpRequest extends DomFunction implements Serializable, EventTarget { 
	
	
	private static final long serialVersionUID = 6061227464821458524L;
	protected String method ="get";
	protected DomFunction onreadystatechange;
	static final int UNSENT = 0;
	static final int OPENED = 1;
	static final int HEADERS_RECEIVED = 2;
	static final int LOADING = 3;
	static final int DONE = 4;
	protected int readyState; 
	protected  int status;
	protected byte[] statusText; 
	
	protected Object responseObject;
	protected String responseObjectCallback;
	protected Object[] responseObjectCallbackParam =null;
	
	
	protected String responseText;
	protected String requestUrl;
	protected String name = "XMLHttpRequest".concat(ApplicationManager.getNextFunctoinName());
	public enum XMLHttpRequestResponseType { 
		NULL,
		arraybuffer,
		blob,
		document,
		json,
		text; 
		public String toString(){
		return (this.name().equals("NULL"))? "": this.name();
		}
	};   
	
	
	
	/**
	 * 
	 * @param onreadystatechange DomFunction
	 * @param method String "post" or "get"
	 * @param requestUrl String
	 */
	public XMLHttpRequest(String method,DomFunction onreadystatechange, String requestUrl) {
		
		super();
		this.onreadystatechange = onreadystatechange; 
		this.requestUrl = requestUrl;
		this.method =method;
		super.args=null;
		
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String getBody(){
		StringBuilder sb = new StringBuilder();
		 
		sb.append("{\nvar ".concat(name).concat("=new XMLHttpRequest();"));
		sb.append("\n".concat(name).concat(".onreadystatechange =function("));
		if (onreadystatechange.args!=null){
			for(String arg:onreadystatechange.args)
				sb.append(arg.concat(" ,"));
		}
		if(sb.toString().endsWith(","))
			sb.replace(sb.length()-1, sb.length(), "");
		sb.append("){");
		sb.append("\n     if (".concat(this.name).concat(".readyState == 4 && ").concat(this.name).concat(".status == 200) {"));
	//	if(onreadystatechange.body!=null)
			sb.append("\n          ".concat(this.onreadystatechange.body.toString().replace("\n", "\n          ").replace("eventListenerNamePlaceHolder", name)));
		sb.append("\n}};");  
		sb.append("\n".concat(name).concat(".open(\"").concat(method).concat("\", \"./?domlistener=").concat(requestUrl.trim())
				.concat("\", true);"));
		sb.append("\n".concat(name).concat(".send();"));
		return sb.toString().concat("}");
	}
	
	public String toString(){
		return super.toString();
	}
		 
	
	 

	 
	 
	 
	
	/**
	 * Reads a file and returns a String containing all the readable file contents
	 * @param filename
	 * @return 
	 * @return String of file contents
	 */
	private  String readscript(String filename){
		String  result = new String(); 
		Path file = Paths.get(filename);
		 
		try {
			InputStream in = Files.newInputStream(file);
		 
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        result.concat(line);
		        result.concat("\n");
		    }
		} catch (IOException e) {
		    System.err.println(e);
		}
		return result;
	}

	@Override
	public void addEventListener(String type, DomFunction function, boolean useCapture,String sesionId) {
		throw new RuntimeException("Mehod not implementerd");
	}

	@Override
	public void removeEventListener(String type, DomFunction function, boolean useCapture, String sesionId) {
		throw new RuntimeException("Mehod not implementerd");
		
	}

	@Override
	public boolean dispatchEvent(DomEventAbstract evt) throws DomEventException {
		throw new RuntimeException("Mehod not implementerd"); 
		 
	}
	
	/**
	 * Invokes the callback method on the response object. If the methos fail the return value will be null;
	 * @return
	 */
	public Object getReponse() {
		//throw new RuntimeException("Mehod not implementerd");
		if(responseObject==null) return null;
		try {
			Class<?>[] cl =null;
			if(responseObjectCallbackParam!=null && responseObjectCallbackParam.length>0){
				cl = new Class<?>[responseObjectCallbackParam.length];
				for(int i=0; i< responseObjectCallbackParam.length;i++){
					cl[i] = responseObjectCallbackParam[i].getClass();
				}
			}
			 
			return this.responseObject.getClass().getMethod(responseObjectCallback.replace("(", "").replace(")",""),cl).invoke(this.responseObject, responseObjectCallbackParam);
		 
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	
	public String getResponseText(){
		return responseText;
	}

	public void setRequestUrl(String id) {
		this.requestUrl =id;
		
	}

	public String getRequestUrl() {
		return requestUrl;
	}
	
	public void setResponseObject(Object object, String callBack){
		this.responseObject = object;
		this.responseObjectCallback=callBack;
	}

	public void setResponseObject(Object object, String callBack, Object[] params){
		this.responseObject = object;
		this.responseObjectCallback=callBack;
		this.responseObjectCallbackParam = params;
	}
	
	public Object getResponseObject(){
		return this.responseObject;
	}
}
	 

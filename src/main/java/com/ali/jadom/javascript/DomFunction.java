package com.ali.jadom.javascript;
 
import java.io.IOException;
import java.io.Serializable;

import com.ali.jadom.ApplicationManager;
import com.ali.java.jaFile.FileReader;  
 
public class DomFunction extends JavaScript implements Serializable, Appendable, JavaScriptObject {


	private static final long serialVersionUID = -7568252713234287995L;
	protected String name=null;
	protected StringBuilder body;
	protected String[] args;

	public DomFunction(){
		this.name=ApplicationManager.getNextFunctoinName();
		this.body=new StringBuilder().append(body); 
	}
	
	/**
	 * Creates a function with he name body and arguments
	 * @param name
	 * @param body
	 * @param args
	 */
	public  DomFunction(String name, String body ,String[] args ){
		super();		
		if(name==null) 
			name = ApplicationManager.getNextFunctoinName();
		this.name = name;
		if(args!=null)
			this.args = args;
		this.body=new StringBuilder().append(body);

	}
	
	public DomFunction(String body){
		super();
		this.name = ApplicationManager.getNextFunctoinName(); 
		this.body=new StringBuilder().append(body);
		this.args=null;
		if(body!=null&& body.toLowerCase().equals("function"))
		{
			this.body=new StringBuilder();
			this.name= "function";
		}
	}
	
	
	@Override
	public String toString(){  
		StringBuilder s = new StringBuilder();
		if(this.name!=null && this.name.toLowerCase().equals("function")){
		 	return s.append( "{".concat(super.toString()).concat("\n}")).toString(); 
		 }
		s.append(this.getFunctionSignature());
		return s.append(this.getBody()).toString();
	}
	 
	/**
	 * Returns the body of the function with out any braces
	 * @return String
	 */
	public String getBody(){
		String body ="{\n";
		for(String ss: this.body.toString().split(";") ){
			body = body.concat("\n     ").concat(ss).concat(";");
		} 
	 	return (!ApplicationManager.JAVASCRIPT_CONDENSE)?body.concat("\n}").replace("\n\n", "\n"):
	 		body.concat("\n").replace("= ","=").replace("  ", "").replace("\n", "").replace("return ", "return")
				.replace(" ;","").replace("= ", "=").replace("; ",";").replace("{ ", "{").concat("}");
	}

	private String getFunctionSignature(){
		String signature= "function(";
		if(args!=null && args.length>0){
			for(int i=0 ; i<args.length;i++){
				signature = signature.concat(args[i]);
				if(i<args.length-1)
					signature = signature.concat(", ");
			}
		}
		return signature.concat(")");
	}

	public static   long getSerialversionuid() {
		return serialVersionUID;
	}

	public   void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public   void setBody(String body) {
		this.body = new StringBuilder().append(body);
	}

	public   void setArgs(String[] args) {
		this.args = args;
	}

	 
	@Override
	public Appendable append(CharSequence csq) throws IOException {
		if(body==null) body = new StringBuilder();
		body.append(csq);
		return null;
	}
	
	
	/**
	 * 
	 */
	@Override
	public Appendable append(CharSequence csq, int start, int end) throws IOException {  

		if(body==null) body = new StringBuilder();
		body.append(csq,start,end);
		return this;
	}

	@Override
	public Appendable append(char c) throws IOException {

		if(body==null) body = new StringBuilder();
		body.append(c);
		return this;
	}
	
	public void replace(String arg1, String arg2){ 
		this.body = new StringBuilder(body.toString().replace(arg1, arg2));
	}

	/**
	 * Adds an argument to the function
	 * @param arg
	 */
	public void addParam(String arg) {
		if(args!=null)  
			for(String param:args)
				if(param.equals(arg))
					return;
		args = growStringArray(args);
		args[args.length-1] =arg;
	}
 
	private String[] growStringArray(String[] array){
		if(array==null) array = new String[0];
		String[] temp = new String[array.length];
		System.arraycopy(array, 0, temp, 0, array.length);
		array= new String[array.length+1];
		System.arraycopy(temp, 0, array, 0, temp.length);
		return array;
	}
	public void readFromFile(String filename) {
		this.body = new StringBuilder();
		this.body.append( new FileReader().readFile(filename));
		//System.out.println("body = "+  this.body);
	}
	
	
	
}

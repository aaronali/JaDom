package com.ali.jadom.javascript;

import com.ali.jadom.dom.ApplicationManager;

public class JavaScript implements JavaScriptObject{
 
	protected JavaScript[] value;
	protected StringBuilder script; 
	private String placeHolder;
	
	 public JavaScript(){
		 value = new JavaScript[0];
		 this.placeHolder = ApplicationManager.getNextId()+ApplicationManager.getNextId();
		 script = new StringBuilder();
	 }
	 
	 
	 public JavaScript(String script){
		 value = new JavaScript[1];    
		 value[0]= new JavaScript();
		 value[0].script = new StringBuilder().append(script); 
		 placeHolder = ApplicationManager.getNextId()+ApplicationManager.getNextId();
		 this.script = new StringBuilder().append(placeHolder);
		 
	 }
 
	 public void growValue(){
		if(value==null) value = new JavaScript[0];
		JavaScript[] temp = new JavaScript[value.length+1];
		System.arraycopy(value, 0, temp, 0, temp.length-1);
		value = new JavaScript[temp.length];
		System.arraycopy(temp, 0, value, 0, temp.length);
		
	 }
	 
	 public void addFunction(DomFunction function){
		 
	 }
	 
	 public void addJS(String js){ 
		 growValue();
		 value[value.length-1]=new JavaScript(js);
		 script.append("\n".concat(placeHolder)); 
	 }
	 
	 
	 public void addJavaScipt(JavaScript javaScript){
		 growValue();
		 value[value.length-1] = javaScript;
		 script.append("\n".concat(placeHolder)); 
	 }
	 
	 @Override
	 public String toString(){
	 
		 int count =0;
		 String s =  "";
		 for(int i =0 ; i< this.script.toString().length(); i++){  
			 s =s.concat(String.valueOf(script.toString().charAt(i)));
				if(s.endsWith(placeHolder)){
					if(value[count].value!=null){
						s = s.replace(placeHolder,  value[count].toString());
						count++;
					}else{
						s = s.replace(placeHolder, value[count].script);
						count++;
					}
				}
			 }
		 
		 return s;
	 }
	 
}

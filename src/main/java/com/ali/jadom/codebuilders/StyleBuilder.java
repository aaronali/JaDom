package com.ali.jadom.codebuilders;

import java.util.ArrayList;
import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.DOMelement;
import com.ali.jadom.dom.MediaTypesEnum;
import com.ali.jadom.dom.Style; 

public class StyleBuilder {
	
	private Style[] styles = new Style[0];
	private StringBuilder styleCode = new StringBuilder();
		
	
	public StyleBuilder(){ 
		super();
	}

	public  StyleBuilder(String code){
		styleCode.append(code);
	}
	

	public StyleBuilder(StyleBuilder sb) {
		super();
		this.styleCode = sb.styleCode;
		this.styles = sb.styles;
		
	}
	
	protected static Style[] growArray(Style[] array){
		Style[] temp = new Style[array.length];
		System.arraycopy(array, 0, temp, 0, array.length);
		array=new Style[temp.length+1];
		System.arraycopy(temp, 0, array, 0, temp.length);
		return array;
	}
	
 
	
	private void addStyle(Style style){
		styles =growArray(styles);
		styles[styles.length-1]=style; 
	}
	
	public void addStyle(String styleName, String[] valueNames, String[] values){ 
		addStyle(new Style(styleName, valueNames,values));
	}
	public void addStyle(String styleName, String[] valueNames, String[] values, MediaTypesEnum media){
		addStyle(new Style(styleName, valueNames,values,media));
	}
	public String generateStyleSheet(){
		
		 Style[] medias =new Style[0];
		 String code= "";
		 for(int i=0; i<styles.length;i++){
			 if(styles[i].getMediaTypes()!=null)
			 {
				 medias = (Style[]) growArray(medias);
				 medias[medias.length-1]= styles[i];
			 }else{
				code+='\n'+styles[i].toString(); 
			 }
		 }
		 code +=processMedia(styles);
		 return  code+'\n';
	}
	
	public DOMelement generateStyles(){
		Style x =  new Style(""); 
		x.setNodevalue(this.generateStyleSheet());
		return x;
	}
	
	
	public String processMedia(Style[] s){
		HashMap<String,Style[]> result = new HashMap<String,Style[]>();
		for(int i=0; i<styles.length;i++){
			String key=styles[i].getMediaTypes();
			if(key!=null){
				if(!result.containsKey(key)){
					Style[] sty = {styles[i] }; 
					result.put(key,  sty);
				}else{
					Style[] newStyles = result.get(key);
					newStyles= growArray(newStyles);
					newStyles[newStyles.length-1]=styles[i];
					result.replace(key,newStyles); 
				}
			}
		}
		String style="";
		ArrayList<String> md = new ArrayList<String>();
		for(int i=0;i<styles.length;i++){
			if(styles[i].getMediaTypes()!=null && !md.contains(styles[i].getMediaTypes())){
				md.add(styles[i].getMediaTypes());
				String key=styles[i].getMediaTypes();
				
				style +="\n\n"+styles[i].getMediaTypes()+"{\n";
				for(int x = 0; x< result.get(key).length;x++){
				//	String cls ="\n     "+styles[x].toString().replace("\n", "\n      ");
					style+= "     "+result.get(key)[x].toString().replace("\n", "\n      ")+"\n";
				}
			style+="\n}\n";
			}
		}
		return style;
	}


	public void addStyle(String styleName, String valueNames[], Object[] values){
		styleCode.append("\n."+styleName+"{");
		for(int i=0;i<values.length;i++){
			if(values[i].getClass().getGenericSuperclass().equals(Number.class))
				styleCode.append("\n"+valueNames[i]+": "+String.valueOf(values[i])+"%;" );
			else
				styleCode.append("\n"+valueNames[i]+": "+String.valueOf(values[i])+";" );
		}
		styleCode.append("\n}\n");
	} 
	
	public String getCode(){
		return styleCode.toString();
	}
	
	  

	public void addStyle(DOMelement domElement) {
		
		if(ApplicationManager.INLINE_SYTLES) return;
		if(domElement.getStyle()!=null) 
			this.addStyle(domElement.getStyle());
		if(domElement.getEmbeddedElements()!=null){
			for(int i=0; i< domElement.getEmbeddedElements().length;i++){ 
			//	Style s = domElement.getEmbeddedElements()[i].getStyle();
				addStyle(domElement.getEmbeddedElements()[i]);
					
				 
			}
		}  
	}
	
	 

	public void addStyle(DOMelement[] elements) {
		for(int i=0; i< elements.length;i++){
			addStyle(elements[i]);
		}
	}
}

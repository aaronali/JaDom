package com.ali.jadom.dom;

import java.util.ArrayList;
import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.PreferredContructor;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.java.jalo.Logger;

@Tag("style")
public class Style extends DOMelement implements MetadataContent , FlowingContent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6467123086008103959L;
	public String name;
	public String[] valuesNames;
	public String[] values;
	
	protected boolean styleScript = false;

	public boolean isId=false;
	MediaTypesEnum[] mediaTypes=null;
	String mediaValue =null; 
	
	/**
	 * Creates an empty style with he given name. If the given name is 'style' then the style will be
	 *  created as a complete style script
	 * rather then an individual style.
	 * @param name
	 */
	@PreferredContructor
	public Style(String name){ 
		super(tag(Style.class),ApplicationManager.STRING_EMPTY,ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE);
		this.name=name;
		if(name.toLowerCase().equals(Style.class.getSimpleName().toLowerCase())){
			this.styleScript=true;
			this.name = tag(Style.class);
		}
	}
	
	
	public Style(String name, String[]valueNames, String[]values){ 
		super(tag(Style.class),"",ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE);
		this.valuesNames=valueNames;
		this.values = values;
		this.name = name;
	}
	
	public Style(String name, String[]valueNames, String[]values, MediaTypesEnum MediaTypes){ 
		super(tag(Style.class),"",ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE);
		this.valuesNames=valueNames;
		this.values = values;
		mediaTypes = new MediaTypesEnum[1];
		mediaTypes[0] = MediaTypes;
		this.name = name;
	}
	
	public Style(String name, String[]valueNames, String[]values, MediaTypesEnum[] mediaQueries,String mediaValues ){
		super(tag(Style.class),"",ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE);
		this.valuesNames=valueNames;
		this.values = values;
		mediaTypes = mediaQueries;
		mediaValue =mediaValues;
		this.name = name;
	} 
	
	/**
	 * Parses a style sting to create a css style rule. The string must be 
	 * in format {valuename:value;valuename2:value;} Braces are optional, semicolons and colons are not
	 * @param id
	 * @param styleString
	 */
	public Style(String id, String styleString) { 
		super(tag(Style.class),ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE,ApplicationManager.FORCE_NO_ATTRIBUTE);
		name=id;
		styleString = styleString.replace("{", "");
		styleString = styleString.replace("}", ""); 
		styleString = styleString.trim(); 
	 
		String[] temp = styleString.split(";");
		this.values = new String[temp.length];
		this.valuesNames = new String[temp.length]; 
		for(int i = 0 ; i< temp.length; i ++){ 
				String[] vals = temp[i].split(":");
				valuesNames[i] = vals[0];
				values[i] = vals[1]; 
		} 
		
	}
	
	public void setStyleFromStyleSheet(String styleString){ 
		styleString = styleString.replace("{", "");
		styleString = styleString.replace("}", ""); 
		styleString = styleString.trim(); 
	 
		String[] temp = styleString.split(";");
		this.values = new String[temp.length];
		this.valuesNames = new String[temp.length];
		
		for(int i = 0 ; i< temp.length; i ++){
			 
				String[] vals = temp[i].split(":");
				valuesNames[i] = vals[0];
				values[i] = vals[1]; 
		} 
		
	}
	
	
	/**
	 * Adds the given attributes to the style
	 * @param styleName
	 * @param stylevalue
	 */
	public void addNewStyle(String styleName, String stylevalue){
		if(styleScript){
			if(stylevalue.contains(":")){
				String[] val = new String[0];
				String[] vals = new String[0];
				stylevalue = stylevalue.replace("{","");
				Style s = new Style(styleName, val ,vals); 
				stylevalue = stylevalue.replace("}", "");
				String[] temp =  new String[0];
				temp =stylevalue.split(";");
				for(int i= 0; i < temp.length; i ++){
					temp[i] = temp[i].replace(";","");
					s.addNewStyle(temp[i].trim().split(":")[0].trim(), temp[i].trim().split(":")[1].trim());
				}
				if(s!=null)
					this.addDomElement(s);
					 
			} 
		}else{
			this.valuesNames = growStringArray(valuesNames);
			this.values = growStringArray(values);
			values[values.length-1] = stylevalue;
			valuesNames[valuesNames.length-1] = styleName;
		}
	}
	
	
	
	/**
	 * Adds a  the style string to the style where the string is in format "stylename:stylevalue".  If this is a <b>Style Script</b> the 
	 * format of the string should be 'name { stylename:stylevale; style;value}
	 * @param styleString
	 */
	public void addNewStyle(String styleString){
		if(styleString!=null && styleString!=ApplicationManager.FORCE_NO_ATTRIBUTE){
			if(!styleScript){
				String[] styls = styleString.replace("{", "").replace("}", "").trim().split(";");
				for(int i=0;i<styls.length;i++){
					addNewStyle(styls[i].split(":")[0],styls[i].split(":")[1].replace(";", "").concat(";"));
				}
			}
			else {
				Style style =new Style(styleString.split("{")[0].trim().replace("{",""),styleString.split("{")[1].trim().replace("{","").replace("}", "").trim());
				if(style!=null)
					this.addDomElement(new Style(styleString.split("{")[0].trim().replace("{",""),styleString.split("{")[1].trim().replace("{","").replace("}", "").trim()));
					 
			}
		}
	}

	public String getMediaTypes(){
		if(mediaTypes==null) return null;
		String style ="\n@media "; 
		for(int x= 0; x< mediaTypes.length ; x++){
			style+=" "+mediaTypes[x];
			if (x<mediaTypes.length-1)
				style+=",";
		}
		return style;
	}
	

	public void addStyle(Style style){
		if(style==null)return;
		if(styleScript)
			addDomElement(style);
			 
		else{
			this.valuesNames=style.valuesNames;
			this.values = style.values;
		} 
	}
	 
	
	@Override
	public String toString(){ 
		if(styleScript){
			 
			 if(nodevalue!=null && !nodevalue.replace('\n',' ').trim().isEmpty()){
				String style = " \n<"+tag(Style.class)+">\n" +this.nodevalue;//this.generateStyleSheet();
			/*	for(int i =0; i< this.getEmbeddedElements().length;i++){
					style =style.concat(((Style)this.getEmbeddedElements()[i]).toString()+"\n");
					
				}*/
				style =style.concat("</"+tag(Style.class)+">\n");
				 
			return style;
			 }
		}else{
		try{
			if(valuesNames!=null){
				String style = ((isId)?'#':'.')+name+"{\n";
				for(int i=0; i<valuesNames.length;i++){
					style+="   "+valuesNames[i]+" : " +values[i] +";\n";
				} 
			style+="}";
			return style;
			}
		} catch (java.lang.NullPointerException e){
			e.printStackTrace();
			Logger.info(nodevalue);
		  
		}
		}
		return nodevalue;
	}
	
	protected static Style[] growArray(Style[] array){
		if(array==null) array =new Style[0];
		Style[] temp = new Style[array.length];
		System.arraycopy(array, 0, temp, 0, array.length);
		array=new Style[temp.length+1];
		System.arraycopy(temp, 0, array, 0, temp.length);
		return array;
	}
	
	
	private String[] growStringArray(String[] array){
		if(array==null) array = new String[0];
		String[] temp = new String[array.length];
		System.arraycopy(array, 0, temp, 0, temp.length);
		array = new String[array.length+1];
		System.arraycopy(temp, 0, array, 0, temp.length);
		return array;
	}
	
	protected static Style[] shrinkStyleArray(Style[] array){
		Style[] temp = new Style[(array!=null)?array.length:0];
		System.arraycopy(array, 0, temp, 0, array.length);
		array=new Style[0];
		int placeHolder =0;
		for(int i =0; i < temp.length; i++){
			if(temp[i]!=null){
				array =growArray(array);
				array[placeHolder]=temp[i];
				placeHolder++;
			}
		} 
		return array;
	}
	
	public String generateStyleSheet(){
		if(!this.styleScript) return "";
		 Style[] styles = (Style[]) this.getEmbeddedElements();
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
		 this.nodevalue=code;
		 return  code+'\n';
	}
	
	public DOMelement generateStyles(){
		Style x =  new Style(""); 
		x.setNodevalue(this.generateStyleSheet());
		return x;
	}
	
	
	public String processMedia(Style[] styles){
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
}

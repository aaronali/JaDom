package com.ali.jadom.codebuilders;
 
import com.ali.jadom.dom.DOMelement;
import com.ali.java.jalo.Logger;

public class Html {

	StyleBuilder styleBuilder = new StyleBuilder();
	DOMelement[] elements = new DOMelement[0];
      
     
	
    /** enable boot strap on elements **/
	boolean bootstrap;
	/** StringBuilder for appending all the HTML elements **/
	StringBuilder htmlCode = new StringBuilder(); 
	/**
	 * Default constructor
	 * @param bootstrapas boolean
	 */
	public Html(boolean bootstrap){
		this.bootstrap = bootstrap;
	}
	
	/**
	 * Returns the html code from this instance
	 * @return htmlCode as String
	 */
	public String getCode(){
		return htmlCode.toString();
	}
	
	public void add(DOMelement element){
		Logger.info("Adding dom element to hrtml code\n"+element.toString());
		elements = DOMelement.growElementArray(elements);
		elements[elements.length-1] = element; 
	}
	  
	
	 
	
	/**
	 * Adds inline styles , id, class , and javascript to the current html
	 * @param lineSizePercent
	 * @param fontSizePx
	 * @param domClass
	 * @param id
	 * @param jsCallout
	
	private String  addInlineStyle(int lineSizePercent, int fontSizePx, String domClass, String id, String jsCallout){
		if(ApplicationManager.INLINE_SYTLES){
			 
			htmlCode.append(" style='");
			if(fontSizePx>0 || lineSizePercent>0){
			 htmlCode.append((lineSizePercent!=0) ? " line-height:"+ lineSizePercent +"%;" : ""); 
			}
			htmlCode.append((fontSizePx!=0) ? " font-size:"+ fontSizePx +"px;" : "");
			if(customStyleNames!=null){
				htmlCode.append(this.getCustomStyle(className));
			}
			htmlCode.append("'");
			htmlCode.append((domClass!=null) ? " class='"+ domClass +"'" : ""); 
			htmlCode.append((id!=null) ? " id='"+ id +"'" : ""); 
			htmlCode.append((jsCallout!=null) ? " "+ jsCallout : "");
		}else{
			String className =String.valueOf(id.charAt(0)).toUpperCase();
			className ="appParagraph"+ className + id.substring(1);
			String[] valueNames=
				{"font-size", "line-height"};
			this.generatedStyleSheet.addStyle(className, valueNames);
		}
	}
 */
 
 
 
	
	public String getHTML(){
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i < elements.length;i++){
			  sb.append(elements[i].toString());
		 }
		 return sb.toString();
	}
	 

	public DOMelement[] getElements() {
		return elements;
	}
	
}

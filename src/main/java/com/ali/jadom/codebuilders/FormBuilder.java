package com.ali.jadom.codebuilders;

public class FormBuilder {
 
	private boolean bootStrapEnabled = false;
	StringBuilder htmlCode = new StringBuilder();
	private boolean bootstrap = false;
	
	public FormBuilder(String id, String domClass,boolean bootstrap){
		if(id==null) id ="";
		if(domClass==null) domClass="";
		htmlCode.append("<form id='"+id+"'  class='"+domClass+"'  >");
		this.bootstrap = bootstrap;
		 
	}
	
	public void inlineTextInput( String label, int labelPercentWidth, int inputPercentWidth, String value, String id, String placeHolder, String groupClass, String inputClass ,String jsCallout){
		build(InputType.TEXT,  true,  label,true,  labelPercentWidth,  inputPercentWidth,  value,  id, placeHolder, groupClass,  inputClass , jsCallout) ;

	}
	public void inlineCheckBox( String label, int labelPercentWidth, int inputPercentWidth, String value, String id, String placeHolder, String groupClass, String inputClass ,String jsCallout){
		build(InputType.CHECKBOXGROUP,  true,  label,true,  labelPercentWidth,  inputPercentWidth,  value,  id, placeHolder, groupClass,  inputClass , jsCallout) ;

	}
	
	public void inlineCheckBoxGroup( String label, int labelPercentWidth, int inputPercentWidth, String[] values, String id, String placeHolder, String groupClass, String inputClass ,String jsCallout){
		for(String value:values)
			build(InputType.CHECKBOX,  true,  label,true,  labelPercentWidth,  inputPercentWidth,  value,  id,  placeHolder, groupClass,  inputClass , jsCallout) ;
		 
	}
	
	public void build(InputType type,boolean inline, String label, boolean labelInline,int labelPercentWidth, int inputPercentWidth, String value, String id, String placeHolder, String groupClass, String inputClass ,String jsCallout){

		if (value==null) value ="";
		if (inputClass==null) inputClass="";
		if (jsCallout==null) jsCallout="";
		if (groupClass==null) groupClass=""; 
		String lbWidth = String.valueOf(labelPercentWidth)+'%';
		String inWidth = String.valueOf(inputPercentWidth);
		if(bootstrap)
		{
			htmlCode.append("<div class=\"for-group "+groupClass+" " + (inline && (!type.equals(InputType.CHECKBOXGROUP)) ?   "inline": "") + " "+(inline &&(type.equals(InputType.CHECKBOXGROUP)) ?   "inline": "") + "\" "+ (inline && (type.equals(InputType.CHECKBOXGROUP)) ?   " style='width:\"auto\";'": "") +">\n");
		}	
		if(label!=null){
			htmlCode.append("<label " + ((bootstrap) ?   "for='"+id+"'"  : "")   +"  "+ ((labelInline) ?   String.format("class='block' style='min-width:%s;max-width:%s;' ",lbWidth ,lbWidth): "")+" >"+label);
			htmlCode.append("</label>\n");
			
		}
		htmlCode.append("<input type ='"+String.valueOf(type.toString().toLowerCase())+"' id='"+id+"' class= '" + ((bootstrap) ?   inputClass + "form-control  "  : "")+" "+ ((labelInline) ?  "inline'": "'")+"   "+((labelInline) ? "style='min-width:"+inWidth+"%;max-width:"+inWidth+"%;' " : "") + ((placeHolder!=null) ? " placeHolder ='" + placeHolder +"'" : "") + "/> \n");
		 
		htmlCode.append("</div>");
	}
	
	public void br(){
		htmlCode.append("</br>");
	}
	
	public String  getCode(){
		htmlCode.append("</form>");
		return htmlCode.toString();
	}
	
}

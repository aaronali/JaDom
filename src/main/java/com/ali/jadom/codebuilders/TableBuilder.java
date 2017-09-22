package com.ali.jadom.codebuilders;

import java.util.ArrayList;
import java.util.Enumeration;

public class TableBuilder {

	String[] tableHeaders;
	boolean bootstrap = false;
	StringBuilder stringBuilder = new StringBuilder();
	StyleBuilder styles = new StyleBuilder();
	public TableBuilder(TableType tableType, String[] tableHeders){
		if(tableType== TableType.jQuery_Responsive){
			stringBuilder.append("<!-- jQuery Responsove table -->\n<div class=\"appTable\">\n     <table data-role=\"table\" class=\"ui-responsive\">\n");
		}else	if(tableType== TableType.Bootstrap_Responsive){
			stringBuilder.append("<!-- bootsgrap Responsove table -->\n<div class=\"appTable table-responsive\">\n     <table class=\"table\">\n");
			}
		
		stringBuilder.append("          <tr>\n");
		for(int i =0; i< tableHeders.length; i++){
			stringBuilder.append("               <th><div id=\""+tableHeders[i]+i+"\"  class=\"appTableHeader\" >"+tableHeders[i]+"</div></th>\n");	
		}
		stringBuilder.append("          </tr>\n");
		this.tableHeaders=tableHeders;
	}
	
	public void addRow(Object[] rowData){
		Row row= new Row(rowData);
		stringBuilder.append(row.toString());
	}
	
	public String toString(){
		return this.stringBuilder.toString()+"     </table>\n</div><!--  end of application generated table -->\n";
	}
	
	public enum TableType{
		jQuery_Responsive,
		Bootstrap_Responsive
	}
	public class Row{
		public String rowDataString = new String("          <tr>\n");
		public Row(Object[] rowData){
			for(int i =0; i < rowData.length; i ++){
				rowDataString+="               <td>"+rowData[i].toString() +"</td>\n";
			}  
		}
		public String  toString(){
			return  "\n\n"+ rowDataString +"          </tr>\n\n\n";
		}
	} 
 
	
	
	
}

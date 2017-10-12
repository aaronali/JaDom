package com.ali.jadom.codebuilders;

import com.ali.jadom.dom.Br;
import com.ali.jadom.dom.Code;
import com.ali.jadom.dom.IDOMelement;
import com.ali.jadom.dom.Div;
import com.ali.jadom.dom.P; ;

public class JaDomParser {
 
	public static IDOMelement simpleParse(String domString){
		//throw new RuntimeException("Method not implmented");
		Div div = new Div();
		String[] returnString =   domString.split("\n");
		for(int i=0; i < returnString.length ; i++){
		    switch (returnString[i].replace("<", "").substring(0, returnString[i].indexOf('>'))){
		    	case "p":
		    		div.addDomElement(new P(returnString[i]));
		    		break;
		    	case "code":
		    		div.addDomElement(new Code(returnString[i]));
		    		break;
		    	default:
		    		div.addDomElement(new P(returnString[i]));
		    		break;
		    		
		    }
		    
			div.addDomElement(new Br());  
		}
		return div;
	}
	
}

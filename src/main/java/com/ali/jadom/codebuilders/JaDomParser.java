package com.ali.jadom.codebuilders;

import java.util.ArrayList;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.*;
import com.ali.jadom.dom.Object;
import com.ali.java.jaFile.FileReader; ;

public class JaDomParser {
 
	public  static void main(String...strings) {
		String s =FileReader.ReadFile("C:\\workspaces\\medchain\\JaDomSpringStarterSuite\\src\\main\\java\\documents\\jadom.html");
	//	System.out.println(s);
		simpleParse(s);
	}
	static DOMelement[] elements = {
			new A("","",false),new Abbr("",""),new Address(),new Area(), new Article(), new Aside(), new B(),
			new Base(), new Bdi(DirectionEnum.LTR), new Bdo(), new BlockQuote(), new Body(), new Br(), new Button(),
			new Caption(), new Code(), new Col(), new Colgroup(),   new Data("",""), new Dd(), new Del(),
			new Details(), new Dfn(), new Div(), new Dl(), new Document(), new Dt(), new Em(), new Embed(),
			new FigCaption(), new Figure(), new Footer(), new Form(), new H(1),new H(2), new H(3), new H(4), new H(5), new Head(), new Header(), new Hr(), new Html(), 
			new I(), new Iframe(), new Img(null,null,false), new Input(), new Ins(), new Kbd(null), new Label(), new Li(), new Link("","",false), new Main()
			, new Mark(),  new Menu(), new Meta(), new Nav(), new Object(), new Ol(), new P(), new Param("",""), new Picture(), new Pre(),
			new Q(), new Rb(),  new Rp(), new Rt(), new Rtc(), new Ruby(), new S(), new Samp(),
			new Script("",false), new Small(), new Source("",false,""), new Span(), new Strong(), new Style("stylr"), new Sub() , new Summary()
			, new Table(), new Sup(), new Time("",""), new Title(""), new Track(), new U(), new Ul(), new URL(""),
			new Var(), new Video(), new Wbr()
	};
	
	public static IDOMelement simpleParse(String domString){ 
		Div div = new Div();   
		String temp = "";
		ArrayList<DOMelement> found  = new ArrayList<DOMelement>();
		for(int index=0; index < domString.length() ; index++){
			temp=temp.concat(String.valueOf(domString.charAt(index))); 
			for(DOMelement element : elements){
				if (temp.endsWith(element.getBasicCloseTag())) { 
					DOMelement ee = element;
					ee.addAttribute("id",ApplicationManager.getNextId()); 
					String r = element.getBasicOpenTag();
					String inner =""; temp.split(r.replaceAll(">", ""))[1].substring(1);
					String[] tt = temp.split(ee.getBasicOpenTag().substring(0,ee.getBasicOpenTag().length()-2));
					 						 
						String gd =tt[tt.length-1].concat("<");
						inner =gd.substring(gd.indexOf(">")+1, gd.length()-1).replace(ee.getBasicCloseTag(), ""); 
					int siz = 0;int ne = 0;
					for(int ds=0;ds<tt.length-1;ds++) {
						siz = siz +tt[ds].length();
						ne =ne + tt[ds].length();
					}
					ne =ne+tt[tt.length-1].length()-1;
					temp=temp.substring(0, siz).concat(temp.substring(ne, temp.length()-1));
					System.out.println(temp);
					ee.innerHtml(inner.replace(ee.getBasicCloseTag(), ""));  
					System.out.println(ee.toString()); 
					found.add(ee); 
				}
			} 
		}
		return null;
	}
	
	public static IDOMelement simpleParse1(String domString){
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

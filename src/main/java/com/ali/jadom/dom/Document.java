package com.ali.jadom.dom;

import java.io.Serializable; 
import java.util.HashMap;

import com.ali.jadom.codebuilders.StyleBuilder; 

@Tag("!doctype")
public class Document extends DOMelement implements Serializable { 
	private static final long serialVersionUID = 1L;
	protected String doctype = "html";
	
	public Document() {
		super(tag(Document.class), "nullnodevalue", ApplicationManager.FORCE_NO_ATTRIBUTE, 
				ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE); 
		addAttribute("",doctype);
	} 
	
	public Document(String doctype) {
		super(tag(Document.class), "nullnodevalue", ApplicationManager.FORCE_NO_ATTRIBUTE, 
				ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE); 
		this.doctype =doctype;
		if(doctype!=null)
			addAttribute("",doctype);
	}  
	 
	 
	public Document(String doctype, HashMap<String, String> attributes) {
		super(tag(Document.class), "nullnodevalue", ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE); 
		if(attributes!=null)
			super.setAttributes(attributes);
		if(doctype!=null)
			addAttribute("",doctype);
	}

	public Document(Document document) {
		super(document);
		this.doctype= document.doctype;
		this.recurse= document.recurse; 
	}

	public void linkStyleSheet(String src){
		Link link = new Link(src, "text/css", true);
		link.setRel(RelType.STYLESHEET);
		this.getEmbeddedElements()[0].addDomElement(link); 
	}
	
	/**
	 * Adds a style sheet to the head element
	 * @param src
	 */
	public void addHeaderStyle(String src){ 
		this.getEmbeddedElements()[0].appendHTML("<"+tag(Style.class)+">"+src+"</"+tag(Style.class)+">");	
	}
	
	private String[] allowedDoms =  {com.ali.jadom.dom.Head.class.getName(), com.ali.jadom.dom.Body.class.getName()};
	@Override
	public boolean addDomElement(DOMelement element) {
		System.out.println(element.getClass().getName() +" " +super.isElementInList(allowedDoms, element));
		if(super.isElementInList(allowedDoms, element))  
			return super.addDomElement(element);
		else
			return false;
	}
	
	 
	/**
	 * Links a java script src file to the html
	 * @param src
	 */
	public void linkJavaScript(String src){
		Script link = new Script(src, true); 
		this.getEmbeddedElements()[0].addDomElement(link);
		 
		
	}
	
	/**
	 * 
	 * @param title
	 */
	public void changeTitle(String title){
		if(!this.contains(Head.class)){
			Head head=new Head();
			head.addTitle(title);
			this.addDomElement(head);
		}else{
			DOMelement ele =this.getEmbeddedElements()[0];
			if(ele!=null)
				if(ele.isOfType(Head.class)){
					if(ele.contains(Title.class)){
						for(int i=0;i<ele.getEmbeddedElements().length;i++){
							if(ele.getEmbeddedElements()[i].isOfType(Title.class)){
								ele.getEmbeddedElements()[i].nodevalue=title;
								return;
							}
						}
						(ele).addDomElement(new Title(title));
						return;
					}
				} 
		} 
	}
	
	public void addTitle(String title){
		changeTitle(title);
	}
	
	
	@Override
	public String toString(){ 
		String s = super.toString();
		if(ApplicationManager.INLINE_SYTLES || recurse){
			return s;  
		}   
		StyleBuilder styleBuilder = new StyleBuilder();
		styleBuilder.addStyle(this); 
		Style tempStyle=new Style(tag(Style.class));
		tempStyle.setNodevalue(styleBuilder.generateStyleSheet()); 
		 Document doc = new Document(this); 
		 if(doc.getEmbeddedElements()!=null)
			 doc.getEmbeddedElements()[0].addDomElement(tempStyle); 
	 	 if(tempStyle.getEmbeddedElements()!=null && tempStyle.getEmbeddedElements().length>0)
				doc.getEmbeddedElements()[0].addDomElement(tempStyle);
		 doc.recurse=true; 
		 return doc.toString().concat("\n</").concat(this.doctype).concat(">");
	}
	 private boolean recurse=false;


}

package com.ali.jadom.codebuilders;

import java.util.ArrayList;
import java.util.List;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.JadomConfig;
import com.ali.jadom.dom.Body;
import com.ali.jadom.dom.DOMclass;
import com.ali.jadom.dom.DOMelement;
import com.ali.jadom.dom.Document;
import com.ali.jadom.dom.H;
import com.ali.jadom.dom.Head; 
import com.ali.jadom.dom.Img;
import com.ali.jadom.dom.Link;
import com.ali.jadom.dom.P;
import com.ali.jadom.dom.Style;
import com.ali.jadom.dom.Title;

public class HtmlTemplate {
  
	protected String id = null;
	private JadomConfig config;
	private List<DOMelement> elements;
	private String title =  null; 
	
	private Head head = null;
	
	@Override
	public Object clone() {
		return  new HtmlTemplate(this);
	}
	
	/**
	 * Sets the title for the document 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title=title;
		head.addTitle(title);
	}

	protected HtmlTemplate(HtmlTemplate template) {
		this.config=template.config;
		this.elements=new  ArrayList<DOMelement>(template.elements);
		this.head =  this.createHead("");
		this.id=null;
	}
	
	/**
	 * Returns the element with the given id or returns null
	 * @param Id
	 * @return
	 */
	public DOMelement getElementById(String Id) {
		for(DOMelement element : elements) {
			if(element.Id().equals(id))
				return element;
		}
		return null;
	}
	
	/**
	 * Replaces the element with the same id or returns false if the element with the given id is not present
	 * @param element
	 * @return
	 */
	public boolean setElement(DOMelement element) {
		for(int index = 0 ; index< elements.size(); index++) {
			if(elements.get(index).Id().equals(element.Id())){
				elements.set(index, element);
				break;
			}
		}
		return elements.contains(element);
	}
	
	
	/**
	 * Replaces the element with the given id or returns false if the element with the given id is not present
	 * @param element
	 * @return
	 */
	public boolean setElement(String id, DOMelement element) {
		for(int index = 0 ; index< elements.size(); index++) {
			if(elements.get(index).Id().equals(id)){
				elements.set(index, element);
				break;
			}
		}
		return elements.contains(element);
	}
	
	/**
	 * Inserts the element before the element witht the destination element.id
	 * @param element
	 * @return
	 */
	public boolean insertBeforeElement(DOMelement destination, DOMelement element) {
		for(int index = 0 ; index< elements.size(); index++) {
			if(elements.get(index).Id().equals(destination.Id())){
				elements.add(index, element); 
				break;
			}
		}
		return elements.contains(element);
	}
	
	/**
	 * Inserts the element after the element with the destination element.id
	 * @param element
	 * @return
	 */
	public boolean insertAfterElement(DOMelement destination, DOMelement element) {
		for(int index = 0 ; index< elements.size(); index++) {
			if(elements.get(index).Id().equals(destination.Id())){
				elements.add(index+1, element); 
				break;
			}
		} 
		return elements.contains(element);
	}
	
	
	
	/**
	 * Creates a html template with the name as the title
	 * @param pageName
	 */
	public HtmlTemplate(String pageName) { 
		config = JadomConfig.getInstance();
		elements=  new ArrayList<DOMelement>();
		head = createHead(pageName); 
	}
	
	public String id() {
		if(id==null) 
			id = ApplicationManager.getNextId();
		return id;
	}
	
	/**
	 * Adds a stylesheet link to the head
	 * @param src
	 */
	public void addStlyeSheetLnk(String src) {
		Link link = Link.createStyleLink(src);
		head.addDomElement(link);
	}
	
	/**
	 * Creates a default head element with the given title
	 * @param title
	 * @return
	 */
	public 	Head createHead(String title) {
		Head head = new Head();
		Title t = new Title(title!=null?title:config.get(JadomConfig.title_default));
		head.addDomElement(t);
		return this.head!=null?this.head:head;
	}
	
	public void setHead(Head head) {
		this.head=head;
	}
	
	public void addDomElement(DOMelement element) {
		elements.add(element);
	}
	
	public DOMelement addHeader(int size, String text, DOMclass domclass) {
		 H h = new H(size,text,domclass);
		 this.elements.add(h);
		 return h;
	}
	public DOMelement addHeader(int size, String text, String domclass) {
		 H h = new H(size,text,new DOMclass(domclass));
		 this.elements.add(h);
		 return h;
	}
	
	public DOMelement addParagraph(String text, DOMclass domclass) {
		P p = new P(text,domclass);
		this.elements.add(p);
		return p;
	}
	
	
	public DOMelement addImage(String src, String alt,DOMclass domClass, boolean isExternal) { 
		Img img = new Img(src,alt, domClass, isExternal);
		this.elements.add(img); 
		 return img;
	}
	
	public DOMelement add(DOMelement element) {
		this.elements.add(element);
		return element;
	}
	
	public DOMelement addImage(String src, String alt,String classString, boolean isExternal) { 
		Img img = new Img(src,alt, new DOMclass(classString),isExternal);
		this.elements.add(img);
		return img;
	}
	
	public String toString() {
		Document document = new Document(ApplicationManager.HTML);
		document.addDomElement(head); 
		Body body = new Body();
		for(Style e :  styles) {
			head.addDomElement(e);
			
		}
		for(DOMelement e :  elements) {
			body.addDomElement(e);
			
		}
		document.addDomElement(body);
		return document.toString();
	}

	protected List<Style> styles = new ArrayList<Style>();
	public void addStyle(Style bodyStyle) { 
		this.styles.add(bodyStyle);
		
	}



}

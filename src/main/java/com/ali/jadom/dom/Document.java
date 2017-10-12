package com.ali.jadom.dom;

import java.io.Serializable; 
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap; 

import com.ali.jadom.annotations.Hidden;
import com.ali.jadom.codebuilders.StyleBuilder;
import com.ali.jadom.dom.superelements.DOMobject;
import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.MetadataContent;
import com.ali.jadom.dom.superelements.SectioningRoot;
import com.ali.jadom.exceptions.JaDomComplianceError;
import com.ali.java.jaFile.FileReader;
import com.ali.java.jalo.Logger; 

/**
 * DOM Document class
 * @author Aaron Ali
 *
 */
/**enum DocumentReadyState { "loading", "interactive", "complete" };
 
  // DOM tree accessors
  getter object (DOMString name); 
  NodeList getElementsByName(DOMString elementName);

  // dynamic markup insertion
  Document open(optional DOMString type = "text/html", optional DOMString replace = "");
  WindowProxy open(DOMString url, DOMString name, DOMString features, optional boolean replace = false);
  void close();
  void write(DOMString... text);
  void writeln(DOMString... text);

  // user interaction
  readonly attribute WindowProxy? defaultView;
  readonly attribute Element? activeElement;
  boolean hasFocus();
           attribute DOMString designMode;
  boolean execCommand(DOMString commandId, optional boolean showUI = false, optional DOMString value = "");
  boolean queryCommandEnabled(DOMString commandId);
  boolean queryCommandIndeterm(DOMString commandId);
  boolean queryCommandState(DOMString commandId);
  boolean queryCommandSupported(DOMString commandId);
  DOMString queryCommandValue(DOMString commandId);

  // special event handler IDL attributes that only apply to Document objects
  [LenientThis] attribute EventHandler onreadystatechange
  **/
@Tag("!doctype")
public class Document extends DOMelement implements Serializable { 
	
	@Hidden(true)
	private static final long serialVersionUID = 1L; 
	protected DocumentReadyStateEnum documentReadyState=DocumentReadyStateEnum.loading;
	protected ILocation location =null;
	protected String domain=null;
	protected String referrer=null;
	protected String cookie=null;
	protected String lastModified =null; 
	 // getter object (DOMString name);
	protected String title=null;
	protected String dir=null;
	protected DOMelement body=null;
    protected DOMelement head=null;
    protected Collection<DOMelement> images=null;
    protected Collection<DOMelement> embeds=null;
    protected Collection<DOMelement> plugins=null;
    protected Collection<DOMelement> links=null;
    protected Collection<DOMelement>  forms=null;
    protected Collection<DOMelement> scripts=null;
	protected String doctype = ApplicationManager.HTML;  
	protected String windowId= null; 
	@Hidden(true)
	protected FileReader fileReader = new FileReader();
	@Hidden(true)
	protected Script windowLoader = null;
	  
    //  NodeList getElementsByName(DOMString elementName);
    @Hidden(true)
    private boolean recurse=false;
    @Hidden(true)
    private String[] allowedDoms =  {com.ali.jadom.dom.Head.class.getSimpleName() ,com.ali.jadom.dom.Body.class.getSimpleName()};
	
 
    
	public Document() {
		super(tag(Document.class), "nullnodevalue", ApplicationManager.FORCE_NO_ATTRIBUTE, 
				ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE); 
		addAttribute("",doctype);
		windowLoader=Script.createScript(fileReader.readFile(ApplicationManager.PATH_JADOM_SCRIPTS.concat("/setWindows.js.jadom")));  
	} 
	
	public Document(String doctype) {
		super(tag(Document.class), "nullnodevalue", ApplicationManager.FORCE_NO_ATTRIBUTE, 
				ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE); 
		this.doctype =doctype;
		if(doctype!=null) {
			addAttribute("",doctype); 
			if("html".equals(doctype.toLowerCase().trim())){
				Html html = new Html();
				this.addDomElement(html);
			}
		}
		windowLoader=Script.createScript(fileReader.readFile(ApplicationManager.PATH_JADOM_SCRIPTS.concat("/setWindows.js.jadom")));  
	}  
	 
	 
	public Document(String doctype, HashMap<String, String> attributes) {
		super(tag(Document.class), ApplicationManager.NULL_NODE_VALUE, ApplicationManager.FORCE_NO_ATTRIBUTE,
				ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE, ApplicationManager.FORCE_NO_ATTRIBUTE); 
		if(attributes!=null)
			super.setAttributes(attributes);
		if(doctype!=null)
			addAttribute("",doctype);
		windowLoader=Script.createScript(fileReader.readFile(ApplicationManager.PATH_JADOM_SCRIPTS.concat("/setWindows.js.jadom")));  
	} 

	public Document(Document document) {
		super(document);
		this.doctype= document.doctype;
		this.recurse= document.recurse; 
		this.body=document.body;
		this.head=document.head; 
		windowLoader=Script.createScript(fileReader.readFile(ApplicationManager.PATH_JADOM_SCRIPTS.concat("/setWindows.js.jadom")));  
	}
	
    

	public void linkStyleSheet(String src){
		Link link = new Link(src, "text/css", true);
		link.setRel(RelTypeEnum.STYLESHEET);
		this.getEmbeddedElements()[0].addDomElement(link);  
		this.scripts.add(link); 
	}
	
/***
	 * Adds a style sheet to the head element
	 * @param src
	  
	public void addHeaderStyle(String src){ 
		this.getEmbeddedElements()[0].appendHTML("<"+tag(Style.class)+">"+src+"</"+tag(Style.class)+">");	
	}*/
	
	
	/**
	 * Adds a style sheet to the head element
	 * @param src
	 */
	public void addHeaderStyle(String src){ 
		if(this.getEmbeddedElements()==null)
			this.addDomElement(new Head());
		src =src.replace(ApplicationManager.STRING_NEWLINE, "").trim();
		src = src.replace("{","{\n" ).trim();
		src = src.replace(";}",";\n}\n").trim();
		src.replace("}", "}\n\n").trim();
		src=src.replaceAll(":", " : ").trim();
		while(src.contains("  ")) src= src.replaceAll("  ", " ");
		this.getEmbeddedElements()[0].appendHTML("<"+tag(Style.class)+">\n"+src+"\n</"+tag(Style.class)+">");	
	}
	 
	private void assignBody(DOMelement element){
		element.document=this;
		if(element.getEmbeddedElements()!=null)
			for(DOMelement ele: element.getEmbeddedElements()){
				ele.document=this;
				assignBody(ele);
			}
	}
	
	private void assignParent(DOMelement element){
		element.parent=this;
		if(element.getEmbeddedElements()!=null)
			for(DOMelement ele: element.getEmbeddedElements()){
				ele.parent=element;
				assignParent(ele);
			}
	}
		
		
	/**
	 * Adds a style sheet to the head element
	 * @param src
	 */
/*	public void addHeaderStyle(String src){ 
		if(this.getEmbeddedElements()==null)
			this.addDomElement(new Head());
		src =src.replace(ApplicationManager.STRING_NEWLINE, "");
		src = src.replace("{","{\n     " );
		src = src.replace(";}",";\n}\n" );
		src.replace("}", "} \n\n");
		
		this.getEmbeddedElements()[0].appendHTML("<"+tag(Style.class)+">\n"+src+"\n</"+tag(Style.class)+">");	
	}
	*/
	
	/**
	 * Adds a title tag to the page with thte given text
	 * @param title
	 */
	public void addTitle(String title){
		changeTitle(title);
	}
	/*
 	 @Override
	public boolean addDomElement(DOMelement element) {
		 if(ApplicationManager.FORCE_HTML_COMPLIANCE==true) {
			if(super.isElementInList(allowedDoms, element) &&  !this.contains(element.getClass())) { 
				boolean s =  super.addDomElement(element); 
				if(s==true) {
					if(element.getClass().equals(Body.class)) {
						this.body=element;
					}else if(element.getClass().equals(Head.class)){
						this.head=element;
					}
				}
				return s;
			}
			else
				throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName().concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override")));
		 }
		 else {
			return super.addDomElement(element);
		 }
	} */
 	 	@Override
		public boolean addDomElement(DOMelement element)  { 
			if(this.document==null)
				this.document= this; 
			element.document =this;
			assignBody(element);
			assignParent(element);
			if(ApplicationManager.FORCE_HTML_COMPLIANCE){
				if(element.isOfType(HeadingContent.class,MetadataContent.class)) {
					if(head==null) {
						head= new Head(); 
					}
					if(element.getClass().equals(Title.class)){
						head.removeDomElement(Title.class);
						head.addDomElement(element);
					}
					return this.getEmbeddedElements()[0].addDomElement(head);
				}
				if(element.isOfType(SectioningRoot.class)) {
					if(element.getClass().equals(Head.class)) {
						element.document=this;
						this.head=element;
						return this.getEmbeddedElements()[0].addDomElement(head);
					} 
					if(element.getClass().equals(Body.class)) {
						element.document=this;
						this.body=element;
						return this.setBody(body);
					}
				} 	 
				
				if( !element.isOfType(Head.class ) && !element.isOfType(Body.class) && !element.isOfType(Html.class)){
					throw new RuntimeException(new JaDomComplianceError(JaDomComplianceError.Error.CLASS_NOT_ALLOWED, this,element));
				}
			}
			if(element.isOfType(Head.class)&& this.contains(Head.class)){
				for(DOMelement ele:this.getEmbeddedElements()){
					if(ele.isOfType(Head.class)){
						ele = element;
						return true;
					}
				}
				
			}else if(element.isOfType(Body.class)&& this.contains(Body.class)){
				for(DOMelement ele:this.getEmbeddedElements()){
					if(ele.isOfType(Body.class)){
						ele = element;
						return true;
					}
				}
			}  
			if(this.contains(Body.class) && element.isOfType(Head.class)){
					Body temp = (Body) this.getEmbeddedElements()[0];
					this.removeDomElement(Body.class);
					this.addDomElement(element);
					this.addDomElement(temp);
				}
			return super.addDomElement(element); 
		} 
	 
	/**
	 * Links a java script src file to the html
	 * @param src
	 */
	public void linkJavaScript(String src){
		Script link = new Script(src, true); 
		this.getEmbeddedElements()[0].addDomElement(link);
		this.scripts.add(link);	
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
	
	 
	
	@Override
	public void addAttribute(String name,String value) {
		if(!ApplicationManager.FORCE_HTML_COMPLIANCE)
			super.addAttribute(name, value); 
	}
	@Override
	public void addAttribute(String name, Number value) {
		if(!ApplicationManager.FORCE_HTML_COMPLIANCE)
			super.addAttribute(name, value);  
	}
	@Override
	public void addAttribute(String name, boolean value) {
		if(!ApplicationManager.FORCE_HTML_COMPLIANCE)
			super.addAttribute(name, value);  
	}
	
	
	@Override
	public String toString(){ 
		/*String s = super.toString();
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
		 return doc.toString().concat("\n</").concat(this.doctype).concat(">");*/ 
		this.nodename = tag.concat(ApplicationManager.STRING_SPACE).concat(this.doctype);
		String s = super.toString(); 
		this.nodename = tag;
		if(ApplicationManager.INLINE_SYTLES || recurse){
			return s;  
		}   
		StyleBuilder styleBuilder = new StyleBuilder();
		styleBuilder.addStyle(this); 
		Style tempStyle=new Style(tag(Style.class));
		tempStyle.setNodevalue(styleBuilder.generateStyleSheet()); 
		 Document doc = new Document(this); 
		 if(doc.getEmbeddedElements()!= null && doc.getEmbeddedElements()[0].getEmbeddedElements()!=null){
			 doc.getEmbeddedElements()[0].getEmbeddedElements()[0].addDomElement(tempStyle); 
			 doc.getEmbeddedElements()[0].getEmbeddedElements()[0].addDomElement(windowLoader);
		 }
	 	 if(tempStyle.getEmbeddedElements()!=null && tempStyle.getEmbeddedElements().length>0){
				doc.getEmbeddedElements()[0].addDomElement(tempStyle); 
				 doc.getEmbeddedElements()[0].addDomElement(windowLoader);
	 	 }
	 	 if(this.getEmbeddedElements()!=null && this.getEmbeddedElements().length>0) {
		 	 for(int i=0; i<this.getEmbeddedElements().length;i++){
		 		 if(this.getEmbeddedElements()[i].isOfType(Script.class)){
		 			 doc.getEmbeddedElements()[0].addDomElement(this.getEmbeddedElements()[i]);
		 		 }
		 	 }
	 	 }
		 doc.recurse=true; 
		 return doc.toString();//.concat("\n</").concat(this.doctype).concat(">");

	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public DocumentReadyStateEnum getDocumentReadyState() {
		return documentReadyState;
	}

	public void setDocumentReadyState(DocumentReadyStateEnum documentReadyState) {
		this.documentReadyState = documentReadyState;
	}

	public ILocation getLocation() {
		return location;
	}

	public void setLocation(ILocation location) {
		this.location = location;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		Title t= new Title(title);
		if(this.head  ==null){
			this.head= new Head(); 
		} 
		this.head.addDomElement(t);
		this.getEmbeddedElements()[0].addDomElement(head); 
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public DOMelement getBody() {
		return body;
	}

	public boolean setBody(DOMelement body) {
		this.body = body;
		if(this.getEmbeddedElements()!=null) {
			if(this.getEmbeddedElements()[0].contains(Body.class)) {
				this.removeDomElement(Body.class);  
			}
			return this.getEmbeddedElements()[0].addDomElement(body);
		}else {
			this.addDomElement(new Head());
			return this.getEmbeddedElements()[0].addDomElement(body);
		}
		
	}

	public DOMelement getHead() {
		return head;
	}

	public void setHead(DOMelement head) {
		this.head = head;
	}

	public Collection<DOMelement> getImages() {
		return images;
	}

	public void setImages(Collection<DOMelement> images) {
		this.images = images;
	}

	public Collection<DOMelement> getEmbeds() {
		return embeds;
	}

	public void setEmbeds(Collection<DOMelement> embeds) {
		this.embeds = embeds;
	}

	public Collection<DOMelement> getPlugins() {
		return plugins;
	}

	public void setPlugins(Collection<DOMelement> plugins) {
		this.plugins = plugins;
	}

	public Collection<DOMelement> getInks() {
		return links;
	}

	public void setInks(Collection<DOMelement> inks) {
		this.links = inks;
	}

	public Collection<DOMelement> getForms() {
		return forms;
	}

	public void setForms(Collection<DOMelement> forms) {
		this.forms = forms;
	}

	public Collection<DOMelement> getScripts() {
		return scripts;
	}

	public void setScripts(Collection<DOMelement> scripts) {
		this.scripts = scripts;
	}

	public boolean isRecurse() {
		return recurse;
	}

	public void setRecurse(boolean recurse) {
		this.recurse = recurse;
	}

	public String[] getAllowedDoms() {
		return allowedDoms;
	}

	public void setAllowedDoms(String[] allowedDoms) {
		this.allowedDoms = allowedDoms;
	}
	
	
	 


}

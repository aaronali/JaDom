package com.ali.jadom.dom;
  
 
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.ali.jadom.javascript.EventTarget;
import com.ali.jadom.javascript.EventType;
import com.ali.jadom.javascript.KeyBoardEventObject;
import com.ali.jadom.javascript.MediaEvent;
import com.ali.jadom.javascript.MouseEventObject;
import com.ali.jadom.javascript.UiEvent;
import com.ali.jadom.javascript.XMLHttpRequest;
import com.ali.java.jaFile.FileReader;
import com.ali.java.jalo.Logger;
import com.ali.jadom.javascript.DomEventInterface.EventPhase;
import com.ali.jadom.dom.superelements.DOMobject;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.GlobalEventHandlers;
import com.ali.jadom.dom.superelements.SectioningRoot;
import com.ali.jadom.exceptions.JaDomComplianceError;
import com.ali.jadom.ApplicationManager;
import com.ali.jadom.JadomConfig;
import com.ali.jadom.annotations.Hidden;
import com.ali.jadom.codebuilders.StyleBuilder;
import com.ali.jadom.javascript.DomEventAbstract;
import com.ali.jadom.javascript.DomEventException; 
import com.ali.jadom.javascript.EventListener;  
import com.ali.jadom.javascript.DomFunction; 

@SuppressWarnings("serial")
public abstract class DOMelement extends   java.lang.Object  implements   GlobalEventHandlers, EventTarget, IDOMelement ,  java.io.Serializable{ 
 
	protected Style style=null; 
	protected DOMelement[] embeddedElements;
	protected String tag=null; 
	protected String nodename;
	protected String nodevalue;
	protected boolean draggable;
	protected boolean hidden;
	protected long tabIndex; 
	protected String accessKey;  
	protected boolean spellcheck;
	protected String contextmenu;	
	protected DOMelement document;
	protected DOMelement parent;

	protected HashMap<String, String> attributes =null;
	protected HashMap<String, DOMobject> properties =null;
	private EventListener[] eventListerners = null;

	protected boolean bootstrap = false;
	
	
	private static String DOMERR000010 = "DOMERR000010 : Warning, no id detected on %s "; 
	
	/**
	 * Creates a DOMelement where param is the name of the node
	 * @param nodeName
	 */
	public DOMelement(String nodeName){
		super(); 
		nodename = nodeName;
		this.nodevalue = "";
		this.tag = nodename; 
		addAttribute(ApplicationManager.STRING_ID.toLowerCase(),   tag+ApplicationManager.getNextId()); 
		detecteBootstap(); 
	}
	
	/**
	 * Creates a domElement with the node name and the the given value
	 * @param nodeName
	 * @param nodeValue
	 */
	public DOMelement(String nodeName, String nodeValue){
		super(); 
		nodename = nodeName;
		this.nodevalue = nodeValue;
		this.tag = nodename;
		addAttribute(ApplicationManager.STRING_ID.toLowerCase(),   tag+ApplicationManager.getNextId());
		detecteBootstap(); 
	}
	
	/**
	 * Creeates a domElement with the given parameters
	 * @param nodeName
	 * @param nodeValue
	 * @param attributes
	 */
	public DOMelement(String nodeName , String nodeValue,HashMap<String,String> attributes){
		super(); 
		nodename = nodeName;
		this.attributes = attributes;
		this.nodevalue = nodeValue;
		this.tag = nodeName;
		if(!attributes.containsKey(ApplicationManager.STRING_ID.toLowerCase()))
			addAttribute(ApplicationManager.STRING_ID.toLowerCase(),   tag+ApplicationManager.getNextId());
		detecteBootstap(); 
		}
	
	/**
	 * Creates a dom element with the given parameters
	 * @param nodeName
	 * @param nodeValue
	 * @param id
	 * @param domClass
	 * @param styles
	 * @param jsCallout
	 */
	public DOMelement(String nodeName, String nodeValue, String id, String domClass, String styles, String jsCallout){
		super();
		this.nodename = nodeName;
		this.nodevalue = nodeValue;
		this.tag=nodeName;
		attributes = new HashMap<String,String>();
		addAttribute(ApplicationManager.STRING_ID.toLowerCase(), (id!=null)?id : tag+ApplicationManager.getNextId());
		if(domClass!=null)
			addAttribute("domClass", domClass);
		if(getClass()!=Style.class && styles!=ApplicationManager.NULL_NODE_VALUE)
			addAttribute("style", styles);
		if(styles!=null && getClass()!=Style.class && this.getClass()!=Document.class &&styles!=ApplicationManager.NULL_NODE_VALUE){ 
			this.style =new Style(id, styles);
			 
		}
		addAttribute("jsCallout", jsCallout); 
		detecteBootstap(); 
	} 
	
	/**
	 * Creates a domEleemnt with the characteristics of the source domElement
	 * @param element
	 */
	public DOMelement(DOMelement element) { 
		this.style = element.style;
		this.embeddedElements = element.embeddedElements;
		this.tag = element.tag;
		this.nodename = element.nodename;
		this.nodevalue = element.nodevalue;
		this.draggable =element.draggable;
		this.hidden = element.hidden;
		this.tabIndex = element.tabIndex;
		this.accessKey = element.accessKey;    
		this.spellcheck = element.spellcheck;
		this.contextmenu = element.contextmenu;
		this.attributes = element.attributes;
		if(element.sb!=null)
		{
			this.sb =new StyleBuilder(sb);

		}

		detecteBootstap(); 
	}

	/**
	 * Creates a domEleemt with the given node name and the child domELement
	 * @param nodeName
	 * @param element
	 */
	public DOMelement(String nodeName, DOMelement element) {
		super();
		nodename = nodeName;
		this.nodevalue = "";
		this.tag = nodename; 
		this.addDomElement(element);
		addAttribute(ApplicationManager.STRING_ID.toLowerCase(),   tag+ApplicationManager.getNextId());
	}

	public DOMelement(String nodeName, String innerHTML, DOMclass domClass) {
		super();
		nodename = nodeName;
		this.nodevalue = innerHTML;
		this.tag = nodename;  
		addAttribute(ApplicationManager.STRING_ID.toLowerCase(),   tag+ApplicationManager.getNextId());
		addAttribute(DOMclass.class.getSimpleName().toLowerCase(), domClass.Name());
		detecteBootstap(); 
	}

	public synchronized final String getNodename() {
		return nodename;
	}

	public synchronized final void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public synchronized final String getNodevalue() {
		return nodevalue;
	}

	public synchronized final void setNodevalue(String nodevalue) {
		this.nodevalue = nodevalue;
	}

	public synchronized final HashMap<String, String> getAttributes() {
		return attributes;
	}

	public synchronized final void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	
	
	/**
	 * Returns this elements style
	 * @see com.ali.jadom.dom.Style
	 * @return
	 */
	public synchronized final Style getStyle() {
		return style;
	}
	
	
	Style[] styles=new Style[0];
	/**
	 * Gets all the styles from this domElement and all child elements
	 * Depreciated user the StyleBuilder class to get and auto generate style sheets
	 * @return
	 */
	@Deprecated
	public final Style[] getStyles(){
		Style[] styles=new Style[0];
		if(this.style!=null)
		{ 
			 styles =  Style.growArray(styles);
			 styles[0] = this.style; 
		}
		if(this.embeddedElements!=null)
			for(int i=0;i<this.embeddedElements.length;i++){
				if(this.embeddedElements[i].getStyle()!=null){
					styles = Style.growArray(styles);
					styles[styles.length-1] = embeddedElements[i].getStyle();
					if(embeddedElements[i]!=null){
						Style[] embeddedStyles = new Style[0];
						if( embeddedElements[i].getStyles().length>0){
						  embeddedStyles = embeddedElements[i].getStyles();
						}
						 
						while(embeddedStyles.length>0){ 
							styles = Style.growArray(styles);
							styles[styles.length-1] = embeddedStyles[0];
							embeddedStyles[0] =null;
							embeddedStyles = Style.shrinkStyleArray(embeddedStyles);
						}
					
					} 
				}
			}
		return styles;
	}

	public final void setStyle(Style style) { 
		this.style = style;
	}

	public String tag(){
		return tag;
	}
	 

	/**
	 * Returns the current DomElement as an HTML5 string.
	 */
	@Override
/*	public String toString(){ 
		String s =  "<"+nodename;
		if(attributes!=null){
			if(!attributes.containsKey("id")){
				addAttribute("id", ApplicationManager.getNextId());
			}
			String domclass =null;
			if(attributes.containsKey("domClass")){
				domclass = attributes.get("domClass");
				if(!domclass.contains(attributes.get("id")))
					domclass+=" "+attributes.get("id");
				//addAttribute("class", domclass);
			}else{
				//addAttribute("class", attributes.get("id"));
				domclass =attributes.get("id");
			} 
			java.lang.Object[] keys =   attributes.keySet().toArray();
			Arrays.sort(keys);
			for(java.lang.Object key:keys){
				if(attributes.get(key)!=null && !attributes.get(key).equals(ApplicationManager.FORCE_NO_ATTRIBUTE)){
					if(key.toString().toLowerCase().equals("jscallout")){
						s+=" "+attributes.get(key);
					}else 	if(key.toString().equals("style")){
						if(!ApplicationManager.INLINE_SYTLES  && attributes.get("id")!=null && attributes.get("style")!=null){
							this.style =new Style(attributes.get("id"),attributes.get("style")); 
						}else{
							s+=" "+key+"=\""+attributes.get(key)+"\"";
						} 
					} else if(key.equals("")){
						s+=" "+attributes.get(key);
					}
					else{  
						if(key.toString().equals("domClass"))
							s+=" class=\"".concat(domclass.trim().replace("  ", " ")).concat("\"");
						else
							s+=" ".concat(key.toString().trim()).concat("=\""+attributes.get(key).trim().replace("  ", " ")+"\"");
					} 
				} 
			}
		}
	//	 s= s+">\n"+((nodevalue.startsWith("nullnodevalue"))? nodevalue.replace("nullnodevalue", "") : nodevalue + "\n</"+nodename+"> " ); 
		s= s+">\n"+((nodevalue.trim().startsWith(ApplicationManager.NULL_NODE_VALUE.toLowerCase()))? nodevalue.replace("nullnodevalue", "")  : ((nodevalue.endsWith("\n"))? nodevalue:nodevalue + "\n")+"</"+nodename+"> " ); 
		
		if(this.eventListerners!=null && this.eventListerners.length>0){
			s=s.concat("\n<script>");
			for(int i=0;i<eventListerners.length;i++){
				s =s.concat("\ndocument.getElementById(\"").concat(this.getAttributes().get("id")).concat("\")").concat(eventListerners[i].toString());
			}
			s=s.concat("\n</script>");
		} 
		int count=0;
		String temp ="";  
		if(!this.getClass().getSimpleName().equals("Style")){
			for(int i = 0; i < s.length();i++){ 
				temp+=s.charAt(i);
				String added=null;
				if(temp.endsWith("%s")){
					temp =temp.replace("%", "%%");
					temp = temp.replace("%%s", "%s"); 
					if(count<embeddedElements.length){
						DOMelement ele =embeddedElements[count]; 
						try{ 
							added = ele.toString() ;
							temp =String.format(temp+" ",  added+" ");
							count++;
						}catch (Exception e){
								e.printStackTrace();
						} 
					}else{
					//	System.out.print(this.getClass().getCanonicalName());
						try{
							DOMelement ele =embeddedElements[count]; 
							added = ele.toString() ;
							temp =String.format(temp+" ",  added+" ");
							count++;
						}catch (Exception e){
							e.printStackTrace();
					} 
					}
				}
			}
		}else{
			if(((Style)this).styleScript){
				for(int i=0;i<this.getEmbeddedElements().length;i++)
					temp.concat(" \n " + this.embeddedElements[i].toString());
				return "<style>\n ".concat(temp).concat(" \n </style>");
			}
		} 
		temp.trim(); 
		return temp; 
	}
*/public String toString(){  
		if(nodevalue==null)
				Logger.warning("node value is null");
		String tempnv = "  ".concat(nodevalue==null?"":nodevalue);
		tempnv =tempnv.replace(ApplicationManager.STRING_NEWLINE, "\n  ");
		String s =  "\n<"+nodename;
		if(attributes!=null){
			if(!attributes.containsKey("id")){
				if(!this.isOfType(SectioningRoot.class))
						addAttribute("id", ApplicationManager.getNextId());
			}
			String domclass =null;
			if(attributes.containsKey(ApplicationManager.STRING_DOMCLASS.toLowerCase()) ||attributes.containsKey(ApplicationManager.STRING_DOMCLASS )){
				domclass = attributes.get(ApplicationManager.STRING_DOMCLASS.toLowerCase());
				if(domclass==null) domclass = attributes.get(ApplicationManager.STRING_DOMCLASS);
				if(!domclass.contains(attributes.get("id"))&& !attributes.get("id").contains(ApplicationManager.FORCE_NO_ATTRIBUTE)) 
					domclass+=" "+attributes.get("id");
				//addAttribute("class", domclass);
			}else{
				//addAttribute("class", attributes.get("id"));
				domclass =attributes.get("id");
			} 
			java.lang.Object[] keys =   attributes.keySet().toArray();
			Arrays.sort(keys);
			for(java.lang.Object key:keys){
				if(attributes.get(key)!=null && !ApplicationManager.NULL_NODE_VALUE.equals(attributes.get(key))){
					if(attributes.get(key)!=null && !attributes.get(key).contains(ApplicationManager.FORCE_NO_ATTRIBUTE)){
						if(key.toString().toLowerCase().equals("jscallout")){
							s+=" "+attributes.get(key);
						}else 	if(key.toString().equals("style")){
							if(!ApplicationManager.INLINE_SYTLES  && attributes.get("id")!=null && attributes.get("style")!=null){
								this.style =new Style(attributes.get("id"),attributes.get("style")); 
							}else{
								s+=" "+key+"=\""+attributes.get(key)+"\"";
							} 
						} else if(key.equals("")){
							s+=" "+attributes.get(key);
						}
						else{  
							if(key.toString().toLowerCase().equals(ApplicationManager.STRING_DOMCLASS.toLowerCase()) )
								s+=" class=\"".concat(domclass.trim().replace("  ", " ")).concat("\"");
							else
								s+=" ".concat(key.toString().trim()).concat("=\""+attributes.get(key).trim().replace("  ", " ")+"\"");
						} 
					} 
				}
			}
		}
	//	 s= s+">\n"+((nodevalue.startsWith("nullnodevalue"))? nodevalue.replace("nullnodevalue", "") : nodevalue + "\n</"+nodename+"> " ); 
	//	s= s+">\n"+((nodevalue.trim().startsWith(ApplicationManager.NULL_NODE_VALUE.toLowerCase()))? nodevalue.replace("nullnodevalue", "")  : ((nodevalue.trim().endsWith(ApplicationManager.STRING_NEWLINE))? nodevalue:nodevalue.concat(ApplicationManager.STRING_NEWLINE))+"</"+nodename+"> " ); 
	//	s= s+">\n"+((nodevalue.trim().startsWith(ApplicationManager.NULL_NODE_VALUE.toLowerCase()))? nodevalue.replace("nullnodevalue", "")  : ((nodevalue.trim().endsWith(ApplicationManager.STRING_NEWLINE))? nodevalue.replace(ApplicationManager.STRING_NEWLINE, "\n     "):nodevalue.replace(ApplicationManager.STRING_NEWLINE, "\n     ").concat(ApplicationManager.STRING_NEWLINE))+"</"+nodename+"> " ); 
 		s= s+">\n"+((nodevalue.trim().startsWith(ApplicationManager.NULL_NODE_VALUE.toLowerCase()))? nodevalue.replace("nullnodevalue", "")  : ((nodevalue.trim().endsWith(ApplicationManager.STRING_NEWLINE))? tempnv:tempnv.concat(ApplicationManager.STRING_NEWLINE))+"</"+nodename+"> " ); 
			
		if(this.getEventListerners()!=null && this.getEventListerners().length>0){
			s=s.concat("\n<script>");
			for(int i=0;i<getEventListerners().length;i++){
				s =s.concat("\ndocument.getElementById(\"").concat(this.getAttributes().get("id")).concat("\")").concat(getEventListerners()[i].toString());
			}
			s=s.concat("\n</script>");
		} 
		int count=0;
		String temp ="";  
		if(!this.getClass().getSimpleName().equals(Style.class.getSimpleName())){ 
		  	if(this.getClass()==Body.class)
		  		Logger.warning(this,"test" , this.getClass().getName());
			for(int i = 0; i < s.length();i++){ 
				temp+=s.charAt(i);
				String added=null;
				if(temp.endsWith("%s")){
					temp =temp.replace("%", "%%");
					temp = temp.replace("%%s", "%s"); 
					if(count<embeddedElements.length){
						DOMelement ele =embeddedElements[count];  
						try{ 
							added = ele.toString() ;
							temp =String.format(temp+" ",  added+" ");
							count++;
						}catch (Exception e){
								e.printStackTrace();
						} 
					}else{ 
						try{
							DOMelement ele =embeddedElements[count]; 
							added = ele.toString() ;
							temp =String.format(temp+" ",  added+" ");
							count++;
						}catch (Exception e){
							e.printStackTrace();
					} 
					}
				}
			}
		}else{
			if(((Style)this).styleScript){
				Logger.log("Style Found");
				for(int i=0;i<this.getEmbeddedElements().length;i++) {
					temp.concat(" \n " + this.embeddedElements[i].toString());
					Logger.log(temp);
				}
				temp = temp.replaceAll(":", " : ");
				while(temp.contains("  ")) temp = temp.replaceAll("  ", " ");
				return "<style>\n ".concat(temp).concat(" \n </style>");
			}
		} 
		temp.trim().concat("\n"); 
		return temp; 
	}	
	public void setHTML(String html){
		this.nodevalue = html;
	}
	public void appendHTML(String html){
		this.nodevalue+= html;
	}
	public void concatHTML(String html){
		this.nodevalue = html +nodevalue;
	}
	
	
	public void setDraggable(boolean draggable){
		this.draggable =draggable;
		if(draggable)
			addAttribute("draggable", "true");
		else
			removeAttribute("draggable");
	}
	
	
	
	
	public final DOMelement[] getEmbeddedElements() {
		return embeddedElements;
	}

	public final void setEmbeddedElements(DOMelement[] embeddedElements) {
		this.embeddedElements = embeddedElements;
	}

	public final boolean isHidden() {
		return hidden;
	}

	public final void setHidden(boolean hidden) {
		this.hidden = hidden;
		if(hidden)
			addAttribute("hidden", true);
		else
			removeAttribute("hidden");
	}

	public final long getTabIndex() {
		return tabIndex; 
	}

	public final void setTabIndex(long tabIndex) {
		this.tabIndex = tabIndex;
		if(tabIndex<0)
			removeAttribute("tabIndex");
		else
			addAttribute("tabIndex", tabIndex);
	}

	public final String getAccessKey() {
		return accessKey;
	}

	public final void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		if(accessKey!=null)
			addAttribute("accessKey", accessKey);
		else
			removeAttribute("accessKey");
	}

	public final boolean isSpellcheck() {
		return spellcheck;
	}

	public final void setSpellcheck(boolean spellcheck) {
		this.spellcheck = spellcheck;
		if(spellcheck)
			addAttribute("spellcheck", "true");
		else
			removeAttribute("spellcheck");
	}

	public final String getContextmenu() {
		return contextmenu;
	}

	public final void setContextmenu(String contextmenu) {
		this.contextmenu = contextmenu;
		if(contextmenu!=null)
			addAttribute("contextMenu",contextmenu);
		else removeAttribute("contextMenu");
	}

	public final boolean isDraggable() {
		return draggable;
	}

	public Document getDocument(){
		return (Document) this.document;
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean addDomElement(DOMelement element) {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&element.isOfType(Title.class)&& (element.contains(Title.class) || !this.isOfType(Head.class)))
			throw new RuntimeException(element.getClass().getCanonicalName().concat(" can only occur once in the document Head.\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to override"));
		
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && element.contains(FlowingContent.class))
			throw new RuntimeException(element.getClass().getCanonicalName().concat(" must be placed before any FLow Content.\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to override"));
		
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && element.isOfType(Main.class)&& this.contains(Main.class))
			throw new RuntimeException("Only one main class is allowed in the docuemnt.\nSet ApplicationManager.FORCE_HTML_COMPLIANCE to override");
		if(embeddedElements==null)
			this.embeddedElements = new DOMelement[0];
		for(DOMelement ele: this.embeddedElements){
			if (ele==element) return false;
		}
		embeddedElements =DOMelement.growElementArray(this.embeddedElements);
		element.parent = this;
		element.document =this.document;
		embeddedElements[embeddedElements.length-1] = element;
		this.nodevalue+="%s";
		return true;
	}
	
	 
	
	public boolean isOfType(Class<?> cclass){
		if(this.getClass().equals(cclass))
			return true;
		for(Class<?> cls : this.getClass().getInterfaces()){
			if(cclass.equals(cls))
				return true;
		}
		return false;
	}
	
	public boolean isOfType(Class<?> Class1, Class<?> Class2){
		for(Class<?> cls : this.getClass().getInterfaces()){
			if(cls==Class1||cls==Class2)
				return true;
		}
		return false;
	}
	
	public boolean isOfType(Class<?> Class1, Class<?> Class2, Class<?> Class3){
		for(Class<?> cls : this.getClass().getInterfaces()){
			if(cls==Class1||cls==Class2||cls==Class3)
				return true;
		}
		return false;
	}
	public boolean isOfType(Class<?> Class1, Class<?> Class2,Class<?> Class3, Class<?> Class4){
		for(Class<?> cls : this.getClass().getInterfaces()){
			if(cls==Class1||cls==Class2||cls==Class3||cls==Class4)
				return true;
		}
		return false;
	}
	/**
	 * Returns the dom elements given id. If the element does not hav an id, one will be created and stored for thiis element
	 * @return String 
	 */
	public String Id(){
		if(getAttribute("id")==null)
			addAttribute("id", ApplicationManager.getNextId());
		return getAttribute("id");
	}
	
	public String getAttribute(String attributeName){
		return attributes.get(attributeName);
	}
	/**
	 * Returns true if the element name appears in the list
	 * @param classNameList
	 * @param element
	 * @return boolean
	 */
	protected boolean isElementInList(String[] classNameList, DOMelement domElemen){
		for(String s:classNameList){ 
			if(s.trim().equals(domElemen.getClass().getCanonicalName().trim())) { 
				return true;
			}
		}
		return false; 
	}
	
	/**
	 * Adds the element styles to the style sheet
	 * @param builder
	 */
	public void addToSyleSheet(StyleBuilder builder){
		builder.addStyle(this);
	}
	
	/**
	 * Adds an attribute role with the given role
	 * @param role
	 */
	public void addAttribute(Role role) {
		this.addAttribute(ApplicationManager.STRING_ROLE,role.name());
	}
	/**
	 * Adds or over rights and attribute for the element
	 * @param name
	 * @param value
	 */
	public void addAttribute(String name, String value){
		if(this.attributes==null)
			this.attributes=new HashMap<String,String>();
		if(name.equals("style")){
			if(attributes.get(name)!=null){
				String s = attributes.get(name);
				if(!value.trim().endsWith(";")) value =  value.concat(";");
				attributes.put(name, value.concat("" ).concat(s));
//				if(this.style==null){
//					if(this.getAttributes().get("domClass")==null)
//						this.addAttribute("domClass", this.getAttributes().get("id"));
//					this.style = new Style(this.getAttributes().get("domClass")); 
 				}
				//if(name.equals(tag(Style.class))){
					if(this.style==null){
						if(this.getAttributes().get(DOMclass.class.getSimpleName().toLowerCase())==null)
							this.addAttribute(DOMclass.class.getSimpleName().toLowerCase(), this.getAttributes().get("id"));
						 this.style = new Style(this.getAttributes().get(DOMclass.class.getSimpleName().toLowerCase()));  
					}
					this.style.addNewStyle(value);
				 
				//System.out.println(this.style.toString());
				name=null;
				value=null;
				return;
			}else if(name.equals("sandbox")){
				if(!attributes.containsKey(name))
					attributes.put(name, value);
				else{
					attributes.put(name, attributes.get(name).concat(" ".concat(value)));
				}
			}else if(name.toLowerCase().equals(DOMclass.class.getSimpleName().toLowerCase())){
				if(attributes.containsKey(DOMclass.class.getSimpleName().toLowerCase())){
					attributes.put(DOMclass.class.getSimpleName().toLowerCase(), attributes.get(DOMclass.class.getSimpleName().toLowerCase()).concat(" ").concat(value));
				} else{
					attributes.put(DOMclass.class.getSimpleName().toLowerCase(),value);
				}
			} else{
				attributes.put(name,value);
			}
		// }else{
		//	 attributes.put(name, value); 
		 }
	 
	 
	/**
	 * Adds or over rights and attribute for the element
	 * @param name
	 * @param value
	 */
	public void addAttribute(String name, Number value){
		if(this.attributes==null)
			this.attributes=new HashMap<String,String>();
		attributes.put(name, String.valueOf(value));
	}
	
	/**
	 * Adds or over rights and attribute fro the element
	 * @param name
	 * @param value
	 */
	public void addAttribute(String name, boolean value){
		if(this.attributes==null)
			this.attributes=new HashMap<String,String>();
		attributes.put(name, String.valueOf(value));
	}
	/**
	 * removes the attribute form the element
	 * @param name
	 */
	public void removeAttribute(String name){
		this.attributes.remove(name);  
	}
	
	/**
	 * Returns the tag annotation value from the class or returns the class name in lower case
	 * @param object
	 * @return
	 */
	public static String tag(Class<?> object){ 
		return (object.getAnnotation(Tag.class)!=null)?
				object.getAnnotation(Tag.class).value()[0] : object.getSimpleName().toLowerCase().trim();
	}
	
	
	/**
	 * Grows an array of DOM elements by onw
	 * @param array
	 * @return
	 */
	public static DOMelement[] growElementArray(DOMelement[] array){
		DOMelement[] temp = new DOMelement[array.length];
		System.arraycopy(array, 0, temp, 0, array.length);
		array = new DOMelement[temp.length+1];
		System.arraycopy(temp, 0, array, 0, temp.length);
		return array; 
	}
	
	/**
	 * Sets attribute id to value indicated in ApplicationManager.FORCE_NO_ATTRIBUTE)
	 * @see ApplicationManager
	 */
	public void forceNoId(){
		addAttribute("id",ApplicationManager.FORCE_NO_ATTRIBUTE);
	}
	
	private StyleBuilder sb = null;
	/**
	 * Returns a string value of all the styles needed including all the child elements
	 * @return
	 */
	public String getStyleString(){ 
		String styleString = (this.style!=null)?this.style.toString():""; 
		for(int i=0;i< this.getEmbeddedElements().length;i++)
			styleString+=this.getEmbeddedElements()[i].getStyle();
		return styleString;
	}
	 
	 public void addEventListener(String type, DomFunction function,  boolean useCapture){
		if(this.getEventListerners()==null) this.setEventListerners(new EventListener[0]);
		EventListener[] eos = new EventListener[getEventListerners().length+1];
		System.arraycopy(getEventListerners(), 0, eos, 0, getEventListerners().length);
		setEventListerners(new EventListener[eos.length]);
		System.arraycopy(eos,0 , getEventListerners(), 0, eos.length); 
		getEventListerners()[getEventListerners().length-1]=new EventListener(type, function, useCapture); 
	 //	ApplicationManager.addEventListener(eventListerners[eventListerners.length-1],sessionId);
	}
	
	@Override
	 public void addEventListener(String type, DomFunction function,  boolean useCapture, String sessionId){ 
		 if(this.getEventListerners()==null) this.setEventListerners(new EventListener[0]);
		EventListener[] eos = new EventListener[getEventListerners().length+1];
		System.arraycopy(getEventListerners(), 0, eos, 0, getEventListerners().length);
		setEventListerners(new EventListener[eos.length]);
		System.arraycopy(eos,0 , getEventListerners(), 0, eos.length); 
		getEventListerners()[getEventListerners().length-1]=new EventListener(type, function, useCapture); 
	//	eventListerners[eventListerners.length-1].setId(eventListerners[eventListerners.length-1].getId().concat(sessionId));
		ApplicationManager.addEventListener(getEventListerners()[getEventListerners().length-1],sessionId);
	}
	 
	
	 public void addEventListener(EventListener eventListener, String sessionId){
			if(this.getEventListerners()==null) this.setEventListerners(new EventListener[0]);
			EventListener[] eos = new EventListener[getEventListerners().length+1];
			System.arraycopy(getEventListerners(), 0, eos, 0, getEventListerners().length);
			setEventListerners(new EventListener[eos.length]);
			System.arraycopy(eos,0 , getEventListerners(), 0, eos.length); 
			getEventListerners()[getEventListerners().length-1]= eventListener ; 
			ApplicationManager.addEventListener(eventListener, sessionId); 
		}
	 
	@Override
	public void removeEventListener( String type, DomFunction function,  boolean useCapture, String sessionId){
		EventListener[] temp = new EventListener[getEventListerners().length];
		EventListener ss =new EventListener(type,function,useCapture);
		ApplicationManager.removeEventListener(ss,sessionId);
		int i=0;
		for(int x=0;x<getEventListerners().length;x++){
			if(ss.getType().equals( type)) {
				temp[i] = getEventListerners()[x];
				i++;
			}
		} 
		setEventListerners(new EventListener[i]);
		System.arraycopy(temp, 0, getEventListerners(), 0, i);
	}
	
	
	public void addToGlobals(String name){
		ApplicationManager.addGlobal(name, this);
	}
	
		
	@Override
	public  boolean  dispatchEvent(DomEventAbstract evt) throws DomEventException{
		evt.initEvent(evt.type , evt.bubbles, evt.cancelable); 
		return evt.isDefaultPrevented();
		
	 }
	 
	 
	public void purge(){ 
		int count =0;
		DOMelement[] els = new DOMelement[this.embeddedElements.length];
		for(int i=0;i<this.embeddedElements.length;i++){
			if(this.embeddedElements[i]!=null){
				els[count] = embeddedElements[i];
				count++;
			}
		}
		embeddedElements = new DOMelement[count]; 
		System.arraycopy(els, 0, embeddedElements, 0, count);
	}
	
	
	public String getElementById(){
		return "document.getElementById(\"".concat((String)this.getAttributes().get("id")).concat("\")");
	}
	
	/**
	 * Returns a copy of the element with the given id
	 * @param id
	 * @return
	 */
	public DOMelement getElementById(String id){
		DOMelement element = null;
		if(this.attributes.get(ApplicationManager.STRING_ID) != null ) {
			if(this.attributes.get(ApplicationManager.STRING_ID).trim().equals(id.trim())) {
				element = this;
				return this;
			} 
		}else {
			Logger.log(Level.WARNING, String.format(DOMERR000010, nodename));
		}
		if(this.getEmbeddedElements()!=null) {
			for (DOMelement ele : this.getEmbeddedElements()) {
				element = ele.getElementById(id);
				if (element!=null) {
					return element;
				}
			}
		}
		return element;
	}
	
	public String getElementByIdInnerHTML(){
		return getElementById().concat(".innerHTML =\"").concat(nodevalue);
	}

	public boolean contains(Class<?> class1) {
		boolean contains = false;
		if(this.embeddedElements!=null) {
			for(int i=0;i < this.embeddedElements.length; i++){ 
				if(this.embeddedElements[i].getClass().equals(class1)){
					contains = true;
					return contains;
				}
				contains = this.embeddedElements[i].contains(class1);
					if(contains==true) 
						return contains;
				}
				
			}
		return contains;
	}
	
	/**
	 * Removes the element from the embedded elements if it is present
	 * @param class1
	 */
	protected void removeDomElement(Class<?> class1) {
		if(embeddedElements==null) return; // there are no elements at all
		int count =0;
		DOMelement[] els = new DOMelement[embeddedElements.length];
		for(int i=0; i<embeddedElements.length;i++){
			if(!embeddedElements[i].isOfType(class1)){
				els[count]=embeddedElements[i];
				count++;
			}
		}
		this.embeddedElements= new DOMelement[count];
		System.arraycopy(els, 0, embeddedElements, 0, count);
	}
	
	@Override
	public boolean equals(java.lang.Object object){
		if(object.getClass()!=this.getClass()) return false;
		if(((DOMelement)object).nodename.equals(this.nodename) && ((DOMelement)object).nodevalue.equals(this.nodevalue) && ((( ((DOMelement)object).embeddedElements==null)&& this.embeddedElements==null )|| ((DOMelement)object).embeddedElements.equals(this.getEmbeddedElements())) 
		&& ((DOMelement)object).getAttributes().equals(this.attributes)&&(((((DOMelement)object).getStyle()==null&&((DOMelement)object).getStyle()==null ) )|| ((DOMelement)object).getStyle().equals(this.style))){
			return true;
			
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private java.lang.Object[] addObject(java.lang.Object object[], java.lang.Object item){
		if(object == null) object = new java.lang.Object[0];
		object = growObjectArray(object);
		object[object.length-1]=item;
		return object;
	}
	private java.lang.Object[] growObjectArray(java.lang.Object object[]){
		java.lang.Object temp[] = new java.lang.Object[object.length+1];
		System.arraycopy(object, 0, temp, 0, object.length);
		object = new java.lang.Object[temp.length]; 
		System.arraycopy(temp, 0, object, 0, object.length);
		return object;
	}
	// GLOBAL EVENTS

	
	/**
	 * @inheritJavadoc
	 * @param object
	 * @param method
	 * @param params
	 * @param sessionId
	 */
	@Override
	public void onclick(java.lang.Object object, String method, java.lang.Object[] params, String sessionId){  
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){
			runFunction(EventType.onclick.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onclick.toString(),object, method,params,sessionId); 
	}


	@Override
	public void onload(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Body.class) && !isOfType(Iframe.class) && !isOfType(Img.class) && !isOfType(Link.class) && !isOfType(Script.class) && !isOfType(Style.class))){
			throw new RuntimeException("The onload events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onload.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("load",object, method,params,sessionId); 
	}

	@Override
	public void onloadstart(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Body.class) && !isOfType(Iframe.class) && !isOfType(Img.class) && !isOfType(Link.class) && !isOfType(Script.class) && !isOfType(Style.class))){
			throw new RuntimeException("The onload events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onloadstart.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onloadstart.toString(),object, method,params,sessionId); 
	}
	
	@Override
	public void ondblclick(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.ondblclick.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.ondblclick.toString(),object, method,params,sessionId); 
	}
	
	@Override
	public void onmousedown(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onmousedown.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onmousedown.toString(),object, method,params,sessionId); 
	}
	
	
	@Override
	public void onmouseenter(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onmouseenter.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onmouseenter.toString(),object, method,params,sessionId); 
	}
	
	
	
	@Override
	public void onmouseleave(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onmouseleave.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onmouseleave.toString(),object, method,params,sessionId); 
	}
	
	
	@Override
	public void onmouseout(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onmouseout.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onmouseout.toString(),object, method,params,sessionId); 
	}
	

	@Override
	public void onmousemove(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction(EventType.onmousemove.toString(),((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener(EventType.onmousemove.toString(),object, method,params,sessionId); 
	}
	
	
	@Override
	public void onwheel(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("wheel",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("wheel",object, method,params,sessionId); 
	}
	
	@Override
	public void onmouseup(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("mouseup",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("mouseup",object, method,params,sessionId); 
	}
	
	/* ToDo Add Track element as allowd
	 * (non-Javadoc)
	 * @see com.ibm.ca.dom.SuperElements.GlobalEventHandlers#oncuechange(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.String)
	 */
	@Override
	public void oncuechange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId){  
		if(ApplicationManager.FORCE_HTML_COMPLIANCE){
		//	throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){
			runFunction("cuechange",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("cuechange",object, method,params,sessionId); 
	}


	
	@Override
	public void oncontextmenu(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE ){
			//throw new RuntimeException("The onload events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("contextmenu",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("contextmenu",object, method,params,sessionId); 
	}

	@Override
	public void onchange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Input.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("change",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("change",object, method,params,sessionId); 
	}
	
	@Override
	public void oncanplaythrough(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !isOfType(MediaElement.class)){ 
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("canplaythrough",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("canplaythrough",object, method,params,sessionId); 
	}
	
	/*TODO add testare and slect as allowed elements keygen
	 * (non-Javadoc)
	 * @see com.ibm.ca.dom.SuperElements.GlobalEventHandlers#oncanplay(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.String)
	 */
	@Override
	public void oncanplay(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !isOfType(MediaElement.class)){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("canplay",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("canplay",object, method,params,sessionId); 
	}
	
	
	
	@Override
	public void oncancel(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("cancel",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("cancel",object, method,params,sessionId); 
	}
	
	
	@Override
	public void onblur(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("blur",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("blur",object, method,params,sessionId); 
	}
	

	@Override
	public void onautocompleteerror(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  !isOfType(Input.class) ){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("autocompleteerror",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("autocompleteerror",object, method,params,sessionId); 
	}
	
	
	@Override
	public void onautocomplete(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  !isOfType(Input.class) ){
			throw new RuntimeException("The onautocomplete events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("autocomplete",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("autocomplete",object, method,params,sessionId); 
	}
	
	@Override
	public void onabort(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Img.class) || (!isOfType(Input.class) && getAttribute("type")!="image"))){
			throw new RuntimeException("The abort events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("abort",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("abort",object, method,params,sessionId); 
	}
	@Override
	public void onclose(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Img.class) || (!isOfType(Input.class) && getAttribute("type")!="image"))){
			throw new RuntimeException("The abort events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("close",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("close",object, method,params,sessionId); 
	}
	
	
	
	@Override
	public void onmouseover(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onclick events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		if(object.getClass()==DomFunction.class){ 
			runFunction("mouseover",((DomFunction)object),method ,  sessionId);
			return;
		}
		addEventListener("mouseover",object, method,params,sessionId); 
	}
	
	
	@Override
	public void ondrag(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException{
		params =addEventParam(params);
		this.setDraggable(true);  
	 DomEventAbstract event = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondrag.toString(), null) ;
 
		_genericSetEvent(object, method, params, sessionId,event);
		 
	}
	
	@Override
	public void ondragend(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragend.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragend",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragend",object, method,params,sessionId); 
		
	}
	@Override
	public void ondragenter(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragend.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragenter",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragenter",object, method,params,sessionId); 
		
	}
	@Override
	public void ondragexit(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragexit.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragexit",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragexit",object, method,params,sessionId); 
		
	}
	@Override
	public void ondragleave(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragleave.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragleave",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragleave",object, method,params,sessionId); 
		
	}
	@Override
	public void ondragover(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragexit.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragexit",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragexit",object, method,params,sessionId); 
		
	}
	@Override
	public void ondragstart(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException { 
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragstart.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragstart",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragstart",object, method,params,sessionId); 
		
	}
	@Override
	public void ondrop(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		params =addEventParam(params);
		this.setDraggable(true);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondragstart.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("dragstart",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("dragstart",object, method,params,sessionId); 
		
	}
	@Override
	public void ondurationchange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(MediaElement.class))) 
			throw new RuntimeException("The ondurationchange events are not supported by ".concat(this.getClass().getCanonicalName()));
		params =addEventParam(params);
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ondurationchange.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("durationchange",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("durationchange",object, method,params,sessionId);  
	}
	@Override
	public void onemptied(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(MediaElement.class))) 
			throw new RuntimeException("The onemptied events are not supported by ".concat(this.getClass().getCanonicalName()));
		params =addEventParam(params);
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onemptied.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("emptied",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("emptied",object, method,params,sessionId); 
	}
	@Override
	public void onended(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(MediaElement.class))) 
			throw new RuntimeException("The onended events are not supported by ".concat(this.getClass().getCanonicalName()));
		params =addEventParam(params);
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onended.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("ended",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("ended",object, method,params,sessionId); 
	}
	@Override
	public void onerror(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(MediaElement.class))) 
			throw new RuntimeException("The onerror events are not supported by ".concat(this.getClass().getCanonicalName()));
		params =addEventParam(params);  
		DomEventAbstract mouseEvent = new MouseEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onerror.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("error",((DomFunction)object),method ,  sessionId, mouseEvent);
			return;
		}	
		addEventListener("error",object, method,params,sessionId);  
	}
	@Override
	public void onfocus(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException { 
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class))){
			throw new RuntimeException("The onfocus events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		params =addEventParam(params);  
		DomEventAbstract mouseEvent = new UiEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onfocus.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("focus",((DomFunction)object),method ,  sessionId,mouseEvent);
			return;
		}
		addEventListener("focus",object, method,params,sessionId);  
	}
	/*ToDo
	 * ADD TEXTAREA AS ALLOWD CLASS
	 * (non-Javadoc)
	 * @see com.ibm.ca.dom.SuperElements.GlobalEventHandlers#oninput(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.String)
	 */
	@Override
	public void oninput(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException { 
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Input.class))){
			throw new RuntimeException("The oninput events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		params =addEventParam(params);  
		DomEventAbstract mouseEvent = new UiEvent(true,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.oninput.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("input",((DomFunction)object),method ,  sessionId,mouseEvent);
			return;
		}
		addEventListener("input",object, method,params,sessionId);  
	}
	@Override
	public void oninvalid(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Input.class))){
			throw new RuntimeException("The oninput events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		params =addEventParam(params);  
		DomEventAbstract mouseEvent = new UiEvent(false,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.oninvalid.toString(), null) ;
		if(object.getClass()==DomFunction.class){ 
			runFunction("invalid",((DomFunction)object),method ,  sessionId,mouseEvent);
			return;
		}
		addEventListener("invalid",object, method,params,sessionId);  
	}
	@Override
	public void onkeydown(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericCheck("onkeydown"); 
		params =addEventParam(params);  
		DomEventAbstract event = new KeyBoardEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onkeydown.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event); 
	}
	@Override
	public void onkeypress(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericCheck("onkeypress"); 
		params =addEventParam(params);  
		DomEventAbstract event = new KeyBoardEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onkeypress.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onkeyup(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericCheck("onkeyup"); 
		params =addEventParam(params);  
		DomEventAbstract event = new KeyBoardEventObject(true,true,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onkeyup.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onloadeddata(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onkeypress"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onloadeddata.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onloadedmetadata(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onloadedmetadata"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onloadedmetadata.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onpause(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onpause"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onpause.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onplay(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onplay"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onplay.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onplaying(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onplaying"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onplaying.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onprogress(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onprogess"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onprogress.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onratechange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onratechange"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onratechange.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onreset(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onreset"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onreset.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
		
	}
	@Override
	public void onresize(java.lang.Object object, String method, java.lang.Object[] params, String sessionId){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Body.class)))
			throw new RuntimeException("onresize event is only allowed on the ".concat(Body.class.getCanonicalName())); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onresize.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onscroll(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Address.class) || !isOfType(BlockQuote.class) || !isOfType(Body.class) || !isOfType(Caption.class)
				 || !isOfType(Dd.class) || !isOfType(Div .class) || !isOfType(Dt.class) || !isOfType(H.class) || !isOfType(Html.class) || !isOfType(Object.class)
				 || !isOfType(Ol.class) || !isOfType(P.class)|| !isOfType(Pre.class) || !isOfType(Ul.class)))
			throw new RuntimeException("onscro event is not allowd with ".concat(this.getClass().getCanonicalName())); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onscroll.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onseeked(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException { 
		_genericMediaCheck("onseeked"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onseeked.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onseeking(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onseeking"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onseeking.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onselect(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericInputCheck("onselect"); 
		if(ApplicationManager.FORCE_HTML_COMPLIANCE){
			if(getAttribute("type")==null)
				throw new RuntimeException("Type must be defined for onslect event");
			if(getAttribute("type")!="file" ||(getAttribute("type")!="file" || (getAttribute("type")!="file")))
				throw new RuntimeException("Type must be defined for onslect event as 'file', 'password' or 'text'");
		}
		params =addEventParam(params);  
		DomEventAbstract event = new UiEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onselect.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onshow(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !isOfType(Menu.class))
			throw new RuntimeException("onshow event is only supported by the ".concat(Menu.class.getCanonicalName()));
		params =addEventParam(params);  
		DomEventAbstract event = new UiEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onshow.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onsort(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Img.class) || (!isOfType(Input.class) && getAttribute("type")!="image"))){
			throw new RuntimeException("The onsort events are not supported by ".concat(this.getClass().getCanonicalName()));
		}
		params =addEventParam(params);  
		DomEventAbstract event = new UiEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onsort.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onstalled(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck("onstalled"); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onstalled.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onsubmit(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onsuspend(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck(EventType.onsuspend.name()); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onsuspend.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event); 
	}
	@Override
	public void ontimeupdate(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException { 
		_genericMediaCheck(EventType.ontimeupdate.name()); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.ontimeupdate.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void ontoggle(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onvolumechange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck(EventType.onvolumechange.name()); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onvolumechange.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	@Override
	public void onwaiting(java.lang.Object object, String method, java.lang.Object[] params, String sessionId)
			throws IOException {
		_genericMediaCheck(EventType.onwaiting.name()); 
		params =addEventParam(params);  
		DomEventAbstract event = new MediaEvent(false,false,this,true, EventPhase.CAPTURING_PHASE, true, this, null,EventType.onwaiting.toString(), null) ;
		_genericSetEvent(object, method, params, sessionId,event);
	}
	 
	private void _genericSetEvent(java.lang.Object object, String method,java.lang.Object[] params, String sessionId, DomEventAbstract event){
		if(object.getClass()==DomFunction.class){ 
			runFunction(event.getType().substring(2),((DomFunction)object),method ,  sessionId,event);
			return;
		}
		addEventListener(event.getType().substring(2),object, method,params,sessionId); 
	}
	
	private void _genericCheck(String eventname){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (isOfType(Base.class) || isOfType(Iframe.class) || isOfType(Bdo.class) || isOfType(Br.class) || isOfType(Script.class) || isOfType(Meta.class)|| isOfType(Style.class)|| isOfType(Title.class) || isOfType(Param.class)|| isOfType(Head.class) || isOfType(Html.class)))
			throw new RuntimeException("The ".concat(eventname).concat(" events are not supported by ").concat(this.getClass().getCanonicalName())); 
	}
	private void _genericMediaCheck(String eventname){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(MediaElement.class)))
			throw new RuntimeException("The ".concat(eventname).concat(" events are not supported by ").concat(this.getClass().getCanonicalName())); 
	}
	private void _genericInputCheck(String eventname){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!isOfType(Input.class)))
			throw new RuntimeException("The" .concat(eventname).concat(" events are not supported by ").concat(this.getClass().getCanonicalName())); 
	}
	
	/**
	 * checks for the "event" parameter in the object array and adds it if it is not there already
	 * @param params
	 * @return
	 */
	private java.lang.Object[] addEventParam(java.lang.Object[] params){
		boolean hasEvent = false;
		if(params==null) params = new java.lang.Object[0];
		for(java.lang.Object object:params){
			if(object.toString()=="event"){
				hasEvent=true;
				break;
			}
		
		}
		if(!hasEvent){
			params = growObjectArray(params);
			params[params.length-1]="event";
		}
		return params;
	}
	
	
	private void addEventListener(String evet, java.lang.Object object, String method,  java.lang.Object[] params,String sessionId){
		XMLHttpRequest x=new XMLHttpRequest( "get",null,ApplicationManager.getNextId().concat(sessionId)); 
		x.setResponseObject(object, method,params);
		x.getBody().replace(ApplicationManager.EVENT_LISTENER_NAME_PLACEHOLDER, x.getName());
		EventListener event= new EventListener(evet, x, true,x.getRequestUrl()); 
		event.bindRequest(x,sessionId); 
		addEventListener(event,sessionId); 
	}
	
	private void runFunction(String eventName, DomFunction domFunction,String responseText, String sessionId){  
		XMLHttpRequest x=new XMLHttpRequest( "get",domFunction,ApplicationManager.getNextId().concat(sessionId));
		x.setResponseText(responseText);
	
		x.getBody().replace(ApplicationManager.EVENT_LISTENER_NAME_PLACEHOLDER, x.getName());
		
		EventListener event= new EventListener(eventName, x, true,x.getRequestUrl());
		event.bindRequest(x,Id()); 
		addEventListener(event,sessionId);
		
	}
 
	private void runFunction(String eventName, DomFunction domFunction,String responseText, String sessionId, DomEventAbstract event){  
		domFunction.addParam("event");
		XMLHttpRequest x=new XMLHttpRequest( "get",domFunction,ApplicationManager.getNextId().concat(sessionId));
		x.setResponseText(responseText); 
		
		String temp ="";
		if(event.isDefaultPrevented())
			temp = temp.concat("\nevent.preventDefault();");
		x.getBody().replace(ApplicationManager.EVENT_LISTENER_NAME_PLACEHOLDER, x.getName());
		x.setBody("{".concat(temp.concat(x.getBody().substring(x.getBody().indexOf('{')+1, x.getBody().length()))));
		EventListener eventListener= new EventListener(eventName, x, true,x.getRequestUrl());
		eventListener.bindRequest(x,Id()); 
		addEventListener(eventListener,sessionId);
		
	}
	
	/**
	 * Returns the innerhtml as a string;
	 * @return
	 */
	public String innerHtml(){
		return this.toString().replace("<".concat(tag).concat(">"),"").replace("</".concat(tag).concat(">"),"");
	}
	
	/** Sets the current node value to the given String 
	 * 
	 * @param innerHtml
	 */
	public void innerHtml(String innerHtml){
		this.nodevalue = innerHtml;
	}
	
	public void innnHtmlFromUrl(String url){
		FileReader fr = new FileReader();
		this.nodevalue = fr.readUrl(url);
	}
	public void innnHtmlFromFile(String url){
		FileReader fr = new FileReader();
		this.nodevalue = fr.readFile(url);
	}
	
	
	/**
	 * Adds a property object to the properties map using the name as the key and the Object as the value
	 * @param name
	 * @param form
	  
	public void addProperty(String name, Object object) {
		if(this.properties==null) {
			this.properties = new HashMap<String,DOMobject>();
		}
		properties.put(name, (DOMobject)object);
	}	
	*/
	public void addProperty(String name, DOMelement domElement) {
		if(this.properties==null) {
			this.properties = new HashMap<String,DOMobject>();
		}
		properties.put(name,  domElement);
	}
	
	public void addProperty(String name, DOMobject e) {
		if(this.properties==null) {
			this.properties = new HashMap<String,DOMobject>();
		}
		properties.put(name,   e);
	}
	
	/**
	 * Returns all the properties objects as a Map &lt;String,Object&gt; or an empty Map if no properties are found
	 * @return
	 */
	public Map<String,DOMobject> getPropeties() {
		if(this.properties==null) {
			this.properties = new HashMap<String,DOMobject>();
		}
		return this.properties;
	}
	
	/**
	 * Retursn the property object associated with the name or returns null if not found
	 * @param name
	 * @return
	 */
	public DOMobject getProperty(String name) { 
		if(this.properties==null || !this.properties.containsKey(name))
			return null ;
		else return this.properties.get(name);
	}
	
	
	 public void updateAttributesAndProperties(DOMelement element) { 
	    	for(Field f: element.getClass().getDeclaredFields()){  
	    	 	try {
					if((f.getDeclaredAnnotationsByType(Hidden.class).length>0 
							&&	f.getDeclaredAnnotation(Hidden.class).value()==true)|| f.get(element)==null)  {
					}else { 
						try {
						if(f.get(element)!=null) {
							this.addAttribute(f.getName(),(String) f.get(element)); 
							Logger.log(f.getName().concat(" -> added to attributes for ").concat(this.getClass().getSimpleName()));
						}
						}catch(Exception e) {	 
							try { 
								this.addProperty(f.getName(),(DOMobject) f.get(element)); 
								Logger.log(f.getName().concat(" -> added to properties for ").concat(this.getClass().getSimpleName()));							
							} catch (Exception e1) { 
					   			Logger.log(f.getName().concat(" -> Error adding propety ").concat(this.getClass().getSimpleName()));
							}
						
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	 
	    }

	public EventListener[] getEventListerners() {
		return eventListerners;
	}

	public void setEventListerners(EventListener[] eventListerners) {
		this.eventListerners = eventListerners;
	}
	    
	 
	 /**
	  * Create and throw a generic jadom class compliance error
	  * @param arg1
	  * @param arg2
	  */
	 protected void throwComplianceError(DOMobject arg1 , DOMobject arg2){
		 throw new RuntimeException(new JaDomComplianceError(arg1,arg2));
	 }

	public String getElementId() {
		return this.attributes.get(ApplicationManager.STRING_ID); 
	}
	 
	 
	/***
	 * Reads the config and sets the default bootstrap boolean
	 */
	private void detecteBootstap() { 
		this.bootstrap = Boolean.valueOf(JadomConfig.getInstance().isBootstrapped()); 
	}
	 
	 /**
	  * Returns true if the element should be bootstrapped
	  * @return
	  */
	public boolean isBootstrapped() {
		return this.bootstrap;
	}
	
	/**
	 * Override the default bootstrap  boolean
	 * @param boot
	 * @return
	 */
	public boolean setBootstrap(Boolean boot) {
		return this.bootstrap=boot;
	}
	
	
	public String getBasicOpenTag() {
		return String.format(ApplicationManager.BASIC_OPEN_TAG, this.tag);
	}
	
	
	public String getBasicCloseTag() {
		return String.format(ApplicationManager.BASIC_CLOSE_TAG, this.tag);
	}
}

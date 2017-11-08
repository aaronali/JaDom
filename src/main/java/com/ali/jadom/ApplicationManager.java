package com.ali.jadom;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap; 
import java.util.Random;
import java.util.UUID;

import com.ali.jadom.dom.Abbr;
import com.ali.jadom.dom.DOMelement;
import com.ali.jadom.dom.IDOMelement;
import com.ali.jadom.javascript.EventListener;
import com.ali.jadom.javascript.EventListenerInterface;
import com.ali.java.jaFile.FileReader; 
 

public class ApplicationManager implements Serializable {
	
	
	private static final long serialVersionUID = -8895564563680815588L;
	public static final ApplicationManager appManager = new ApplicationManager();
	/* header constants defaults*/
	public static final String DEFAULT_HEADER_CLASS = null;
	public static final String DEFAULT_HEADER_JS = null;
	
	/* paragraph constants defaults*/
	public static final String DEFAULT_PARAGRAPH_JAVASCRIPT = null;
	public static final String DEFAULT_PARAGRAPH = null;
	public static final int DEFAULT_PARAGRAPH_LINESIZE = 2;
	public static final int DEFAULT_PARAGRAPH_FONTSIZE = 14;
	public static final String DEFAULT_PARAGRAPH_DOM_CLASS = null;

	public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd  hh:mm:ss";
	
	public static final boolean AREA_ANCHOR_USE_LINK_MANAGER= false;
	public static boolean DEFAULT_BUTTON_AUTO_FOCUS = false;
	public static boolean DEFAULT_BUTTON_DISABLED= false;
	
	public static final boolean INLINE_SYTLES = false;
	/** Specifies the default language for the document object **/
	public static final String DEFAULT_HTML_LANG = "en";
	/** Species an attribute not to be processed **/
	public static final boolean FORCE_HTML_COMPLIANCE = true;
	public static final boolean JAVASCRIPT_CONDENSE = false;
	public static final Boolean FORCE_LIST_VALUES = false; 
	public static final boolean HTML_CONDENSE = false; 
	

	public static final boolean ALLOW_EMPTY_ELEMENTS = false;
	public static final String FORCE_NO_ATTRIBUTE = "FORCE_NO_ATTRIBUTE";
	public static final String NULL_NODE_VALUE = "nullnodevalue";
	public static final String EVENT_LISTENER_NAME_PLACEHOLDER = "eventListenerNamePlaceHolder";
	public static final String BASIC_OPEN_TAG ="<%s>";
	public static final String BASIC_CLOSE_TAG ="</%s>";

	public static final String HTML="html";
	public static final String STRING_DOMCLASS="domClass"; 
	public static final String STRING_HREF = "href";
	public static final String STRING_DOWNLOAD = "download";
	public static final String STRING_HREFLANG = "hreflang";
	public static final String STRING_REL = "rel";
	public static final String STRING_TYPE = "type";
	public static final String STRING_NAME = "name";
	public static final String STRING_TARGET ="target";
	public static final String STRING_TITLE ="title"; 
	public static final String STRING_NEWLINE = "\r\n";
	public static final String STRING_ADDRESS_SEPERATOR = ", "; 
	public static final String STRING_ALT = "alt";
	public static final String STRING_SHAPE = "shape";
	public static final String STRING_COORDS ="coords";
	public static final String STRING_DIR ="dir";
	public static final String STRING_CITE ="cite";
	public static final String STRING_VALUE ="value";
	public static final String STRING_OPEN ="open";
	public static final String STRING_WIDTH ="width"; 
	public static final String STRING_SCRIPTS ="scripts"; 
	public static final String STRING_HEIGHT ="height";
	public static final String STRING_SRC ="src";
	public static final String STRING_ID ="id";
	public static final String STRING_SPACE =" ";
	public static final String STRING_DBLSPACE ="  ";
	public static final String STRING_CANVAS_NOT_SUPPORTED= "Canvas is not supported by your browser";
	public static final String STRING_EMPTY = "";
	public static final String STRING_CROSSORIGIN = "crossorgin";
	public static final String STRING_MEDIA = "media";
	public static final String STRING_SIZE = "size";
	public static final String STRING_ISMAP = "ismap";
	public static final String STRING_USEMAP = "usemap";
	public static final String String_HTTPEQUIV = "httpequiv";
	public static final String STRING_CHARSET = "charset";
	public static final String STRING_CONTENT = "content";
	public static final String STRING_DOUBLE_UNDERSCORE = "__";
	public static final String STRING_UNDERSCORE = "_";
	public static final String STRING_HYPHEN = "-"; 
	public static final String STRING_PERIOD = ".";
	public static final String EXTENSTION_JADOM_HTML = ".jadom.html";
	public static final String EXTENSTION_JADOM_CAROUSEL_DEFAULT_CSS = ".jadom.carousel.default.css";
	public static final String EXTENSTION_JADOM_JS = ".jadom.js";
	public static final String EXTENSTION_JADOM_CLASSES = ".jadom.classes";
	public static final String STRING_SRCSET = "srcset";
	public static final String STRING_FULLWIDTH = "fullwidth";
	public static final String STRING_ROLE = "role";
	public static final String STRING_UNTITLED = "untitled";
	public static final String CHAR_SEMICOLON = ";"; 
	

	public static String RESOURCES_CSS ="resources".concat(String.valueOf(File.separatorChar)).concat("css").concat(String.valueOf(File.separatorChar)).trim(); 
	public static String RESOURCES_JS = "resources".concat(String.valueOf(File.separatorChar)).concat("js").concat(String.valueOf(File.separatorChar)).trim(); 
	public static String PATH_JADOM_SCRIPTS = "resources".concat(String.valueOf(File.separatorChar)).concat("scripts"); 
	 
	private static ArrayList<String> autoIds =  null;
	private static ArrayList<String> autoFunctionName = null;
	private static HashMap<String,Collection<EventListener>> eventListeners = new HashMap<String,Collection<EventListener>>();
	
	public static HashMap<String, IDOMelement> GLOBALS = new HashMap<String,IDOMelement>();
	
	public static Abbr getAbbr(String abbr){
		return (Abbr) GLOBALS.get(abbr) ;
	}
	public static DOMelement getGlobal(String name){
		return  (DOMelement) GLOBALS.get(name) ;
	}
	
	public static void addGlobal(String name, IDOMelement element){
		if(GLOBALS.containsKey(name))
			if(GLOBALS.get(name)==element)
				return;
		GLOBALS.put(name, element);
	}

	public static void setScriptPath(String path){
		 PATH_JADOM_SCRIPTS = path;
	}
	public static String getScriptPath(){
		return PATH_JADOM_SCRIPTS;
	}
  

	public ApplicationManager(){
		
	}

	/**<i>public <b>Collection&ltEventListener&gt  </b> getEventListsener</i><b>(sessionId)</b><br>
	 * Returns a collection of event listeners associates with the sessionId. If the session id is not in the
	 * EventListener the return value is an empty ArrayList of EventListeners
	 * @param sessionId String
	 * @return Collection&ltEventListener&gt for the current session
	 * @see com.ali.jadom.javascript.EventListener
	 */
	public Collection<EventListener> getEventListseners(String sessionId){
		 if(eventListeners.containsKey(sessionId))
				return eventListeners.get(sessionId);
		 return new ArrayList<EventListener>();
	}
	
/*	public Collection<EventListener>  getEventListseners(){
		if(eventListeners==null) return new ArrayList<EventListener>();
		return eventListeners.values();
	}
	*/
	
	 
	/**
	 * <i>public static <b>void</b> addEventListener</i><b>(eventListener, sessionId)</b><br>
	 * Adds the EventListener to the session event listeners array list so it can be acted on.
	 * @param eventListener EventListener
	 * @param sessionId String
	 * @see com.ibm.ca.EventListener
	 */
	public static void  addEventListener(EventListener eventListener, String sessionId){
		if(!eventListeners.containsKey(sessionId)) { 
			eventListeners.put(sessionId, new ArrayList<EventListener>()); 
		}
		eventListeners.get(sessionId).add(eventListener); 
	}
	
	/**
	 *  <i>public static <b>void</b> addEventListener</i><b>(DOMelementInterface, sessionId)</b><br>
	 * Registers the EventListeners for the DOMelement and all its child elements
	 * @param element DOMelementInterface
	 * @param sessionId String
	 * @see com.ali.jadom.javascript.EventListener
	 */
	public static void addEventListeners(IDOMelement element, String sessionId){
		if(((DOMelement)element).getEventListerners()!=null){
			for(EventListenerInterface  eve :((DOMelement)element).getEventListerners()){
				addEventListener((EventListener)eve,sessionId); 
			}
		}
		if(((DOMelement)element).getEmbeddedElements()!=null){
			for(IDOMelement ele: ((DOMelement)element).getEmbeddedElements()){
				addEventListeners(ele, sessionId);
			}
		}
	}
	
	/**<i>public static <b>String</b> getNextId</i><b>()</b><br>
	 * Generates an unique auto id and returns the string
	 * @return String alphaNumberic auto id
	 */
	public static String getNextId(){ 
		if(autoIds==null)autoIds= new ArrayList<String>();
		String uuid =null;
		boolean testing = true;
		while(testing){	
			uuid = UUID.randomUUID().toString();  
			testing = Character.isDigit(uuid.charAt(0));
			if(!testing)
				uuid =uuid.substring(0,8);
			if(autoIds.contains(uuid)) testing = true;
			if(!testing){
				autoIds.add(uuid);
			}
		}
		return uuid;
	}
	
	/**
	 * <i>public static <b>String</b> getNextFunctoinName</i><b>()</b><br>
	 * Auto generates a unique string for a function name and returns the value
	 * @return String for function name
	 */
	public  static  String getNextFunctoinName() {  
		if(autoFunctionName==null)autoFunctionName= new ArrayList<String>();
		    Random r = new Random();
		    String str ="abcdefghijklmnopqrstuvwxyz";
		    StringBuilder sb = null;  
		    while(sb==null || autoFunctionName.contains(sb.toString())){
		    	sb = new StringBuilder();
		    	for(int i = 0; i < 10; i++) {
		    		sb.append(str.charAt(r.nextInt(str.length()-1))); 
		    	}
		    }
		    autoFunctionName.add(sb.toString());
		    return  sb.toString();
		 
	}

	public static void removeSessionEventListeners(String sesionId){
		if(eventListeners.containsKey(sesionId))
			eventListeners.get(sesionId).clear();
	}
	
	
	public static void removeEventListener(EventListener ss, String sessionId) {
		EventListener lToRemove = null;
		if(eventListeners.containsKey(sessionId)){
			for(EventListener eve:eventListeners.get(sessionId)){
				if(eve.getEvent() == ss.getEvent()&&eve.getFunction().toString().trim().equals(ss.getFunction().toString().trim())&&eve.getType().equals(ss.getType())){
				lToRemove=eve;
				break;
				}
			}
		}
		if(lToRemove!=null){
			eventListeners.get(sessionId).remove(lToRemove); 
		}
		 
	}
	
	
	/**
	 * <i>public static <b>void</b> removeEventListeners</i><b>(domElement, sessionId)</b><br>
	 * Removes the the EventListeners for the DOMelement and all its child elements.
	 * @param domElement
	 * @param sessionId
	 */
	public static void removeEventListeners(DOMelement domElement, String sessionId){
		if(eventListeners.containsKey(sessionId)){
			if( domElement.getEventListerners()!=null){
				for(EventListener eve:((DOMelement)domElement).getEventListerners()){
					removeEventListener(eve,sessionId);
				}
			}
		} 
		
		
		if(domElement.getEmbeddedElements()!=null){
			for(DOMelement ele: ((DOMelement)domElement).getEmbeddedElements()){
				removeEventListeners(ele,sessionId);
			}
		}
	}
	
	// ERROR MESSAGE HELPERS
	private String getClassNotAllowedClass =  " is not allowd to hav a child of type. ";
	/**
	 * Returns the custom error string for adding an unsupported element
	 * @return String Error message String
	 */
	public String getClassNotAllowedClass(){
		return getClassNotAllowedClass;
	}
	
	private String getElementCreationError =  " failed to create empty class  ";
	/**
	 * Returns the custom error string for adding an unsupported element
	 * @return String Error message String
	 */
	public String getElementCreationError(){
		return getElementCreationError;
	}
	
	/**
	 * Set the custom error string for adding an unsupported element
	 * @param string
	 */
	public void setClassNotAllowedClass(String string){
		getClassNotAllowedClass = string;
	} 
	
	private String getClassNotAllowedAttribute =  " is not allowed to have any attributes. ";
	/**
	 * Returns the custom error string for adding an unsupported attribute
	 * @return String Error message
	 */
	public String getClassNotAllowedAttribute(){
		return getClassNotAllowedAttribute;
	}
	/**
	 * Set the custom error string for adding an unsupported attributes
	 * @param string
	 */
	public void setClassNotAllowedAttribute(String string){
		getClassNotAllowedAttribute = string;
	}
	
	private String genericHelp = " Change ApplicationManager.FORCE_HTML_COMPLIANCE to override.";
	/**
	 * Returns the custom helper string for overriding an unsupported elements error
	 * @return String Error message
	 */
	public String getGenericeHelp(){
		return genericHelp;
	}
	
	private String getClassNotAllowedClasses = " is not allowed to have any child elements.";
	/**
	 * Returns the custom error string for no elements allowed
	 * @return String Error message
	 */
	public String getClassNotAllowedClasses() {
		return getClassNotAllowedClasses;
	} 
	
	 
	/**
	 * Converts a file to an encoded Base64 Binary
	 * @param file
	 * @return
	 */
	public String FileToBase64Binary(File file) { 
         String encodedfile = null;
         FileInputStream fileInputStreamReader = null ;
       try {
           fileInputStreamReader = new FileInputStream(file);
           byte[] bytes = new byte[(int)file.length()];
           fileInputStreamReader.read(bytes);
           encodedfile = Base64.getEncoder().encodeToString(bytes);
       } catch (FileNotFoundException e) { 
           e.printStackTrace();
       } catch (IOException e) { 
           e.printStackTrace();
       }finally {
    	   try {
			fileInputStreamReader.close();
		} catch (IOException e) { 
			e.printStackTrace();
		}
       } 
       return encodedfile;
   } 
}

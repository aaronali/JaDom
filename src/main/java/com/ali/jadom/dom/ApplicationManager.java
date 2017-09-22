package com.ali.jadom.dom;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap; 
import java.util.Random;
import java.util.UUID;

import com.ali.jadom.javascript.EventListener;
import com.ali.jadom.javascript.EventListenerInterface;

 

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
	
	public static final boolean INLINE_SYTLES = false;
	/** Specifies the default language for the document object **/
	public static final String DEFAULT_HTML_LANG = "en";
	/** Species an attribute not to be processed **/
	public static final String FORCE_NO_ATTRIBUTE = "FORCE_NO_ATTRIBUTE";
	public static final boolean FORCE_HTML_COMPLIANCE = true;
	public static final String NULL_NODE_VALUE = "nullnodevalue";
	public static final boolean JAVASCRIPT_CONDENSE = false;
	public static final Boolean FORCE_LIST_VALUES = false; 
	public static final String EVENT_LISTENER_NAME_PLACEHOLDER = "eventListenerNamePlaceHolder";
	
	private static ArrayList<String> autoIds =  null;
	private static ArrayList<String> autoFunctionName = null;
	private static HashMap<String,Collection<EventListener>> eventListeners = new HashMap<String,Collection<EventListener>>();
	
	public static HashMap<String, DOMelementInterface> GLOBALS = new HashMap<String,DOMelementInterface>();
	
	public static Abbr getAbbr(String abbr){
		return (Abbr) GLOBALS.get(abbr) ;
	}
	public static DOMelement getGlobal(String name){
		return  (DOMelement) GLOBALS.get(name) ;
	}
	
	public static void addGlobal(String name, DOMelementInterface element){
		if(GLOBALS.containsKey(name))
			if(GLOBALS.get(name)==element)
				return;
		GLOBALS.put(name, element);
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
	public static void addEventListeners(DOMelementInterface element, String sessionId){
		if(((DOMelement)element).eventListerners!=null){
			for(EventListenerInterface  eve :((DOMelement)element).eventListerners){
				addEventListener((EventListener)eve,sessionId); 
			}
		}
		if(((DOMelement)element).getEmbeddedElements()!=null){
			for(DOMelementInterface ele: ((DOMelement)element).getEmbeddedElements()){
				addEventListeners(ele, sessionId);
			}
		}
	}
	
	/**<i>public static <b>String</b> getNextId</i><b>()</b><br>
	 * Generates an auto id and returns the string
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
			if( domElement.eventListerners!=null){
				for(EventListener eve:((DOMelement)domElement).eventListerners){
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
	public String getClassNotAllowedClass(){
		return getClassNotAllowedClass;
	}
	public void setClassNotAllowedClass(String string){
		getClassNotAllowedClass = string;
	}
	
	
	private String getClassNotAllowedAttribute =  " is not allowed to have any attributes. ";
	public String getClassNotAllowedAttribute(){
		return getClassNotAllowedAttribute;
	}
	public void setClassNotAllowedAttribute(String string){
		getClassNotAllowedAttribute = string;
	}
	
	private String genericHelp = " Change ApplicationManager.FORCE_HTML_COMPLIANCE to override.";
	public String getGenericeHelp(){
		return genericHelp;
	}
	
	private String getClassNotAllowedClasses = " is not allowed to have any child elements.";
	public String getClassNotAllowedClasses() {
		return getClassNotAllowedClasses;
	} 
}

package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;

 
@Tag("ol")
public class Ol extends DOMelement implements FlowingContent, PalpableContent{

	 
	
	private static final long serialVersionUID = -1617500380123314543L;

	public enum Type{
		  LOWER_ALPHA /**	Lowercase latin alphabet **/,
		  UPPER_ALPHA /** 	Uppercase latin alphabet **/,
		  LOWER_ROMAN /** 	Lowercase roman numerals **/,
		  UPPER_ROMAN /**	Uppercase roman numeral **/; 
		
		@Override 
		public String toString(){
			return name().toLowerCase().replace("_", "-");
		}
	}
	protected boolean reversed;
	protected long start;
	protected Type type;
	private int valueCount =-1; 
	private Boolean forceListValues = ApplicationManager.FORCE_LIST_VALUES;
	 
	/**
	 * 
	 * @param olText
	 * @param attributes
	 */
	public Ol(String olText, HashMap<String, String> attributes) {
		super(tag(Ol.class), olText, attributes);  
		if(attributes.get("start")!=null)
			start = Long.valueOf(attributes.get("start"));
		if(attributes.get("type")!=null)
			this.type = Enum.valueOf(Type.class, attributes.get(type)); 
		if(attributes.get("reversed")!=null)
			this.reversed = Boolean.valueOf(  attributes.get(type)); 
	} 

	/**
	 * 
	 * @param element
	 */
	public Ol(IDOMelement element){
		super((Ol)element);
		this.start=((Ol)element).start;
		this.type=((Ol)element).type;
		this.valueCount=((Ol)element).valueCount;
		this.forceListValues=((Ol)element).forceListValues;
	}
	/**
	 * 
	 */
	public Ol(){
		super(tag(Ol.class)); 
	}
	 /**
	  * 
	  * @param olText
	  */
	public Ol( String olText) {
		super(tag(Ol.class), olText); 
	} 
	 
	/**
	 * 
	 * @param olText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Ol(String olText,  String id, String domClass, String Styles, String jsCallout) {
		super(tag(Ol.class), olText, id, domClass, Styles, jsCallout);  
	}

	/**
	 * 
	 * @param liText
	 * @param value
	 */
	public void addLi(String liText, int value){ 
		if(value<11) throw new RuntimeException("Listitem values must bew greater than 1"); 
		this.addDomElement(new Li(liText,value));
		if(forceListValues){
			if(valueCount<0|| valueCount<start){
					start=value;
			}
		}
	}
	/**
	 * 
	 * @param liText
	 * @param domClass
	 * @param value
	 */
	public void addLi(String liText, String domClass , int value){ 
		if(value<11) throw new RuntimeException("Listitem values must bew greater than 1"); 
		this.addDomElement(new Li(liText,domClass,value));
		if(forceListValues){
			if(valueCount<0|| valueCount<start){
					start=value;
			}
		}
	}
	/**
	 * 
	 * @param olText
	 * @param reversed
	 * @param type
	 * @param start
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Ol(String olText, boolean reversed, Type type, Long start, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Ol.class), olText, id, domClass, Styles, jsCallout); 
		addAttribute("reversed",String.valueOf(reversed));
		this.reversed =reversed;
		this.type =type;
		addAttribute("type",type.toString());
		if(forceListValues){
			this.start = start; 
			addAttribute("start",String.valueOf(start));
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public final boolean isReversed() {
		return reversed;
	}

	/**
	 * 
	 * @param reversed
	 */
	public final void setReversed(boolean reversed) {
		this.reversed = reversed;
		addAttribute("reversed",String.valueOf(reversed)) ;
	}

	/**
	 * 
	 * @return
	 */
	public final long getStart() {
		return start;
	}

	/**
	 * 
	 * @param start
	 */
	public final void setStart(long start) {
		this.start = start;
		addAttribute("start",String.valueOf(start)) ;
	}

	/**
	 * 
	 * @return
	 */
	public final Type getType() {
		return type;
	} 
	/**
	 * @param type
	 */
	public final void setType(Type type) {
		this.type = type; 
		addAttribute("type",type.toString()) ;
	}
	
	
	 
	public void addLi(String text){
		addDomElement(new Li(text));
	}
	 
	public void addLi(String text , String domClass){
		addDomElement(new Li(text,domClass));
	}
	
	
	@Override
	public String toString(){ 
		return super.toString();  
	}
	
	
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && (!element.isOfType(Li.class) && !element.isOfType(Script.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
}

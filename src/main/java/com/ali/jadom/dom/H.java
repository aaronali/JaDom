package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.HeadingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 
@Tag(value={"h"})
public class H extends DOMelement implements HeadingContent, PalpableContent, FlowingContent{
 
	private static final long serialVersionUID = -3432994602955503448L;
	private int headerSize;

	public H(int headerSize){
		super(tag(H.class));
		this.headerSize = headerSize;
	}
	

	/**
	 * 
	 * @param headerSize
	 * @param headerText
	 */
	public H(int headerSize, String headerText){
		super(tag(H.class)+headerSize,headerText);
		this.headerSize = headerSize;
	}
	
	/**
	 * 
	 * @param headerSize
	 * @param headerText
	 * @param domClass
	 */
	public H(int headerSize, String headerText, DOMclass domClass) {
		super(tag(H.class)+headerSize,headerText);
		this.headerSize = headerSize;
		this.addAttribute(DOMclass.class.getSimpleName().toLowerCase(), domClass.name);
	}
	
	/**
	 * 
	 * @param headerSize
	 * @param headerText
	 * @param id
	 * @param domClass
	 * @param jsCallOut
	 */
	public H(int headerSize, String headerText, String id, String domClass, String jsCallOut){
		super(tag(H.class)+headerSize,headerText, id,   domClass,   null, jsCallOut); 
		this.headerSize = headerSize;
	}
	
	/**
	 * 
	 * @param headerSize
	 * @param headerText
	 * @param id
	 * @param domenum
	 * @param jsCallOut
	 */
	public H(int headerSize, String headerText, String id, Enum<?> domenum, String jsCallOut){
		super(tag(H.class)+headerSize,headerText, id,   domenum.toString(),   null, jsCallOut); 
		this.headerSize = headerSize;
	}
	
	
	public H(int headerSize, String headerText, HashMap<String, String> attributes) {
		super(tag(H.class)+headerSize,headerText, attributes);
		this.headerSize = headerSize;
	}
	
	public synchronized final int getHeaderSize() {
		return headerSize;
	}
	
	public synchronized final void setHeaderSize(int headerSize) {
		this.headerSize = headerSize;
		this.tag = tag(H.class)+headerSize;
	}
	 
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&( !element.isOfType(PhrasingContent.class)))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){
		return super.toString(); 
	}
	
	@Override
	public String getBasicOpenTag() {
		return String.format(ApplicationManager.BASIC_OPEN_TAG,this.getClass().getSimpleName().toLowerCase()).concat(String.valueOf(this.headerSize));
	}
	
	
	@Override
	public String getBasicCloseTag() {
		return "</".concat(this.getClass().getSimpleName().toLowerCase()).concat(String.valueOf(this.headerSize)).concat(">");
	}
	
	
}
//
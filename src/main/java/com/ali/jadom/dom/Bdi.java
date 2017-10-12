package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 

/**
 * Creates a html &ltbdi&gt tag for Bi-Directional text
 * @author aaronali
 *
 */
@Tag("bdi")
public class Bdi extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent{
    
	private static final long serialVersionUID = 4147795980858478029L;
	/** Text direction **/
	protected DirectionEnum textDirection = DirectionEnum.LTR;
	
	/**
	 * Creates an emoty &ltbdi&gt tag
	 * @param bdi Bdi
	 */
	public Bdi(Bdi bdi){
		super(bdi);
		this.textDirection = bdi.textDirection;
	}
	
	/**
	 * Creates a &ltbdu&gt tag with the given direction 
	 * @see DirectionEnum
	 * @param textDirection Direction
	 */
	public Bdi( DirectionEnum textDirection) {
		super(tag(Bdi.class));
		this.textDirection = textDirection; 
		this.addAttribute("textDirection", textDirection.toString());
	}
	 
	/**
	 * Creates a &ltbdu&gt tag with the given direction and the given text
	 * @see DirectionEnum
	 * @param textDirection Direction
	 */
	public Bdi( DirectionEnum textDirection,String bdiHTML) {
		super(tag(Bdi.class), bdiHTML);
		this.textDirection = textDirection; 
		this.addAttribute("textDirection", textDirection.toString());
	}

	/**
	 * 
	 * Creates a &ltbdu&gt tag with the given direction and the given text
	 * @see DirectionEnum
	 * @param textDirection Direction 
	 * @param bdiHTML String
	 * @param attributes hashMap&ltString,String&gt
	 */
	public Bdi( DirectionEnum textDirection,String bdiHTML, HashMap<String, String> attributes) {
		super(tag(Bdi.class), bdiHTML, attributes); 
		this.textDirection = textDirection;
		this.addAttribute("dir", textDirection.toString() );
		
	}

	/*** 
	 * Creates a &ltbdu&gt tag with the given direction and the given text and attributes
	 * @param textDirection String
	 * @param id String or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param domClass String or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param Styles String or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @param jsCallout String or null or ApplicationManager.FORCE_NO_ATTRIBUTE
	 * @see DirectionEnum
	 */
	public Bdi( DirectionEnum textDirection,  String id, String domClass, String Styles, String jsCallout) {
		super(tag(Bdi.class),"", (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.textDirection =textDirection;  
		this.addAttribute("textDirection", textDirection.toString());
	}

	/**
	 * Gets the text direction of the current Bdi object
	 * @return String
	 */
	public final DirectionEnum getTextDirection() {
		return textDirection;
	} 

	/**
	 * Flips the direction of the current text
	 */
	public void switchTextDirection(){
		if(this.textDirection==DirectionEnum.LTR)
			setTextDirection(DirectionEnum.RTL);
		else
			setTextDirection(DirectionEnum.LTR);
	}
	
	/**
	 * Sets the direction of the current bdi text
	 * @param textDirection Direction
	 * @see DirectionEnum
	 */
	public final void setTextDirection(DirectionEnum textDirection) {
		this.textDirection = textDirection;
		if(textDirection!=null)
			addAttribute("textDirection",textDirection.toString());
		else
			removeAttribute("textDirection");
	}
 
 
  

	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString(); 
	}
	 
	
}  

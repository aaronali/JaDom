package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
 
/**
 * A html5 bi-directional &ltbdo&gt text object for displaying text forward or backwards
 * @author aaronali
 *
 */
@Tag("bdo")
public class Bdo extends DOMelement implements PalpableContent, FlowingContent, PhrasingContent {
   
	private static final long serialVersionUID = -6717619716028415233L;
	/**
	 * Direction of the text
	 */
	protected DirectionEnum textDirection = DirectionEnum.LTR;
	
	/**
	 * Creates an empty &ltbdo&gt tag
	 */
	public Bdo(){
		super(tag(Bdo.class)); 
	}
	
	/**
	 * Creates  a  &ltbdo&gt tag with he same attributes as the given element.
	 * @param bdo
	 */
	public Bdo(Bdo bdo){
		super(tag(Bdo.class));
		this.textDirection = bdo.textDirection;
	}
	
	/**
	 * Creates an empty &ltbdo&gt tag in the given direction
	 * @param textDirection
	 */
	public Bdo( DirectionEnum textDirection) {
		super(tag(Bdo.class));
		this.textDirection = textDirection; 
		this.addAttribute("textDirection", textDirection.toString());
	}
	
	/**
	 * Creates  a  &ltbdo&gt tag in the given direction with the given text
	 * @param textDirection Direction
	 * @param bdoHTML String
	 */
	public Bdo( DirectionEnum textDirection,String bdoHTML) {
		super(tag(Bdo.class), bdoHTML);
		this.textDirection = textDirection; 
		this.addAttribute("textDirection", textDirection.toString());
	}

	/**
	 * Creates  a  &ltbdo&gt tag in the given direction with the given text and given attributes 
	 * @param textDirection Direction
	 * @param bdoHTML String
	 * @param attributes HasMap&ltString,String&gt
	 */
	public Bdo( DirectionEnum textDirection,String bdoHTML, HashMap<String, String> attributes) {
		super(tag(Bdo.class), bdoHTML, attributes); 
		this.textDirection = textDirection;
		this.addAttribute("dir", textDirection.toString() ); 
	}
	  

	/**
	 * Creates  a empty  &ltbdo&gt tag in the given direction with the given attributes 
	 * @param textDirection Direction
	 * @param id String or Null or ApplicationManager.NULL_NODE_VALUE
	 * @param domClass String or Null or ApplicationManager.NULL_NODE_VALUE
	 * @param Styles String or Null or ApplicationManager.NULL_NODE_VALUE
	 * @param jsCallout String or Null or ApplicationManager.NULL_NODE_VALUE
	 */
	public Bdo( DirectionEnum textDirection, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Bdo.class), "", (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.textDirection =textDirection;  
		this.addAttribute("textDirection", textDirection.toString());
	}

	/**
	 * Creates  a  &ltbdo&gt tag in the given direction with the given text and given attributes 
	 * @param textDirection Direction
	 * @param bdoHTML String
	 * @param id String or Null or ApplicationManager.NULL_NODE_VALUE
	 * @param domClass String or Null or ApplicationManager.NULL_NODE_VALUE
	 * @param Styles String or Null or ApplicationManager.NULL_NODE_VALUE
	 * @param jsCallout String or Null or ApplicationManager.NULL_NODE_VALUE
	 */
	public Bdo( DirectionEnum textDirection,String bdoHTML, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Bdo.class), bdoHTML, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		this.textDirection =textDirection;  
		this.addAttribute("textDirection", textDirection.toString());
	}
	 
	/**
	 * Gets the current text direction
	 * @return Direction
	 * @see com.ali.jadom.dom.DirectionEnum
	 */
	public final DirectionEnum gettextDirection() {
		return textDirection;
	}

	/**
	 * Sets the current text direction
	 * @param textDirection Direction
	 */
	public final void setTextDirection(DirectionEnum textDirection) {
		this.textDirection = textDirection;
		if(textDirection!=null)
			addAttribute("textDirection",textDirection.toString());
		else
			removeAttribute("textDirection");
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

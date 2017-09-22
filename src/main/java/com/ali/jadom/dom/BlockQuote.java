package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
 /**
  * A Html5 &ltblockquote&gt tag for text quoted from a given source. Any citations should be within the cite value
  * @author aaronali
  *
  */
@Tag("blockquote")
public class BlockQuote extends DOMelement implements PalpableContent, FlowingContent, PhrasingContent{
  
	private static final long serialVersionUID = -7653628494165592519L;
	/** citation of quote source */
	protected String cite; 
	
	/**
	 * Creates an empty &ltblockquote&gt
	 */
	public BlockQuote(){
		super(tag(BlockQuote.class));
		this.cite="";    
	}	
	
	/**
	 * Creats a &ltblockquote&gt witht he same properties as the given element
	 * @param blockQuote BlockQuote
	 */
	public BlockQuote(BlockQuote blockQuote){
		super(blockQuote);
		this.cite = blockQuote.cite;
	}
	
	/**
	 * Creates a &ltblockquote&gt witht the given html embedded
	 * @param htmlCode String
	 */
	public BlockQuote(String htmlCode){
		super(tag(BlockQuote.class), htmlCode);
		this.cite="";    
	}
	
	/**
	 * Creates a &lyblockquote&gt with the given html code embedded and the given citation.
	 * @param htmlCode
	 * @param cite
	 */
	public BlockQuote(String htmlCode, String cite){
		super(tag(BlockQuote.class), htmlCode);
		this.cite=cite;  
		this.addAttribute("cite",  cite);
	}
	   
	/**
	 * Creates a &lyblockquote&gt with the given text , citation and attributes
	 * @param htmlCode String
	 * @param cite String or null
	 * @param attributes HashMap&ltString,String&gt
	 */
	public BlockQuote( String htmlCode,String cite, HashMap<String, String> attributes) {
		super("blockquote", htmlCode, attributes); 
		this.cite = cite; 
		if(cite!=null){
			this.addAttribute("cite",  cite); 
			this.cite =cite;
		}
	}

	/**
	 * Creates a &lyblockquote&gt with the given text , citation and attributes
	 * @param htmlCode String
	 * @param cite String or null
	 * @param id String or null
	 * @param domClass String or null
	 * @param Styles String or null
	 * @param jsCallout String or null
	 */
	public BlockQuote(String htmlCode, String cite, String id, String domClass, String Styles, String jsCallout) {
		super(tag(BlockQuote.class), htmlCode, (id!=null)?id:ApplicationManager.getNextId(), domClass, Styles, jsCallout); 
		if(cite!=null){
			this.cite =cite; 
			this.attributes.put("cite", cite);
		}
	}

	/**
	 * Gets the current cite value
	 * @return String
	 */
	public  final String getCite() {
		return cite;
	}

	/**
	 * Sets the current cite value. Removes the cite if the value is null.
	 * @param cite or null
	 */
	public  final void setCite(String cite) {
		this.cite = cite; 
		if(cite!=null)
			this.addAttribute("cite",  cite);
		else this.removeAttribute("cite");
	}

	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(FlowingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	}
	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	
}  

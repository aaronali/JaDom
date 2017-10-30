package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PhrasingContent; 
 

@Tag("area")
public class Area extends DOMelement implements PhrasingContent, FlowingContent{
   
	public static final long serialVersionUID = 6340721450509436444L;
	protected String  alt;
	protected Coord  coords;
	protected ShapeEnum shape;
	protected String href;
	protected String download;
	protected String rel;
	  
	/**
	 * 
	 * @param alternateText
	 * @param coords
	 * @param shape
	 * @param href
	 * @param download
	 * @param rel
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Area(String alternateText, Coord  coords, ShapeEnum shape, String href, 	String download, String rel,  String id, String domClass, String Styles, String jsCallout) {
		super(tag(Area.class), "nullnodevalue", id, domClass, Styles, jsCallout); 
		if(alternateText!=null){
			this.alt = alternateText ;
			addAttribute("alt", alternateText);
		}
		this.coords = coords;
		addAttribute("shape",coords.toString());
		this.shape = shape;
		addAttribute("shape",shape.toString());
		this.href = href;
		if (href!=null)
			if(!ApplicationManager.AREA_ANCHOR_USE_LINK_MANAGER) 
				addAttribute("href",href) ;
			else
				addAttribute("href","Link?page="+href );
		this.download = download;
		if(download!=null){
			addAttribute("download", download);
		}
		
		this.rel = rel;
		if(rel!=null)
			addAttribute("rel",rel);
	}

	/**
	 * 
	 * @param coords
	 * @param attributes
	 */
	public Area(Coord coords, HashMap<String, String> attributes) {
		super(tag(Area.class), "nullnodevalue", attributes);  
		this.coords = coords;
		this.addAttribute("coords", coords.toString());
		if(this.getAttributes().get("shape")==null){
			this.shape =ShapeEnum.DEFAULT;
			addAttribute("shape", this.shape.toString());
		}else{ 
			this.shape =Enum.valueOf(ShapeEnum.class,attributes.get("shape"));
			addAttribute("shape", this.shape.toString());
		}
		if(attributes!=null){
			if(attributes.get("alt")!=null){
				this.alt = attributes.get("alt") ; 
			}
			if(attributes.get("href")!=null){
				this.alt = attributes.get("href") ; 
			}
			if(attributes.get("rel")!=null){
				this.alt = attributes.get("rel") ; 
			}
			if(attributes.get("download")!=null){
				this.alt = attributes.get("download") ; 
			}
		}
	}

	/**
	 * 
	 */
	public Area() { 
		super(tag(Area.class), "nullnodevalue");
		this.coords = new Coord();
		this.shape = ShapeEnum.DEFAULT;
		addAttribute("shape", this.shape.toString());
	}

	/**
	 * 
	 * @param coords
	 * @param alternateText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Area(Coord  coords, String alternateText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Area.class), "nullnodevalue", id, domClass, Styles, jsCallout); 
		this.coords=coords;
		if(alternateText!=null){
			this.alt = alternateText ;
			addAttribute("alt", alternateText);
		}
	}
	
	
	
	/**
	 * Gets the areas alternate text
	 * @return String
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * Sets the areas alternate text
	 * @param alt String
	 */
	public void setAlt(String alt) {
		this.alt = alt;
		if(!alt.equals(null))
			addAttribute("alt", alt);
		else removeAttribute("alt");
 
	}
	
	/**
	 * Gets the areas coordinates
	 * @return Coord
	 * @see com.ali.jadom.dom.Coord
	 */
	public Coord getCoords() {
		return coords;
	}

	/**
	 * Sets the areas coordinates
	 * @param coords Coord
	 * @see com.ali.jadom.dom.Coord
	 */
	public void setCoords(Coord coords) {
		this.coords = coords; 
		if(coords!=null)
			addAttribute("coords", coords.toString());
		else removeAttribute("coords");
	}

	/**
	 * Gets the current shape of the area
	 * @return Shape
	 * @see com.ali.jadom.dom.ShapeEnum
	 */
	public ShapeEnum getShape() {
		return shape;
	}

	/**
	 * Sets the current shape of the area
	 * @param shape Shape
	 * @see com.ali.jadom.dom.ShapeEnum
	 */
	public void setShape(ShapeEnum shape) {
		this.shape = shape;
		if(shape!=null)
			addAttribute("shape", shape.toString());
		else removeAttribute("shape");
	}

	/**
	 * Gets the current Areas href value
	 * @return
	 */
	public String getHref() {
		return href;
	}

	/**
	 * Sets the current areas hrefValue
	 * @return
	 */
	public void setHref(String href) {
		this.href = href;
		if(href!=null)
			addAttribute("href", href.toString());
		else removeAttribute("href");
	}

	/**
	 * Gets the current areas download value
	 * @return
	 */
	public String getDownload() {
		return download;
	}

	/**
	 * Sets the current areas download value
	 * @param download
	 */
	public void setDownload(String download) {
		this.download = download;
		if(download!=null)
			addAttribute("download", download.toString());
		else removeAttribute("download");
	}

	/**
	 * Gets the current Areas rel value
	 * @return
	 */
	public String getRel() {
		return rel;
	}

	/**
	 * Sets the current areas rel value
	 * @param rel
	 */
	public void setRel(String rel) {
		this.rel = rel;
		if(rel!=null)
			addAttribute("rel", rel.toString());
		else removeAttribute("rel");
	}

	 

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE){
			throw new RuntimeException(this.getClass().getCanonicalName() + " cannot have a child element of any type anf maintain Compliance. Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override");
		}
		return super.addDomElement(element);
	}
	
}

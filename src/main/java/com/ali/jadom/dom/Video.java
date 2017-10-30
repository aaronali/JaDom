package com.ali.jadom.dom;
 
 

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("video")
public class Video extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent, EmbeddedContent, InteractiveContent{
  
	 
	private static final long serialVersionUID = -5178170859535121846L;

	
	protected String src;
	protected String crossorgin;
	protected String poster;
    protected String preload;
    protected String autoplay; 
    public int width ;
    public int height  ;
	
	public Video(){
		super(tag(Video.class));
	}
	/**
	 * 
	 * @param element
	 */
	public Video(IDOMelement element){ 
		this(((Video)element).src, ((Video)element).crossorgin,  ((Video)element).poster,  ((Video)element).preload ,  ((Video)element).autoplay,
				  ((Video)element).width,   ((Video)element).height);
	}
	
	 
	public Video(String src, String crossorgin, String poster, String preload , String autoplay ,
			 int width, int height) {
		super(tag(Video.class));
		this.src = src;
		addAttribute("src", src);
		this.crossorgin = crossorgin;
		if(crossorgin!=null) addAttribute("crossorgin", crossorgin);
		this.poster = poster;
		if(poster!=null) addAttribute("poster", poster);
		this.preload = preload;
		if(preload!=null) addAttribute("preload", preload);
		this.autoplay=autoplay;
		if(autoplay!=null)  addAttribute("autoplay", crossorgin);
		this.width = width;
		if(width>=0) 
			addAttribute("width", width);
		this.height = height;
		if(height>=0)
			addAttribute("height", height);
	}
	
	
 
	/**
	 * 
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Video( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Video.class), "", id, domClass, Styles, jsCallout); 
	}
	/**
	 * 
	 * @return
	 */ 
	public synchronized final String getPreload() {
		return preload;
	}
	/**
	 * 
	 * @param preload
	 */
	public synchronized final void setPreload(String preload) {
		this.preload = preload; 
		if(src!=null) addAttribute("preload", preload);
		else removeAttribute("preload");
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final String getSrc() {
		return src;
	}

	/**
	 * 
	 * @param src
	 */
	public synchronized final void setSrc(String src) {
		this.src = src;
		if(src!=null) addAttribute("src", src);
		else removeAttribute("src");
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final String getCrossorgin() {
		return crossorgin;
	}
	/**
	 * 
	 * @param crossorgin
	 */
	public synchronized final void setCrossorgin(String crossorgin) {
		this.crossorgin = crossorgin;
		if(crossorgin!=null) addAttribute("crossorgin", crossorgin);
		else removeAttribute("crossorgin");
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final String getPoster() {
		return poster;
	} 
	/**
	 * 
	 * @param poster
	 */
	public synchronized final void setPoster(String poster) {
		this.poster = poster;
		if(poster!=null) addAttribute("poster", poster);
		else removeAttribute("poster");
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final  String  getAutoplay() {
		return autoplay;
	} 
	/**
	 * 
	 * @param sandbox
	 */
	public synchronized final void setAutoplay(String autoplay ) {
		this.autoplay = autoplay;
		if(autoplay==null)
			removeAttribute("autoplay");
		else{ 
			addAttribute("autoplay",autoplay);
		}
	}
	 
	 
	 
	/**
	 * 
	 * @return
	 */
	public synchronized final int getWidth() {
		return width;
	}
	/**
	 * 
	 * @param width
	 */
	public synchronized final void setWidth(int width) {
		this.width = width;
		if(width<0)
			removeAttribute("width");
		else addAttribute("width",width);
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final int getHeight() {
		return height;
	} 
	/**
	 * 
	 * @param height
	 */
	public synchronized final void setHeight(int height) {
		this.height = height;
		if(height<0)
			removeAttribute("height");
		else addAttribute("height",height);
	} 
	/**
	 * 
	 * @return
	 */
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE){
			if(getAttribute("src")==null &&(!this.contains(Source.class) && !element.isOfType(Source.class)))
				throw new RuntimeException(this.getClass().getCanonicalName().concat(" must have a ").concat(Source.class.getCanonicalName())
					.concat(" before adding ").concat(element.getClass().getCanonicalName()));
			if(getAttribute("src")!=null && !element.isOfType(Track.class)) 
				throw new RuntimeException("You can only add ".concat(Track.class.getCanonicalName().concat(" to ").concat(this.getClass().getCanonicalName().concat("  after the src attribute is set"))));
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child element of type ").concat(element.getClass().getCanonicalName()));
		}
		return super.addDomElement(element);
	}
	
}

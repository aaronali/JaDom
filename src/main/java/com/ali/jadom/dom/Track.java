package com.ali.jadom.dom;

public abstract class Track extends DOMelement {
	 
	private static final long serialVersionUID = -2675598578034021285L;
	public enum States{
		  NONE,
		  LOADING,
		  LOADED,
		  ERROR;
	}
	public enum Kind{
		subtitles,
		captions,
		descriptions,
		chapters,
		metadata
	}
	
	protected Kind kind;
	protected String src;
	protected String srclang;
	protected String label;
	protected boolean default_;
	/**
	 * 
	 * @param kind
	 * @param src
	 * @param srclang
	 * @param label
	 * @param default_
	 */
	public Track(Kind kind, String src, String srclang, String label, boolean default_) {
		super(tag(Track.class),ApplicationManager.NULL_NODE_VALUE);
		this.kind = kind;
		if(kind!=null)
			addAttribute("kind", kind.toString());
		this.src = src;
			addAttribute("src",src);
		this.srclang = srclang;
		if(srclang!=null)
			addAttribute("srclang", srclang);
		this.label = label;
		if(label!=null)
			addAttribute("label", label);
		this.default_ = default_; 
		addAttribute("default", default_);
	}
	
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE){ 
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not alloeed to have the child elements \n Set ApplicationManager.FORCE_HTML_COMPLIANCE to Override"));
		}
		return super.addDomElement(element);
	}
	
}

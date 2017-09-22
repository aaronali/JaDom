package com.ali.jadom.dom;

@Tag("param")
public class Param extends DOMelement{
 
	private static final long serialVersionUID = -38065362806783367L;
	protected String name;
	protected String value;
	
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public Param(String name, String value){
		 super(tag(Param.class),ApplicationManager.NULL_NODE_VALUE);
		 this.name=name;
		 addAttribute("name",name);
		 this.value=value;
		 addAttribute("value",value);
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public synchronized final void setName(String name) {
		this.name = name;
		if(name!=null)addAttribute("name",name);
		else removeAttribute("name");
	}
	/**
	 * 
	 * @return
	 */
	public synchronized final String getValue() {
		return value;
	}
	/**
	 * 
	 * @param value
	 */
	public synchronized final void setValue(String value) {
		this.value = value;
		if(value!=null)addAttribute("value",value);
		else removeAttribute("value");
	}




	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE)
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not  allowed to have the child elements.\n Set ApplicationManager.FORCE_HTML_COMPLIANCE  to override"));
		return super.addDomElement(element);
	}
}

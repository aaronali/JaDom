package com.ali.jadom.dom;
 

import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("iframe")
public class Iframe extends DOMelement implements FlowingContent, PalpableContent, PhrasingContent, EmbeddedContent, InteractiveContent{
 
	public enum SecurityRule {
		allowForms,
		allowModals,
		allowPointerLock, 
		allowPopups, 
		allowPopupsToEscapeSandbox, 
		allowSameOrigin, 
		allowScripts, 
		allowTopNavigation;
		@Override
		public String toString(){
			String s ="";
			for(int i=0;i<name().length();i++){ 
				if(Character.isLowerCase(name().charAt(i))){
					s =s.concat(String.valueOf(name().charAt(i)));
				}else{
					s=s.concat("_").concat((String.valueOf(name().charAt(i))).toLowerCase());
				}
			}
				
			return s.trim();
		}
		
	}
	 
	private static final long serialVersionUID = -5178170859535121846L;

	
	protected String src;
	protected String srcdoc;
	protected String name;
    protected SecurityRule[] sandbox;
    public boolean seamless = false;
    public boolean allowfullscreen;
    public int width ;
    public int height  ;
	
	public Iframe(){
		super(tag(Iframe.class));
	}
	/**
	 * 
	 * @param element
	 */
	public Iframe(IDOMelement element){ 
		this(((Iframe)element).src, ((Iframe)element).srcdoc,  ((Iframe)element).name,  ((Iframe)element).sandbox ,  ((Iframe)element).seamless,
				((Iframe)element).allowfullscreen,  ((Iframe)element).width,   ((Iframe)element).height);
	}
	
	/**
	 * 
	 * @param src
	 * @param srcdoc
	 * @param name
	 * @param sandbox
	 * @param seamless
	 * @param allowfullscreen
	 * @param width
	 * @param height
	 */
	public Iframe(String src, String srcdoc, String name, SecurityRule sandbox[], boolean seamless,
			boolean allowfullscreen, int width, int height) {
		super(tag(Iframe.class));
		this.src = src;
		addAttribute("src", src);
		this.srcdoc = srcdoc;
		if(srcdoc!=null) addAttribute("srcdoc", srcdoc);
		this.name = name;
		if(name!=null) addAttribute("name", name);
		this.sandbox = sandbox;
		if(sandbox!=null){
			String sandBox="";
			for(int i =0;i<sandbox.length;i++){
				sandBox = sandBox.concat(sandbox[i].toString()); 
			}
			addAttribute("sandbox",sandBox); 
		}
		
		this.seamless = seamless;
		addAttribute("seamless",seamless); 
		if(srcdoc!=null) 
			addAttribute("srcdoc", srcdoc);
		this.allowfullscreen = allowfullscreen;
		if(allowfullscreen)
			addAttribute("jsCallout", "allowfullscreen");
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
	public Iframe( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Iframe.class), "", id, domClass, Styles, jsCallout); 
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
	public synchronized final String getSrcdoc() {
		return srcdoc;
	}
	/**
	 * 
	 * @param srcdoc
	 */
	public synchronized final void setSrcdoc(String srcdoc) {
		this.srcdoc = srcdoc;
		if(srcdoc!=null) addAttribute("srcdoc", srcdoc);
		else removeAttribute("srcdoc");
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
		if(name!=null) addAttribute("name", name);
		else removeAttribute("name");
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final SecurityRule[] getSandbox() {
		return sandbox;
	} 
	/**
	 * 
	 * @param sandbox
	 */
	public synchronized final void setSandbox(SecurityRule[] sandbox) {
		this.sandbox = sandbox;
		if(sandbox==null || sandbox.length==0)
			removeAttribute("sandbox");
		else{
			for(int i =0; i< sandbox.length;i++)
				addAttribute("sandbox",sandbox[i].toString());
		}
	}
	/**
	 * 
	 * @param sandBoxRule
	 */
	public void addSandboxRule(SecurityRule sandBoxRule){
		if(this.sandbox==null) sandbox= new SecurityRule[0];
		 
		SecurityRule[] temp = new SecurityRule[sandbox.length];
		System.arraycopy(sandbox, 0, temp, 0, sandbox.length);
		sandbox = new SecurityRule[temp.length+1];
		System.arraycopy(temp, 0, sandbox, 0, temp.length);
		sandbox[sandbox.length-1]=sandBoxRule;
		
		} 
	
	/**
	 * 
	 * @return
	 */
	public synchronized final boolean isSeamless() {
		return seamless;
	} 
	/**
	 * 
	 * @param seamless
	 */
	public synchronized final void setSeamless(boolean seamless) {
		this.seamless = seamless;
		addAttribute("seamless",seamless);
	} 
	/**
	 * 
	 * @return
	 */
	public synchronized final boolean isAllowfullscreen() {
		return allowfullscreen;
	} 
	/**
	 * 
	 * @param allowfullscreen
	 */
	public synchronized final void setAllowfullscreen(boolean allowfullscreen) {
		this.allowfullscreen = allowfullscreen;
		if(allowfullscreen)
			addAttribute("jsCallOut", "allowfullscreen");
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


   
}

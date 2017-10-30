package com.ali.jadom.dom;
 
import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent; 

/**
 *            attribute DOMString acceptCharset;
           attribute DOMString action;
           attribute DOMString autocomplete;
           attribute DOMString enctype;
           attribute DOMString encoding;
           attribute DOMString method;
           attribute DOMString name;
           attribute boolean noValidate;
           attribute DOMString target;

  readonly attribute HTMLFormControlsCollection elements;
  readonly attribute long length;
  caller getter any (in unsigned long index);
  caller getter any (in DOMString name);

  void submit();
  void reset();
  boolean checkValidity();
 * @author AARONAli
 *
 */
@Tag("form")
public class Form extends DOMelement implements FlowingContent {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -3622352684651507677L; 
	protected String acceptCharset;
	protected String action;
	protected String autocomplete;
	protected EncTypeEnum enctype;
	protected String encoding;
	protected MethodEnum method;
	protected String name;
	protected String noValidate;
	protected String target;
	protected long length;
/*

void submit();
void reset();
boolean checkValidity();*/
	
	public Form(){ 
		super(tag(Form.class)); 
	}
	
	public Form( String name,String action) {
		super(tag(Form.class)); 
		this.action=action;
		this.addAttribute("action", action);
	}
	
	public Form( String insHTML, String action, String domClass, String Styles, String jsCallout) {
		super(tag(Form.class), ApplicationManager.NULL_NODE_VALUE, null, domClass, Styles, jsCallout); 
		this.addAttribute("action", action);
	}
	   

	@Override
	public String toString(){ 
		return super.toString();  
	}
	 

	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE &&  !element.isOfType(FlowingContent.class)){ 
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		}
		return super.addDomElement(element);
	}
	
}

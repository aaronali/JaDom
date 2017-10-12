package com.ali.jadom.dom;
 

import com.ali.jadom.dom.superelements.EmbeddedContent;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.FormAssociated;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.Labelable;
import com.ali.jadom.dom.superelements.Listed;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
import com.ali.jadom.dom.superelements.Reasscociateable;
import com.ali.jadom.dom.superelements.Submittable;

/**
 * attribute boolean autofocus;
           attribute boolean disabled;
  readonly attribute HTMLFormElement form;
           attribute DOMString formAction;
           attribute DOMString formEnctype;
           attribute DOMString formMethod;
           attribute DOMString formNoValidate;
           attribute DOMString formTarget;
           attribute DOMString name;
           attribute DOMString type;
           attribute DOMString value;

  readonly attribute boolean willValidate;
  readonly attribute ValidityState validity;
  readonly attribute DOMString validationMessage;
  boolean checkValidity();
  void setCustomValidity(in DOMString error);

  readonly attribute NodeList labels; 
 
 * @author AARONAli
 *
 */
@Tag("button")
public class Button extends DOMelement implements FlowingContent, PhrasingContent, Labelable, InteractiveContent, Listed,Submittable,  FormAssociated{
    
	private static final long serialVersionUID = 6780387456838359054L;
	protected boolean disabled;
	 protected DOMelement form; 
	 protected String formAction;
	 protected String formEnctype;
	 protected String formMethod;
	 protected String formNoValidate;
	 protected String formTarget;  
	 protected String value; 
	protected ButtonTypeEnum type = ButtonTypeEnum.submit;  
	protected String name; 
	protected boolean willValidate;
	protected ValidityStateEnum validity = null;
	protected String validationMessage;
//	  boolean checkValidity();
	//  void setCustomValidity(in DOMString error);
 
	public Button(){
		super(tag(Button.class));
	}
	/**
	 * 
	 * @param element
	 */
	public Button(IDOMelement element){ 
		this(((Button)element).nodename, ((Button)element).disabled, ((Button)element).form,((Button)element).formAction,((Button)element).formEnctype,
				((Button)element).formMethod,((Button)element).formNoValidate,   ((Button)element).formTarget , ((Button)element).value,((Button)element).type,((Button)element).name,
				((Button)element).willValidate,((Button)element).validity,((Button)element).validationMessage);
	}
	
 
 
	public Button(String nodeName, boolean disabled, DOMelement form, String formAction, String formEnctype,
			String formMethod, String formNoValidate, String formTarget, String value, ButtonTypeEnum type, String name,
			boolean willValidate, ValidityStateEnum validity, String validationMessage) {
		super(nodeName);
		this.disabled = disabled;
		this.form = form;
		this.formAction = formAction;
		this.formEnctype = formEnctype;
		this.formMethod = formMethod;
		this.formNoValidate = formNoValidate;
		this.formTarget = formTarget;
		this.value = value;
		this.type = type;
		this.name = name;
		this.willValidate = willValidate;
		this.validity = validity;
		this.validationMessage = validationMessage;
	}
	/**
	 * 
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Button( String id, String domClass, String Styles, String jsCallout) {
		super(tag(Button.class), "", id, domClass, Styles, jsCallout); 
	}
 
 
	 
 
	 
	 
	public synchronized final String getName() {
		return name;
	}
	
	public synchronized final void setName(String name) {
		this.name = name;
		if(name!=null)
			addAttribute("name",name);
		else removeAttribute("name");
	} 
	
	
	public synchronized final Form getForm() {
		return (Form)form;
	}
	public synchronized final void setForm(DOMelement form) {
		this.form = form; 
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
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(Param.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is only  allowed to have the child elements of type ".concat(Param.class.getCanonicalName()).concat(".\n Set ApplicationManager.FORCE_HTML_COMPLIANCE  to override")));
		return super.addDomElement(element);
	}
	
}

package com.ali.jadom.dom;
 

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.Hidden;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.FormAssociated;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.Labelable;
import com.ali.jadom.dom.superelements.Listed; 
import com.ali.jadom.dom.superelements.PhrasingContent; 
import com.ali.jadom.dom.superelements.Submittable;

/**HTML Button tag
 * @author Aaron Ali
 * 
 */
@Tag("button")
public class Button extends DOMelement implements FlowingContent, PhrasingContent, Labelable, InteractiveContent, Listed,Submittable,  FormAssociated{
     
	private static final long serialVersionUID = 72031289195983746L;
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
	@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
	protected boolean willValidate;
	protected ValidityStateEnum validity = null;
	protected String validationMessage;
//	  boolean checkValidity();
	//  void setCustomValidity(in DOMString error);
 
	/**
	 * Creates an empty button tag
	 */
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
	public Button( String id, String domClass, String Styles, String jsCallout,ButtonTypeEnum type) {
		super(tag(Button.class),ApplicationManager.STRING_EMPTY, id, domClass, Styles, jsCallout); 
		this.setType(type);
	}
  
	 
	public Button(ButtonTypeEnum type) {
		super(tag(Button.class),ApplicationManager.STRING_EMPTY);
		this.setType(type);
	
	}
	public synchronized final String getName() {
		return name;
	}
	
	public synchronized final void setName(String name) {
		this.name = name;
		if(name!=null)
			addAttribute(ApplicationManager.STRING_NAME,name);
		else removeAttribute(ApplicationManager.STRING_NAME);
	} 
	
	
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		
	}
	public String getFormAction() {
		return formAction;
	}
	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}
	public String getFormEnctype() {
		return formEnctype;
	}
	public void setFormEnctype(String formEnctype) {
		this.formEnctype = formEnctype;
	}
	public String getFormMethod() {
		return formMethod;
	}
	public void setFormMethod(String formMethod) {
		this.formMethod = formMethod;
	}
	public String getFormNoValidate() {
		return formNoValidate;
	}
	public void setFormNoValidate(String formNoValidate) {
		this.formNoValidate = formNoValidate;
	}
	public String getFormTarget() {
		return formTarget;
	}
	public void setFormTarget(String formTarget) {
		this.formTarget = formTarget;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ButtonTypeEnum getType() {
		return type;
	}
	public void setType(ButtonTypeEnum type) {
		this.type = type;
	}
	public boolean isWillValidate() {
		return willValidate;
	}
	public void setWillValidate(boolean willValidate) {
		this.willValidate = willValidate;
	}
	public ValidityStateEnum getValidity() {
		return validity;
	}
	public void setValidity(ValidityStateEnum validity) {
		this.validity = validity;
	}
	public String getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
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
			super.throwComplianceError(this, element);
		return super.addDomElement(element);
	}
	
}

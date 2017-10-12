package com.ali.jadom.dom;

import java.util.HashMap;

import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.FormContent;
import com.ali.jadom.dom.superelements.InteractiveContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;
import com.ali.jadom.dom.superelements.Reasscociateable;

@Tag("label")
public class Label extends DOMelement implements FlowingContent, PhrasingContent, InteractiveContent, Reasscociateable, PalpableContent, FormContent {

	 
	private static final long serialVersionUID = 2975969940469073342L;
	private DOMelement form;
	private String  htmlFor;
	private DOMelement control;


	public Label() {
		super(tag(Label.class), ApplicationManager.NULL_NODE_VALUE); 
	}

	public Label( HashMap<String, String> attributes) {
		super(tag(Label.class), ApplicationManager.NULL_NODE_VALUE, attributes);  
	}

	 
	
	/**
	 * 
	 * @param captionText
	 * @param attributes
	 */
	public Label(String labelText, HashMap<String, String> attributes) {
		super(tag(Label.class), labelText, attributes);  
	}

	public DOMelement getForm() {
		return form;
	}

	public void setForm(DOMelement form) {
		this.form = form;
		this.addProperty("form",  (Object) form);
	}

	public String getHtmlFor() {
		return htmlFor; 
	}

	public void setHtmlFor(String htmlFor) {
		this.htmlFor = htmlFor;
		this.addAttribute("for",  htmlFor);
	}

	public DOMelement getControl() {
		return control;
	}

	public void setControl(DOMelement control) {
		this.control = control;
		this.addProperty("control",  (Object) control);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

package com.ali.jadom.dom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.dom.superelements.FlowingContent;
import com.ali.jadom.dom.superelements.PalpableContent;
import com.ali.jadom.dom.superelements.PhrasingContent;

@Tag("time")
public class Time extends DOMelement implements FlowingContent, PhrasingContent, PalpableContent{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5204675567771747201L;
	public String dateTime;
	
	/**
	 * 
	 * @param datetimeText
	 * @param dateTimeValue
	 */
	public Time( String datetimeText, String dateTimeValue) {
		super(tag(Time.class), datetimeText); 
		addAttribute("datetime", dateTimeValue);
		this.dateTime = dateTimeValue;
	}

	 
	/**
	 * 
	 * @param datetimeText
	 * @param attributes
	 */
	public Time(String datetimeText, HashMap<String, String> attributes) {
		super(tag(Time.class), datetimeText, attributes); 
		if(attributes.containsKey("datetime"))
			this.dateTime = getAttribute("datetime");
	}

	/**
	 * 
	 * @param datetimeText
	 * @param id
	 * @param domClass
	 * @param Styles
	 * @param jsCallout
	 */
	public Time(String datetimeText, String id, String domClass, String Styles, String jsCallout) {
		super(tag(Time.class), datetimeText, id, domClass, Styles, jsCallout); 
	}
	

	
	/**
	 * 
	 * @return
	 */
	public synchronized final String getDateTime() {
		return dateTime;
	}

	/**
	 * 
	 * @param dateTime
	 */
	public synchronized final void setDateTime(String dateTime) {
		this.dateTime = dateTime;
		if(dateTime ==null) 
			removeAttribute("datetime");
		else
			addAttribute("datetime", dateTime);
	}
	/**
	 * 
	 * @param dateTime
	 */
	public synchronized final void setDateTime(Date date) { 
		dateTime = new SimpleDateFormat(ApplicationManager.DEFAULT_DATE_TIME_PATTERN, Locale.getDefault()).format(date);
		addAttribute("datetime",dateTime);
	}
 
	/**
	 * Add the current time as value and label
	 */
	public synchronized final void setDateTimeNow() { 
		dateTime = new SimpleDateFormat(ApplicationManager.DEFAULT_DATE_TIME_PATTERN, Locale.getDefault()).format(new Date());
		addAttribute("datetime",dateTime);
		this.nodevalue=dateTime;
	}
	/**
	 * Add the current time as value with the given label
	 */
	public synchronized final void setDateTimeNow(String innerHtmml) { 
		dateTime = new SimpleDateFormat(ApplicationManager.DEFAULT_DATE_TIME_PATTERN, Locale.getDefault()).format(new Date());
		addAttribute("datetime",dateTime);
		this.nodevalue=innerHtmml;
	}

	/**
	 * 
	 * @return
	 */
	public static synchronized final long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString(){ 
		return super.toString();  
	}
	@Override
	public boolean addDomElement(DOMelement element){
		if(ApplicationManager.FORCE_HTML_COMPLIANCE && !element.isOfType(PhrasingContent.class))
			throw new RuntimeException(this.getClass().getCanonicalName().concat(" is not allowed to have a child element of type ").concat(element.getClass().getCanonicalName()).concat("\n Set ApplicationManager.FORCE_HTML_COMPLIANCE to false to override"));
		return super.addDomElement(element);
	} 
}

package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;

public enum EncTypeEnum implements DOMobject {
	application_x_www_form_urlencoded{
		 public String toString(){
             return "application/x-www-form-urlencoded";
         }
	},
	multipart_form_data{
		public String toString(){ 
        return "multipart/form-data";
		}
    },
	text_plain{
    	 public String toString(){
             return "text/plain";
         }
    };
}



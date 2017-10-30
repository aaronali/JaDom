package com.ali.jadom.dom;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;



/** 
 * Used to identify the corresponding dom element
 * @author AARONAli
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Tag { 
	String[] value(); 
}

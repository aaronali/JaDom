package com.ali.jadom.annotations;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
/**
 * Thhis attribute is used to declare dom field as hidden so they are
 * not added ti the attributes and passed to the ui
 * @author Aaron Ali
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Hidden {

	boolean value();

}

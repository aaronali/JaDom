package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;

public enum RelTypeEnum  implements DOMobject{
	ALTERNATE, /** Gives alternate representations of the current document **/
	AUTHOR, /** Gives a link to the author of the current document or article. **/
	BOOKMARK, /**  	Gives the permalink for the nearest ancestor section **/
	HELP, /** Provides a link to context-sensitive help **/
	ICON, /** Imports an icon to represent the current document **/
	LICENSE, /** Indicates that the main content of the current document is covered by the copyright license described by the referenced document **/
	NEXT ,/**		Indicates that the current document is a part of a series, and that the next document in the series is the referenced document. **/
	NOFOLLOW, /**	Indicates that the current document's original author or publisher does not endorse the referenced document.**/
	NOREFERER, /**	Requires that the user agent not send an HTTP `Referer` (sic) header if the user follows the hyperlink.**/
	PREFETCH, /**	 Specifies that the target resource should be preemptively cached.**/
	PREV, /**		Indicates that the current document is a part of a series, and that the previous document in the series is the referenced document.  **/
	SEARCH, /**		Gives a link to a resource that can be used to search through the current document and its related pages.  **/
	STYLESHEET, /**	 Imports a stylesheet. **/
	TAG;
	
	@Override
	public String toString(){
		return name().toLowerCase();
	}
}

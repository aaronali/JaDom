package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;

public enum ValidityStateEnum implements DOMobject {
	valueMissing,
	typeMismatch,
	patternMismatch,
	tooLong,
	rangeUnderflow,
	rangeOverflow,
	stepMismatch,
	customError,
	valid; 
}

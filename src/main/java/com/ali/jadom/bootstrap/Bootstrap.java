package com.ali.jadom.bootstrap;

import com.ali.jadom.dom.Meta;

public class Bootstrap {

private String version = null;

	public Bootstrap(String version) {
		this.version=version;
	}
	
	public Meta  meta() {
		Meta meta = new Meta();
		return meta;
	}
} 
package com.ali.jadom.dom.superelements;

import java.io.IOException;

/**
 * Each method should fire the same event in Java
 * @author aaronali
 *
 */
public interface GlobalEventHandlers {
 
	 
	public void onabort(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onautocomplete(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onautocompleteerror(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onblur(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oncancel(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oncanplay(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oncanplaythrough(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onchange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onclick(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException; 
	public void onclose(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oncontextmenu(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oncuechange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondblclick(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondrag(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondragend(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondragenter(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondragexit(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondragleave(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondragover(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondragstart(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondrop(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ondurationchange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onemptied(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onended(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onerror(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onfocus(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oninput(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void oninvalid(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onkeydown(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onkeypress(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onkeyup(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onload(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onloadeddata(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onloadedmetadata(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onloadstart(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmousedown(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmouseenter(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmouseleave(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmousemove(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmouseout(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmouseover(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onmouseup(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onwheel(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onpause(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onplay(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onplaying(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onprogress(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onratechange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onreset(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onresize(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onscroll(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onseeked(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onseeking(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onselect(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onshow(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onsort(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onstalled(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onsubmit(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onsuspend(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ontimeupdate(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void ontoggle(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onvolumechange(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
	public void onwaiting(java.lang.Object object, String method, java.lang.Object[] params, String sessionId) throws IOException;
};

package com.ali.jadom.dom;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.annotations.Hidden;
import com.ali.jadom.exceptions.JaDomComplianceError;

/**URL class for web links
 * based off specifications https://url.spec.whatwg.org/#urlsearchparams
 * @author Aaron Ali
 *
 */
public class URL  extends HTMLHyperlinkElementUtils{

	 
 
	private static final long serialVersionUID = 2037828163984061292L;

		@Hidden(ApplicationManager.FORCE_HTML_COMPLIANCE?true:false)
		protected UrlSearchParams searchParams;
		/**
		 * Creates an anchor tag with the same properties as the given element
		 * @param ele DOMelementInterface&ltA&gt
		 */
		public URL(IDOMelement ele){
			super((HTMLHyperlinkElementUtils)ele);
			this.setOrigin(((HTMLHyperlinkElementUtils)ele).origin);
			this.setHref(((HTMLHyperlinkElementUtils)ele).href);
			this.setProtocol(((HTMLHyperlinkElementUtils)ele).protocol);
			this.setUsername(((HTMLHyperlinkElementUtils)ele).username);
			this.setPassword (((HTMLHyperlinkElementUtils)ele).password);
			this.setHost(((HTMLHyperlinkElementUtils)ele).host);
			this.setPort(((HTMLHyperlinkElementUtils)ele).port);
			this.setPathname(((HTMLHyperlinkElementUtils)ele).pathname);
			this.setSearch(((HTMLHyperlinkElementUtils)ele).search);
			this.setHash(((HTMLHyperlinkElementUtils)ele).hash);
		}
		
		public URL(String href) {
			super(tag(URL.class),href);
			this.href=href;
			this.addAttribute("href", href);
		}

		 

		public UrlSearchParams getSearchParams() {
			if(searchParams==null)searchParams = new UrlSearchParams();
			return searchParams;
		}

		public void setSearchParams(UrlSearchParams searchParams) {
			this.searchParams = searchParams;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		 
		public String toUrlString() { 
			return href;
		}
		
		public String toString() { 
			String ch = "?";String nul ="";
			return href.concat(searchParams!=null && searchParams.size()>0?ch:nul).concat(searchParams!=null?this.searchParams.toString():nul); 
		}
		
		@Override
		public boolean addDomElement(DOMelement element) {
			if(ApplicationManager.FORCE_HTML_COMPLIANCE)
				throw new RuntimeException(new JaDomComplianceError(JaDomComplianceError.ErrorEnum.CLASS_NOT_ALLOWED, this,element));
			return super.addDomElement(element);
				
		} 
}

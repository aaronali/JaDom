package com.ali.jadom.bootstrap;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ali.jadom.ApplicationManager;
import com.ali.jadom.JadomConfig;
import com.ali.jadom.dom.Link;
import com.ali.jadom.dom.Meta;
import com.ali.jadom.dom.RelTypeEnum;
import com.ali.jadom.exceptions.JaDomBootstrapConfigurationError; 
import com.ali.java.jalo.Logger;

public class Bootstrap {
  
	public static boolean init=false;
	
	private String cssInclude = null;
	private String jsInclude = null; 
	private static Map<String,String> cssFileMapping = new ConcurrentHashMap<String,String>();
	
	protected final static String BSTRAP0001 =  "BSTRAP0001 : Error ,bootstrap version was selected in configuration file. ";
	protected final static String BSTRAP0002 =  "BSTRAP0002 : Error occured reading the bootsrap css data . ";
	protected final static String BSTRAP0003 =  "BSTRAP0003 : Error occured reading the bootsrap javascript data . ";
	protected final static String BSTRAP0004 =  "BSTRAP0004 : Error occured reading the bootsrap classes data . ";
	protected final static String BSTRAP0005 =  "BSTRAP0005 : Error occured reading the bootsrap deafult css for the carousel . ";
	protected final static String BSTRAP0006 =  "BSTRAP0006 : Error getting the bootsrap deafult css for the carousel from %s . ";
	protected final static String BSTRAP0007 =  "BSTRAP0007 : Error getting the bootsrap deafult css for the carousel from %s . ";

	 
	/**
	 * Create an instance of the bootstrap class
	 * @param version
	 */
	public Bootstrap() { 
		if(!init)
			init();
		this.cssInclude =headerInclude;
		this.jsInclude= footerInclude;
	}
	
	/**
	 * Creates bootstrap instance using the given code in the header instead of the generic default
	 * @param includeCode
	 */
	public Bootstrap(String includeCode) {
		if(!init)
			init();
		this.cssInclude=includeCode;
	}
	
	public Meta  meta() {
		Meta meta = new Meta();
		return meta;
	}
	private static String headerInclude=null;
	private static String footerInclude=null; 

	private static BootEnum BootClasses;
	
	
	public String getCssIncudes() {
		return this.cssInclude;
	}
	
	public String getJsInclude() {
		return jsInclude;
	}
	public void reset() {
		this.cssInclude = Bootstrap.headerInclude;
		this.jsInclude = Bootstrap.footerInclude;
	}
	
	 public static void init() {
		 
		 JadomConfig config =JadomConfig.getInstance();
		 String js  =(ApplicationManager.RESOURCES_JS).concat(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_JS)).trim();
		 String css = (ApplicationManager.RESOURCES_CSS.concat(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_HTML)).trim());
		 String clas = (ApplicationManager.RESOURCES_CSS.concat(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_CLASSES)).trim());
			  if( !config.isBootstrapped()) {
			 
			 throw new RuntimeException(new JaDomBootstrapConfigurationError(BSTRAP0001));
		 }  
	 	InputStream stream =Bootstrap.class.getClassLoader().getResourceAsStream(ApplicationManager.RESOURCES_CSS
		 		   .concat(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_HTML)).trim());

		 
		 stream=Bootstrap.class.getClassLoader().getResourceAsStream(css);
		 String tt=null; 
		 if(stream!=null) {
			 java.util.Scanner s=null;
			 try {
				s = new java.util.Scanner(stream).useDelimiter("\\A"); 
				tt =  s.hasNext() ? s.next() : ""; 
				s.close();
				s=null;
				Bootstrap.headerInclude = tt;
			 }catch(Exception e) {
				  
			 }finally {
				  if(s!=null)
					  try{
						  if(s!=null)
							  s.close(); 
					  }finally {};
			 }
		 }else {
			 String method = "init";
			 Exception e =new JaDomBootstrapConfigurationError(BSTRAP0002);
			 Logger.severep(Bootstrap.class, method, BSTRAP0002, e);
			 throw new RuntimeException(e);
		 }
		 

		 tt=null;   
	 	 InputStream istream = Bootstrap.class.getClassLoader().getResourceAsStream(js);
	 	  
		 
		 if(istream!=null) {
			 java.util.Scanner s=null;
			 try {
				s = new java.util.Scanner(istream).useDelimiter("\\A"); 
				tt =  s.hasNext() ? s.next() : ""; 
				istream.close();
				s=null;
				Bootstrap.footerInclude = tt;
			 }catch(Exception e) {
				  
			 }finally {
				  if(s!=null)
					  try{
						  if(istream!=null)
							  istream.close(); 
					  } catch (IOException e) { 
						e.printStackTrace();
					}finally {};
			 }
		 }else{ 
			 String method = "init";
			 Exception e =new JaDomBootstrapConfigurationError(BSTRAP0003);
			 Logger.severep(Bootstrap.class, method, BSTRAP0003, e);
			  throw new RuntimeException(e); 
		 } 
		 
		 tt=null;   
	 	 istream =null;
	 	 loadCarouselCss();
		 Bootstrap.init = true;
		 } 
	  
	 /**
	  * When set to try the header shold include the link for the deafult carousel css
	  * @param useDefaultCss
	  */
	 public void setUseDefaultCarouselCss(boolean useDefaultCss) {
		 JadomConfig config = JadomConfig.getInstance();
		 if(useDefaultCss) {
			 cssInclude  =cssInclude.trim();
			 Link link =   Link.createStyleLink(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_CAROUSEL_DEFAULT_CSS));
			 cssInclude = cssInclude.concat(ApplicationManager.STRING_NEWLINE).concat(link.toString().trim().concat(ApplicationManager.STRING_NEWLINE)).trim();
		 }
	 }
	 
	 
	 private static void loadCarouselCss() { 
		 JadomConfig config = JadomConfig.getInstance();
		 
		 if(!Boolean.valueOf(config.get(JadomConfig.bootstrap_user_default_carousel_css)))
			 return;
		 String css = (ApplicationManager.RESOURCES_CSS.concat(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_CAROUSEL_DEFAULT_CSS)).trim());
	 	  if( !config.isBootstrapped()) {
			 throw new RuntimeException(new JaDomBootstrapConfigurationError(BSTRAP0006));
		 }  
	 	InputStream stream =Bootstrap.class.getClassLoader().getResourceAsStream(css); 
		 stream=Bootstrap.class.getClassLoader().getResourceAsStream(css);
		 String tt=null; 
		 if(stream!=null) {
			 java.util.Scanner s=null;
			 try {
				s = new java.util.Scanner(stream).useDelimiter("\\A"); 
				tt =  s.hasNext() ? s.next() : ""; 
				s.close();
				s=null;
				cssFileMapping.put(config.getBootstrapVersion().concat(ApplicationManager.EXTENSTION_JADOM_CAROUSEL_DEFAULT_CSS).trim(),tt);
			 }catch(Exception e) {
				  
			 }finally {
				  if(s!=null)
					  try{
						  if(s!=null)
							  s.close(); 
					  }finally {};
			 }
		 }else {
			 String method = "init";
			 Exception e =new JaDomBootstrapConfigurationError(BSTRAP0006);
			 Logger.severep(Bootstrap.class, method, BSTRAP0006, e);
			 throw new RuntimeException(e);
		 }
		 
	 }
	 
	 /**
	  * Returns a css file string from the css file mapping
	  * @param filename
	  * @return
	  */
	 public String getCssFile(String filename) {
		 return cssFileMapping.get(filename);
	 }
	 
	 
	 /**
	  * Sets a css file string from the css file mapping
	  * This function will not overwrite any previous mapping.
	  * Use updateCssFile(filename) to force an overwrite.
	  * @param filename
	  * @return
	  */
	 public boolean putCssFile(String filename, String fileString) {
		 if(cssFileMapping.get(filename) !=null) return false;
		 cssFileMapping.put(filename,fileString);
		 return cssFileMapping.get(filename)!=null;
	 }
	 
	 
	 /**
	  * Updates or sets the css file string from the css file mapping.
	  * Use putCssFile(filename) to ensure you dont overwrite previous mapping
	  * @param filename
	  * @return
	  */
	 public boolean updateCssFile(String filename, String fileString) { 
		 cssFileMapping.put(filename,fileString);
		 return cssFileMapping.get(filename)!=null;
	 }
}
	  
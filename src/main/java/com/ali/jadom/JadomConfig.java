package com.ali.jadom;
 
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import com.ali.java.jalo.Logger; 
 

public class JadomConfig {

	private static Properties properties;
	private Properties props;
	
	private static String configFilename = "resources/jadom.config.properties"; 
	private static boolean debug = true; 
	private static boolean init=false;
	public static final String JADOM0000 = "JADOM0000 : Failed to find the required config file %s ";
	public static final String JADOM0010 = "JADOM0010 : Success, Properties loaded from %s ";
	public static final String JADOM0020 = "JADOM0020 : File found but failed to read the required config file %s ";
	public static final String JADOM0030 = "JADOM0030 : Inititlization completed with %s errors ";	 
	public static final String JADOM0050 = "JADOM0050 : Failed to find the %s file in the dafault location. Please verify your intallation ";	
	public static final String JADOM0060 = "JADOM0060 : JaDomConfig did not initialize correctly. No Properties loaded or errors during initialization";	
	public static final String JADOM0070 = "JADOM0070 : Success, JaDomConfig initialize correctly. ";	
	public static final String JADOM0080 = "JADOM0080 : Success, Scripts loaded from %s  ";	
	public static final String JADOM0081 = "JADOM0081 : Failed to load required scripts loaded from %s  Errors may occur ";	
	public static final String JADOM0082 = "JADOM0082 : Success, Application Scripts set  ";		
	// Configuration name strings
	public final static String external_link_preffix="external_link_preffix";
	public final static String internal_link_preffix="internal_link_preffix";
	public final static String a_allow_phasing_content="a_allow_phasing_content";
	public final static String a_allow_flowing_content="a_allow_flowing_content";
	public final static String a_allow_interactive_content="a_allow_flowing_content";
	public final static String a_allow_palpable_content="a_allow_palpable_content";
	public final static String a_allow_multiple_urls="a_allow_multiple_urls";
	public final static String a_new_tab_text="a_new_tab_text"; 
	public final static String bootstrap__4_0_0__beta="bootstrap__4_0_0__beta";
	public final static String bootstrap__3_3_7__dist="bootstrap__3_3_7__dist"; 
	
	public enum SCRIPTS{
		addEventListener_js_jadom,
		document_getElementById_js_jadom,
		responsiveCanvas_js_jadom,
		sendWindows_js_jadom,
		setWindows_js_jadom,
		XMLhttpBody_js_jadom;
		
		@Override
			public String toString() {
				return this.name().replaceAll("_", ".");
			}
		}
	
	private ApplicationManager manager = new ApplicationManager(); 
	public static ConcurrentHashMap<String,String>  Scripts = new ConcurrentHashMap<String,String>();
	
	private JadomConfig(){
		debug=(properties.getProperty("debug") != null)?Boolean.valueOf(properties.getProperty("debug")):true;
		this.props= new Properties();
		props.putAll(properties); 
	}
	
	
	/**
	 * Initializes the properties object for later reference
	 */
	private static void init() { 
		// To avoid complete JaDom failure this value should never be changed unless to changes
		// to the location of the default jadom.config.propeties file 
		String deafultConfig = "resources/jadom.config.properties";
		String deafultScriptLocation = "resources/scripts";
		int err = 0; ;
		
		InputStream input = null; 
		InputStream scriptsStream =null;
		
		scriptsStream = JadomConfig.class.getClassLoader().getResourceAsStream(deafultScriptLocation); 
		if (scriptsStream == null) {
			com.ali.java.jalo.Logger.warning(String.format(JADOM0081,deafultScriptLocation));
			++err;
		}else {
			com.ali.java.jalo.Logger.warning(String.format(JADOM0080,deafultScriptLocation));
			Properties pp = new Properties();
			try {
				pp.load(scriptsStream);
				for(Object key : pp.keySet()) {
					InputStream temp =  JadomConfig.class.getClassLoader().getResourceAsStream(deafultScriptLocation.concat(String.valueOf(File.separatorChar)).concat(key.toString()));;
					java.util.Scanner s = new java.util.Scanner(temp).useDelimiter("\\A");
				    String tt =  s.hasNext() ? s.next() : "";
					System.out.println(tt); ;
					Scripts.put(key.toString(), tt);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			ApplicationManager.setScriptPath(deafultScriptLocation);
			com.ali.java.jalo.Logger.warning(JADOM0082);
		}
		
		input = JadomConfig.class.getClassLoader().getResourceAsStream(configFilename); 
		if (input == null) {
			com.ali.java.jalo.Logger.warning(String.format(JADOM0000,configFilename));
			++err;
		}
		if (input == null) {
			input = JadomConfig.class.getClassLoader().getResourceAsStream(deafultConfig);  
		}
		if (input == null) { 
			com.ali.java.jalo.Logger.warning(String.format(JADOM0050,deafultConfig));
			++err;
		}else {
			try {
				if(properties==null) properties = new Properties();
				properties.load(input);
				com.ali.java.jalo.Logger.warning(String.format(JADOM0010,configFilename));
			} catch (IOException e) {
				++err;
				com.ali.java.jalo.Logger.warning(String.format(JADOM0020,configFilename));
				com.ali.java.jalo.Logger.severe(JadomConfig.class, "init",String.format(JADOM0020,configFilename),e);
			}   
		} 
		if(properties!=null && err==0) {
			init=true;
			Logger.log(JADOM0070);
		}else {

			Logger.log(JADOM0060);
		}
		com.ali.java.jalo.Logger.warning(String.format(JADOM0030,err));  
	}
	
	/**
	 * Returns the value of the given property or returns null if it is not found
	 * @param name
	 * @return
	 */
	public String get(String name) {
		return properties.getProperty(name);
	}
	
	
	/**
	 * Initializes the class if needed then returns an instance of the class
	 * @return
	 */
	public static JadomConfig getInstance() {
		if(!init) {
			init();
		}
		return new JadomConfig();
	}
	
	
	public boolean debug() {
		return debug;
	}
	
	public ApplicationManager getManager() {
		return this.manager;
	}
	
	/**
	 * Returns the detailed bootstrap version or returns null
	 * @return
	 */
	public String getBootstrapVersion() {
		String prop = properties.getProperty(bootstrap__4_0_0__beta);
		if(prop!=null && Boolean.valueOf(prop)){
			 return bootstrap__4_0_0__beta.replaceAll(ApplicationManager.STRING_DOUBLE_UNDERSCORE, ApplicationManager.STRING_UNDERSCORE);
		}
		prop = properties.getProperty(bootstrap__3_3_7__dist);
		if(prop!=null && Boolean.valueOf(prop)){ 
			return bootstrap__3_3_7__dist;
		}
		return null;
	}

	/**
	 * Returns if the application is bootstrap enabled
	 * @return
	 */
	public boolean isBootstrapped() {
		return getBootstrapVersion()!=null;
	}
	
	public static boolean Debug() {
		return debug;
	}
}

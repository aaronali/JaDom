package com.ali.jadom.dom;
 
import java.util.ArrayList;
import java.util.Collection; 
import java.util.List;
import java.util.Map; 

@Tag("urlSearchParams")
public class UrlSearchParams  {

	 


	private class KeyValuePair{
		protected String key;
		protected String value;
		
		public KeyValuePair(String key, String value) {
			this.value=value;
			this.key=key;
		}
		
		public String toString() {
			String equals ="=";
			return key.concat(equals).concat(value);
		}
	}
	
	
	private static final long serialVersionUID = -1550271106454956759L;


	private List<KeyValuePair> params = new ArrayList<KeyValuePair>();
	
	
	public UrlSearchParams() { 
	}
	
	public UrlSearchParams(String string) { 
		String[] inParams = string.split(",");
		for(int i =0; i<inParams.length;i++){
			append(inParams[i].split(":")[0].trim(),inParams[i].split(":")[1].trim());
		} 
	}
	
	public UrlSearchParams(Map<String, String> paramsIn) { 
		for(String name : paramsIn.keySet()) {
			append(name,paramsIn.get(name));
		}
	}
	
	
	/**
	 * Adss a new parameter to the paramaters list
	 * @param name
	 * @param value
	 */
	public void append(String name, String value) { 
		params.add(new KeyValuePair(name,value));
	} 
	public void put(String name, String value) {
		params.add(new KeyValuePair(name,value));
	}
	  
	
	/**
	 * Removes all parameters with the given name
	 * @param name
	 */
	public void delete(String name) { 
		for(int i=0; i<params.size();i++) {
			 if(params.get(i).key.equals(name)) {
				 params.remove(i);
			 }
		} 
	} 
	  
	/**
	 * Removes any parameter with the given name and appends the new paramater to the parameter list
	 * @param name
	 * @param value
	 */
	public void set(String name , String value) {
		  delete(name);
		  append(name,value);
	}
	
	
	/**
	 * Returns the first value for the given name in the parameters list or returns null
	 * @param name
	 * @return
	 */ 
	public String get(String name){ 
		for(int i =0; i<params.size();i++) {
			if(params.get(i).key.equals(name)) {
				return params.get(i).value;
			}
		}
		return null;
	} 
	
	/**
	 * Returns a list with all the values of the parameters with the given name or returns 
	 * an empty collection.
	 * @param name
	 * @return
	 */
	public Collection<?> getAll(String name){  
		Collection<String> vals = new ArrayList<String>();
		for(int i =0; i<params.size();i++) { 
			if(params.get(i).key.equals(name)) {
				vals.add(params.get(i).value);
			}
		}
		return vals;
	  }
	
	
	  public boolean has(String name) {  
			for(int i =0; i<params.size();i++) { 
				if(params.get(i).key.equals(name)) {
					return true;
				}
			}
			return false;
	  } 
	   

	  /**
	   * Sorts the parameters by name and preserves the relative order
	   * where the name more then one name is found
	   */
	  public void sort() {
		 boolean passed = false; 
		 do {
			 passed = true;
			for(int i=1; i<params.size();i++) {
				if(params.get(i-1).key.compareTo(params.get(i).key)>0) {
					KeyValuePair lowest =params.get(i);
					params.set(i, params.get(i-1));
					params.set(i-1, lowest);
					passed=false;
				}
			}
		 }while(!passed); 
	  }      
	  
	  public int size() {
		  return this.params.size();
	  }
	  
	  public String toString() {
		  String paramString ="";
		  int i = 0;
		  for(KeyValuePair kv : this.params) {
			  paramString=paramString.concat(kv.toString());
			  ++i;
			  if(i<this.params.size()) {
				  paramString=paramString.concat("&");
			  } 
		  }
		  return paramString;
	  }
}

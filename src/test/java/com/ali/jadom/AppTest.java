package com.ali.jadom;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.text.html.HTML;

import com.ali.jadom.dom.*;
import com.ali.java.jalo.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        document = new Document();
    }

    public static void testApplicationMAnager() {
    	ApplicationManager appManager = new ApplicationManager();
    	
    }
    
    Document document =null;
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

 
    /**
     * Test document attributes compliance
     */
     public void testDocument() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 document.updateAttributesAndProperties(document); 
    	 assertTrue(!document.toString().contains("id")&& !document.toString().contains("documentReadyState"));
 
     }
     
     /**
      * Test attributes not populating on document
      */
     public void testDocument1() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 document.setTitle("my Title");
    	 document.updateAttributesAndProperties(document); 
    //	 System.out.println(document);
    	 assertTrue(!document.toString().contains("id=")&& !document.toString().contains("documentReadyState"));
 
     }
     
     /**
      * Test adding title
      */
     public void testDocument2() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 document.setTitle("my Title");
    	// System.out.println(document);
    	 document.updateAttributesAndProperties(document); 
    	 assertTrue(document.getHead().toString().contains("<title>my Title</title>"));
     }
     
     /**
      * Test adding title to document
      */
     public void testDocument3() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 Title title = new Title("my Title");
    	 try {
    		 document.addDomElement(title);
    	 }catch(Exception e) { 
    	 }
    	// System.out.println(document);
    	assertTrue(document.getHead().toString().contains("<title>my Title</title>"));
     }
     
     
     public void testDocument4() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 Title title = new Title("my Title");
    	 Body b = new Body();
    	 document.addDomElement(b);
    	 try {
    		 document.addDomElement(title);
    	 }catch(Exception e) { 
    	 }
    	 //System.out.println(document.toString());
    	assertTrue(document.toString().contains("<body") && document.toString().contains("</body>"));
     }
     
     public void testDocument5() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 Title title = new Title("my Title");
    	 Body b = new Body();

    	 document.addDomElement(b);
    	 try {
    		 document.addDomElement(title);
    	 }catch(Exception e) { 
    	 }
     // System.out.println(document);
    	assertTrue(!document.getHead().toString().contains("<body"));
     }
     
     public void testDocument6() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 Title title = new Title("my Title");
    	 Body b = new Body();

    	 document.addDomElement(b);
    	 try {
    		 document.addDomElement(title);
    	 }catch(Exception e) { 
    	 }
    	//  System.out.println(document);
    	assertTrue(document.getBody().toString().contains("<body") && document.getBody().toString().contains("</body>"));
     }
     
     public void testDocument7() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 Title title = new Title("my Title");
    	 Body b = new Body();
    	 
    	 try {
    		 document.addDomElement(title);

        	 document.addDomElement(b);
    	 }catch(Exception e) { 
    	 }
    	// System.out.println(document);
    	assertTrue(document.getBody().toString().contains("id="));
     }
     
     public void testDocument8() { 
    	 document = new Document("html");
    	 document.addAttribute("id", "id"); 
    	 Title title = new Title("my Title");
    	 Body b = new Body();
    	 
    	 try {
    		 document.addDomElement(title);

        	 document.addDomElement(b);
    	 }catch(Exception e) { 
    	 }
    	 System.out.println(document);
    	assertFalse(document.getBody().toString().contains("<title>my Title</title>"));
     }
    /*
    public void testAddBody1() { 
    	Head h = new Head(); 
    	this.document.setHead(h);
    	Body b = new Body("test");
    	this.document.addDomElement(b); 
    	assertTrue(document.toString().contains("id") && document.toString().contains("<body") 
    			&& document.toString().contains("</body>"));
    	 
    }
    
    public void testAddBody2() { 
    	this.document.addDomElement(new Body());
    	Logger.log("checking basic body structure"); 
    	try {
    		this.document.addDomElement(new Body()); 
    		 System.out.println("---------------------------");
       	 System.out.println(document.toString());
    		assertTrue(true);
    	}catch(Exception e) { 
    		assertTrue(true);
    	}   
    } 
    public void test3() {
    	  Document document = new Document();
          Head head = new Head();
          head.addAttribute("title", "JaDom"); 
          Body b = new Body();
          b.addDomElement(new H(2,"JaDom"));
          document.addDomElement(head);
          document.addDomElement(b);
          System.out.println(document);
          assertTrue(true);
    } 
   
    public void test4() {
    	 Logger.log("444444444444444444444444444444444444444444444444444444444444444");
    	  ApplicationManager applicationManager = new ApplicationManager(); 
          Path currentRelativePath = Paths.get("");
          String s = currentRelativePath.toAbsolutePath().toString();
          Logger.log("Setting script path tpo");
          applicationManager.setScriptPath(currentRelativePath.toAbsolutePath().toString().concat(File.separator).concat(ApplicationManager.STRING_SCRIPTS));
          Document document = new Document("html");
          Head head = new Head();
          head.addAttribute("title", "JaDom MedChain"); 
          Body body = new Body();
          H h2 = new H(2,"JaDom",new DOMclass("blue"));
          Style styles = new Style("text-align:center;");
          h2.setStyle(styles);
          body.addDomElement(h2);
          P p = new P("This is an example paragraph", new DOMclass("myp"));
          body.addDomElement(p);
          document.addHeaderStyle(".blue {  color: blue;} h2{text-align:center;} .myp{ margin:10px;}" );
          document.addDomElement(head);
          document.addDomElement(body);
          Logger.log(document);
          
          assertTrue(true);
    }*/
    	 public static void main(String...strings) {
    		 ApplicationManager applicationManager = new ApplicationManager(); 
             Path currentRelativePath = Paths.get("");
             String s = currentRelativePath.toAbsolutePath().toString(); 
             applicationManager.setScriptPath(currentRelativePath.toAbsolutePath().toString().concat(File.separator).concat(ApplicationManager.STRING_SCRIPTS));
             Document document = new Document("html");
             Head head = new Head();
             head.addDomElement(new Title("JaDom MedChain")); 
             Body body = new Body();
             H h2 = new H(2,"JaDom",new DOMclass("blue"));
             Style styles = new Style("text-align:center;");
             h2.setStyle(styles);
             body.addDomElement(h2);
             P p = new P("This is an example paragraph", new DOMclass("myp"));
             body.addDomElement(p);
             document.addDomElement(head);
             document.addHeaderStyle(".blue {  color: blue;} h2{text-align:center;} .myp{ margin:10px;}" );
             
             document.addDomElement(body);
             Logger.log(document);
             
    	 }
}

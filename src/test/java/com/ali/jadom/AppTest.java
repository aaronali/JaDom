package com.ali.jadom;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.ali.jadom.bootstrap.Bootstrap;
import com.ali.jadom.bootstrap.Bootstrap400Beta;
import com.ali.jadom.codebuilders.HtmlTemplate;
import com.ali.jadom.codebuilders.NavBuilder;
import com.ali.jadom.codebuilders.StyleBuilder;
import com.ali.jadom.dom.*;
import com.ali.java.jalo.Logger;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

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

	public static ApplicationManager appManager;
	public static JadomConfig jadomConfig;
	public static void testApplicationMAnager() {
		appManager = new ApplicationManager();
		jadomConfig = JadomConfig.getInstance();

	}

	Document document =null;
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( AppTest.class );
	}
	
	public static void testconfig1() {
		JadomConfig c = JadomConfig.getInstance(); 
		
		assertTrue(true);
	}

	/**
	 * Validate default debug as true
	 */
	public static void Test_config_1() {
		JadomConfig config= JadomConfig.getInstance();
		assertTrue(config.debug());
	}

	/**
	 * validate reading defalut config location
	 */
	public static void Test_config_2() {
		JadomConfig config= JadomConfig.getInstance();
		assertTrue(config.get("hello test").equals("hello test"));
	}   





	/**
	 * Test document attributes compliance
	 */
	public void testDocument() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		document.updateAttributesAndProperties(document); 
		System.out.println(document);
		assertTrue(!document.toString().contains("documentReadyState"));

	}

	/**
	 * Test attributes not populating on document
	 */
	public void testDocument1() { 
		JadomConfig config = JadomConfig.getInstance();
		document = new Document("html");
		document.addAttribute("id", "id"); 
		document.setTitle("my Title");
		document.updateAttributesAndProperties(document); 
		//System.out.println(document);
		assertTrue( !document.toString().contains("documentReadyState"));

	}

	/**
	 * Test adding title
	 */
	public void testDocument2() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		document.setTitle("my Title");
		document.updateAttributesAndProperties(document); 
		// //System.out.println(document);
		assertTrue(document.toString().contains("<title>my Title</title>"));
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
		// //System.out.println(document);
		assertTrue(document.toString().contains("<title>my Title</title>"));
	}


	public void testDocument4() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body();
		document.setBody(b);
		try {
			document.addDomElement(title);
			System.out.println(document.toString());
			assertTrue(this.passBasics(document) && document.toString().contains("my Title"));
		}catch(Exception e) 
		{
		}  
	}

	public void testDocument5() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body();

		document.setBody(b);
		try {
			document.addDomElement(title);
		}catch(Exception e) { 
		}
		// //System.out.println(document);
		assertTrue(passBasics(document) && !document.getHead().toString().contains("<body"));
	}

	public void testDocument6() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body();

		document.setBody(b); 
			document.addDomElement(title);
		 	assertTrue(passBasics(document) && document.getBody().toString().contains("<body") && document.getBody().toString().contains("</body>"));
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
		System.out.println(document);
		assertTrue(this.passBasics(document)&& document.getBody().toString().contains("id="));
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
		assertTrue(this.passBasics(document) && !document.getBody().toString().contains("<title>my Title</title>"));
	}

	public void testDocument9() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");

		try {
			document.addDomElement(title);

			document.addDomElement(b);
		}catch(Exception e) { 
		}
		////System.out.println(document);
		assertTrue(this.passBasics(document) && document.getBody().toString().contains("test body"));
	}
	public void testDocument10() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body"); 
		try { 
			document.addDomElement(b); 
		}catch(Exception e) { 
		}
		  System.out.println(document);
		int i = document.toString().split("<body").length;


		//  	 //System.out.println(i);
		assertTrue(this.passBasics(document) && i==2);
	}


	public void testDocument11() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			document.addDomElement(title); 
			document.addDomElement(b);
			document.setBody(new Body());
		}catch(Exception e) { 
		}
		////System.out.println(document);
		//System.out.println("document.toString().split(\"body\").length" + document.toString().split("<body").length);
		assertTrue(document.toString().split("<body").length==2 && !document.getBody().toString().contains("test body"));
	}    

	public void testDocument11__() { 
		JadomConfig.getInstance();
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			document.addDomElement(title); 
			document.setBody(new Body()); 
		}catch(Exception e) { 
			e.printStackTrace();
		}
		//System.out.println(document);
		//System.out.println("document.toString().split(\"body\").length =" + document.toString().split("<body").length);
		assertTrue(document.toString().split("<body").length==2 && !document.toString().contains("test body"));
	}
	public void testDocument11_() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			document.addDomElement(title); 
			
			document.setBody(b);
			//System.out.println(document);
			assertTrue(document.toString().split("<body").length==2 && document.getBody().toString().contains("test body"));

			document.addDomElement(new Body());
		}catch(Exception e) { 
		}
		 System.out.println(document);
		//	 //System.out.println(document.getBody().toString().split("body").length);
		assertTrue(document.toString().split("<body").length==2 && !document.getBody().toString().contains("test body"));
	}

	public void testDocument12() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			document.addDomElement(title); 
			document.addDomElement(b);
			document.addDomElement(new Body());
		}catch(Exception e) { 
		}
		 	 //System.out.println(document);
		//System.out.println(document.getBody().toString().split("body").length);
		assertTrue( !document.getBody().toString().contains("test body"));
	}

	/**
	 * Ensure we cant add to overwrite the head with out duplication
	 */
	public void testDocument12_() { 
		document = new Document("html");
		//System.out.println(document);
//		document.addAttribute("id", "id"); 
//		Title title = new Title("my Title");
//		Body b = new Body("test body");  
//		//System.out.println(b);
//		try {
//			document.addDomElement(title); 
//		//	document.addDomElement(b);
//			document.addDomElement(new Head());
//			document.addDomElement(b);
//		}catch(Exception e) { 
//		}
//		//System.out.println(document);
//		//System.out.println(document.getBody().toString().split("head").length);
//		assertFalse( document.toString().contains("my Title"));
	}

	
	public void testDocument13() { 
		JadomConfig.getInstance();
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			A a = new A("AchorText", "href", false);
			b.addDomElement(a);
			document.addDomElement(title); 
			document.addDomElement(b); 

		}catch(Exception e) { 
		}
		//System.out.println(document);
		////System.out.println(document.getBody().toString().split("body").length);
		assertTrue(document.toString().contains("<a ") && document.toString().contains("</a>"));
	}

	public void testDocument14() { 
		JadomConfig.getInstance();
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			A a = new A("AchorText", "href", true);
			b.addDomElement(a);
			document.addDomElement(title); 
			document.addDomElement(b); 

		}catch(Exception e) { 
		}

		assertTrue(document.toString().contains("<a ") && document.toString().contains("</a>"));
	}

	
	/**
	 * Test adding title
	 */
	public void testDocument15() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		document.setTitle("my Title");
		// //System.out.println(document);
		document.updateAttributesAndProperties(document); 
		assertTrue(document.toString().contains("<title>my Title</title>"));
	}
	
	 
	
	/** Ensure anchor tag is added properly **/
	public void test_A_1() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			A a = new A("AchorText", "href", true);
			b.addDomElement(a);
			document.addDomElement(title); 
			document.setBody(b); 

		}catch(Exception e) { 
		}
		//System.out.println(document.getBody()); 
		assertTrue(document.toString().contains("<a ") && document.toString().contains("<a href="));
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
    		 //System.out.println("---------------------------");
       	 //System.out.println(document.toString());
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
          //System.out.println(document);
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
//	public static void main(String...strings) {
//		ApplicationManager applicationManager = new ApplicationManager(); 
//		Path currentRelativePath = Paths.get("");
//		String s = currentRelativePath.toAbsolutePath().toString(); 
//		applicationManager.setScriptPath(currentRelativePath.toAbsolutePath().toString().concat(File.separator).concat(ApplicationManager.STRING_SCRIPTS));
//		Document document = new Document("html");
//		Head head = new Head();
//		head.addDomElement(new Title("JaDom MedChain")); 
//		Body body = new Body();
//		H h2 = new H(2,"JaDom",new DOMclass("blue"));
//		Style styles = new Style("text-align:center;");
//		h2.setStyle(styles);
//		body.addDomElement(h2);
//		P p = new P("This is an example paragraph", new DOMclass("myp"));
//		body.addDomElement(p);
//		document.addDomElement(head);
//		document.addHeaderStyle(".blue {  color: blue;} h2{text-align:center;} .myp{ margin:10px;}" );
//
//		document.addDomElement(body);
//		Logger.log(document);
//
//	}

	public static void test_urlParams_1() {
		UrlSearchParams p = new UrlSearchParams();
		p.append("test", "true");
		//System.out.println(p);
		assertTrue(p.toString().equals("test=true"));
	}


	public static void test_urlParams_2() {
		UrlSearchParams p = new UrlSearchParams();
		p.append("test", "true");
		p.append("test1", "false");
		//System.out.println(p);
		assertTrue(p.toString().equals("test=true&test1=false") && p.size()==2);
	} 

	public static void test_urlParams_3() {
		UrlSearchParams p = new UrlSearchParams();
		p.append("test", "true");
		p.append("test1", "false");
		p.delete("test");
		//System.out.println(p);
		assertTrue(p.toString().equals("test1=false") && p.size()==1);
	}

	public static void test_url_2()
	{
		URL url = new URL("http//www.google.com"); 
		//System.out.println(url.toString());
		assertTrue(url.toString().equals("http//www.google.com"));
	}     	 

	public static void test_url_3()
	{
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		//System.out.println("--------------- "+url.toString().replaceAll("\n","").replaceAll(" ", ""));
		assertTrue(url.toString().equals("http//www.google.com?test=true"));
	}

	public static void test_url_4()
	{
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		url.getSearchParams().append("test2", "false");
		//	 //System.out.println("--------------- "+url.toString().replaceAll("\n","").replaceAll(" ", ""));
		assertTrue(url.toString().equals("http//www.google.com?test=true&test2=false"));
	}

	public static void test_url_22()
	{
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		url.getSearchParams().append("test2", "false");
		RuntimeException e1 =null;
		try {
			url.addDomElement(new P("test"));
		}catch(RuntimeException e) {
			e1=e;
		} 
		//System.out.println(e1);
		assertTrue(e1!=null);
	}


	public static void test_url_11()
	{ 
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		url.getSearchParams().append("test2", "false"); 
		A a = new A("http//www.google.com",true);
		a.addDomElement(url);
		//System.out.println(a.getNodevalue());

		assertTrue(a.getNodevalue().equals("%s"));
	}

	public static void test_url_1()
	{ 
		A a= new A("anchorText", "www.address.com", true,null) ;

		//   		 URL url = new URL("http//www.google.com");
		//   		 url.getSearchParams().append("test", "true");
		//   		 url.getSearchParams().append("test2", "false");   
		//System.out.println(a);

		assertTrue(a.getHref().equals("www.address.com")); 
	} 		

	public static void test_url_13()
	{ 
		A a= new A("anchorText", "www.address.com", true,null) ;

		//   		 URL url = new URL("http//www.google.com");
		//   		 url.getSearchParams().append("test", "true");
		//   		 url.getSearchParams().append("test2", "false");   
		//System.out.println(a); 
		//System.out.println(a.getNodevalue());

		assertTrue(a.getNodevalue().replaceAll(" ", "").trim().equals("anchorText"));

	}
	public static void test_url_12()
	{ 
		A a= new A("anchorText", "www.address.com", true,null) ;

		//		 URL url = new URL("http//www.google.com");
		//		 url.getSearchParams().append("test", "true");
		//		 url.getSearchParams().append("test2", "false");   
		//System.out.println(a);

		assertTrue(a.isExternal());

	} 	

	/**
	 * Must edit config file to test
	 * set external_link_preffix to test?
	 */
//	public static void test_url_14()
//	{   
//		JadomConfig config = JadomConfig.getInstance();
//		A a= new A("anchorText", "www.address.com", true,null) ; 
//		assertTrue(a.toString().contains("href=\"test?www.address.com\""));
//
//	} 	

	/**
	 * Must edit config file to test
	 * set internal_link_preffix to test?
	 */
//	public static void test_url_15()
//	{   
//		JadomConfig config = JadomConfig.getInstance();
//		A a= new A("anchorText", "www.address.com", true,null) ; 
//		assertTrue(a.toString().contains("href=\"test?www.address.com\""));
//
//	} 	

	
	public static void test_url_16()
	{    
		A a= new A("anchorText", "www.address.com", true,null) ; 
		try {
			a.addDomElement(new P("test'"));
			assertTrue(true);
		}catch(RuntimeException e) {
			e.printStackTrace();
			assertTrue(false);
		} 

	} 
	
	
	public static void test_url_17()
	{    
		A a= new A("anchorText", "www.address.com", true,null) ; 
		try {
			a.addDomElement(new I("test'"));
			assertTrue(true);
		}catch(RuntimeException e) { 
			assertTrue(false);
		} 

	} 
	
	public static void test_url_18()
	{    
		A a= new A("anchorText", "www.address.com", true,null) ; 
		try {
			a.addDomElement(new Html());
			assertTrue(false);
		}catch(RuntimeException e) { 
			assertTrue(true);
		} 

	} 
	
	public static void test_url_19()
	{    
		A a= new A("anchorText", "www.address.com", true,null) ; 
		a.setNewTab(true); 
		
		//System.out.println(a);
			assertTrue(true); 

	} 

	
	public static void test_url_20()
	{    
		Abbr abbr= new Abbr("Hyper Language","HTML") ;  
		//System.out.println(abbr);
		abbr.setTitle("HyperText Markup Language"); 
		//System.out.println(abbr);
			assertTrue(abbr.toString().contains(" title=\"HyperText Markup Language\">")
					&& abbr.toString().contains("<abbr ") 
					&& abbr.toString().contains("</abbr>")); 

	} 

	
	
	public static void testAddress01() {
		Address add = new Address();
		add.innerHtml("55 Maarshal Lane");
		add.addDomElement(new A("www.google.com",true));
		//System.out.println(add);
		assertTrue(add.toString().contains("<address ") && add.toString().contains("</address>"));
	}
	
	public static void test_doucment_setbody() {
		Document document = new Document();
    	Body body = new Body();
    	
    	body.addDomElement(new H(1,"Hello from JaDom"));
    	document.setBody(body);
    	//System.out.println(document);
    	assert(true);
    	
	}
	
	
	public void test_link1() {
		Document document = new Document();
    	Body body = new Body(); 
    	document.addDomElement(body);
    	Link link = new Link("applicatiom.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	
    	//System.out.println(link.toString()); 
    	
    	try {
    		link.addDomElement(new P("test"));
    		assertTrue(false);
    	}catch(Exception e) { 	}
		assertTrue(true);
	}
	
	public void test_link2() { 
    	Link link = new Link("href.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	 //System.out.println(link.toString()); 
    		assertTrue(link.toString().contains("<link ") && link.toString().trim().endsWith(">") && link.getHref().trim().equals("href.css")
    				&& link.toString().contains("href=\"href.css\""));
}
	
	public void test_link3() { 
		Link link = new Link("href.css", "text/css",false);
		//System.out.println(link.toString());   	
		assertTrue(link.toString().contains("<link ") && link.toString().trim().endsWith(">") && link.getHref().trim().equals("href.css")
				&& link.toString().contains("href=\"href.css\""));

	}
	
	public void test_link4() { 
		Link link = new Link("href.css", "text/css",false);
		Head head = new Head();
		Document document = new Document("html");
		head.addDomElement(link);
		//System.out.println(head.toString());  
		document.setHead(head);
		assertTrue(document.toString().contains("<link ") && document.toString().trim().endsWith(">") && head.contains(link.getClass())
				&& document.toString().contains("href=\"href.css\""));

	}
	
	public void test_documentid() { 
		Link link = new Link("href.css", "text/css",false);
		link.addAttribute("id", "temp1");
		Head head = new Head();
		head.addDomElement(link); 
		Document d = new Document();
		d.setHead(head);
		DOMelement t = link.getElementById(link.Id());
		//System.out.println(t.toString());
		//System.out.println((link.Id()));
		//System.out.println("++++++++++++");
		 System.out.println(head.toString());   	
		assertTrue(link.toString().equals(t.toString()));

	}
	
	public void test_documentid1() { 
		Link link = new Link("href.css", "text/css",false);
		link.addAttribute("id", "temp1");
		Head head = new Head();
		head.addDomElement(link); 
		Document d = new Document();
		d.setHead(head);
		Body body = new Body();
		P p = new P("test","idtest",new DOMclass("testclass"));
		body.addDomElement(p);
		d.setBody(body);
		DOMelement t = d.getElementById("idtest");
		//System.out.println(t.toString());
		//System.out.println((link.Id()));
		//System.out.println("++++++++++++");
		//System.out.println(head.toString()); 
		String r = t.toString();
		String dd = d.toString();
		assertTrue(dd.contains(r));

	}
	public void test_documentid2() { 
		Link link = new Link("href.css", "text/css",false);
		link.addAttribute("id", "temp1");
		Head head = new Head();
		head.addDomElement(link); 
		Document d = new Document();
		d.setHead(head);
		Body body = new Body();
		P p = new P("test","idtest",new DOMclass("testclass"));
		body.addDomElement(p);
		d.addDomElement(body);
		DOMelement t = d.getElementById("idtest"); 
		assertTrue(t.toString().equals(t.toString()));

	}
	public void test_link__1() { 
		Link link = new Link("href.css", "text/css",false);
		link.addAttribute("id", "temp1");
		Head head = new Head();
		head.addDomElement(link); 
		Document d = new Document();
		d.setHead(head);
		//System.out.println(d.toString());
		assertTrue(d.toString().contains(link.toString().trim()));

	}
	
	
	public void test_nav1() {
		NavBuilder  nav = new NavBuilder(false,false);
		nav.addNavLink("home.html", "home", null);
		//System.out.println(nav.getCode()) ;
		 nav = new NavBuilder(true,false);
			nav.addNavLink("home.html", "home", null);
			//System.out.println(nav.getCode()) ;
			nav = new NavBuilder(false,true);
			nav.addNavLink("home.html", "home", null);
			//System.out.println(nav.getCode()) ;
		assertTrue(nav.toString().contains("<nav") && nav.getCode().trim().toString().contains("</nav>"));
	}
	
	public void test_nav2() {
		NavBuilder  nav = new NavBuilder(true,false);
		nav.addNavLink("home.html", "home", null);
		//System.out.println(nav.getCode()) ;
		assertTrue(nav.getCode().contains("<nav") && nav.getCode().trim().toString().contains("</nav>"));
	}
	
	public void test_nav3() {
		NavBuilder  nav = new NavBuilder(false,true);
		nav.addNavLink("home.html", "home", null);
		//System.out.println(nav.getCode()) ;
		assertTrue(nav.toString().contains("<nav") && nav.getCode().trim().toString().contains(">"));
	}
	
	
	
	/** Meta tag test **/
	
	public void test_meta1() {
		Meta meta = new Meta("viewport",null,"width=device-wdith, initial-scale=1, shrink-to-fit=no",null);
		//System.out.println(meta.toString()); 
		assertTrue(meta.toString().contains("<meta")&& meta.toString().trim().endsWith(">"));
	}
	
	
	public void test_meta2() {
		Meta meta = new Meta("viewport",null,"width=device-wdith, initial-scale=1, shrink-to-fit=no",null);
		//System.out.println(meta.getName()); 
		//System.out.println(meta.getCharset()); 
		//System.out.println(meta.getContent()); 
		//System.out.println(meta.toString()); 
		assertTrue(meta.getCharset() == null  && meta.getName().trim().equals("viewport")&&
				meta.getContent().trim().equals("width=device-wdith, initial-scale=1, shrink-to-fit=no"));
 	}
	
	/********* BOOT STRAP SET UP *****************/
	
	
	public void testBoot() {
		JadomConfig config = JadomConfig.getInstance();
		//System.out.println(config.isBootstrapped());
		assertTrue(config.isBootstrapped()); 
	}
	

	public void testBoot1() {
		JadomConfig config = JadomConfig.getInstance();
		//System.out.println(config.isBootstrapped());
		assertTrue(config.isBootstrapped()); 
	}
	
	
	public void testBoot2() {
		JadomConfig config = JadomConfig.getInstance();
		//System.out.println(config.getBootstrapVersion());
		assertTrue(config.getBootstrapVersion().equals("bootstrap-4.0.0-beta")); 
	}
	 
	
	public void testBoot3() {
		JadomConfig config = JadomConfig.getInstance();
		Document d = new Document();
		d.setBootstrap(false);
		Document c = new Document();
		//System.out.println(d.isBootstrapped());
		//System.out.println(c.isBootstrapped());
		assertTrue(!d.isBootstrapped() && c.isBootstrapped());
	}
	
	
	public void testBoot4() {
		try { 
			Bootstrap strap = new Bootstrap();
			assertTrue(true);
		}catch(Exception e) {
			assertFalse(true); 
		}
	}
	
	
	
	
	
	
	//	this test should fail under regular operation
	//Used for testing error handeling
//	public void testBoot5() {
//		try {  
//			Bootstrap strap = new Bootstrap(); 
//			Head h= new Head();
//			h.setBootstrap(true);
//			h.toString();
//			assertTrue(false);
//		}catch(Exception e) {
//			assertTrue(true); 
//		}
//	}
	
	public void testBoot6() {
		Bootstrap strap = new Bootstrap("headerincludecode");
		assertTrue(strap.getCssIncudes().equals("headerincludecode"));
	}
	
	
	public void testBoot7() {
		Bootstrap.init();
		Bootstrap strap = new Bootstrap();
		//System.out.println(strap.getCssIncudes());
		assertTrue(strap.getCssIncudes().trim().endsWith("<!--  unit test confirmation boot4beta  -->"));
	}
	public void testBoot8() {
		Bootstrap.init();
		Bootstrap strap = new Bootstrap();
		Head  head = new Head();  
		try {
			head.toString();
			if(!ApplicationManager.INLINE_SYTLES) {
				assertTrue(false);
			return;
			}
		}catch(Exception e) {

			assertTrue(true);
		}

		assertTrue(true);
	}
	
	public void testBoot9() {
		JadomConfig.getInstance();
		Bootstrap.init(); 
		Head  head = new Head(); 
		Document d = new Document();
		d.setHead(head);
		d.setBody(new Body());
		System.out.println(d.toString());
		assertTrue(d.toString().contains("<!--  unit test confirmation boot4beta  -->"));
	}
	
	
	
	
	
	// This test will fail  when bootstrap is enabled
//	public void testBoot10() {
//		JadomConfig.getInstance(); 
//		 
//		Head  head = new Head(); 
//		Document d = new Document();
//		d.setHead(head);
//		//System.out.println(d.toString());
//		assertTrue(!d.toString().contains("<!--  unit test confirmation boot4beta  -->"));
//	}
	
	
	// test the dom element tag() function
	public void testtag() {
		A a = new A("blah",true);
		P p = new P();
		//System.out.println(a.getBasicOpenTag());
		//System.out.println(p.getBasicOpenTag());
		//System.out.println(a.tag());
		//System.out.println(p.tag()); 
		assertTrue(a.tag().equals("a") && p.tag().equals("p") && p.getBasicOpenTag().equals("<p>")
				&& a.getBasicOpenTag().equals("<a>"));
	}
	
	public void testBoot10() {
		JadomConfig.getInstance();
		Bootstrap.init(); 
		Head  head = new Head(); 
		Document d = new Document();
		d.setHead(head);
		d.setBody(new Body());
		//System.out.println(d.getBody().toString());
		assertTrue(d.toString().contains("<!-- unit test comfirmation bootstrap-4.0.0-beta.jadom.js -->") && d.toString().contains("</body>") && d.getBody().toString().contains("<!-- unit test comfirmation bootstrap-4.0.0-beta.jadom.js -->"));
	}
	
	
	public void testBoot11() {
		JadomConfig.getInstance();
		Bootstrap.init(); 
		Head  head = new Head(); 
		Document d = new Document();
		d.setHead(head);
		d.setBody(new Body());
		//System.out.println(d.getBody().toString());
		assertTrue(d.getBody().toString().trim().contains("<!-- unit test comfirmation bootstrap-4.0.0-beta.jadom.js -->"));
	}
	
	
	public void testBoot12() {
		JadomConfig.getInstance();
		Bootstrap.init(); 
		Head  head = new Head(); 
		Document d = new Document();
		d.setHead(head);
		d.setBody(new Body());
		//System.out.println(d.toString());
		assertTrue(d.getBody().toString().trim().indexOf("body>")>d.getBody().toString().trim().indexOf("jadom.js"));
	}
	
	
	public void testBoot13() {
 	Link link = new Link("applicatiom.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	
    	
    	NavBuilder  nav = new NavBuilder(true,true);
		nav.addNavLink("home.html", "home", null);  
			nav.addNavLink("home.html", "home", null);  
			nav.addNavLink("home.html", "home", null); 
    	Document document = new Document();
    	Body body = new Body();
    	List<DOMclass> clist =new ArrayList<DOMclass>();
    	clist.add(Bootstrap400Beta.carousel.toDomClass());
    	clist.add(Bootstrap400Beta.slide.toDomClass());

    	
    	Div div = new Div(clist);
    	Style style = new Style("center");
    	style.addAttribute("_center", "text-align:center"); 
    	body.addDomElement(new H(1,"JaDom"));
    	body.addDomElement(div);
    	body.addDomElement(new H(2,"A whole new way to do development", Bootstrap400Beta.text_center.toDomClass()));
    	body.addDomElement(nav.getAsSpan());
    	document.setBody(body);
    	//System.out.println(div.toString());
    	assertTrue( div.toString().contains("class=\"carousel slide") &&
    		 document.toString().contains("class=\"carousel slide"));
	}
	
	
	public void testBoot14() {
	    	
	    	NavBuilder  nav = new NavBuilder(true,true);
			nav.addNavLink("home.html", "home", null);  
				nav.addNavLink("home.html", "home", null);  
				nav.addNavLink("home.html", "home", null); 
	    	Document document = new Document();
	    	Body body = new Body();
	    	List<DOMclass> clist =new ArrayList<DOMclass>();
	    	clist.add(Bootstrap400Beta.carousel.toDomClass());
	    	clist.add(Bootstrap400Beta.slide.toDomClass());

	    	
	    	Div div = new Div(clist);
	    	Style style = new Style("center");
	    	style.addAttribute("_center", "text-align:center"); 
	    	body.addDomElement(new H(1,"JaDom"));
	    	body.addDomElement(div);
	    	body.addDomElement(new H(2,"A whole new way to do development", Bootstrap400Beta.text_center.toDomClass()));
	    	body.addDomElement(nav.getAsSpan());
	    	document.setBody(body);
	    System.out.println(document.toString());
	    	assertTrue( div.toString().contains("class=\"carousel slide") &&
	    		 document.toString().contains("class=\"carousel slide") &&
	    		 document.toString().contains("<link href=\"bootstrap-4.0.0-beta.jadom.carousel.default.css\" rel=\"stylesheet\">") 
	    		  
	    		 && document.getHead().toString().contains("<link href=\"bootstrap-4.0.0-beta.jadom.carousel.default.css\" rel=\"stylesheet\">"));

		}
	// This test will fail under normal conditions. Test bootstrap css carousel link
//	public void testBoot15() {
//    	
//    	NavBuilder  nav = new NavBuilder(true,true);
//		nav.addNavLink("home.html", "home", null);  
//			nav.addNavLink("home.html", "home", null);  
//			nav.addNavLink("home.html", "home", null); 
//    	Document document = new Document();
//    	Body body = new Body();
//    	List<DOMclass> clist =new ArrayList<DOMclass>();
//    	clist.add(Bootstrap400Beta.carousel.toDomClass());
//    	clist.add(Bootstrap400Beta.slide.toDomClass());
//
//    	
//    	Div div = new Div(clist);
//    	Style style = new Style("center");
//    	style.addAttribute("_center", "text-align:center"); 
//    	body.addDomElement(new H(1,"JaDom"));
//    	body.addDomElement(div);
//    	body.addDomElement(new H(2,"A whole new way to do development", Bootstrap400Beta.text_center.toDomClass()));
//    	body.addDomElement(nav.getAsSpan());
//    	document.setBody(body);
//    	//System.out.println(document.toString());
//    	assertTrue( div.toString().contains("class=\"carousel slide") &&
//    		 document.toString().contains("class=\"carousel slide") &&
//    		 !document.toString().contains("<link href=\"bootstrap-4.0.0-beta.jadom.carousel.default.css\" rel=\"stylesheet\">") 
//    		  
//    		 && !document.getHead().toString().contains("<link href=\"bootstrap-4.0.0-beta.jadom.carousel.default.css\" rel=\"stylesheet\">"));
//
//	}
	
	public void testBoot16() {
		Bootstrap strap = new Bootstrap();
		//System.out.println(strap.getCssFile("bootstrap-4.0.0-beta.jadom.carousel.default.css"));
		assertTrue(strap.getCssFile("bootstrap-4.0.0-beta.jadom.carousel.default.css")!=null);
	}
	
	public void testBoot17() {
		String s ="/* unit test confirmation bootstrap-4.0.0-beta.jadom.carousel.default.css */";
		Bootstrap strap = new Bootstrap();
		Document d = new Document("html");
		d.setHead(new Head());
		d.setBody(new Body());
		System.out.println(d);
		//System.out.println(strap.getCssFile("bootstrap-4.0.0-beta.jadom.carousel.default.css"));
		assertTrue(strap.getCssFile("bootstrap-4.0.0-beta.jadom.carousel.default.css").contains(s) &&
				d.toString().contains("bootstrap-4.0.0-beta.jadom.carousel.default.css"));
	}
	
    public void  testBoot18() { 
    	Link link = new Link("applicatiom.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	
    	
    	NavBuilder  nav = new NavBuilder(true,true);
		nav.addNavLink("home.html", "home", null);  
			nav.addNavLink("home.html", "home", null);  
			nav.addNavLink("home.html", "home", null); 
    	Document document = new Document();
    	Body body = new Body();
    	List<DOMclass> clist =new ArrayList<DOMclass>();
    	clist.add(Bootstrap400Beta.carousel.toDomClass());
    	clist.add(Bootstrap400Beta.slide.toDomClass());

    	
    	Div div = new Div(clist);
    	div.addAttribute("data-ride","carousel");
  //  	System.out.println(div);
    	assertTrue(div.toString().contains("data-ride"));
    }
    
    public void  testBoot19() { 
    	Link link = new Link("applicatiom.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	
    	
    	NavBuilder  nav = new NavBuilder(true,true);
		nav.addNavLink("home.html", "home", null);  
			nav.addNavLink("home.html", "home", null);  
			nav.addNavLink("home.html", "home", null); 
    	Document document = new Document();
    	Body body = new Body();
    	List<DOMclass> clist =new ArrayList<DOMclass>();
    	clist.add(Bootstrap400Beta.carousel.toDomClass());
    	clist.add(Bootstrap400Beta.slide.toDomClass());

    	
    	Div div = new Div(clist);
    	Div innerDiv=new Div(Bootstrap400Beta.carousel_inner.toDomClass()); 
    	Div carsouelItem = new Div(Bootstrap400Beta.carousel_item.toDomClass());
    	
    	div.addAttribute("data-ride","carousel");
    	innerDiv.addDomElement(carsouelItem);
    	div.addDomElement(innerDiv);
    	
    	body.addDomElement(div);
    	document.addDomElement(body);
    	document.addDomElement(new Head()); 
    	//System.out.println(document.toString());
    	assertTrue(innerDiv.toString().contains("carousel-inner") && 
    			div.toString().contains("data-ride") &&
    			div.toString().contains("data-ride")  &&
    			carsouelItem.toString().contains("carousel-item")   &&
				div.toString().contains("carousel-item"));
    }
    
    public void testImg1() {
    	Img img = new Img("src", "alt", false);
    	img.setCrossorigin("crossorigin");
    	img.setHeight(1000);
    	img.setWidth(999);
    	assertTrue(img.getSrc().equals("src") && 
    			img.getAlt().equals("alt")  &&
    		!img.isExternal()
    		&& img.getWidth()==999
    		&& img.getHeight()==1000
    		&& img.getCrossorigin().equals("crossorigin"));

    }
    
    public void testImg2() {
    	Img img = new Img("src", "alt", false);
    	img.setCrossorigin("crossorigin");
    	img.setHeight(1000);
    	img.setWidth(999);
    	//System.out.println(img.toString());
    	assertTrue(img.toString().contains("<img")  &&
    	img.toString().contains("alt=\"alt\"")
    	&& img.toString().contains("src=\"src\"") 
    	);
    }
    
    public void testMain1() {
    	Main main = new Main();
    	System.out.println(main);
    	assertTrue(main.toString().contains("<main")
    			&& main.toString().contains(main.getBasicCloseTag())
    			&& main.toString().contains("role")
    			); 
    	
    }
	 
    public void testSpan1() {
    	Span span = new Span(); 
    	System.out.println(span);
    	assertTrue(span.toString().contains("<span ") &&
    			span.toString().contains("</span>"));
    }
    
    
    
    public void testNav() {
    	Nav nav = new Nav();
    	System.out.println(nav);
    	assertTrue(nav.toString().contains("<nav ") &&
    			nav.toString().contains("</nav>"));
    }
    
    public void testNav1() {
    	JadomConfig c = JadomConfig.getInstance();
    	Bootstrap strap = new Bootstrap();
    	Nav nav = strap.getNav("BrandName",null,false);
    	System.out.println(nav);
    	assertTrue(nav.toString().contains("<nav ") &&
    			nav.toString().contains("</nav>") &&
    			nav.contains(Span.class) &&
    			nav.toString().contains("class=\"navbar navbar-expand-lg navbar-light bg-light"));
    }
    
    public void testNav2() {
    	JadomConfig c = JadomConfig.getInstance();
    	Bootstrap strap = new Bootstrap();
    	Nav nav = strap.getNav("BrandName","href",false);
    	System.out.println(nav);
    	assertTrue(nav.toString().contains("<nav ") &&
    			nav.toString().contains("</nav>") &&
    			nav.contains(Span.class) &&
    			nav.toString().contains("class=\"navbar navbar-expand-lg navbar-light bg-light"));
    }
    public void testbutton() {
    	JadomConfig c = JadomConfig.getInstance();
    	Bootstrap strap = new Bootstrap();
    	Button button = new Button(ButtonTypeEnum.button);
          Document document = new Document("html");
          document.setHead(new Head());
          Body body = new Body();
        body.addDomElement(button);
        document.setBody(body);
          
	button.updateAttributesAndProperties(button);
	System.out.println(button.toString());
	assertTrue(true);
    }
    
    
    
    public void testP1() {
    	P p = new P();
    	P pp = new P("innerText",new DOMclass("center"));
    	System.out.println(p.toString());
    	System.out.println(pp.toString());
    	assertTrue(p.toString().contains("<p ")
    			&& p.toString().contains("</p>")
    			&& pp.toString().contains("</p>")
    			&& pp.toString().contains("<p ")
    			&& pp.getAttribute("domclass").contains("center")
    			&& pp.toString().contains("class=\"center")
    			);
    }
    public void testP2() {
    	P p = new P();
    	P pp = new P("innerText",new DOMclass("center"));
    	System.out.println(p.toString());
    	System.out.println(pp.toString());
    	assertTrue(p.toString().contains("<p ")
    			&& p.toString().contains("</p>") );
    }  
    
    public void testP3() { 
    	P pp = new P("innerText",new DOMclass("center")); 
    	System.out.println(pp.toString());
    	assertTrue( pp.toString().contains("</p>")
    			&& pp.toString().contains("<p ")
    			&& pp.getAttribute("domclass").contains("center")
    			&& pp.toString().contains("class=\"center")
    			);
    }
    
    public void testP4() { 
    	P pp = new P("innerText",new DOMclass("center")); 
    	pp.setText("test text");
    	System.out.println(pp.toString());
    	assertTrue( pp.toString().contains("</p>")
    			&& pp.toString().contains("<p ")
    			&& pp.getAttribute("domclass").contains("center")
    			&& pp.toString().contains("class=\"center")
    			&& !pp.toString().contains("innerText")
    			&& pp.getNodevalue().equals("test text"));
    }
    
    public void testHtmlTemplateMaker_001() {
    	HtmlTemplate tem = new HtmlTemplate("New Templated Page");
    	System.out.println(tem.toString());
    	assertTrue(tem.toString().contains("New Templated Page"));
    }
    
    
    public void testHtmlTemplateMaker_002() {
    	HtmlTemplate tem = new HtmlTemplate("Page1");
    	System.out.println(tem.toString()); 
    	System.out.println("_____________________"); 
    	HtmlTemplate temp1 = (HtmlTemplate) tem.clone(); 
    	temp1.setTitle("Page2");
    	System.out.println("===========");
    	System.out.println(tem.toString()); 
    	System.out.println("===========");
    	System.out.println(tem.toString());  
    	System.out.println("===========");
    	System.out.println(temp1.toString());
    	System.out.println("===========");
    	assertTrue(tem.toString().contains("Page1") 
    		&& !tem.toString().contains("Page2")
    		&& temp1.toString().contains("Page2")
    		&& !temp1.toString().contains("Page1"));
    }
 
    public boolean passBasics(Document document) {
    	return document.toString().contains("<!-- unit test comfirmation bootstrap-4.0.0-beta.jadom.js -->")
    			&&  document.toString().contains("<!-- unit test comfirmation bootstrap-4.0.0-beta.jadom.js -->")
    			&&  document.toString().contains("// unit test comfirmations setWindows.js")
        	    			;
    } 
    public void functionaltestOnToString1() {
    	Head head = new Head();
    	Document d = new Document("html");
    	String r = d.toString().replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
    	String s =d.toString().replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
    	String y =d.toString().replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
    	String o = d.toString().replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
    	String n = d.toString().replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
    	String tt = d.toString().replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
 
     assertTrue( r.contentEquals(s) && s.contentEquals(y) && y.contentEquals(o)&& o.contentEquals(n)&& n.contentEquals(tt)&&
 			d.toString().split("// unit test comfirmations setWindows.js").length==2);
    }
    
    
    public String trim(String string) {
    	return  string.replaceAll(" ", "").replaceAll("  ", "").replaceAll("\r\n","").replaceAll("\n","");
    	 
    }
    public void functionaltestOnToString() {
    	Head head = new Head();
    	Document d = new Document("html");
    	String r = d.toString();
    	String s =d.toString();
    	String y =d.toString();
    	String o = d.toString();
    	String n = d.toString();
    	String tt = d.toString();
    	System.out.println(d.toString().split("// unit test comfirmations setWindows.js").length); 
    	assertTrue(d.toString().split("// unit test comfirmations setWindows.js").length==2);
    }
    
    
    public void testStyle01() {
    	Style style = new Style(".bannerbackground");
    	style.addNewStyle("background-image: url(\"paper.gif\")");
    	String h = (trim(style.toString()));
    	assertTrue(h.contentEquals(".bannerbackground{background-image:url(\"paper.gif\");}")); 
  
    
    
    }
    
    
    public void testStyle02() {
    	Style style = new Style(".bannerbackground");
    	style.addNewStyle(" background-image: url(\"paper.gif\")");
    	String h = (trim(style.toString()));
    	P p = new P();
    	p.addDomElement(style);
    	System.out.println(p.toString());
    	Document d = new Document("html");
    	Body body = new Body();
    	body.addDomElement(p);
    	Style s = new Style("id","name:value");
    	d.addDomElement(body);
    	System.out.println(d);
    	System.out.println(s);
    	assertTrue(h.contentEquals(".bannerbackground{background-image:url(\"paper.gif\");}")); 
  
    
    
    }
    
    
    public void testStyle03() {
    	JadomConfig c = JadomConfig.getInstance();
    	Style style = new Style(".bannerbackground");
    	style.addNewStyle(" background-image: url(\"paper.gif\")");
    	style.addNewStyle(" textalign:center");
    	String h = (trim(style.toString()));
    	P p = new P();
    	//p.addDomElement(style);
    	p.setStyle(style); 
    	Document  document = new Document();
    	Body body = new Body();
    	body.addDomElement(p);
    	document.addDomElement(body);
    	System.out.println(p.toString()); 
    	System.out.println("===================");
    	System.out.println(style.toInlineString());  
    	System.out.println(document.toString());
    	if(!ApplicationManager.INLINE_SYTLES)
    		assertTrue(this.passBasics(document) && p.toString().contains("bannerbackground") &&
    			!p.toString().contains("\"background-image") && !p.toString().contains("paper.gif"));
    	else
    		assertTrue(this.passBasics(document) && !p.toString().contains("bannerbackground") &&
        			p.toString().contains("\"background-image") && p.toString().contains("paper.gif"));
    
    }
    
    public void testStyle04() {
    	JadomConfig c = JadomConfig.getInstance();
    	Style style = new Style(".bannerbackground");
    	style.addNewStyle("background-image: url(\"paper.gif\")");
    	style.addNewStyle(" textalign:center");
    	String h = (trim(style.toString())); 
    	P p = new P();
    	// p.addDomElement(style);
    	p.setStyle(style); 
    	Document  document = new Document();
    	Body body = new Body();
    	body.addDomElement(p);
    	document.addDomElement(body); 
  boolean vs =document.toString().contains(" style=\"background-image:url('paper.gif');textalign:center;\"");
  String ii =      trim(document.toString().split("</head>")[0].trim());
  boolean d= ii.contains("<style>.bannerbackground{background-image:url('paper.gif');textalign:center;}</style>");
    	System.out.println(document.toString()
    			); 
    	if(!ApplicationManager.INLINE_SYTLES)
    		 	assertTrue(d && !vs && this.passBasics(document) && p.toString().contains("bannerbackground") &&
    			!p.toString().contains("\"background-image") && !p.toString().contains("paper.gif"));
    	else { 
    			assertTrue(!d && vs && this.passBasics(document) && !p.toString().contains("bannerbackground") &&
        			p.toString().contains("\"background-image") && p.toString().contains("paper.gif"));
    	}
    }
    
    
    public void funvtionalTest2() {
        HtmlTemplate 
		template = new HtmlTemplate("JaDom");
    	Style style=new Style(".banner");
    	style.addNewStyle("position:absolute;top:4rem; background-color:#fff;opacity: 0.8;width:100%;padding: 5px;"
       	 		+ "margin-left:20%;margin-right:20%;width:60%");   
       	Style bodyStyle = new Style("style");
       	bodyStyle.addNewStyle("body", "background-color:black");
       	Style contentStyle = new Style(".contentStyle");
       	contentStyle.addNewStyle("background-color:white;color:black;margin:10%");
       	
       	Img bannerImg = new Img("images/mainbanner.jpg","images/mainbanner.jpg",false, "bannerImage"
       		   , Bootstrap400Beta.img_fluid,null,null);
         template.addStyle(bodyStyle); 
         
          
          Div outerBanner = new Div("","outerbanner",null);
          outerBanner.addDomElement(bannerImg);
          Div div = new Div("","bannerDiv",null);
          div.setStyle(style); 
       	H h1 = new H(1,"JaDom","mainheader" ,Bootstrap400Beta.text_center,null);
       	div.addDomElement(h1); 
       	H h3 = new H(3, "An Enhanced Java DOM Interaction Library", "secondaryHeade",Bootstrap400Beta.text_center,null);
       	div.addDomElement(h3);
       	H h4 = new H(4,"Minimal to no JS and Minimal to no HTML Required","h4header",Bootstrap400Beta.text_center,null);
       	div.addDomElement(h4);
       	outerBanner.addDomElement(div);; 
          template.add(outerBanner);
          Div contentDiv = new Div("","contentDiv",null);
          contentDiv.setStyle(contentStyle);
          P p = new P("P TExt", "mainP",null);
          contentDiv.addDomElement(p);
          template.add(contentDiv);
          System.out.println(template.toString());
    }
    
    public void testp3() {
    	P p = new P(":ssssssfdsf dsd");
    	assertTrue(p.toString().contains("id"));
    	
    }
    
}
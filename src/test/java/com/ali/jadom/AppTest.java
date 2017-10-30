package com.ali.jadom;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ali.jadom.codebuilders.NavBuilder;
import com.ali.jadom.codebuilders.StyleBuilder;
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
		assertTrue(!document.toString().contains("id")&& !document.toString().contains("documentReadyState"));

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
		System.out.println(document);
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
		// System.out.println(document);
		assertFalse(document.getBody().toString().contains("<title>my Title</title>"));
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
		//System.out.println(document);
		assertFalse(!document.getBody().toString().contains("test body"));
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


		//  	 System.out.println(i);
		assertTrue(i==2);
	}


	public void testDocument11() { 
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
		System.out.println("document.toString().split(\"body\").length" + document.toString().split("<body").length);
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
		System.out.println(document);
		System.out.println("document.toString().split(\"body\").length =" + document.toString().split("<body").length);
		assertTrue(document.toString().split("<body").length==2 && !document.toString().contains("test body"));
	}
	public void testDocument11_() { 
		document = new Document("html");
		document.addAttribute("id", "id"); 
		Title title = new Title("my Title");
		Body b = new Body("test body");  
		try {
			document.addDomElement(title); 
			document.addDomElement(b);
			System.out.println(document);
			assertTrue(document.toString().split("<body").length==2 && document.getBody().toString().contains("test body"));

			document.addDomElement(new Body());
		}catch(Exception e) { 
		}
		//	 System.out.println(document);
		//	 System.out.println(document.getBody().toString().split("body").length);
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
		 	 System.out.println(document);
		System.out.println(document.getBody().toString().split("body").length);
		assertTrue( !document.getBody().toString().contains("test body"));
	}

	/**
	 * Ensure we cant add to overwrite the head with out duplication
	 */
	public void testDocument12_() { 
		document = new Document("html");
		System.out.println(document);
//		document.addAttribute("id", "id"); 
//		Title title = new Title("my Title");
//		Body b = new Body("test body");  
//		System.out.println(b);
//		try {
//			document.addDomElement(title); 
//		//	document.addDomElement(b);
//			document.addDomElement(new Head());
//			document.addDomElement(b);
//		}catch(Exception e) { 
//		}
//		System.out.println(document);
//		System.out.println(document.getBody().toString().split("head").length);
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
		System.out.println(document);
		//System.out.println(document.getBody().toString().split("body").length);
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
		System.out.println(document.getBody()); 
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
		System.out.println(p);
		assertTrue(p.toString().equals("test=true"));
	}


	public static void test_urlParams_2() {
		UrlSearchParams p = new UrlSearchParams();
		p.append("test", "true");
		p.append("test1", "false");
		System.out.println(p);
		assertTrue(p.toString().equals("test=true&test1=false") && p.size()==2);
	} 

	public static void test_urlParams_3() {
		UrlSearchParams p = new UrlSearchParams();
		p.append("test", "true");
		p.append("test1", "false");
		p.delete("test");
		System.out.println(p);
		assertTrue(p.toString().equals("test1=false") && p.size()==1);
	}

	public static void test_url_2()
	{
		URL url = new URL("http//www.google.com"); 
		System.out.println(url.toString());
		assertTrue(url.toString().equals("http//www.google.com"));
	}     	 

	public static void test_url_3()
	{
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		System.out.println("--------------- "+url.toString().replaceAll("\n","").replaceAll(" ", ""));
		assertTrue(url.toString().equals("http//www.google.com?test=true"));
	}

	public static void test_url_4()
	{
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		url.getSearchParams().append("test2", "false");
		//	 System.out.println("--------------- "+url.toString().replaceAll("\n","").replaceAll(" ", ""));
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
		System.out.println(e1);
		assertTrue(e1!=null);
	}


	public static void test_url_11()
	{ 
		URL url = new URL("http//www.google.com");
		url.getSearchParams().append("test", "true");
		url.getSearchParams().append("test2", "false"); 
		A a = new A("http//www.google.com",true);
		a.addDomElement(url);
		System.out.println(a.getNodevalue());

		assertTrue(a.getNodevalue().equals("%s"));
	}

	public static void test_url_1()
	{ 
		A a= new A("anchorText", "www.address.com", true,null) ;

		//   		 URL url = new URL("http//www.google.com");
		//   		 url.getSearchParams().append("test", "true");
		//   		 url.getSearchParams().append("test2", "false");   
		System.out.println(a);

		assertTrue(a.getHref().equals("www.address.com")); 
	} 		

	public static void test_url_13()
	{ 
		A a= new A("anchorText", "www.address.com", true,null) ;

		//   		 URL url = new URL("http//www.google.com");
		//   		 url.getSearchParams().append("test", "true");
		//   		 url.getSearchParams().append("test2", "false");   
		System.out.println(a); 
		System.out.println(a.getNodevalue());

		assertTrue(a.getNodevalue().replaceAll(" ", "").trim().equals("anchorText"));

	}
	public static void test_url_12()
	{ 
		A a= new A("anchorText", "www.address.com", true,null) ;

		//		 URL url = new URL("http//www.google.com");
		//		 url.getSearchParams().append("test", "true");
		//		 url.getSearchParams().append("test2", "false");   
		System.out.println(a);

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
		
		System.out.println(a);
			assertTrue(true); 

	} 

	
	public static void test_url_20()
	{    
		Abbr abbr= new Abbr("Hyper Language","HTML") ;  
		System.out.println(abbr);
		abbr.setTitle("HyperText Markup Language"); 
		System.out.println(abbr);
			assertTrue(abbr.toString().contains(" title=\"HyperText Markup Language\">")
					&& abbr.toString().contains("<abbr ") 
					&& abbr.toString().contains("</abbr>")); 

	} 

	
	
	public static void testAddress01() {
		Address add = new Address();
		add.innerHtml("55 Maarshal Lane");
		add.addDomElement(new A("www.google.com",true));
		System.out.println(add);
		assertTrue(add.toString().contains("<address ") && add.toString().contains("</address>"));
	}
	
	public static void test_doucment_setbody() {
		Document document = new Document();
    	Body body = new Body();
    	
    	body.addDomElement(new H(1,"Hello from JaDom"));
    	document.setBody(body);
    	System.out.println(document);
    	assert(true);
    	
	}
	
	
	public void test_link1() {
		Document document = new Document();
    	Body body = new Body(); 
    	document.addDomElement(body);
    	Link link = new Link("applicatiom.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	
    	System.out.println(link.toString()); 
    	
    	try {
    		link.addDomElement(new P("test"));
    		assertTrue(false);
    	}catch(Exception e) { 	}
		assertTrue(true);
	}
	
	public void test_link2() { 
    	Link link = new Link("href.css", false, false, null, null, null, null,  RelTypeEnum.STYLESHEET, null, false, null);
    	 System.out.println(link.toString()); 
    		assertTrue(link.toString().contains("<link ") && link.toString().trim().endsWith(">") && link.getHref().trim().equals("href.css")
    				&& link.toString().contains("href=\"href.css\""));
}
	
	public void test_link3() { 
		Link link = new Link("href.css", "text/css",false);
		System.out.println(link.toString());   	
		assertTrue(link.toString().contains("<link ") && link.toString().trim().endsWith(">") && link.getHref().trim().equals("href.css")
				&& link.toString().contains("href=\"href.css\""));

	}
	
	public void test_link4() { 
		Link link = new Link("href.css", "text/css",false);
		Head head = new Head();
		head.addDomElement(link);
		System.out.println(head.toString());   	
		assertTrue(head.toString().contains("<link ") && head.toString().trim().endsWith(">") && head.contains(link.getClass())
				&& head.toString().contains("href=\"href.css\""));

	}
	
	public void test_documentid() { 
		Link link = new Link("href.css", "text/css",false);
		link.addAttribute("id", "temp1");
		Head head = new Head();
		head.addDomElement(link); 
		Document d = new Document();
		d.setHead(head);
		DOMelement t = link.getElementById(link.Id());
		System.out.println(t.toString());
		System.out.println((link.Id()));
		System.out.println("++++++++++++");
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
		P p = new P("test",new DOMclass("testclass"),"idtest");
		body.addDomElement(p);
		d.addDomElement(body);
		DOMelement t = d.getElementById("idtest");
		System.out.println(t.toString());
		System.out.println((link.Id()));
		System.out.println("++++++++++++");
		System.out.println(head.toString());   	
		assertTrue(d.toString().contains(t.toString()));

	}
	public void test_documentid2() { 
		Link link = new Link("href.css", "text/css",false);
		link.addAttribute("id", "temp1");
		Head head = new Head();
		head.addDomElement(link); 
		Document d = new Document();
		d.setHead(head);
		Body body = new Body();
		P p = new P("test",new DOMclass("testclass"),"idtest");
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
		d.addDomElement(head);
		System.out.println(d.toString());
		assertTrue(d.toString().contains(link.toString().trim()));

	}
	
	
	public void test_nav1() {
		NavBuilder  nav = new NavBuilder(false,false);
		nav.addNavLink("home.html", "home", null);
		System.out.println(nav.getCode()) ;
		 nav = new NavBuilder(true,false);
			nav.addNavLink("home.html", "home", null);
			System.out.println(nav.getCode()) ;
			nav = new NavBuilder(false,true);
			nav.addNavLink("home.html", "home", null);
			System.out.println(nav.getCode()) ;
		assertTrue(nav.toString().contains("<nav") && nav.getCode().trim().toString().contains("</nav>"));
	}
	
	public void test_nav2() {
		NavBuilder  nav = new NavBuilder(true,false);
		nav.addNavLink("home.html", "home", null);
		System.out.println(nav.getCode()) ;
		assertTrue(nav.getCode().contains("<nav") && nav.getCode().trim().toString().contains("</nav>"));
	}
	
	public void test_nav3() {
		NavBuilder  nav = new NavBuilder(false,true);
		nav.addNavLink("home.html", "home", null);
		System.out.println(nav.getCode()) ;
		assertTrue(nav.toString().contains("<nav") && nav.getCode().trim().toString().contains(">"));
	}
	
	
	
	/** Meta tag test **/
	
	public void test_meta1() {
		Meta meta = new Meta("viewport",null,"width=device-wdith, initial-scale=1, shrink-to-fit=no",null);
		System.out.println(meta.toString()); 
		assertTrue(meta.toString().contains("<meta")&& meta.toString().trim().endsWith(">"));
	}
	
	
	public void test_meta2() {
		Meta meta = new Meta("viewport",null,"width=device-wdith, initial-scale=1, shrink-to-fit=no",null);
		System.out.println(meta.getName()); 
		System.out.println(meta.getCharset()); 
		System.out.println(meta.getContent()); 
		System.out.println(meta.toString()); 
		assertTrue(meta.getCharset() == null  && meta.getName().trim().equals("viewport")&&
				meta.getContent().trim().equals("width=device-wdith, initial-scale=1, shrink-to-fit=no"));
 	}
	
	/********* BOOT STRAP SET UP *****************/
	
	
	public void testBoot() {
		JadomConfig config = JadomConfig.getInstance();
		System.out.println(config.isBootstrapped());
		assertTrue(config.isBootstrapped()); 
	}
	

	public void testBoot1() {
		JadomConfig config = JadomConfig.getInstance();
		System.out.println(config.isBootstrapped());
		assertTrue(config.isBootstrapped()); 
	}
	
	
	public void testBoot2() {
		JadomConfig config = JadomConfig.getInstance();
		System.out.println(config.getBootstrapVersion());
		assertTrue(config.getBootstrapVersion().equals("bootstrap-4_0_0-beta")); 
	}
	 
	
	public void testBoot3() {
		JadomConfig config = JadomConfig.getInstance();
		Document d = new Document();
		d.setBootstrap(false);
		Document c = new Document();
		System.out.println(d.isBootstrapped());
		System.out.println(c.isBootstrapped());
		assertTrue(!d.isBootstrapped() && c.isBootstrapped());
	}
	
}

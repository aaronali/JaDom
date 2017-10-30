package com.ali.jadom.codebuilders;

import com.ali.jadom.dom.Span;

public class NavBuilder {

	StringBuilder navBuilder = new StringBuilder();
	boolean bootstrap = false;
	String navClass ="";
	String navId= "";
	boolean justified = false;
	boolean jQueryUi = false;
	
	
	/**
	 * Create a navigation item
	 * @param bootstrap
	 * @param jQueryUi
	 */
	public  NavBuilder(boolean bootstrap, boolean jQueryUi){
		this.bootstrap = bootstrap;
	 	navBuilder.append("<div class='appNavigation'>\n<nav id=\"navId\"   >\n"); 
	 	if(bootstrap)
	 		navClass += "nav ";
	 	this.jQueryUi=jQueryUi;
	}
	

	
	public void createNavPill(){
		navClass +="nav-pills ";		   
	}
	
	public void CreateNavTab(){
		navClass += "nav-tabs";
	}
	private int navItems=0;
	private boolean stacked;
	public void setNavStacked(boolean isStacked){
		stacked = isStacked;
		if(isStacked)
			if(bootstrap)
				if(!navClass.contains("nav-stacked"))
					navClass+= " nav-stacked";
				else;
			else if(jQueryUi){
				navId +="navAppMenu";
				navBuilder.insert(0,"\n<script> $(function() {  $( \"#navMenu\" ).menu();  } </script>\n");
 
			}
		else
			if(bootstrap)
				if(navClass.contains(" nav-stacked"))
					navClass = navClass.replace(" nav-stacked", "");
				else;
			else if(jQueryUi){
				if(navBuilder.lastIndexOf("\n<script> $(function() {  $( \"#navMenu\" ).menu();  } </script>\n")>-1){
					navBuilder.delete(0, "/n<script> $(function() {  $( \"#navMenu\" ).menu();  } </script>\n".length());
				}
			}
		
	}
	
	public void createNav(String navClass){
		navBuilder.append("     <ul class=\"" +((bootstrap)?"nav ": "") + " "+navClass+"\">\n");		   
	}
	
	
	public void addNavLink(String link, String linkText, String domClass){
		if(!navBuilder.toString().contains("<ul"))
				navBuilder.append("      <ul id=\"navMenu\" class=\"navMenu navUlClass\">\n");
		navItems++;
		 navBuilder.append("            <li role=\"presentation\"   class=\"navLinkClass "+domClass+"\"><a href=\"./Link?page="+link+"\">"+linkText+"</a></li>\n");
	}
	
	
	public void navJustify(boolean isJustify){	
		this.justified = isJustify;
		if(isJustify)
			if(bootstrap) 
				navClass =navClass.concat(" nav-justified"); 
			else
				navClass = navClass.concat(" fullwidth  flex");
			 
		else
			if(bootstrap)
				if(navClass.contains(" nav-justified"))
					navClass =navClass.replace(" nav-justified", "");
				else;
			else
					if(navClass.contains(" fullwidth flex"))
						navClass = navClass.replace(" fullwidth  flex", "");
			
		
	}
	
	
	public NavBuilder(String code, boolean bootstrap)  {
		this.bootstrap = bootstrap;
		this.navBuilder.append(code);
	}

	public String getCode(){
		int navWidth= 1;
		if(navItems>0)navWidth= 100/navItems;
		if(justified && !bootstrap){
			navClass.concat(" flex");
		}
		navBuilder.append("     </ul>\n");
		String nav =  navBuilder.toString();
		nav = nav.replaceAll("navUlClass", navClass);
		nav = nav.concat("</nav>\n</div>\n");
		if(justified && !bootstrap){
			nav = nav.replaceAll("navLinkClass" , "flex");
			nav = nav.replaceAll("navLinkStyle","width:"+navWidth+"%;");
		}
		if(stacked && !bootstrap && jQueryUi){
			nav= "<script> $(function() {$(\"#navUlId\" ).menu();}); </script>"+nav;
		}
		nav.replaceAll("style=\"navLinkStyle\"", "");
		nav=nav.replaceAll("null", "");
		/*
		String nav = navBuilder.toString();
		nav= nav.concat("\n"+((bootstrap)?"</div> <! --nav container end  -->\n" : ""));
		nav = nav.concat("</div>\n");
		nav = nav.concat("</nav>\n");
		*/
		return nav;
				
	}
	 

	public void setCode(String code) {
		this.navBuilder.append(code);
	}
	
	public Span getAsSpan(){ 
		return new Span(this.getCode());
	}
	
	
   /*     <div class="navbar-header">")
		
		<div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>
            <li><a href="../navbar-static-top/">Static top</a></li>
            <li><a href="../navbar-fixed-top/">Fixed top</a></li>
          </ul>
        </di
        
        */
	 
	
	public String toString() {
		return this.getCode();
	}
}

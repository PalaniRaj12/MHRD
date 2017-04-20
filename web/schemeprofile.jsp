
<html>

<head>
  <title>Profile page</title>
  
  <style type="text/css">
  
 html
{ height: 100%;
 }

*
{ margin: 0;
  padding: 0;}

.btn { display: inline-block; *display: inline; *zoom: 1; padding: 4px 10px 4px; margin-bottom: 0; font-size: 13px; line-height: 18px; color: #333333; text-align: center;text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75); vertical-align: middle; background-color: #f5f5f5; background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6); background-image: -ms-linear-gradient(top, #ffffff, #e6e6e6); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6)); background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6); background-image: -o-linear-gradient(top, #ffffff, #e6e6e6); background-image: linear-gradient(top, #ffffff, #e6e6e6); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0); border-color: #e6e6e6 #e6e6e6 #e6e6e6; border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25); border: 1px solid #e6e6e6; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); cursor: pointer; *margin-left: .3em; }
.btn:hover, .btn:active, .btn.active, .btn.disabled, .btn[disabled] { background-color: #e6e6e6; }
.btn-large { padding: 9px 14px; font-size: 15px; line-height: normal; -webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; }
.btn:hover { color: #333333; text-decoration: none; background-color: #e6e6e6; background-position: 0 -15px; -webkit-transition: background-position 0.1s linear; -moz-transition: background-position 0.1s linear; -ms-transition: background-position 0.1s linear; -o-transition: background-position 0.1s linear; transition: background-position 0.1s linear; }
.btn-primary, .btn-primary:hover { text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25); color: #ffffff; }
.btn-primary.active { color: rgba(255, 255, 255, 0.75); }
.btn-primary { background-color: #4a77d4; background-image: -moz-linear-gradient(top, #6eb6de, #4a77d4); background-image: -ms-linear-gradient(top, #6eb6de, #4a77d4); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6eb6de), to(#4a77d4)); background-image: -webkit-linear-gradient(top, #6eb6de, #4a77d4); background-image: -o-linear-gradient(top, #6eb6de, #4a77d4); background-image: linear-gradient(top, #6eb6de, #4a77d4); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#6eb6de, endColorstr=#4a77d4, GradientType=0);  border: 1px solid #3762bc; text-shadow: 1px 1px 1px rgba(0,0,0,0.4); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.5); }
.btn-primary:hover, .btn-primary:active, .btn-primary.active, .btn-primary.disabled, .btn-primary[disabled] { filter: none; background-color: #4a77d4; }
.btn-block { width: 100%; display:block; }

body
{ font-family:sans-serif;
  font-size:22px;
  background: #092756;
  color: #FFF;
  align:center;
  padding-top:30px;
  overflow: auto;
  overflow-x:auto;
  }


h1, h2, h3, h4, h5, h6 
{ color: #A21FA2;
  letter-spacing: 0em;
  font: normal 170% 'century gothic', arial;
  padding: 0 0 5px 0;}

a, a:hover
{ outline: none;
  text-decoration: underline;
  color: #009FBC;}




#header
{ background: #092756;
  border-bottom: 4px solid #a3c2c2;
  height: 177px;}
  
#logo
{ width: 100%;
  position: relative;
  height: 140px;
  background: transparent;}

#logo #logo_text 
{ positio: absolute; 
  top: 10px;
  left: 0;}

#logo h1, #logo h2
{ font: normal 300% 'century gothic', arial, sans-serif;
	font-size:50px;
  border-bottom: 0;
  text-transform: none;
  margin: 0 0 0 39px;}

#logo_text h1, #logo_text h1 a, #logo_text h1 a:hover 
{ padding: 22px 0 0 0;
  color: #FFF;
  letter-spacing: 0.1em;
  text-decoration: none;}


#menubar
{ width: 680px;
  height: 46px;} 
  
//menu items starts here.....
ul#menu
{ float:left;
  margin:0px;}

ul#menu li
{ float:left;
  padding: 0 0 0 9px;
  list-style: none;
  margin: 1px 2px 0 0;
  background: transparent;}

ul#menu li a
{ font-family: sans-serif;
  font-size:18px;
  display: block; 
  float: left; 
  height: 20px;
  padding: 6px 35px 5px 28px;
  text-align: center;
  color: #eee6ff;
  text-decoration: none;
  background: transparent;} 

ul#menu li.selected a
{ height: 20px;
  padding: 6px 35px 5px 28px;}

ul#menu li.selected
{ margin: 1px 8px 0px 10px;
  background: #264d73;}
  
//menu name font color.....

ul#menu li.selected a, ul#menu li.selected a:hover
{ 
  background: #A21FA2;
  color: #000;}
  
//menu item hover color full

ul#menu li a:hover
{ color: #FFF;
  background: #A21FA2;}

#footer
{ width: 100%;
  font-family: 'trebuchet ms', sans-serif;
  font-size: 100%;
  height: 60px;
  padding: 28px 0 5px 0;
  text-align: center; 
  background:  #264d73;
  border-top: 2px double #a3c2c2;
  color: #FFF;}

#footer p
{ line-height: 1.7em;
  padding: 0 0 10px 0;}

#footer a
{ color: #a3c2c2;
  text-decoration: blink;}

#footer a:hover
{ color: #FFF;
  text-decoration: none;}

center{
padding-top:30px;
padding-bottom:30px;
}

th, td {
    padding: 5px;
    text-align: left;
}

  
  #logout{  
  float: right;
  margin: 0 50px 0 0;
  width:20%;
  height:80px;
  font-size: 18px;
  font-family: sans-serif;
  font-weight: bold;
  }
 .vali
 {
  color: #fff; text-shadow: 0 0 10px rgba(0,0,0,0.3); letter-spacing:2px; text-align:center; padding: 10px; 
 }
  </style>
<script type="text/javascript">
  

var n=JSON.parse(localStorage.getItem("on_oad"));
var count=localStorage.getItem("cou");

window.addEventListener("load",function(){
	//document.write("on_load"+localStorage.getItem("on_oad")+"iobtn;  "+localStorage.getItem("iobtn")+" count:  "
		//		+localStorage.getItem("cou")+"t1:  "+localStorage.getItem("temp1")+"  t2:  "+localStorage.getItem("temp2"));
   <%

   %>             
                
},false);

var count=0;
  var temp=0;
  function onchangein()
  {		  
	if(n==1)
	{
		  count++;
	  if(count>=1)
		 {
	  document.getElementById("btnin").innerHTML="In time marked...";
		document.getElementById("btnin").disabled=true;
	  document.getElementById("btnout").style.visibility="visible";
	  document.getElementById("msg").style.visibility="hidden";
	  n++;
	  temp=1;
		 }
	  else
		  {
		  document.getElementById("btnin").disabled=true;
		  document.getElementById("btnout").style.visibility="visible";			
		  }
  	}
	else if(n>1)
	{
		  document.getElementById("msg").innerHTML="In-time and Out-time entered already....";		   		  
		  document.getElementById("btnin").disabled=true;
		  document.getElementById("btnout").disabled=true;  		  
	}
  }
  
  function onchangeout()
  {	  	 
	if(n>=1)
	{
	  count++;
	  if(count>=2 && temp==1)
		 {
		  //document.write(n);	  
		  document.getElementById("btnout").innerHTML="out time marked...";
		  document.getElementById("btnout").disabled=true;
		  	document.getElementById("btnin").innerHTML="In time marked...";
		  	document.getElementById("btnin").disabled=true;
		  	n++;
		 }
	  else if(count>=1 && temp!=1)
		  {
		  //document.write(count);
		  	document.getElementById("msg").innerHTML="please Enter your In-time First...";		  	
		  }
	  else{
		  //document.write(n);
		  document.getElementById("btnin").disabled=true;
		  document.getElementById("btnout").disabled=true;
	  }
	 }
	else if(n>2)
	{
	      document.getElementById("msg").innerHTML="In-time and Out-time entered already....";		
		  document.getElementById("btnin").disabled=true;
		  document.getElementById("btnout").disabled=true;  
	}
	else
		{
		  document.write(n);
		}
  }
  
  function locals()
  {
	  localStorage.removeItem("on_oad");
	  localStorage.removeItem("iobtn");
	  localStorage.removeItem("temp1");
	  localStorage.removeItem("cou");
	  localStorage.removeItem("temp2");
  }
  
  </script>
</head>

<body>
  <div id="main">                  
    <div id="body_contents">
    
  <center>
  <table id="t01">
  <div class="vali">
		<% 
			if(null!=request.getAttribute("error"))
			{
				out.println(request.getAttribute("error"));
			}
		%>
</div>
  <caption>Scheme Details</caption>
  <tr>
    <td>Scheme code</td>
    <td>:</td>
    <td>
    <%
		if (session != null) {
			if (session.getAttribute("schemecode") != null) {
				String name = (String) session.getAttribute("schemecode");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
	</td>
  </tr>
  
  <tr>
    <td>Scheme Name</td>
    <td>:</td>
    <td>
    <%
		if (session != null) {
			if (session.getAttribute("schemename") != null) {
				String name = (String) session.getAttribute("schemename");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
  </tr>
  
  
  <tr>
    <td>Scheme Apply link</td>
    <td>:</td>
    <td>
    <%
		if (session != null) {
			if (session.getAttribute("schemelink") != null) {
				String name = (String) session.getAttribute("schemelink");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
  </tr>
  
  
  <tr>
    <td>Min age</td>
    <td>:</td>
    <td>
    <%
		if (session != null) {
			if (session.getAttribute("minage") != null) {
				String name = session.getAttribute("minage").toString();				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
	</td>
  </tr>
  
  
  <tr>
    <td>Max age</td>
    <td>:</td>
    <td>
    <%
		if (session != null) {
			if (session.getAttribute("maxage") != null) {
				String name =(String)session.getAttribute("maxage").toString();				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
		
    </td>
  </tr>
  
  
  <tr>
    <td>Annual Income</td>
    <td>:</td>
    <td>
    <%
		if (session != null) {
			if (session.getAttribute("aincome") != null) {
				String name =session.getAttribute("aincome").toString();				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
  </tr>
	
	<tr>
	<td>Caste category</td>
	<td>:</td>
	<td>
    <%
		if (session != null) {
			if (session.getAttribute("caste") != null) {
				String name = (String) session.getAttribute("caste");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
	</tr>
	
	<tr>
	<td>Educational qualification</td>
	<td>:</td>
	<td>
    <%
		if (session != null) {
			if (session.getAttribute("eduqual") != null) {
				String name = (String) session.getAttribute("eduqual");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
	</tr>
        
        <tr>
	<td>Marital Status</td>
	<td>:</td>
	<td>
    <%
		if (session != null) {
			if (session.getAttribute("marital") != null) {
				String name = (String) session.getAttribute("marital");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
	</tr>
        
        <tr>
	<td>Gender</td>
	<td>:</td>
	<td>
    <%
		if (session != null) {
			if (session.getAttribute("gender") != null) {
				String name = (String) session.getAttribute("gender");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
	</tr>
        
        <tr>
	<td>Physical</td>
	<td>:</td>
	<td>
    <%
		if (session != null) {
			if (session.getAttribute("physical") != null) {
				String name = (String) session.getAttribute("physical");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
	</tr>
        
        <tr>
	<td>Citizenship</td>
	<td>:</td>
	<td>
    <%
		if (session != null) {
			if (session.getAttribute("citizenship") != null) {
				String name = (String) session.getAttribute("citizenship");				
				out.print(name);	
			} 
			else {
				out.print("null");
			}
		}
		%>
    </td>
	</tr>
  
	<tr>
	<td colspan="3"><button type="submit"  onclick=" window.location.href='updatepassword.jsp'" class="btn btn-primary btn-block btn-large">Update Password</button>
	</td>
	</tr>
 
     </table>
</center>	
	
    </div>
	
    
    
    
   
  
  </div>
</body>
</html>

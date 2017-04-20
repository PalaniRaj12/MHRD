<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.DButil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Eligible_list_bean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Eligible_Schemes</title>

<script>
var req,value;
function sendRequest(qq)
{
    
    value=qq;
    //window.alert(value);
    if(window.XMLHttpRequest)
    {
        req=new XMLHttpRequest();
    }
    else if(window.ActiveXObject)
    {
        req=new ActiveXObject("Microsoft.XMLHTTP");
    }
    var url="applyschemestatus?schemeid="+value;
    req.onreadystatechange=getResponse;
    req.open("GET",url,true);
    req.send(null);    
}
    function getResponse()
    {
        if(req.readyState==4)
        {
            if(req.status==200)
            {
                document.getElementById(value).innerHTML=((req.responseText==0)?"Apply":"Applied");
            }
        }
    }
</script>
    

 <style>
  
.btn { display: inline-block; *display: inline; *zoom: 1; padding: 4px 10px 4px; margin-bottom: 0; font-size: 13px; line-height: 18px; color: #333333; text-align: center;text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75); vertical-align: middle; background-color: #f5f5f5; background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6); background-image: -ms-linear-gradient(top, #ffffff, #e6e6e6); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6)); background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6); background-image: -o-linear-gradient(top, #ffffff, #e6e6e6); background-image: linear-gradient(top, #ffffff, #e6e6e6); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0); border-color: #e6e6e6 #e6e6e6 #e6e6e6; border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25); border: 1px solid #e6e6e6; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); cursor: pointer; *margin-left: .3em; }
.btn:hover, .btn:active, .btn.active, .btn.disabled, .btn[disabled] { background-color: #e6e6e6; }
.btn-large { padding: 9px 14px; font-size: 15px; line-height: normal; -webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; }
.btn:hover { color: #333333; text-decoration: none; background-color: #e6e6e6; background-position: 0 -15px; -webkit-transition: background-position 0.1s linear; -moz-transition: background-position 0.1s linear; -ms-transition: background-position 0.1s linear; -o-transition: background-position 0.1s linear; transition: background-position 0.1s linear; }
.btn-primary, .btn-primary:hover { text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25); color: #ffffff; }
.btn-primary.active { color: rgba(255, 255, 255, 0.75); }
.btn-primary { background-color: #4a77d4; background-image: -moz-linear-gradient(top, #6eb6de, #4a77d4); background-image: -ms-linear-gradient(top, #6eb6de, #4a77d4); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6eb6de), to(#4a77d4)); background-image: -webkit-linear-gradient(top, #6eb6de, #4a77d4); background-image: -o-linear-gradient(top, #6eb6de, #4a77d4); background-image: linear-gradient(top, #6eb6de, #4a77d4); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#6eb6de, endColorstr=#4a77d4, GradientType=0);  border: 1px solid #3762bc; text-shadow: 1px 1px 1px rgba(0,0,0,0.4); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.5); }
.btn-primary:hover, .btn-primary:active, .btn-primary.active, .btn-primary.disabled, .btn-primary[disabled] { filter: none; background-color: #4a77d4; }
.btn-block { width: 100%; display:block; }

* { -webkit-box-sizing:border-box; -moz-box-sizing:border-box; -ms-box-sizing:border-box; -o-box-sizing:border-box; box-sizing:border-box; }

body {
 
	width:auto;
	height:auto;
        color:black;
	overflow:auto;
	overflow-x:auto;
	font-family: 'Open Sans', sans-serif;
	font-size:16px;
}
  #customers {
      
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    padding: 25px;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    text-align: left;
    padding: 10px;
    //padding-right: 15px;
    //width:10%;
}

#customers th {
    
    background-color: #4CAF50;
   
text-align: center;
}
 </style>
  

</head>

<body>
     <div class="pwd">
                        <% 
                            session.getAttribute("aadharno");
			if(null!=session.getAttribute("err"))
			{
				//out.println("if"+session.getAttribute("err"));
                                  // out.println("if"+session.getAttribute("arraylist"));
			}
                        else
                        {
                            	//out.println("else"+session.getAttribute("err"));
                                //out.println("else"+session.getAttribute("k"));
                        }
		%>
     </div>
     <center><p><h1>Your Eligible Schemes List </h1></p></center>
        
    <table align="center" border="1" id="customers">
        
         <tr>                                        
                                        <th>Scheme Code</th>
                                        <th>Scheme Name</th>
                                        <th>Status</th>
         </tr>
                                        
        <%
            Connection con=DButil.getDbconnection();
            try{
            PreparedStatement ps=con.prepareStatement("select scheme_code, scheme_name, apply from usereligiblescheme where username=?");
            String s=(String)session.getAttribute("aadharno");
            ps.setString(1,s);
           %>     
            <% ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                     String q=rs.getString(1);
                 %>
                 <tr>
                     <td>
                         <%= q%>
                     </td>
                     
                     <td>
                         <%= rs.getString(2)%>
                     </td>
                     
                     <td>
                         
                          
                          <button  onclick="sendRequest(this.value)" id="<%=q%>" value="<%=q%>">
                         <%
                         if(rs.getInt(3)==0)
                         {
                             %>Apply<%}                         
                         else
                         {%>Applied<%}
                         %>
                     </button>
                     
                     </td>
                 </tr>
                <%}}
                catch(Exception e)
                {
                    e.printStackTrace();
                            
                %></table>
                <p>catch</p>
                 <%
                    
                }
            %>                
</body>
</html>

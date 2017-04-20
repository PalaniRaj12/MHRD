
<%@page import="bean.SchemeCreationbean"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.Eligible_list_bean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML>
<html>
<head>
<title>MHRD</title>
<style>
    .grid-form,.grid-form1{
        height:30%;
        overflow:auto;
    }
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    
}

#customers td, #customers th {
    border: 1px solid #ddd;
    text-align: left;
    padding: 6px;
    //width:10%;
}

#customers tr:nth-child(even){background-color: #f2f2f2}



#customers th {
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: #4CAF50;
    color: white;
text-align: center;
}
 </style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<script src="js/jquery.min.js"> </script>
<!-- Mainly scripts -->
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<link href="css/custom.css" rel="stylesheet">
<script src="js/custom.js"></script>
<script src="js/screenfull.js"></script>
		<script>
		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}



			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			});



		});
		</script>

<!----->

<!--pie-chart--->

<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body>
<div id="wrapper">

<!----->
        <nav class="navbar-default navbar-static-top" role="navigation">
             <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <h1> <a class="navbar-brand" href="#">Dashboard</a></h1>
			   </div>
			 <div class=" border-bottom">
        	<div class="full-left">
        	  <section class="full-top">
				<button id="toggle"><i class="fa fa-arrows-alt"></i></button>
			</section>
			<!--<form class=" navbar-left-right">
              <input type="text"  value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}">
              <input type="submit" value="" class="fa fa-search">
            </form>-->
            <div class="clearfix"> </div>
           </div>


            <!-- Brand and toggle get grouped for better mobile display -->

		   <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="drop-men" >



					<li class="dropdown">
		              <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">Admin<i class="caret"></i></span><img src="images/wo.jpg"></a>
		              <ul class="dropdown-menu " role="menu">
		                <li><a href="#"><i class="fa fa-clipboard"></i>Logout</a></li>
		              </ul>
		            </li>

		        </ul>
		     </div><!-- /.navbar-collapse -->
			<div class="clearfix">

     </div>

		    <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">

                    <li>
                        <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-indent nav_icon"></i> <span class="nav-label">Scheme Menu</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            
					   </ul>
                    </li>
                    <li>
		  <a href="<%=request.getContextPath()%>/Ueligible" class=" hvr-bounce-to-right"> <i class="fa fa-align-left nav_icon"></i>View Eligible Schemes</a>
                 </li>
                 <li>
                  <a href="<%=request.getContextPath()%>/Allschemeviewservlet" class=" hvr-bounce-to-right"><i class="fa fa-align-left nav_icon"></i>Show All Schemes</a>
                 </li>	    
					 <li>
                        <a href="logout.php" class=" hvr-bounce-to-right"><i class="fa fa-inbox nav_icon"></i> <span class="nav-label">Logout</span> </a>
                    </li>
            </div>
			</div>
        </nav>
        <div id="page-wrapper" class="gray-bg dashbard-1">
       <div class="content-main">

  		<!--banner-->
		    <div class="banner">

				<h2>
				<a href="index.html">Home</a>
				<i class="fa fa-angle-right"></i>
				<span>View scheme</span>
				</h2>
		    </div>
		<!--//banner-->
		<!--content-->
		<div class="content-top">


			<div class="grid-form">
		 		<div class="grid-form1">
		 		<h3 id="forms-example" class="">View Schemes</h3>			
     <div class="pwd">
                     <table border="1" id="customers">
                                    <tr>
                                        <th>S.No</th>
                                        <th>Scheme Code</th>
                                        <th>Scheme Name</th>
                                        <th>Scheme Apply Link</th>
                                        <th>Minimum Age</th>
                                        <th>Maximum Age</th>
                                        <th>Annual Income</th>
                                        <th>Caste category</th>
                                        <th>Educational Qualification</th>
                                        <th>Marital Status</th>
                                        <th>Gender</th>
                                        <th>Physically challenged</th>
                                        <th>citizenship</th>
                                    </tr>
                        
                
             	<% 
                        if (session.getAttribute("allschemelist") != null) {
		ArrayList<SchemeCreationbean> elb=(ArrayList<SchemeCreationbean>)session.getAttribute("allschemelist");			
			Iterator il=elb.iterator();
                        int sno=1;                      
                                while(il.hasNext())
				{
				SchemeCreationbean re=(SchemeCreationbean)il.next();
                                
			    %>
                                
                                <tr>
                                    <td><%=sno++%></td>
                                    <td><%=re.getSchemecode()%></td>
                                    <td><%=re.getSchemename()%></td>
                                    <td><a href="
                                           <%=re.getSchemelink()%> ">click here to apply</a> 
                                    </td>
                                    <td><%=re.getMinage()%></td>
                                    <td><%=re.getMaxage()%></td>
                                  
                                    <td> <% int a=re.getAincome();%>
                                   
                                        <% if(a==0) { %>
                                    
                                        <%= "Any Income" %>
                                        <% } else { %>
                                        <%=a %>
                                        <% }%>
                                    </td>
                                    <td><% String r=re.getCaste();%>
                                   
                                        <% if(r.equalsIgnoreCase("null")) { %>
                                    
                                        <%= "All Caste" %>
                                        <% } else { %>
                                        <%=r %>
                                        <% }%>
                                    </td>
                                    <td><% r=re.getEduqual();%>
                                   
                                        <% if(r.equalsIgnoreCase("null")) { %>
                                    
                                        <%= "All Educational Qualification" %>
                                        <% } else { %>
                                        <%=r %>
                                        <% }%>
                                    </td>
                                    
                                    <td><% r=re.getMarital();%>
                                   
                                        <% if(r.equalsIgnoreCase("null")) { %>
                                    
                                        <%= "All Marital status" %>
                                        <% } else { %>
                                        <%=r %>
                                        <% }%>
                                    </td>
                                      <td><% r=re.getGender();%>
                                   
                                        <% if(r.equalsIgnoreCase("null")) { %>
                                    
                                        <%= "All Gender" %>
                                        <% } else { %>
                                        <%=r %>
                                        <% }%>
                                    </td>
                                    <td><% r=re.getPhysical();%>
                                   
                                        <% if(r.equalsIgnoreCase("null")) { %>
                                    
                                        <%= "All Physical condition" %>
                                        <% } else { %>
                                        <%=r %>
                                        <% }%>
                                    </td>
                                    <td><% r=re.getCitizenship();%>
                                   
                                        <% if(r.equalsIgnoreCase("null")) { %>
                                    
                                        <%= "All citizenship" %>
                                        <% } else { %>
                                        <%=r %>
                                        <% }%>
                                    </td>                                    
                                </tr>                                		
                                  <%}%>  
                                  
                    	        </table>               
                   <%           
                        }
                         else {
				out.println("No Schemes available right now.....");
			}
                        %>
                     
                </div>
                        
		</div>
			<div class="clearfix"> </div>
		</div>
	</div>
		<!--//content-->



		<!---->
<div class="copy">
            <p> &copy; 2017 MHRD. All Rights Reserved | Design by <a href="#" target="_blank">TechGeeks</a> </p>
	    </div>
		</div>
		<div class="clearfix"> </div>
       </div>
     </div>
<!---->
<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<script src="js/bootstrap.min.js"> </script>
</body>
</html>

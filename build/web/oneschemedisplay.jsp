
<!DOCTYPE HTML>
<html>
<head>
<title>MHRD</title>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
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
		                <li><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-clipboard"></i>Logout</a></li>
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
                            <li><a href="create_scheme.jsp" class=" hvr-bounce-to-right"> <i class="fa fa-align-left nav_icon"></i>Create Scheme</a></li>
                            <li><a href="update_scheme.jsp" class=" hvr-bounce-to-right"><i class="fa fa-align-left nav_icon"></i>Update Scheme</a></li>
                            <li><a href="delete_scheme.jsp" class=" hvr-bounce-to-right"><i class="fa fa-align-left nav_icon"></i>Delete Scheme</a></li>
                            <li><a href="view_scheme_menu.jsp" class=" hvr-bounce-to-right"><i class="fa fa-desktop nav_icon"></i>View Scheme</a></li>

					   </ul>
                    </li>
					 <li>
                        <a href="<%=request.getContextPath()%>/logout" class=" hvr-bounce-to-right"><i class="fa fa-inbox nav_icon"></i> <span class="nav-label">Logout</span> </a>
                    </li>
            </div>
			</div>
        </nav>
        <div id="page-wrapper" class="gray-bg dashbard-1">
       <div class="content-main">

  		<!--banner-->
		    <div class="banner">

				<h2>
				<a href="AdminDashboard.jsp">Home</a>
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
			
    <table id="customers">  
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
  
	
 
     </table>      







		</div>
			<div class="clearfix"> </div>
		</div>
	</div>
		<!--//content-->



		<!---->
<div class="copy">
            <p> &copy; 2017 MHRD. All Rights Reserved | Design by <a href="#" target="_blank">Techgeeks</a> </p>
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

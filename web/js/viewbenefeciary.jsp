<%-- 
    Document   : viewbenefeciary
    Created on : 2 Apr, 2017, 2:20:48 PM
    Author     : manis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="viewbenefeciary">
            <select name="schemes">
                <option value="asd">All India rural people pension</option>
                 <option value="FPS12">Farmers Pension Scheme</option>
                  <option value="OPPS">PRAGAYAN MANDRI PENSION SCHEME</option>
                   <option value="WPS">WOMAN WELFARE SCHEME</option>
                 <option value="PMRDF">Prime Ministers Rural Development Fellows Scheme</option>
                  <option value="SY">Scheme Y</option>
                   <option value="SZ">Scheme Z</option>
            </select>
            <input type="submit" value="schemelist">
                
        </form>
    </body>
</html>

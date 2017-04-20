<%-- 
    Document   : view_applied_scheme_admin.jsp
    Created on : 2 Apr, 2017, 3:20:08 PM
    Author     : manis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <table>
        <%ArrayList <String> ar=new ArrayList<String>();
        for(int i=0;i<ar.size();i++)
        {%>
            <tr>
                <td>
                    <%=ar.get(i)%>
                </td>
            </tr>
        <%}%>
        </table>
    </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Adminloginbean;
import bean.Userbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Loginadmin;
import service.Useradmin;

/**
 *
 * @author Vignesh
 */
public class Userservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter pw = response.getWriter();
		//Receiving Values From HTML FORM
		HttpSession session = request.getSession(true); // reuse existing
                
         if(request.getParameter("uloginbtn").equals("ulogin"))
		{
			Useradmin ud=new Useradmin();
			String res=ud.selectuser(request,request.getParameter("aadhar"),request.getParameter("pin"));
			if(res.equalsIgnoreCase("success"))
			{
                          //  String s=map.get("panno").toString();
                            System.out.println(session.getAttribute("panno"));
                          //System.out.println(session.getAttribute("panno")+" "+s);
                         // System.out.println(session.getAttribute((String)map.get("aadhar")));
			/*session.setAttribute("aadhar",map.get("aadhar"));
                        session.setAttribute("panno", map.get("panno"));						
                        session.setAttribute("rid", map.get("rid"));
                        session.setAttribute("name",map.get("name"));                    
                        session.setAttribute("dob",map.get("dob"));
                        session.setAttribute("gender",map.get("gender"));
                        session.setAttribute("email",map.get("email"));
                        session.setAtt0ribute("educationalqualification",map.get("educationalqualification"));
                        session.setAttribute("address",map.get("address"));
                        session.setAttribute("city",map.get("city"));
                        session.setAttribute("district",map.get("district"));
                        session.setAttribute("state",map.get("state"));
                        session.setAttribute("pincode",map.get("pincode"));
                        session.setAttribute("mobileno",map.get("mobileno"));
                        session.setAttribute("physicallychallenged",map.get("physicallychallenged"));			
                        session.setAttribute("maritalstatus",map.get("maritalstatus"));*/
//session.setMaxInactiveInterval(30); // keep page ideal for 30 seconds,redirect to login page again.........	
                          
			request.setAttribute("error",null);
			response.sendRedirect("welcome_user_page.jsp");
			}
			else
			{
				//session.invalidate();
				request.setAttribute("error","Invalid Username or Password");
				RequestDispatcher rd= request.getRequestDispatcher("/user_login.jsp");
				rd.forward(request, response);
			}
		}
                
                
        processRequest(request, response);
    }


}

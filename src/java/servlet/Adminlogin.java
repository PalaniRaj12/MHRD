/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Adminloginbean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Loginadmin;

/**
 *
 * @author Vignesh
 */
public class Adminlogin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    	PrintWriter pw = response.getWriter();
		//Receiving Values From HTML FORM
		HttpSession session = request.getSession(true); // reuse existing
                
         if(request.getParameter("loginbutton").equals("userlogin"))
		{
			Adminloginbean lb=new Adminloginbean();
			Loginadmin ld=new Loginadmin();
			lb=ld.selectuseradmin(request.getParameter("user"),request.getParameter("pass"));
			if(lb!=null)
			{
			session.setAttribute("username",lb.getUsername());
			session.setAttribute("password", lb.getPassword());						
			//session.setMaxInactiveInterval(30); // keep page ideal for 30 seconds,redirect to login page again.........		
			request.setAttribute("error",null);
			response.sendRedirect("AdminDashboard.jsp");
			}
			else
			{
				session.invalidate();
				request.setAttribute("error","Invalid Username or Password");
				RequestDispatcher rd= request.getRequestDispatcher("/inde.jsp");
				rd.forward(request, response);
			}
		}
         else
         {
                                session.invalidate();
				request.setAttribute("error","login first..");
				RequestDispatcher rd= request.getRequestDispatcher("/inde.jsp");
				rd.forward(request, response);
         }
                
                
    
        processRequest(request, response);
    }

    
}

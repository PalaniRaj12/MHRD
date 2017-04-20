/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.SchemeCreationbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.SchemeCreationadmin;

/**
 *
 * @author Vignesh
 */
public class userallschemeview extends HttpServlet {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter pw = response.getWriter();
		//Receiving Values From HTML FORM
		HttpSession session = request.getSession(true); // reuse existing
                
                SchemeCreationbean scb=new SchemeCreationbean();
                SchemeCreationadmin sca=new SchemeCreationadmin();
                
               ArrayList<SchemeCreationbean> al=new ArrayList<SchemeCreationbean>();
                 if(request.getParameter("uschemeallview").equals("uallscheme"))
		{
                    al=sca.allschemefetch();
                    if(!al.isEmpty())
                    {
                        session.setAttribute("allschemelist", al);
                        response.sendRedirect("userallschemeview.jsp");
                    }
                     else if(al.isEmpty())
                     {
                         session.setAttribute("err","No Schemes available right now...");
                                response.sendRedirect("userallschemeview.jsp");
                     }
                    else
                    {
                        //session.invalidate();
				request.setAttribute("err","All scheme display error....");
				RequestDispatcher rd= request.getRequestDispatcher("/userwelcomepage.jsp");
				rd.forward(request, response);
                    }
                   }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

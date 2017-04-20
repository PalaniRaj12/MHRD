/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Eligible_list_bean;
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
public class Allschemeviewservlet extends HttpServlet {

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
                
                SchemeCreationbean scb=new SchemeCreationbean();
                SchemeCreationadmin sca=new SchemeCreationadmin();
                
               ArrayList<SchemeCreationbean> al=new ArrayList<SchemeCreationbean>();
                 if(request.getParameter("schemeallview").equals("allscheme"))
		{
                    al=sca.allschemefetch();
                    if(!al.isEmpty())
                    {
                        session.setAttribute("allschemelist", al);
                        response.sendRedirect("view_all_scheme.jsp");
                    }
                     else if(al.isEmpty())
                     {
                         session.setAttribute("err","No Schemes available right now...");
                                response.sendRedirect("view_all_scheme.jsp");
                     }
                    else
                    {
                        //session.invalidate();
				request.setAttribute("err","scheme display error....");
				RequestDispatcher rd= request.getRequestDispatcher("/userwelcomepage.jsp");
				rd.forward(request, response);
                    }
                    }
                }
        
    }


    


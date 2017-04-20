/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.SchemeCreationbean;
import bean.Eligible_list_bean;
import bean.Userbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Eligibleadmin;

/**
 *
 * @author Vignesh
 */
public class Eligibleservlet extends HttpServlet {

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
                System.out.println("annualincome is"+(String)session.getAttribute("annualincome"));
                String aadhar=(String) session.getAttribute("aadhar");
                System.out.println("here"+aadhar);
                
                String dob=(String) session.getAttribute("dob");
                
                /*String name=(String) session.getAttribute("name");
                String pass=(String) session.getAttribute("password");
                
                String annualincome=(String) session.getAttribute("annual_income");
                String caste=(String) session.getAttribute("caste");
                String edu=(String) session.getAttribute("edu");
                String marital=(String) session.getAttribute("marital");
                String gender=(String) session.getAttribute("gender");
                String phy=(String) session.getAttribute("phy");
                String city=(String) session.getAttribute("city");
                String state=(String) session.getAttribute("state");
                String pin=(String) session.getAttribute("pin");
                String mbl=(String) session.getAttribute("mbl");
                */
                String[] ymd=dob.split("-");
                int year= Integer.parseInt(ymd[0]);
                int month=Integer.parseInt(ymd[1]);
                int day=Integer.parseInt(ymd[2]);
                LocalDate today = LocalDate.now();
		  LocalDate birthday = LocalDate.of(year, month, day);
		   
		  Period p = Period.between(birthday, today);
		   int age=p.getYears() ;
		  //Now access the values as below
		  //System.out.println(p.getDays());
		  //System.out.println(p.getMonths());
		  //System.out.println(p.getYears());
                  System.out.println("here"+aadhar+age+""+dob);
                    ArrayList<Eligible_list_bean> al=new ArrayList<Eligible_list_bean>();
                                          
                    Eligibleadmin ed=new Eligibleadmin();
                    
                    al=ed.selecteligibleschemes(session,age);
                 
                    System.out.println(al);
                 
                     if(al!=null)
                    {
                            ed.apply(session,al,aadhar);   
                             System.out.println("inner"+al);
                            //session.setAttribute("k",k);
                        session.setAttribute("arraylist",al);
                          // session.setAttribute("aa",aadhar);
                            session.setAttribute("err"," Schemes available right now...");
                                response.sendRedirect("user_apply_eligible_scheme_list.jsp");
                    }
                     else if(al==null)
                     {
                         session.setAttribute("err","No Schemes available right now...");
                                response.sendRedirect("user_apply_eligible_scheme_list.jsp");
                     }
                     else
                    {
                        //session.invalidate();
				request.setAttribute("err","Invalid");
				RequestDispatcher rd= request.getRequestDispatcher("/user_login.jsp");
				rd.forward(request, response);
                    }
                }   
                
        
    

}

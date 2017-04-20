/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.SchemeCreationbean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.SchemeCreationadmin;
import util.DataException;

/**
 *
 * @author Vignesh
 */
public class SchemeUpdateservlet extends HttpServlet {

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
        
        response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//Receiving Values From HTML FORM
		HttpSession session = request.getSession(true); // reuse existing
		
                String scode=request.getParameter("scode");
		String sname=request.getParameter("sname");
               // String stxt=request.getParameter("txt");
		String minage=request.getParameter("minage");
                String maxage=request.getParameter("maxage");
		String aincome=request.getParameter("aincome");
		String caste=request.getParameter("caste_category");
		String edu=request.getParameter("edu");
		String marital=request.getParameter("marital_status");
		String gender=request.getParameter("gender");
		String phy=request.getParameter("phy");
                String citi=request.getParameter("citi");
                
               // pw.println(scode+sname+aincome+caste+citi+edu+gender+marital+maxage+minage+phy);
                
                if(request.getParameter("updatebtn").equals("update"))
		{
                    //pw.print("helo");
			SchemeCreationbean lb=new SchemeCreationbean();
                        lb.setSchemecode(scode);
                        lb.setSchemename(sname);
                        //lb.setSchemelink(stxt);
                        lb.setAincome(aincome);
                        lb.setCaste(caste);
                        lb.setCitizenship(citi);
                        lb.setEduqual(edu);
                        lb.setGender(gender);
                        lb.setMarital(marital);
                        lb.setMaxage(maxage);
                        lb.setMinage(minage);
                        lb.setPhysical(phy);
                        
			SchemeCreationadmin ld=new SchemeCreationadmin();
			String res="";
                        res = ld.updatedata(lb);
                        
			if(res.equalsIgnoreCase("success"))
					{
						request.setAttribute("error","Scheme update Success....");
						RequestDispatcher rdis= request.getRequestDispatcher("/update_scheme.jsp");
						rdis.forward(request, response);
					}
                        else if(res.equalsIgnoreCase("notexist"))
					{
                                            //System.out.println("else");
						request.setAttribute("error","Scheme Code and Name does't Match..");
                                                RequestDispatcher rdis= request.getRequestDispatcher("/update_scheme.jsp");
						rdis.forward(request, response);
			
					}
                       else
                        {
                                            //System.out.println("else");
						request.setAttribute("error","Sorry,update failure..");
                                                RequestDispatcher rdis= request.getRequestDispatcher("/update_scheme.jsp");
						rdis.forward(request, response);
			
					}
		
                }                
                else
			{
				//session.invalidate();
				request.setAttribute("error","login first..");
				RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
                
    

        }
}

package servlet;

import bean.Adminloginbean;
import bean.SchemeCreationbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Loginadmin;
import service.SchemeCreationadmin;
import util.DataException;





public class Schemeviewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Schemeviewservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//Receiving Values From HTML FORM
		HttpSession session = request.getSession(true); // reuse existing
		
                String scode=request.getParameter("scode");
		
               // pw.println(scode+sname+aincome+caste+citi+edu+gender+marital+maxage+minage+phy);
                
                if(request.getParameter("viewbtn").equals("view"))
		{
                    SchemeCreationbean sb=new SchemeCreationbean();                           
                    	SchemeCreationadmin ld=new SchemeCreationadmin();
			String res="";
                        sb = ld.viewdata(scode);
                        
			if(sb!=null)
					{
                                            session.setAttribute("schemecode",sb.getSchemecode() );
                                            session.setAttribute("schemename",sb.getSchemename());
                                           // session.setAttribute("schemelink",sb.getSchemelink());
                                            session.setAttribute("minage",sb.getMinage());
                                            session.setAttribute("maxage",sb.getMaxage());
                                            session.setAttribute("aincome",sb.getAincome());
                                            session.setAttribute("caste",sb.getCaste());
                                            session.setAttribute("eduqual",sb.getEduqual());
                                            session.setAttribute("marital",sb.getMarital());
                                            session.setAttribute("gender",sb.getGender());
                                            session.setAttribute("physical",sb.getPhysical());
                                            session.setAttribute("citizenship",sb.getCitizenship());
                                            
						request.setAttribute("error","Scheme view Success....");
						response.sendRedirect("oneschemedisplay.jsp");
					}
					else
					{
                                            //System.out.println("else");
						request.setAttribute("error","Sorry,Scheme Code does not exist....");
                                                RequestDispatcher rdis= request.getRequestDispatcher("/view_one_scheme.jsp");
						rdis.forward(request, response);			
					}
		
                }                
                else
			{
				//session.invalidate();
				request.setAttribute("error","login first..");
				RequestDispatcher rd= request.getRequestDispatcher("/inde.jsp");
				rd.forward(request, response);
			}
                response.getWriter().append("Served at: ").append(request.getContextPath());
        
        }
        }




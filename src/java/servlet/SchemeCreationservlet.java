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





public class SchemeCreationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchemeCreationservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//Receiving Values From HTML FORM
		HttpSession session = request.getSession(true); // reuse existing
		
                String scode=request.getParameter("scode");		
		String sname=request.getParameter("sname");
                String stxt=request.getParameter("txt");
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
                
                if(request.getParameter("createbtn").equals("create"))
		{
                    SchemeCreationbean sb=new SchemeCreationbean();
                    sb.setSchemecode(scode);
                    sb.setSchemename(sname);
                    //sb.setSchemelink(stxt);
                    sb.setMinage(minage);
                    sb.setMaxage(maxage);
                    sb.setAincome(aincome);
                    sb.setCaste(caste);
                    sb.setEduqual(edu);
                    sb.setMarital(marital);
                    sb.setGender(gender);
                    sb.setPhysical(phy);
                    sb.setCitizenship(citi);
                    
                    
                    	SchemeCreationadmin ld=new SchemeCreationadmin();
			String res="";
                        int a=1;
                        if(true)
                        {			
                             a=ld.usercheck(scode); //scode should return 0...
                            System.out.println("user"+a);
                        }
                        
                        if(a==0)
                        {
                            try {                        
                                res = ld.insertdata(sb);
                                            }
                            catch (DataException ex) {                        
                                        }
                        
                            if(res.equalsIgnoreCase("success"))
			    {
				request.setAttribute("error","Scheme creation Success....");
				RequestDispatcher rdis= request.getRequestDispatcher("/create_scheme.jsp");
				rdis.forward(request, response);
			     }
			    else
			    {
                                //System.out.println("else");
				request.setAttribute("error","Sorry,creation failure..");
                                RequestDispatcher rdis= request.getRequestDispatcher("/create_scheme.jsp");
			        rdis.forward(request, response);			
			     }
		
                        }
                        else
                        {
                            request.setAttribute("error","Sorry,Scheme code already exist..");
                                RequestDispatcher rdis= request.getRequestDispatcher("/create_scheme.jsp");
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
                response.getWriter().append("Served at: ").append(request.getContextPath());
        
        }
        }




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DButil;

/**
 *
 * @author Vignesh
 */
public class applyschemestatus extends HttpServlet {

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

        
            response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter(); 
                HttpSession session = request.getSession(true); // reuse existing
		String schemeid=request.getParameter("schemeid");
                System.out.println("scheme id is "+schemeid);
		Connection con=DButil.getDbconnection();
		int yesorno=0;
		try 
		{
			PreparedStatement ps=con.prepareStatement("update usereligiblescheme set apply=? where scheme_code=? and username=? ");
			ps.setInt(1,1);
			ps.setString(2, schemeid);
                        ps.setString(3,(String)session.getAttribute("aadharno"));
			yesorno= ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		out.println(yesorno);
//out.println(yesorno);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

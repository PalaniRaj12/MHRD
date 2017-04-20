/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Adminloginbean;
import bean.Userbean;
//import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import util.DButil;

/**
 *
 * @author Vignesh
 */
public class Userdao {

    public String userloginselect(HttpServletRequest request,String aadhar, String pin) {
        
        String r="";
        HttpSession session = request.getSession(); // reuse existing
        
        Connection con=DButil.getDbconnection();
		Userbean ub=new Userbean();
		int i=0;
		try{
                    PreparedStatement ps=con.prepareStatement("select pincode from aadhar where aadharno=? ");
			ps.setString(1,aadhar);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
                            //System.out.println("here");
                            if(pin.equals(rs.getString(1)))
                            {
                                
                                PreparedStatement ps1=con.prepareStatement("select * from aadhar where aadharno=? ");
                                ps1.setString(1,aadhar);
                                ResultSet rs1=ps1.executeQuery();
                                while(rs1.next())
                                {
                                    for(i=1;i<=rs1.getMetaData().getColumnCount();i++)
                                    {
                                        //r="success";
                                        session.setAttribute(rs1.getMetaData().getColumnName(i),rs1.getString(i).toString());
                                        System.out.println("aadhar"+session.getAttribute(rs1.getMetaData().getColumnName(i)));
                                    }
                                                                   
                                }
                                System.out.println(session.getAttribute("aadharno"));                                PreparedStatement ps2=con.prepareStatement("select * from it where panno=? ");
                                ps2.setString(1,(String)session.getAttribute("panno"));
                                System.out.println(session.getAttribute("panno").toString());
                                ResultSet rs2=ps2.executeQuery();
                                while(rs2.next())
                                {
                                    for(i=1;i<=rs2.getMetaData().getColumnCount();i++)
                                    {
                                        session.setAttribute(rs2.getMetaData().getColumnName(i),rs2.getString(i));
                                        System.out.println("pan"+session.getAttribute(rs2.getMetaData().getColumnName(i)));
                                    }
                                }
				PreparedStatement ps3=con.prepareStatement("select * from rationcard where rid=? ");
                                ps3.setString(1,(String)session.getAttribute("rid"));
                                System.out.println(session.getAttribute("rid").toString());
                                ResultSet rs3=ps3.executeQuery();
                                while(rs3.next())
                                {
                                    for(i=1;i<=rs3.getMetaData().getColumnCount();i++)
                                    {
                                        r="success";
                                        session.setAttribute(rs3.getMetaData().getColumnName(i),rs3.getString(i));
                                        System.out.println("ration"+session.getAttribute(rs3.getMetaData().getColumnName(i)));
                                    }
                                }
                            }
                            else{
                                return "failure";
                            }
                            //map.put("d", "ff");
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
				//System.out.println("length of password"+lb.getEmail());
		return r;
    }
     
    
    
}

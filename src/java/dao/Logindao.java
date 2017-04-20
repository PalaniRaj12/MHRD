package dao;

import bean.Adminallschemeviewbean;
import bean.Adminloginbean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DButil;

public class Logindao {


    public Adminloginbean adminselect(String un, String pw) {
        
        Connection con=DButil.getDbconnection();
		Adminloginbean lb=new Adminloginbean();
		int i=0;
		try{
			
			PreparedStatement ps=con.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1,un);
			ps.setString(2,pw);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=1;
				lb.setUsername(rs.getString(1));
				lb.setPassword(rs.getString(2));
				
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}		
				if(i==0)
				{
					lb=null;
				}
				//System.out.println("length of password"+lb.getEmail());
		return lb;
    }

    public ArrayList<Adminallschemeviewbean> allschemeview() {

        ArrayList<Adminallschemeviewbean> al=new ArrayList<Adminallschemeviewbean>();
        Connection con=DButil.getDbconnection();		
		int i=0;
		try{
			
			PreparedStatement ps=con.prepareStatement("select scheme_code,scheme_name from schema_admin");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=1;
                                Adminallschemeviewbean lb=new Adminallschemeviewbean();
				lb.setSchemecode(rs.getString(1));
				lb.setSchemename(rs.getString(2));	
                                al.add(lb);
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}		
			return al;
    }

}

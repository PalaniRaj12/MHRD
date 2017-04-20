package dao;

import bean.Eligible_list_bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.SchemeCreationbean;
import java.util.ArrayList;
import util.DButil;

public class SchemeCreationdao {

	public String reginsert(SchemeCreationbean lb) {

		Connection con=DButil.getDbconnection();
		int i=0;
		try {
		
		   PreparedStatement ps=con.prepareStatement("insert into schema_admin values(?,?,?,?,?,?,?,?,?,?,?)");
		   ps.setString(1, lb.getSchemecode());
		   ps.setString(2, lb.getSchemename());
                 //  ps.setString(3, lb.getSchemelink());
		   ps.setString(3, lb.getMinage());
		   ps.setString(4,lb.getMaxage());
		   ps.setString(5, lb.getGender());
		   ps.setString(6,lb.getCaste());
		   ps.setString(7, lb.getEduqual());
		   ps.setString(8,lb.getAincome());
		   ps.setString(9, lb.getMarital());
		   ps.setString(10, lb.getPhysical());
                   ps.setString(11, lb.getCitizenship());
		   i=ps.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(i>0)
		{
			System.out.println("registration process"+i);
			
			return "success";
		
		}
		else
		{
			return "FAILURE";
		}
	}

    public String updatescheme(SchemeCreationbean lb) {
        
        
        Connection con=DButil.getDbconnection();
		int i=0;
		try {
		
		   PreparedStatement ps=con.prepareStatement("update schema_admin set min_age=?, max_age=?, gender=?,caste_category=?,edu_qualification=?,annual_income=?"
                           + ",marital_status=?, physically_challenged=?,citizenship=? where scheme_code=? and scheme_name=?"
                           + " ");
		 //ps.setString(1, lb.getSchemecode());
		 //  ps.setString(2, lb.getSchemename());
                 //  ps.setString(3, lb.getSchemelink());
		   ps.setString(1, lb.getMinage());
		   ps.setString(2,lb.getMaxage());
		   ps.setString(3, lb.getGender());
		   ps.setString(4,lb.getCaste());
		   ps.setString(5, lb.getEduqual());
		   ps.setString(6,lb.getAincome());
		   ps.setString(7, lb.getMarital());
		   ps.setString(8, lb.getPhysical());
                   ps.setString(9, lb.getCitizenship());
                 ps.setString(10, lb.getSchemecode());
		   ps.setString(11, lb.getSchemename());
                   
		   i=ps.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(i>0)
		{
			System.out.println("registration process"+i);
			
			return "success";
		
		}
                else if (i==0)
		{
			return "notexist";
		}
                else 
                {
                    return "failure";
                }
    }

    public String deletescheme(String scode) {
       
        Connection con=DButil.getDbconnection();
            int i=0;
		try {
		
		   PreparedStatement ps=con.prepareStatement("delete from schema_admin where scheme_code=?");
		 ps.setString(1,scode);
		   	   i=ps.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(i>0)
		{
			System.out.println("registration process"+i);
			
			return "success";		
		}
		else if (i==0)
		{
			return "notexist";
		}
                else 
                {
                    return "failure";
                }
    }

    public SchemeCreationbean viewscheme(String scode) {
        
        
        SchemeCreationbean sb=new SchemeCreationbean();
        
        Connection con=DButil.getDbconnection();
            int i=0;
		try {
	
		   PreparedStatement ps=con.prepareStatement("select * from schema_admin where scheme_code=?");
		 ps.setString(1,scode);
		   	   ResultSet rs=ps.executeQuery();
                           
				while(rs.next())
			{
				i=1;
				sb.setSchemecode(rs.getString(1));
				sb.setSchemename(rs.getString(2));
                                //sb.setSchemelink(rs.getString(3));
                                sb.setMinage(rs.getString(3));
                                sb.setMaxage(rs.getString(4));
                                sb.setGender(rs.getString(5));
                                sb.setCaste(rs.getString(6));
                                sb.setEduqual(rs.getString(7));
                                sb.setAincome(rs.getString(8));
                                sb.setMarital(rs.getString(9));
                                sb.setPhysical(rs.getString(10));
                                sb.setCitizenship(rs.getString(11));
			}		
                           
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(i==0)			
		{
			sb=null;
		}
                return sb;
    }

    public ArrayList<SchemeCreationbean> allscheme() {
        ArrayList<SchemeCreationbean> al=new ArrayList<SchemeCreationbean>();
        Connection con=DButil.getDbconnection();        
            int i=0;
		try{			
			PreparedStatement ps=con.prepareStatement("select * from schema_admin");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=1;
                                SchemeCreationbean elb=new SchemeCreationbean();
                                elb.setSchemecode(rs.getString(1));
                                elb.setSchemename(rs.getString(2));	
                               // elb.setSchemelink(rs.getString(3));
                                elb.setMinage(rs.getString(3));
                                elb.setMaxage(rs.getString(4));
                                elb.setGender(rs.getString(5));
                                elb.setCaste(rs.getString(6));
                                elb.setEduqual(rs.getString(7));
                                elb.setAincome(rs.getString(8));
                                elb.setMarital(rs.getString(9));
                                elb.setPhysical(rs.getString(10));
                                elb.setCitizenship(rs.getString(11));
                                al.add(elb);                                                                
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}		
				if(i==0)
				{
					al=null;
                                        System.out.println("al is null");
				}
				//System.out.println("length of password"+lb.getEmail());
		return al;
    }

    public int scodecheck(String scode) {
        Connection con=DButil.getDbconnection();
		int i=0;
		try {
		
		   PreparedStatement ps=con.prepareStatement("select * from schema_admin where scheme_code=?");
		   ps.setString(1, scode);
		   ResultSet rs=ps.executeQuery();
			
                   while(rs.next())
                   {
                       i=1;
                   }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		if(i>0)
		{
			System.out.println(i);
			System.out.println(scode);
			return 1;		
		}
		else
		{
			return 0;
		}
    }

	
}

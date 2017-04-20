/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Eligible_list_bean;
import bean.Userbean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import util.DButil;

/**
 *
 * @author Vignesh
 */
public class Eligibledao {

    public ArrayList<Eligible_list_bean> filtereligiblescheme(HttpSession session ,int age) {                 
        ArrayList<Eligible_list_bean> al=new ArrayList<Eligible_list_bean>();
        //Userbean ulb=new Userbean();
        System.out.println("annualincome is"+session.getAttribute("aadharno"));
       
        Connection con=DButil.getDbconnection();        
            int i=0;
		try{			
			PreparedStatement ps=con.prepareStatement("select scheme_code,scheme_name,min_age,"
                                + "max_age from schema_admin "
                                + "where (annual_income=? or annual_income=?) and (caste_category=? or caste_category=?) "
                                + "and (edu_qualification=? or edu_qualification=?) and "
                                + "(marital_status=? or marital_status=? ) and (gender= ? or gender=?) "
                                + "and (physically_challenged=? or physically_challenged=?)");
			
                        ps.setString(1,(String)session.getAttribute("annualincome"));
                        ps.setString(2,"1");
                        ps.setString(3, (String)session.getAttribute("castecategory"));
                        ps.setString(4,"all");
                        ps.setString(5, (String)session.getAttribute("educationalqualification"));
                        ps.setString(6, "all");
                        ps.setString(7, (String)session.getAttribute("maritalstatus"));
                        ps.setString(8, "all");
                        ps.setString(9,(String)session.getAttribute("gender"));
                        ps.setString(10, "all");
                        ps.setString(11, (String)session.getAttribute("physicallychallenged"));
                        ps.setString(12, "all");
                        
                        ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=1;
                                Eligible_list_bean elb=new Eligible_list_bean();
                                elb.setScheme_code(rs.getString(1));
                                elb.setScheme_name(rs.getString(2));	
                                //elb.setScheme_link(rs.getString(3));
                                
                                    int min=Integer.parseInt(rs.getString(3));
                                    int max=Integer.parseInt(rs.getString(4));
                                if(age>=min && age<=max)
                                {
                                    al.add(elb);
                                }
                                
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}		
				if(i==0)
				{
					al=null;
				}
				//System.out.println("length of password"+lb.getEmail());
		return al;
    }

    public void uapply(HttpSession session,ArrayList<Eligible_list_bean> al, String aadhar) {
        
        Connection con=DButil.getDbconnection();
        
         System.out.println("applyaadhar:::"+(String)session.getAttribute("aadharno"));
         
         for(int i=0;i<al.size();i++)
         {
             Eligible_list_bean elb=(Eligible_list_bean)al.get(i);
            // System.out.println(elb.getScheme_code());
             String sc=elb.getScheme_code();
                    int k=0;
                try{			
			PreparedStatement ps=con.prepareStatement("select username from usereligiblescheme where scheme_code=?");
			ps.setString(1,sc);                        
                        ResultSet rs=ps.executeQuery();
			
                        while(rs.next())
			{
                            if(String.valueOf(session.getAttribute("aadharno")).equalsIgnoreCase(rs.getString(1)))
                            {
                             k=1;  
                             System.out.println("k value is"+k);
                            }	
                        }  
			
                        if(k==0)
                        {
                            PreparedStatement ps2=con.prepareStatement("insert into usereligiblescheme values(?,?,?,?)");
                            ps2.setString(1,(String)session.getAttribute("aadharno"));
                            ps2.setString(2,sc);
                            ps2.setString(3,elb.getScheme_name());
                            ps2.setInt(4,0);
                            ps2.executeUpdate();
                            System.out.println();
                        }
                      
                        //return k;
		}                
		catch (Exception e) {
			
			e.printStackTrace();
		}				                
         }
   
      }     
    
    }
    


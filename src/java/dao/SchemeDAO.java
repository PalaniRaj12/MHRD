/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DButil;

/**
 *
 * @author manis
 */
public class SchemeDAO {
    public ArrayList<String> getdetails(String Schemec)
    {
        ArrayList<String>ar=new ArrayList<>();
        try {
            Connection con=DButil.getDbconnection();
            PreparedStatement ps=con.prepareStatement("select name from user.aadhar where aadharno in (select user.username from usereligiblescheme where scheme_code =?)");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               ar.add(rs.getString(1)) ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SchemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
}

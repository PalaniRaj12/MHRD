package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	public static Connection getDbconnection()
	{
		 Connection con=null;
			try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
			} 
			catch (SQLException ex){
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
			
	}
}

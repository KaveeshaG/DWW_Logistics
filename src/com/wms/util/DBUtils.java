package com.wms.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	 public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
	        
	        Connection con = DBConnectionUtil.getDBConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        return ps;
	    }
	    
	    //Check connections.
      public static void main(String[] args) throws ClassNotFoundException, SQLException {
	       PreparedStatement ps = getPreparedStatement("select * form Employee");
	       ResultSet rs = ps.executeQuery();
	       
	       while(rs.next()) {
	    	   System.out.println(rs.getString("uname"));
	       }
	      
      }	
}

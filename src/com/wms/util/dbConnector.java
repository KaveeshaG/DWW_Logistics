package com.wms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbConnector {
	public Connection dbconnect() throws Exception {
		
		
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eva", "root", "root");		 
		 return con;
		 
		 

}
	public ResultSet setData(String query) {
		Statement stmt;
		try {
			stmt = dbconnect().createStatement();
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}  
	
	public ResultSet getData(String query) {
		Statement stmt;
		try {
			stmt = dbconnect().createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Statement createStatement() {
		
		return null;
	}


	
}

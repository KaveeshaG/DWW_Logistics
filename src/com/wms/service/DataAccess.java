package com.wms.service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.wms.model.Employee;
import com.wms.util.DBUtils;;

public class DataAccess {
	
	 public static void addNew(Employee e){
	        try {
	            PreparedStatement ps = DBUtils.getPreparedStatement("insert into employee(uname, name, nic, phn, email, address, pwd, job) values(?,?,?,?,?,?,?,?)");
	            ps.setString(1, e.getUname());
	            ps.setString(2, e.getName());
	            ps.setString(3, e.getNic());
	            ps.setString(4, e.getPhn());
	            ps.setString(5, e.getEmail());
	            ps.setString(6, e.getAddress());
	            ps.setString(7, e.getPwd());
	            ps.setString(8, e.getJob());
	            ps.executeUpdate();
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public static ArrayList<Employee> getAll(){
	    	ArrayList<Employee> ls = new ArrayList<Employee>();
	        
	        try {
	            ResultSet rs = DBUtils.getPreparedStatement("select * from employee").executeQuery();
	            while(rs.next()){
	            	//System.out.println(rs.getString(2));
	                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
	                ls.add(e);
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return ls;
	    }
	    
	    public static List<Employee> getNewById(int id){
	        List<Employee> ls = new LinkedList<>();
	        String sql = "select * from employee where id = " +id;
	        try {
	            ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
	            while(rs.next()){
	                Employee n = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
	                ls.add(n);
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return ls;
	    }
	    
	    public static void update(String name, String nic, String email, String address, String phone, int id){
	        try {
	            String sql = "update employee SET name = ?, nic = ?, phn = ?, email = ?, address = ?" + " where id = ?";
	            PreparedStatement ps= DBUtils.getPreparedStatement(sql);

	            ps.setString(1, name);
	            ps.setString(2, nic);
	            ps.setString(4, email);
	            ps.setString(5, address);
	            ps.setString(3, phone);
	            ps.setInt(6, id);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
	    
	    public static boolean delete(int id){
	        try {
	            String sql = "delete from employee where id = ?";
	            PreparedStatement ps = DBUtils.getPreparedStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            return true;
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	    
	   public static Employee getEmployeeById(int id) {
		   
		   Employee e = null;
		   String sql = "SELECT * FROM employee WHERE id = " + id;
		   
		   try {
			   
			   ResultSet rs = DBUtils.getPreparedStatement(sql).executeQuery();
			   
			   while(rs.next()) {
	                e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			   }
			   
			   return e;
			   
		   } catch (Exception ex) {
			   return e;
		   }
	   }
}


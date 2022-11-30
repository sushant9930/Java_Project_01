package com.practice_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class User
{
	private int id;
	private String name;
	private String email;
	private String country;
	private String password;
	
	
	
	public User(int id, String name, String email, String country, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

public class InsertMultipleRows {
	
	// for insert data to mysql table

	public static void main(String[] args) {
		
		List<User> list=new ArrayList<>();
		 list.add(new User(100, "Denial", "denial@gmail.com", "US", "123"));
	     list.add(new User(200, "Rocky", "rocky@gmail.com", "US", "123"));
	     list.add(new User(300, "Steve", "steve@gmail.com", "US", "123"));
	     list.add(new User(400, "Ramesh", "ramesh@gmail.com", "India", "123"));
	        
	     String insert_user_sql ="Insert into student"+"(id,name,email,country,password) values"+
	    		 				 "(?,?,?,?,?);";
	     try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demojdbc","root","Sushant@9930");
	     
	    	 PreparedStatement pre=con.prepareStatement(insert_user_sql)){
	    	 
	    	 con.setAutoCommit(false);
	    	 for(Iterator<User> itr=list.iterator(); itr.hasNext();) 
	    	 {
	    		 User u=(User) itr.next();
	    		 pre.setInt(1, u.getId());
	    		 pre.setString(2, u.getName());
	    		 pre.setString(3, u.getEmail());
	    		 pre.setString(4,u.getCountry());
	    		 pre.setString(5, u.getPassword());
	    		 pre.addBatch();
	    	 }
	    	 int[] updateCounts = pre.executeBatch();
	    	 System.out.println(Arrays.toString(updateCounts));
	    	 con.commit();
	    	 con.setAutoCommit(true);
	    	 
	     } catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

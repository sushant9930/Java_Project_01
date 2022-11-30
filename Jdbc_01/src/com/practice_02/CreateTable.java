package com.practice_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class User
{
	private int id;
	private String name;
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	
}


public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demojdbc","root","Sushant@9930");
												  
		Statement st=con.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter table name");
		String tname=br.readLine();
		
		String query="create table "+tname+" (id int primary key,name varchar(20))";
		
		st.executeUpdate(query);
		
		System.out.println(tname+" table create successfully...");
		
		List<User> list=new ArrayList<>();
		 list.add(new User(100, "Denial"));
	     list.add(new User(200, "Rocky"));
	     list.add(new User(300, "Steve"));
	     list.add(new User(400, "Ramesh"));
	     
	    
		
		String insert_user_sql ="Insert into "+tname+"(id,name) values"+
				 "(?,?);";
		
		PreparedStatement pr=con.prepareStatement(insert_user_sql);
		con.setAutoCommit(false);
		for(Iterator<User> itr = list.iterator(); itr.hasNext();) 
		{
			User u=(User) itr.next();
			pr.setInt(1,u.getId());
			pr.setString(2,u.getName());
			pr.addBatch();
		}
		
		int [] updateCounts = pr.executeBatch();
		System.out.println(Arrays.toString(updateCounts));
		
		System.out.println("Insertion successfully..");
		
		ResultSet rs=st.executeQuery("select * from "+tname);
		System.out.println("Id\tName");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"      "+rs.getString(2));
		}
		
		
		con.commit();
		con.close();

	}

}

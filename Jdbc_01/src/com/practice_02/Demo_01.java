package com.practice_02;

import java.sql.*;

public class Demo_01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demojdbc","root","Sushant@9930");
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()) 
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println("Class not found..");
		}

	}

}

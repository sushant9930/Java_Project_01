package com.practice_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


		
		final static String url="jdbc:mysql://localhost:3306/wishtree";
		final static String user="root";
		final static String pass="Sushant@9930";
		
		public static Connection getConnection() throws ClassNotFoundException, SQLException 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection DBConnection=DriverManager.getConnection(url,user,pass);
			return DBConnection;
		}

	

}

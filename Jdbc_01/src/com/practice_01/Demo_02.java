package com.practice_01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_02 {

	/// for show table from my sql
	
			public static void main(String[] args) throws SQLException, ClassNotFoundException {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection	 con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/demojdbc", "root","Sushant@9930" );
				
					
				System.out.println("connection established");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from student");
			
				System.out.println("Id\tName\temail\tcountry\tpassword");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"      "+rs.getString(2)+"        "+rs.getString(3)+"       "+rs.getString(4)+"    "+rs.getString(5));
				}
				
				con.close();
			}
			

		

	}



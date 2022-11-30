package com.practice_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo_01 {

	
	// for create table
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		// load the driver
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish the connection between java application with mysql database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demojdbc","root","Sushant@9930");
			
			//create statement object
			Statement st=con.createStatement();
			
			//taking table name from user
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc=new Scanner(new InputStreamReader(System.in));
			System.out.println("Enter table name: ");
			String tname=br.readLine();
					
			//write sql query
			String query="create table "+tname+" (id int primary key,name varchar(20), email varchar(30), country varchar(20), password varchar(20))";
			st.executeUpdate(query);
						
			System.out.println(tname+" table create successfully...");

			sc.close();			
			br.close();
			st.close();
			con.close();
			
	}

}

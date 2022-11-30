package com.assignment_12nov;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 6  WAP using JDBC to select and print all Employee table.

public class Q_6 {
	
	public static void show_emp() throws ClassNotFoundException, SQLException 
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String query="select * from employee";
		ResultSet rs=st.executeQuery(query);
		System.out.println("employee_id \tfirst_name \tDept_id");
		while(rs.next()) 
		{
			System.out.println(rs.getInt(1)+"           "+rs.getString(2)+"           "+rs.getInt(3));
		}
	}
	
	
	public static void insert_emp() throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DBConnection.getConnection();
		String str="insert into employee(id,name,dept_id) values(?,?,?)";
		PreparedStatement pr=con.prepareStatement(str);
		
		System.out.println("Enter employee id : ");
		int id=sc.nextInt();
		System.out.println("Enter employee name : ");
		String name=sc.next();
		System.out.println("Enter department id : ");
		int did=sc.nextInt();
		
		pr.setInt(1, id);
		pr.setString(2, name);
		pr.setInt(3, did);
		int a=pr.executeUpdate();
		
		System.out.println(a);
		
		
	}
	
	public static void update_emp() throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DBConnection.getConnection();
		System.out.println("Enter employee id : ");
		int id=sc.nextInt();
		
		
		String str="update employee set name=? where id="+id;
		PreparedStatement pr=con.prepareStatement(str);
		
		System.out.println("update name : ");
		String name=sc.next();
		pr.setString(1, name);
		int a=pr.executeUpdate();
		System.out.println(a);
		show_emp();
		
		

	}
	
	public static void delete_emp() throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		System.out.println("Enter employee id :");
		int id=sc.nextInt();
		String query="delete from employee where id="+id;
		st.executeUpdate(query);
		show_emp();
		
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println();
		System.out.println("-------------------show employee----------------");
		show_emp();
		System.out.println();
		System.out.println("-------------------insert employee----------------");
		insert_emp();
		System.out.println();
		System.out.println("-------------------update employee----------------");
		update_emp();
		System.out.println();
		System.out.println("-------------------delete employee----------------");
		delete_emp();
		
	}

}

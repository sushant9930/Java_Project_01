package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.Interfaces.SignUp_Interface;
import com.utility.DBConnection;

public class SignUp implements SignUp_Interface
{

	public void signup() throws SQLException, ClassNotFoundException 
	{
		Connection con=DBConnection.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Sign up.....");
		System.out.println();
		System.out.println("First name : ");
		String fname=sc.next();
		System.out.println("Last name : ");
		String lname=sc.next();
		System.out.println("User name : ");
		String uname=sc.next();
		System.out.println("Password : ");
		String pass01=sc.next();
		System.out.println("Mobile no. : ");
		String mno=sc.next();
		System.out.println("Email id : ");
		String email=sc.next();
		System.out.println("Location : ");
		String loc=sc.next();
		
		//String locc=  "update users set location_id=(select l.location_id from location l where l.location_city='"+loc+"') where user_location = '"+loc+"'";
		
		String str1="insert into users(user_first_name, user_last_name, user_name, user_contact, user_email, user_location, password) values (?,?,?,?,?,?,?) ";
		PreparedStatement pre=con.prepareStatement(str1);
		pre.setString(1, fname);
		pre.setString(2, lname);
		pre.setString(3, uname);
		pre.setString(4, mno);
		pre.setString(5, email);
		pre.setString(6, loc);
		pre.setString(7, pass01);
		pre.addBatch();
		int[] a=pre.executeBatch();
		
		System.out.println();
		System.out.println("                    ....User details updated....");
		
		pre.close();
		sc.close();
		con.close();
	}

		
}

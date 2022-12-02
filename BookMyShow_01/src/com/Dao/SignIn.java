package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Dao.Interfaces.SignIn_Interface;
import com.utility.DBConnection;

public class SignIn implements SignIn_Interface
{

	public int userLogin(String uid, String pas, String ulocc, int flag) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DBConnection.getConnection();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from users where user_name='"+uid+"' and password='"+pas+"';");
		while(rs.next()) 
		{
			String db_user=rs.getString("user_name");
			String db_name01=rs.getString(2);
			String db_name02=rs.getString(3);
			String db_pass = rs.getString("password");
			ulocc=rs.getString(7);
			
			if(uid.equalsIgnoreCase(db_user) && pas.equals(db_pass)) 
			{
				System.out.println();			
				System.out.println("Welcome "+db_name01+" "+db_name02+".");
				return flag=1;				
			}
			if(!(uid.equalsIgnoreCase(db_user) && pas.equals(db_pass))) 
			{
				return flag=0;
			}
		}		
		st.close();
		rs.close();
		return flag;
	}	
	
	public String forLocation(String userid, String pass, String ulocc) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from users");
		while(rs.next()) 
		{
			String db_user=rs.getString(4);
			String db_name01=rs.getString(2);
			String db_name02=rs.getString(3);
			String db_pass = rs.getString(8);
			ulocc=rs.getString(7);
			if(userid.equalsIgnoreCase(db_user) && pass.equals(db_pass)) 
			{
				return ulocc;	
			}
		}
		st.close();
		rs.close();
		return ulocc;
	}
}

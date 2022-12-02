package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Dao.Interfaces.User_Setting_Interface;
import com.mysql.cj.jdbc.CallableStatement;
import com.utility.DBConnection;

public class User_Settings implements User_Setting_Interface
{
	
	public void show_Booking(String userid) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DBConnection.getConnection();
		System.out.println("=============================================================================================================");
		String str20="select booking_date, booking_id, show_time, total_price, show_date  from booking_01 where user_id=(select user_id from users where user_name='"+userid+"')";
		Statement st1007=con.createStatement();
		ResultSet rs1007=st1007.executeQuery(str20);
		System.out.println("BOOKING DATE \tBOOKING ID \tSHOW TIME \tTOTAL PRICE \tSHOW DATE");
		while(rs1007.next()) 
		{
			
			System.out.println(rs1007.getDate(1)+"        "+rs1007.getInt(2)+"            "+rs1007.getTime(3)+"            "+rs1007.getInt(4)+"        "+rs1007.getDate(5));
			
		}
		st1007.close();
		rs1007.close();
		System.out.println("=============================================================================================================");
		
		System.out.println("\n\nSeats");
		System.out.println("\nDo you want see seats");
		System.out.println("\nEnter 'Y' for yes and No for 'N'");
		char ch=sc.next().charAt(0);
		if(ch=='Y') {
		System.out.println("Enter booking id : ");
		int id=sc.nextInt();
		String str201="select * from bookmyseat.booking_seat where booking_id="+id+"";
		System.out.println();
		Statement st1008=con.createStatement();
		ResultSet rs1008=st1008.executeQuery(str201);	
		System.out.println("Chair \tRow   \tBooking_id");
		while(rs1008.next()) 
		{			
			System.out.println(rs1008.getInt(2)+"          "+rs1008.getString(3)+"          "+rs1008.getInt(6));
		}
		st1008.close();
		rs1008.close();	
		
		}
	}
	
	public void delete_Booking(String userid, int sid, String tid) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DBConnection.getConnection();
		System.out.println("=============================================================================================================");
		String str20="select booking_date, booking_id, show_time,show_date  from booking_01 where user_id=(select user_id from users where user_name='"+userid+"')";
		Statement st1007=con.createStatement();
		ResultSet rs1007=st1007.executeQuery(str20);
		System.out.println("Booking Date  \tBooking Id  \tShow Time  \tShow Date");
		while(rs1007.next()) 
		{
			
			System.out.println(rs1007.getDate("booking_date")+"        "+rs1007.getInt("booking_id")+"        "+rs1007.getTime("show_time")+"        "+rs1007.getDate("show_date"));
			
		}
		st1007.close();
		rs1007.close();
		System.out.println("=============================================================================================================");
		
		System.out.println("\nPlease enter booking number : ");
		int num=sc.nextInt();
		String str="delete from booking_01 where user_id=(select user_id from users where user_name='"+userid+"') and booking_id="+num+"";	
		Statement st=con.createStatement();
		st.executeUpdate(str);
		
		String str010="update screen_status set SEAT_STATUS='Available', user_id=null, booking_id=null where  booking_id="+num+" and user_id=(select user_id from users where user_name='"+userid+"') and theater_id='"+tid+"' and screen_id=(select screen_id from shows where slot_id="+sid+")";
		Statement st10=con.createStatement();
		st10.executeUpdate(str010);
		
		String str011="delete from booking_seat where user_name='"+userid+"' and booking_id="+num+"";
		Statement st11=con.createStatement();
		st11.executeUpdate(str011);
		System.out.println("=============================================================================================================");
		System.out.println("Delete your booking successfully......");
		System.out.println("=============================================================================================================");
		
		
	}
	
	public void update_Profile(String userid) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		try(Connection con=DBConnection.getConnection())
		{
			System.out.println("=============================================================================================================");
			System.out.println("Profile Updation");
			System.out.println(" 1  : Update first name and last name");
			System.out.println(" 2  : Update first name");
			System.out.println(" 3  : Update last name");
			System.out.println(" 4  : Update email address");
			System.out.println(" 5  : Update Mobile number");
			System.out.println(" 6  : Update Location");
			System.out.println(" 7  : Update username");
			System.out.println(" 8  : Update Password");
			System.out.println("=============================================================================================================");
			System.out.println("\nSelect from above");
			int cc=sc.nextInt();
			
			switch(cc) 
			{
			case 1 :
			{
				
				System.out.println("Update first name and last name");
				System.out.println("Enter new first name : ");
				String first=sc.next();
				System.out.println("Enter new last name : ");
				String last=sc.next();
				String str="update users set user_first_name='"+first+"', user_last_name='"+last+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, first);
				pr.setString(2, last);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				
				break;
				
			}
			case 2 :
			{
				System.out.println("Update first name");
				System.out.println("Enter new first name : ");
				String first=sc.next();
				String str="update users set user_first_name='"+first+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, first);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;
			}
			case 3 :
			{
				System.out.println("Update last name");
				System.out.println("Enter new last name : ");
				String last=sc.next();
				String str="update users set user_last_name='"+last+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, last);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;
			}
			case 4 :
			{
				System.out.println("Update email address");
				System.out.println("Enter new email address : ");
				String email=sc.next();
				String str="update users set user_email='"+email+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, email);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;
			}
			case 5 :
			{
				System.out.println("Update mobile number");
				System.out.println("Enter new mobile number : ");
				String mob=sc.next();
				String str="update users set user_contact='"+mob+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, mob);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;

			}
			case 6 :
			{
				System.out.println("Update location");
				System.out.println("Enter new Location : ");
				String loc=sc.next();
				String str="update users set user_location='"+loc+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, loc);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;
			}
			case 7 :
			{
				System.out.println("Update username");
				System.out.println("Enter new username : ");
				String uname=sc.next();
				String str="update users set user_email='"+uname+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, uname);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;
			}
			case 8 :
			{
				System.out.println("Update password");
				System.out.println("Enter new password : ");
				String passw=sc.next();
				String str="update users set user_email='"+passw+"' where user_name='"+userid+"'";
				PreparedStatement pr=con.prepareStatement(str);
				pr.setString(1, passw);
				int a= pr.executeUpdate();
				System.out.println("\n=============================================================================================================");
				System.out.println("Update successfully......");
				System.out.println("=============================================================================================================");
				break;
			}
			}
			
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public int delete_Profile(String userid, char ch1001,int flag200, int flag) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		if(flag==1) {
		System.out.println("You want to delete your account permantly : ");
		System.out.println("'Y'for (Yes) or 'N' for (No)");
		ch1001=sc.next().charAt(0);
		if(ch1001=='Y') 
		{
			try(Connection con=DBConnection.getConnection())
			{
				System.out.println("Enter your password");
				String upass=sc.next();
				
				String strr="call delete_profile(?,?)";
				PreparedStatement pr=con.prepareStatement(strr);
				pr.setString(1, userid);
				pr.setString(2, upass);
				int aa=pr.executeUpdate();
				String str="delete from users where password='"+upass+"';";
				Statement st=con.createStatement();
				st.executeUpdate(str);
				
				System.out.println("\n=============================================================================================================");
				System.out.println("                       Delete profile successfully");
				System.out.println("=============================================================================================================");
				
				
				return flag200=1;
			}
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		}
		return flag200;
		
	}
	
	public int log_Out(char ch1002, int flag2001) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("You want to log Out : ");
		System.out.println("'Y'for (Yes) or 'N' for (No)");
		ch1002=sc.next().charAt(0);
		if(ch1002=='Y') 
		{
			return flag2001=1;
		}
		else
		{
			System.out.println("Thank you for using BOOK MY SEAT.....");
			return flag2001=0;
			
		}
	}
	
	public void view_Profile(String userid, String pass, String exit) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		String str="select * from users where user_name='"+userid+"' and password='"+pass+"'";
		try(Connection con=DBConnection.getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(str))
		{
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5)+"    "+rs.getString(6)+"    "+rs.getString(7)+"    "+rs.getString(8));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	


}

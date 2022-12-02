package com.Test;
import com.Dao.*;
import com.Dao_Services_Implements.Choose_method_Service;
import com.Dao_Services_Implements.Pattern_Service;
import com.Dao_Services_Implements.Show_Movies_Service;
import com.Dao_Services_Implements.SignIn_Service;
import com.Dao_Services_Implements.SignUp_Service;
import com.Dao_Services_Implements.User_Setting_Service;
import com.Pojo.Booking;
import com.Pojo.Location;
import com.Pojo.Movies;
import com.Pojo.Screen;
import com.Pojo.Screen_Status;
import com.Pojo.Shows;
import com.Pojo.Theater;
import com.Pojo.User;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.utility.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import com.Dao.*;
public class BookMySeat_Main {

	static User_Setting_Service u;
	static SignUp_Service       su;
	static SignIn_Service       si;
	static Show_Movies_Service  sm;
	static Pattern_Service      p;
	static Choose_method_Service cm;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException 
	{
		
		Connection con=DBConnection.getConnection();	
		Scanner sc=new Scanner(System.in);
		u=new User_Setting_Service(new User_Settings());
		su=new SignUp_Service(new SignUp());
		si=new SignIn_Service(new SignIn());
		sm=new Show_Movies_Service(new Show_movies());
		p=new Pattern_Service(new Pattern());
		cm=new Choose_method_Service(new Choose_methods());
		
		String temp="";
		char ch_01=' ';
		int flag = 0, choose=0, flag2=0, flag4=0;
		int flag01=0, flag02=0, flag200=0, flag2001=0, flag2002=0;
		String ulocc="", tlocc="";
		String userid="";
		int sn;
		char c1=' ', ch1001=' ', ch1002=' ';
		int ch100=0;
		String pass="";
		String mov ="", log="";
		int sid=0;
		String tid="";
		String exit="";
		String point="", point1="",point2="";
		
		ArrayList<Movies> al=new ArrayList<Movies>();
		ArrayList<Screen_Status> all=new ArrayList<Screen_Status>();
	
do {
		System.out.println("============================================================================================================");
		System.out.println("-------------------Welcome to Book My Show-------------------");
		System.out.println("-----------------------------------------------1 : User Login");
		System.out.println("-----------------------------------------------2 : User Sign-up");
		System.out.println("=============================================================================================================");
		System.out.println("\n");
		System.out.println("Select login option--->");
		int num=sc.nextInt();
		switch(num) 
		{
			case 1:
					{	
						System.out.println("=============================================================================================================");
						System.out.println("                       User Login");
						System.out.println("=============================================================================================================");
						
						flag200=u.delete_Profile(userid, ch1001,flag200,flag);
						if(flag200==1 ) 
						{
// user login						
						   flag=cm.login(flag, userid, pass, ulocc, ch_01);
//option to sign up						   
							if(flag==0) {
								System.out.println();		
								System.out.println("Sorry something wrong.... please try again...");
								System.out.println("Your username or password incorrect....");
								System.out.println("\n\n");
								System.out.println();
								System.out.println("You want to sign up......");
								System.out.println("('Y' for Yes or 'N' for No)");
								ch_01=sc.next().charAt(0);
								if(ch_01=='N') 
								{
									break;
								}
								flag2=1;
							}
						}
						System.out.println("=============================================================================================================");
						System.out.println("\nEnter your username : ");
						userid=sc.next();
						System.out.println();
						System.out.println("Enter your password :");
						pass=sc.next();
						sc.nextLine();
						
						try{
								flag = si.userLogin(userid, pass, ulocc, flag);
						}
						catch(ClassNotFoundException e) 
						{
							e.printStackTrace();
					  		System.out.println(e.getMessage());
						}catch(SQLException e) 
						{
							e.printStackTrace();
					  		System.out.println(e.getMessage());
						}
						
						if(flag==1) {	
							System.out.println("=============================================================================================================");
							System.out.println("Log in successfully.....");
							System.out.println("=============================================================================================================");
						}
						
						if(flag==0) {
							System.out.println("\n");		
							System.out.println("Sorry something wrong.... please try again...");
							System.out.println("Your username or password incorrect....");
							System.out.println("\n\n");
							System.out.println();
							System.out.println("You want to sign up......");
							System.out.println("('Y' for Yes or 'N' for No)");
							ch_01=sc.next().charAt(0);
							if(ch_01=='N') 
							{
								break;
							}
							flag2=1;
					
						}
						if(flag2==1) 
						{
							su.signup();
						}
						ulocc=si.forLocation(userid, pass, ulocc);
						con.close();
						
						break;						
					}
					
						
			case 2 :
			{
						if(ch_01=='Y' || flag==0) 
						{
							try {
								
									su.signup();

								}
							catch(SQLException e) 
							{
								e.printStackTrace();
								System.out.println("Enter correct values....");
							}
							catch(ClassNotFoundException cc) 
							{
								System.out.println("Driver connection issue in sign up......");
							}
						}
						break;
			}
						
		}
		
	//flag200=;

	if(flag==1 ) 
	{
	do {
		System.out.println();
		System.out.println("=============================================================================================================");
		System.out.println("******Menu*****");
		System.out.println("1 : choose movies directly");
		System.out.println("2 : Setting");
		System.out.println("=============================================================================================================");
		System.out.println();
		try {
		System.out.println("Choose from above");	
		choose =sc.nextInt();
		//sc.next();
		
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		switch(choose) 
		{
		  case 1 :
		  {
			  
			  sm.show(ulocc);
			do {  
		  	  System.out.println();
		  	  System.out.println("Select Movie....");
		  	  System.out.println();
		  	  System.out.println("Enter movie id...");
		  	  mov=sc.next();
		  	  sc.nextLine();
	
// show selected movie		  	  
		  	try{
		  		flag01 =cm.show_Selected_Move(mov, flag01 ,temp, userid, ulocc,al);
		  		System.out.println(flag01);
		  	}
		  	catch(Exception e) 
		  	{
		  		e.printStackTrace();
		  		System.out.println(e.getMessage());
		  	}

		  	if(flag01==0) 
		  	{
		  		System.out.println("This Movie shows are not available in your area theaters......");
			  	System.out.println("Do you want search shows in another area?");
			  	System.out.println("'Y'for (Yes) or 'N' for (No)");
			  	c1=sc.next().charAt(0);
		  	}
			}while(c1=='Y');
			if(c1=='N') 
		  	{
		  		flag02=1;
		  		System.out.println("=============================================================================================================");
		  		System.out.println("=============================================================================================================");
		  		System.out.println("Menu");
		  		point=sc.next();
		  		break;
		  	}
			if(flag01==1) 
				{	
				System.out.println("=============================================================================================================");
					cm.show_Theater_Selected(mov,ulocc);
		  			System.out.println("\nEnter theater id :");
		  			tid=sc.next();
		  			System.out.println("Enter show id : ");
		  			sid=sc.nextInt();
		  			System.out.println("Enter number of seat's :");
		  			sn=sc.nextInt();

// show theater table which is user want see
		  			
		  			
		  			flag4=cm.check_Availability(tid,flag4 );
		  			if(flag4==1) 
		  			{
		  				System.out.println("\nShow Housefull.....");
		  				point=cm.callMainMethod(point); 
		  				break;
		  			}
		  			else
		  			{
		  				int available_seat=(100-flag4);
		  				
		  				System.out.println("available seat   :    "+available_seat+"\n");
		  				if(available_seat>=sn)
		  				{
		  					cm.show_Hall(tid, sid, userid,all,flag4);
		  				}
		  				else 
		  				{
		  					System.out.println("=============================================================================================================");
		  					System.out.println("\nAvailable seat less than enter seat\n");
		  					System.out.println("=============================================================================================================");
		  					point=cm.callMainMethod(point); 
		  					break;
		  				}
		  				
		  			}
		  			
		  			System.out.println("=============================================================================================================");
		  			System.out.println("\nPlease select from above");
		  			System.out.println("Enter seat type : (Normal / Executive / Premium)");
		  			String type=sc.next();
		  			
		  		
// seat selection
		  			for(int i=1; i<=sn; i++) 
		  			{	  				
		  				System.out.println("Enter row : ");
			  			String ch=sc.next();
			  			System.out.println("Enter chair number : ");
			  			int cnum=sc.nextInt();		  			
// seat seletion and adding selected data
			  			cm.seat_Selection_Proc(ch, cnum, tid,sid, userid, sn);			  		
		  			}		  				
/// for booking confirmation

		  				cm.booking_Conf(type,sid,userid,sn,tid, mov);
					}
					else 
					{
						System.out.println("This movie not available in your location..");
					}
						point=cm.callMainMethod(point); 
						break;
		  }
		  
		
				
		
		
		 
		  case 2 :{
			  
			  System.out.println(userid);
			  
			  
			  		System.out.println("=============================================================================================================");
			  		System.out.println("Setting");
			  		System.out.println(" 1   :   Profile");
			  		System.out.println(" 2   :   Booking");
			  		System.out.println(" 3   :   Update Profile");
			  		System.out.println(" 4   :   Delete  your account");
			  		System.out.println(" 5   :   Log Out");
			  		System.out.println("=============================================================================================================");
			  		System.out.println("\nSelect from above list.........");
			  		ch100=sc.nextInt();
			  		switch(ch100) 
			  		{
				  		case 1 :
				  		{
				  			u.view_Profile(userid,pass,exit);
				  			point=cm.callMainMethod(point); 
					  		break;
				  		}
				  		case 2 :
				  		{
				  			
				  		do {
				  			System.out.println("=============================================================================================================");
				  			System.out.println("  View Booking menu");
				  			System.out.println("1  :  View booking");
				  			System.out.println("2  :  Delete Booking");
				  			System.out.println("=============================================================================================================");
				  			System.out.println("\nChoose from above : ");
				  			int ch=sc.nextInt();
				  			switch(ch) {
				  			case 1:
				  			{
				  			u.show_Booking(userid);
				  			break;
				  			}
				  			case 2:
				  			{
				  				u.delete_Booking(userid, sid, tid);
				  				break;
				  			}
				  			
					  		}
				  			
				  			System.out.println("=============================================================================================================");
				  			System.out.println(" 1    :  main menu");
				  			System.out.println(" 2    :  Booking menu");
				  			System.out.println("=============================================================================================================");
				  			System.out.println("\nChoose from above :");
				  			int chh=sc.nextInt();
				  			switch(chh) 
				  			{
				  			case 1 :
				  			{
				  				System.out.println("Enter 'menu' for view main menu");
				  				point=cm.callMainMethod(point); 
				  				break;
				  			}
				  			case 2 :
				  			{
				  				System.out.println("Enter 'menu' for view booking menu");				  			
				  				point=cm.callMainMethod(point); 
				  				break;
				  			}
				  			}
				  			
				  			
				  			}while(point1.equalsIgnoreCase("menu"));
				  			break;
				  		
				  		}
				  		case 3 :
				  		{
				  			u.update_Profile(userid);
				  			point=cm.callMainMethod(point);       //calling to main method
			  				
				  			break;
				  		}
				  		case 4 : 
				  		{
				  			
				  			flag200=u.delete_Profile(userid, ch1001,flag200,flag);
				  			if(flag200==1) {
				  			log=cm.callLog(log);}
				  			if(flag200==0) 
				  			{
				  				point=cm.callMainMethod(point); 
				  			}
				  			
				  			break;
				  		}
				  		case 5  : 
				  		{
				  			u.log_Out(ch1002,flag2001);
				  			break;
				  		}
			  
			  		}
			  		
			  		break;
		  		}
		}
	
	
	}while(point.equalsIgnoreCase("menu"));
	}
}while(log.equalsIgnoreCase("log"));

	}
	
}	
	
	//end
	



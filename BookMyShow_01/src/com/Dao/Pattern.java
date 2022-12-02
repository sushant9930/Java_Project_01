package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Dao.Interfaces.Pattern_Interface;
import com.Pojo.Booking;
import com.utility.DBConnection;

public class Pattern implements Pattern_Interface
{
	
	public void hall() throws ClassNotFoundException, SQLException {
		
		
			System.out.println("----------------------------------SCREEN--------------------------------------\n\n");
			
			char ch='A';
			for(int i=1; i<=10; i++) 
			{
				System.out.print(ch+"        ");
				for(int j=1; j<=10; j++) 
				{
				
				
					System.out.print(j+"        ");
					
				
				}
				System.out.println();
				System.out.println();
				ch++;
			}				
				
	}
			
	
	
}
/*	
*/

package com.practice_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.*;

public class DatabaseToHashMap 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{	
		Connection con=DBConnection.getConnection();
		System.out.println("Successfully connection done...");
		
		HashMap<Integer, String> hm1=new HashMap<Integer, String>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from locations");
		while(rs.next()) 
		{
			int loc=rs.getInt("location_id");
			String city=rs.getString("city");
			hm1.put(loc, city);		
		}
		HashMap<String, ArrayList<String>> lhm1=new HashMap<String, ArrayList<String>>();
		
			
				Statement st1=con.createStatement();
				ResultSet rs1=st.executeQuery("select * from departments");
				while(rs1.next()) 
				{
					int loc=rs1.getInt("location_id");
					String dept=rs1.getString("department_name");

					Set<Map.Entry<Integer, String>> set=hm1.entrySet();
					Iterator<Map.Entry<Integer, String>> itr=set.iterator();
					while(itr.hasNext()) 
					{
						Map.Entry<Integer, String> map=itr.next();
				
					if(map.getKey()==loc) {
					if(lhm1.containsKey(map.getValue())) 
					{
						ArrayList<String> al=lhm1.get(map.getValue());
						String s2=rs1.getString("department_name");
						String s1=map.getValue();
						al.add(s2);					
						lhm1.put(s1, al);
					}
					else 
					{
						ArrayList<String> al=new ArrayList<String>();
						String s2=rs1.getString("department_name");
						String s1=map.getValue();
						al.add(s2);					
						lhm1.put(s1, al);
						
					}	
					}
				}
			}
			
			Set<Map.Entry<String, ArrayList<String>>> set1=lhm1.entrySet();
			Iterator<Map.Entry<String, ArrayList<String>>> itr1=set1.iterator();
			while(itr1.hasNext()) 
			{
				java.util.Map.Entry<String, ArrayList<String>> map=itr1.next();
				System.out.println(map.getKey()+"  "+map.getValue());
			}
			
		}
		
		
		
		
	

}

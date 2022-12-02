package com.Dao_Services_Implements;

import java.sql.SQLException;

import com.Dao.User_Settings;
import com.Dao_Services.User_Setting_Service_Interface;

public class User_Setting_Service implements User_Setting_Service_Interface
{
	User_Settings dao;
	
	
	

	public User_Setting_Service(User_Settings dao) {
		super();
		this.dao = dao;
	}

	public User_Settings getDao() {
		return dao;
	}

	public void setDao(User_Settings dao) {
		this.dao = dao;
	}

	@Override
	public void show_Booking(String userid) throws ClassNotFoundException, SQLException 
	{
		dao=new User_Settings();
		dao.show_Booking(userid);
	}

	@Override
	public void delete_Booking(String userid, int sid, String tid) throws ClassNotFoundException, SQLException {
		
		dao=new User_Settings();
		dao.delete_Booking(userid, sid, tid);
		
	}

	@Override
	public void update_Profile(String userid) throws ClassNotFoundException, SQLException {
		dao=new User_Settings();
		dao.update_Profile(userid);
		
	}

	@Override
	public int delete_Profile(String userid, char ch1001, int flag200, int flag)
			throws ClassNotFoundException, SQLException {
		
		return dao.delete_Profile(userid, ch1001, flag200, flag);
	}

	@Override
	public int log_Out(char ch1002, int flag2001) throws ClassNotFoundException, SQLException {
		
		return dao.delete_Profile(null, ch1002, flag2001, flag2001);
	}

	@Override
	public void view_Profile(String userid, String pass, String exit) throws ClassNotFoundException, SQLException {
		
		dao=new User_Settings();
		dao.view_Profile(userid, pass, exit);
	}
}

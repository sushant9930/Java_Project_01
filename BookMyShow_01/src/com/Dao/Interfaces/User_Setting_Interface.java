package com.Dao.Interfaces;

import java.sql.SQLException;



public interface User_Setting_Interface {

	void show_Booking(String userid) throws ClassNotFoundException, SQLException;
	void delete_Booking(String userid, int sid, String tid) throws ClassNotFoundException, SQLException;
	void update_Profile(String userid) throws ClassNotFoundException, SQLException;
	int delete_Profile(String userid, char ch1001,int flag200, int flag) throws ClassNotFoundException, SQLException ;
	int log_Out(char ch1002, int flag2001) throws ClassNotFoundException, SQLException;
	void view_Profile(String userid, String pass, String exit) throws ClassNotFoundException, SQLException;
}

package com.Dao_Services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Dao.Choose_methods;
import com.Pojo.Movies;
import com.Pojo.Screen_Status;

public interface Choose_method_Service_Interface {

	void show_Theater_Selected(String mov, String ulocc) throws ClassNotFoundException, SQLException;
	String get_User_Location(String userid,String ulocc) throws SQLException, ClassNotFoundException;
	int show_Selected_Move(String mov, int flag01 ,String temp, String userid, String ulocc, ArrayList<Movies> al) throws ClassNotFoundException, SQLException;
	String mov_Name(String mov) throws ClassNotFoundException, SQLException;
	void show_Hall(String tid, int sid, String userid, ArrayList<Screen_Status> al, int flag4) throws SQLException, ClassNotFoundException;
	void seat_Selection_Proc(String ch, int cnum, String tid, int sid, String userid, int sn) throws SQLException, ClassNotFoundException;
	void booking_Conf(String type,int sid,String userid,int sn, String tid, String mov) throws SQLException, ClassNotFoundException;
	int login(int flag, String userid, String pass, String ulocc, char ch_01)throws SQLException, ClassNotFoundException;;
	String callLog(String log);
	String callMainMethod(String point) ;
	int check_Availability(String tid,int flag4 ) throws SQLException, ClassNotFoundException;
}

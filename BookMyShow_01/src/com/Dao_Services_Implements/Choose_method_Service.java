package com.Dao_Services_Implements;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Dao.Choose_methods;
import com.Dao_Services.Choose_method_Service_Interface;
import com.Pojo.Movies;
import com.Pojo.Screen_Status;

public class Choose_method_Service implements Choose_method_Service_Interface
{
	Choose_methods dao1;
	
	
	

	public Choose_method_Service(Choose_methods dao1) {
		super();
		this.dao1 = dao1;
	}

	public Choose_methods getDao1() {
		return dao1;
	}

	public void setDao1(Choose_methods dao1) {
		this.dao1 = dao1;
	}

	@Override
	public void show_Theater_Selected(String mov, String ulocc) throws ClassNotFoundException, SQLException {
		dao1=new Choose_methods();
		dao1.show_Theater_Selected(mov, ulocc);
		
	}

	@Override
	public String get_User_Location(String userid, String ulocc) throws SQLException, ClassNotFoundException {
	
		return dao1.get_User_Location(userid, ulocc);
	}

	@Override
	public int show_Selected_Move(String mov, int flag01, String temp, String userid, String ulocc,
			ArrayList<Movies> al) throws ClassNotFoundException, SQLException {
		
		return dao1.show_Selected_Move(mov, flag01, temp, userid, ulocc, al);
	}

	@Override
	public String mov_Name(String mov) throws ClassNotFoundException, SQLException {
		
		return dao1.mov_Name(mov);
	}

	@Override
	public void show_Hall(String tid, int sid, String userid, ArrayList<Screen_Status> al, int flag4)
			throws SQLException, ClassNotFoundException {
		dao1=new Choose_methods();
		dao1.show_Hall(tid, sid, userid, al, flag4);
		
	}

	@Override
	public void seat_Selection_Proc(String ch, int cnum, String tid, int sid, String userid, int sn)
			throws SQLException, ClassNotFoundException {
		dao1=new Choose_methods();
		dao1.seat_Selection_Proc(ch, cnum, tid, sid, userid, sn);
		
	}

	@Override
	public void booking_Conf(String type, int sid, String userid, int sn, String tid, String mov)
			throws SQLException, ClassNotFoundException {
		dao1=new Choose_methods();
		dao1.booking_Conf(type, sid, userid, sn, tid, mov);
		
	}

	@Override
	public int login(int flag, String userid, String pass, String ulocc, char ch_01)
			throws SQLException, ClassNotFoundException {
		
		return dao1.login(flag, userid, pass, ulocc, ch_01);
	}

	@Override
	public String callLog(String log) {
		
		return dao1.callLog(log);
	}

	@Override
	public String callMainMethod(String point) {
		
		return dao1.callMainMethod(point);
	}

	@Override
	public int check_Availability(String tid, int flag4) throws SQLException, ClassNotFoundException {
		
		return dao1.check_Availability(tid, flag4);
	}

}

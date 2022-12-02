package com.Dao.Interfaces;

import java.sql.SQLException;

public interface SignIn_Interface {
	
	int userLogin(String uid, String pas, String ulocc, int flag) throws ClassNotFoundException, SQLException;
	String forLocation(String userid, String pass, String ulocc) throws ClassNotFoundException, SQLException;
	
	

}

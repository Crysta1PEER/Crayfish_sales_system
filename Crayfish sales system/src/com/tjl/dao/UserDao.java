package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao {
	
	int login(User user);
	
	boolean insert(User user);
	
	boolean delete(String uname);
	
	boolean update(User user);
	
	User select(String uname);

}

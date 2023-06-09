package com.tjl.test;



import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.dao.UserDao;
import com.tjl.dao.UserDao_imp;
import com.tjl.jdbc.JDBCUtils;



public class JDBCUtilsTest {
	@Test
	public void jdbcConnectionTest() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Statement statement=conn.createStatement();
		ResultSet result=statement.executeQuery("select * from info");
		while(result.next()) {
			System.out.println(result.getString("uname"));
		}
	}
	@Test
	public void loginTest() throws Exception {
		UserDao_imp userDao_imp = new UserDao_imp();
		User user = new User("w123", "ww" );
		int type = userDao_imp.login(user);
		System.out.println(type);
	}
	
	@Test
	public void insertTest() throws Exception {
		UserDao_imp userDao_imp = new UserDao_imp();
		User user=new User("ym","ym");
		userDao_imp.insert(user);
		boolean flag=userDao_imp.insert(user);
		System.out.println(flag);
	}
	@Test
	public void deleteTest() throws Exception {
		UserDao_imp userDao_imp = new UserDao_imp();
		User user=new User("ym","ym");
		userDao_imp.insert(user);
		boolean flag=userDao_imp.delete(user.getUname());
		System.out.println(flag);
	}
	@Test
	public void updateTest() throws Exception {
		UserDao_imp userDao_imp = new UserDao_imp();
		User user=new User("wo","wo");
		boolean flag=userDao_imp.update(user);
		System.out.println(flag);
	}
	@Test
	public void selectTest() throws Exception {
		UserDao_imp userDao_imp = new UserDao_imp();
		User user=new User("sc","zs");
		User user1=userDao_imp.select(user.getUname());
		System.out.println(user1);
		
	}
	
}

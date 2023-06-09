package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class UserDao_imp implements UserDao {
	
	private static final String SQL_USER_LOGIN="select type from user where uname=? AND upass=?;";
	private static final String SQL_USER_INSERT = "INSERT INTO USER VALUES(id,?,?,2);";
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?";
	private static final String SQL_USER_UPDATE = "UPDATE USER SET upass=? WHERE uname=?;";
	private static final String SQL_USER_SELECT = "SELECT * FROM USER WHERE uname=?;";
	
	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		try {
			preparedStatement=conn.prepareStatement(SQL_USER_LOGIN);
			preparedStatement.setString(1,user.getUname());
			preparedStatement.setString(2,user.getUpass());
			result = preparedStatement.executeQuery();
			while(result.next()) {
				int type=result.getInt("type");
				return type;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,preparedStatement,result);
		}
		return -1;
	}

	@Override
	public boolean insert(User user) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=conn.prepareStatement(SQL_USER_INSERT);
			preparedStatement.setString(1,user.getUname());
			preparedStatement.setString(2,user.getUpass());
			int line=preparedStatement.executeUpdate();

			if(line>0)
			{
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,preparedStatement,null);
		}
		return false;
	}

	@Override
	public boolean delete(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=conn.prepareStatement(SQL_USER_DELETE);
			preparedStatement.setString(1,uname);
			int line=preparedStatement.executeUpdate();

			if(line>0)
			{
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,preparedStatement,null);
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
		try {
		prepareStatement = conn.prepareStatement(SQL_USER_UPDATE);
		 prepareStatement.setString( 1,user.getUpass());
		 prepareStatement.setString( 2,user.getUname());
		int line = prepareStatement.executeUpdate( );
		return line>0?true : false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.close( conn,prepareStatement, null);
		}
		return false;
	}

	@Override
	public User select(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=conn.prepareStatement(SQL_USER_SELECT);
			preparedStatement.setString(1,uname);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {
				int id=result.getInt("id");
				uname=result.getString("uname");
				String upass=result.getString("upass");
				int type=result.getInt("type");
				return new User(id,uname,upass,type);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,preparedStatement,null);
		}
		return null;
	}




}

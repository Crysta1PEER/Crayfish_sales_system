package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class WareHouseDao_imp {
	
	private static final String SQL_USER_INSERT = "INSERT INTO USER VALUES(id,?,?,2);";
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?";
	private static final String SQL_WAREHOUSE_SELECT = "SELECT * FROM warehouse WHERE trade_name=?;";
	
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


	public User select(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=conn.prepareStatement(SQL_WAREHOUSE_SELECT);
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

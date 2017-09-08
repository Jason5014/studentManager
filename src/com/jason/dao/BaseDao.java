package com.jason.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class BaseDao {
	//连接数据库
		public Connection getConn(){
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stumanager","root","123");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e1){
				e1.printStackTrace();
			}
			return conn;
		}
		
		//删除、修改、添加
		public int executeUpdate(String sql,Object...params){
			Connection conn = getConn();
			int result = 0;
			PreparedStatement ps = null;
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				if(params!=null){
					for(int i = 0; i<params.length;i++){
						ps.setObject(i+1,params[i]);
					}
				}
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return result;
		}
		
		//查询
		public ResultSet executeQuery(String sql,Object...params){
			Connection conn = getConn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				if(params!=null){
					for(int i = 0; i<params.length;i++){
						ps.setObject(i+1,params[i]);
					}
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
}

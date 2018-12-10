package com.sparkstu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BaseDao {

	private static final String DRIVENAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.213.128:3306/blog?useSSL=false&useUnicode=true&characterEncoding=UTF8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull";
	private static final String USER = "root";
	private static final String PASSWORD = "Wei67628315.";

	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement ppst = null;
	private ResultSet rs = null;

	/**
	 * 加载驱动
	 */
	static {
		try {
			Class.forName(DRIVENAME);
		} catch (Exception e) {
			System.out.println("驱动加载失败：" + e.getMessage());
		}
	}

	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("数据库连接失败：" + e.getMessage());
		}
		return conn;
	}

	/**
	 * 获取结果集（无参）
	 * 
	 * @param sql
	 * @return
	 */
	private ResultSet getRs(String sql) {
		conn = this.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("查询（无参）出错:" + e.getMessage());
		}
		return rs;
	}

	/**
	 * 获取结果集
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	private ResultSet getRs(String sql, Object[] params) {
		conn = this.getConn();
		try {
			ppst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ppst.setObject(i + 1, params[i]);
				}
			}
			rs = ppst.executeQuery();
		} catch (SQLException e) {
			System.out.println("查询出错：" + e.getMessage());
		}

		return rs;
	}

	/**
	 * 查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Object> query(String sql, Object[] params) {

		List<Object> list = new ArrayList<Object>();
		ResultSet rs = null;
		if (params != null) {
			rs = getRs(sql, params);
		} else {
			rs = getRs(sql);
		}
		ResultSetMetaData rsmd = null;
		int columnCount = 0;

		try {
			rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			System.out.println("结果集解析出错：" + e.getMessage());
		} finally {
			closeConn();
		}
		return list;
	}

	/**
	 * 更新（无参）
	 * 
	 * @param sql
	 */
	public int update(String sql) {
		int affectedLine = 0;// 受影响的行数
		conn = this.getConn();
		try {
			st = conn.createStatement();
			affectedLine = st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("更新（无参）失败：" + e.getMessage());
		} finally {
			closeConn();
		}
		return affectedLine;
	}

	/**
	 * 更新
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object[] params) {
		int affectedLine = 0;// 受影响的行数
		conn = this.getConn();
		try {
			ppst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					
					ppst.setObject(i + 1, params[i]);
				}
			}
			affectedLine = ppst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("更新失败：" + e.getMessage());
		} finally {
			closeConn();
		}
		return affectedLine;
	}
	
	/**
	 * 更新
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	@Test
	public void update() {
		
		conn = this.getConn();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			rs=stmt.getGeneratedKeys();
			if (rs.next()) {  
		      String  autoIncKeyFromApi = rs.getString(1);  
		      System.out.println(autoIncKeyFromApi);
		    }  else {  
		        // throw an exception from here  
		    } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
	
	private void closeConn() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		if (ppst != null) {
			try {
				ppst.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
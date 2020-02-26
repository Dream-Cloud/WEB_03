package org.lanqiao.mvc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;






public class JDBCUtils {
	// 获取链接
	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {

		//第一步加载配置文件
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pro = new Properties();
		pro.load(in);
		//定义URL
		String url = pro.getProperty("url");
		//从配置文件中获取链接属性
		String driverStr = pro.getProperty("driver");//Driver类的全类名
		String user = pro.getProperty("user");
		String password=pro.getProperty("password");
		//加载mysql的Dirver
		Class.forName(driverStr);
		Connection conn = DriverManager.getConnection(url, user,password);
		return conn;
	}

	// 释放资源
	public static void releaseSource(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}

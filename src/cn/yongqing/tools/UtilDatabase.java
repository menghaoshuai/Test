package cn.yongqing.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UtilDatabase {
	private String username;
	private String password;
	private String driverClass;
	private String url;
	
	private static UtilDatabase util;
	
	private UtilDatabase() {
		init();
	}
	
	public static UtilDatabase create() {
		if (util == null)
			util = new UtilDatabase();
		return util;
	}
	
	private void init() {
		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream("dataload.properties");
			Properties prop = new Properties();
			prop.load(in);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			driverClass = prop.getProperty("driver.class");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) in.close();
			}catch(Exception e){}
		}
	}
	
	public Connection connection() {
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}

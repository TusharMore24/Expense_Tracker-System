package org.repository;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBConfig {
	private static Connection conn;
	private static PreparedStatement stmt;
	private static CallableStatement ctmt;
	private static ResultSet rs;
	private static DBConfig db;
	private static final Logger logger = LogManager.getLogger(DBConfig.class);

	private  DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			File f = new File(".");
			String path = f.getAbsolutePath();
			FileInputStream inputStream = new FileInputStream(path + "/src/main/resources/dbconfig.properties");
			Properties p = new Properties();
			p.load(inputStream);
			String driverClassName = p.getProperty("driver");
			String userName = p.getProperty("username");
			String passWord = p.getProperty("password");
			String url = p.getProperty("url");

			conn = DriverManager.getConnection(url, userName, passWord);
			logger.info("Connection established successfully!");
		} catch (Exception ex) {
			throw new RuntimeException("Error establishing database connection: " + ex.getMessage(), ex);
		}
	}

	public static DBConfig getInstatance() {
		if (db == null) {
			db = new DBConfig();
		}
		return db;
	}

	public static Connection getConnection() {
		return conn;
	}

	public static PreparedStatement getStatement() {
		return stmt;
	}

	public static ResultSet getResult() {
		return rs;
	}

	public static CallableStatement getCallStatement() {
		return ctmt;
	}

}

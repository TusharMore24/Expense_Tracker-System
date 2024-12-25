package org.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class DBState {
	DBConfig config = DBConfig.getInstatance();
	protected Connection conn = config.getConnection();
	protected PreparedStatement stmt = config.getStatement();
	protected ResultSet rs = config.getResult();
	protected CallableStatement ctmt = config.getCallStatement();

//	public DBState() {
//		System.out.println(config.getInstatance());
//		if (conn != null) {
//			System.out.println("Database is connected...");
//
//		} else {
//			System.out.println("Database connection failed.");
//		}
//	}

}

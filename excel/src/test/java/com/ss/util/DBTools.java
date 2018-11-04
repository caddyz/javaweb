package com.ss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBTools {
	private static DBTools instacne;
	private ComboPooledDataSource ds;
	private DBTools() {
		ds = new ComboPooledDataSource();
	}
	public static DBTools getInstance() {
		if(instacne == null) {
			synchronized (DBTools.class) {
				if(instacne == null) {
					instacne = new DBTools();
				}
			}
		}
		return instacne;
	} 
	
	public static void closeConn(Connection conn,PreparedStatement prep,ResultSet set) {
		try {
			if(set!=null) {
				set.close();
			}
			if(prep!=null) {
				prep.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
		
	}
}

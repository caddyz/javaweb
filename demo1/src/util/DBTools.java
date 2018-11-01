package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBTools {
	private static DBTools instance;
	private BasicDataSource bds = new BasicDataSource();
	private DBTools(){
		bds.setDriverClassName(PropertiesUtil.getProperty("jdbc.properties", "driver"));
		/*try {
			Class.forName(PropertiesUtil.getProperty("jdbc.properties", "driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		bds.setUrl(PropertiesUtil.getProperty("jdbc.properties", "url"));
		bds.setUsername(PropertiesUtil.getProperty("jdbc.properties", "user"));
		bds.setPassword(PropertiesUtil.getProperty("jdbc.properties", "password"));
//		bds.setMaxTotal(Integer.parseInt(PropertiesUtil.getProperty("jdbc.properties", "maxTotal")));
//		bds.setInitialSize(Integer.parseInt(PropertiesUtil.getProperty("jdbc.properties", "initialSize")));
//		bds.setMaxWaitMillis(Integer.parseInt(PropertiesUtil.getProperty("jdbc.properties", "maxWaitMillis")));
//		bds.setMaxIdle(Integer.parseInt(PropertiesUtil.getProperty("jdbc.properties", "maxIdle")));
//		bds.setMinIdle(Integer.parseInt(PropertiesUtil.getProperty("jdbc.properties", "minIdle")));
	}
	public static DBTools getInstance(){
		if(instance==null){
			synchronized (DBTools.class) {
				if(instance==null){
					return new DBTools();
				}
			}
		}
		return instance;
	}
	public Connection getConnection(){
		try {
			return bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConn(Connection conn,PreparedStatement prep,ResultSet set){
		try {
			if(set!=null){
				set.close();
			}
			if(prep!=null){
				prep.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		Connection conn = getInstance().getConnection();
		System.out.println(conn);
	}*/
}

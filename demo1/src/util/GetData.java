package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetData {
	public static <E>List<E> getAll(String sql,Class<E> clazz,Object...obj){
		ArrayList<E> list = new ArrayList<E>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i+1, obj[i]);
				}
			}
//			System.out.println("prep"+prep);
			set = prep.executeQuery();
			ResultSetMetaData data = set.getMetaData();
			String columnName = null;
			Object columnValue = null;
			while(set.next()){
				E instance = clazz.newInstance();
				for (int i = 1; i < data.getColumnCount()+1; i++) {
					columnName = data.getColumnLabel(i);
					columnValue = set.getObject(columnName);
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(instance, columnValue);
				}
				list.add(instance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, set);
		}
		return list;
	}
	
	public static Integer insertSql(String sql,Object...obj){
		Integer num = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i + 1, obj[i]);
				}
			}
			num = prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBTools.closeConn(conn, prep, null);
		}
		return num;
	}
	
	public static List<String> getKind(String sql){
		List<String> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
//			System.out.println("prep"+prep);
			set = prep.executeQuery();
			ResultSetMetaData data = set.getMetaData();
			String name = null;
			while(set.next()){
				for (int i = 1; i < data.getColumnCount()+1; i++) {
					name = set.getString(i);
				}
				list.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, set);
		}
		return list;
		}
}

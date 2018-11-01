package dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GetDao;
import util.DBTools;

public class GetDaoImpl implements GetDao{
	@Override
	public <E>List<E> getAll(String sql,Class<E> clazz,Object...obj){
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
	
	@Override
	public Integer getAllCount(){
		String sql = "SELECT COUNT(*) count FROM t_user;";
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		Integer i = 0;
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			set = prep.executeQuery();
			while(set.next()){
				i = set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, set);
		}
		return i;
	}

	@Override
	public Integer upDate(String sql, Object... obj) {
		Connection conn = null;
		PreparedStatement prep = null;
		Integer num = 0;
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i+1, obj[i]);
				}
			}
			num = prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, null);
		}
		return num;
	}
}

package com.ss.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ss.util.DBTools;
import com.ss.util.GetData;

public class Test {
	public static void main(String[] args) {
		/*String sql = "show variables like '%secure_file_priv%';";
		try {
			Connection conn = DBTools.getInstance().getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet set = prep.executeQuery();
			while(set.next()) {
				String str = set.getString(2);
				System.out.println(str);
			}
			set.close();
			prep.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		GetData gd = new GetData();
//		gd.exportFile("test");
		gd.fileToData("test");
//		System.out.println(DBTools.getInstance().getConnection());
	}
	
	
}

package com.ss.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class GetData {
	//将CVS上传到数据库
	public void fileToData(String path) {
		String realPath = path.replace("\\", "/");
		Connection conn = null;
		PreparedStatement prep = null;
		String sql = "load data infile '"+realPath+"'" + 
				"into table test character set gbk " + 
				"fields terminated by ',' optionally enclosed by '\"' escaped by '\"'\r\n" + 
				"lines terminated by '\\r\\n';";
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, null);
		}
	}
	//获取文件的secure_file_priv的地址
	public String getFilePath() {
		String path = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		String sql = "show variables like '%secure_file_priv%';";
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			set = prep.executeQuery();
			while(set.next()) {
				path = set.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, set);
		}
		return path;
	}
	//excel文件转csv文件的方法
	public String excelToCsv(String fromPath,String pathname) {
		String path = getFilePath().replace("\\", File.separator)+pathname+".cvs";
		Workbook workbook = null;
		BufferedWriter bw = null;
		try {
			workbook = StreamingReader.builder().bufferSize(4049).rowCacheSize(200).open(new File(fromPath));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path))));
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				for (Row row : sheet) {
					for (Cell cell : row) {
						if(cell.getCellTypeEnum()==CellType.STRING) bw.write(cell.getStringCellValue());
						if(cell.getCellTypeEnum()==CellType.NUMERIC) bw.write(cell.getNumericCellValue()+"");
						if(cell.getCellTypeEnum()==CellType.BOOLEAN) bw.write(cell.getBooleanCellValue()+"");
						bw.write(",");
					}
					bw.newLine();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) {
					bw.close();
				}
				if(workbook!=null) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path;
	}
	
	//执行sql的导出方法
	public void exportFile(String filename) {
		String name = getFilePath().replace("\\", "/")+filename+".cvs";
		String sql = "select * from test into outfile '"+name+"' \r\n" + 
				"fields terminated by ',' optionally enclosed by '\"' escaped by '\"' lines terminated by '\\r\\n';";
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBTools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			prep.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, null);
		}
	}
	
	//执行sql文件导入导出的通用方法
	public int execute(String sql,Object...obj) {
		int num = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		conn = DBTools.getInstance().getConnection();
		try {
			prep = conn.prepareStatement(sql);
			if(obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i+1, obj[i]);
				}
			}
			num = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTools.closeConn(conn, prep, null);
		}
		return num;
	}
}

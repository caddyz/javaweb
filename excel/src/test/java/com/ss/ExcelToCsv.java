package com.ss;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class ExcelToCsv {
//	private static Log logger = LogFactory.getLog(ExcelToCsv.class);
	public static void excelToCsv(String path) {
		Workbook workbook = null;
		BufferedWriter bw = null;
		workbook = StreamingReader.builder().bufferSize(4096).rowCacheSize(200).open(new File(path));
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("F:\\AuI18N\\t.csv")),"GBK"));
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for(Cell cell: row) {
					if(cell.getCellTypeEnum() == CellType.STRING) bw.write(cell.getStringCellValue());
					if(cell.getCellTypeEnum() == CellType.NUMERIC) bw.write(cell.getNumericCellValue()+"");
					if(cell.getCellTypeEnum() == CellType.BOOLEAN) bw.write(cell.getBooleanCellValue()+"");
					bw.write(",");
				}
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
	}
	
	public static void main(String[] args) {
		excelToCsv("F:\\AuI18N\\de.xlsx");
	}
}

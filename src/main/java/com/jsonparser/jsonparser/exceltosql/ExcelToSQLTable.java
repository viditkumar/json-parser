package com.jsonparser.jsonparser.exceltosql;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToSQLTable {
	private static final String FILE_NAME = "C://Users//Vidit Kumar//Downloads//excel1.xlsx";

	public static void main(String[] args) {
		try {
			InputStream ExcelFileToRead = new FileInputStream(FILE_NAME);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;

			Iterator rows = sheet.rowIterator();
			int rowCount = 0;
			List<String> rowheader = new ArrayList<>();
			List<String> rowdata = new ArrayList<>();
			List<List<String> > rowList = new ArrayList<>();

			while (rows.hasNext()) {
				row = (XSSFRow) rows.next();
				rowdata = new ArrayList<>();
				if(rowCount == 0){
					for(int i=0; i<row.getLastCellNum(); i++) {
						cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
						rowheader.add(cell.toString());
						System.out.print(cell.toString()+" ");
					}
				} else{
					for(int i=0; i<row.getLastCellNum(); i++) {
						cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
						rowdata.add(cell.toString());
						System.out.print(cell.toString()+" ");
					}
					if(!rowdata.isEmpty())
						rowList.add(rowdata);
				}
				System.out.println();
				rowCount++;
			}
			System.out.println(rowheader);
			System.out.println(rowList);
			
//			createTable(rowheader);
//			insertDataIntoTable(rowheader, rowList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertDataIntoTable(List<String> rowheader, List<List<String>> rowList) {
		
	}

	private static void createTable(List<String> rowheader) {
		StringBuffer columnList = new StringBuffer();
		for(String str: rowheader){
			columnList.append(str).append(",");
		}
		columnList.substring(0, columnList.length()-1);
		// create table USER
	}
}

package com.jsonparser.jsonparser.exceltosql;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelToSQL {

	@PostMapping("/import")
	public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
	    
	    // List<Test> tempStudentList = new ArrayList<Test>();
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        // Test tempStudent = new Test();
	            
	        XSSFRow row = worksheet.getRow(i);
	            
	        /*tempStudent.setId((int) row.getCell(0).getNumericCellValue());
	        tempStudent.setContent(row.getCell(1).getStringCellValue());
	        tempStudentList.add(tempStudent);*/   
	    }
	}
}

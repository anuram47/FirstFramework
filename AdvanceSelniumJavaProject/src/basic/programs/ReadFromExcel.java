package basic.programs;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata.xlsx");
		  
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Page1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		String exceldata = cell.getStringCellValue();
		System.out.println(exceldata);
	}
}

package random.program.practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {
	public static String actualURL;  
	public static String actualLoginUrl;
	public static String emailId;
	public static String password;
	public static String actuaFirstName;
	public static String actualLastName;

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/InputData.xlsx");
		  
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("RegisterInputData");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		
		emailId= cell.getStringCellValue();
		System.out.println(emailId);
		row = sheet.getRow(1);
		cell = row.getCell(1);
		actuaFirstName = cell.getStringCellValue();
		System.out.println(actuaFirstName);
		
		row = sheet.getRow(1);
		cell = row.getCell(2);
		actualLastName = cell.getStringCellValue();
		System.out.println(actualLastName);
		
		row = sheet.getRow(1);
		cell = row.getCell(3);
		password = cell.getStringCellValue();
		System.out.println(password);
		
		row = sheet.getRow(1);
		cell = row.getCell(4);
		password = cell.getStringCellValue();
		System.out.println(password);

	}

}

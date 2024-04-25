package testng.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadRegisterTestCaseData {
	@DataProvider(name= "regData")
	public String [][] getRegisterUser() throws EncryptedDocumentException, IOException {

		File file = new File("./TestData/InputData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		 Workbook workBook = WorkbookFactory.create(fis);
		
		int numOfRows = workBook.getSheet("RegisterInputData").getPhysicalNumberOfRows();
		 int numOfCol = workBook.getSheet("RegisterInputData").getRow(0).getPhysicalNumberOfCells();
		String [][] data= new String[numOfRows][numOfCol];
		for (int i = 0; i < numOfRows; i++) {
			
			for (int j = 0; j < numOfCol; j++) {
				data[i][j] = workBook.getSheet("RegisterInputData").getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

}

package workingWithUnitTestingTool;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import utility.UtilClass;

public class WorkWithSingleRowData {

	@Test
	public void printData() throws EncryptedDocumentException, IOException {
		UtilClass uc = new UtilClass();
		uc.toReadSigleRowData("./TestData/InputData.xlsx","LoginInputData", 1);
		
		//uc.toReadSigleRowDataCOl("./TestData/InputData.xlsx","LoginInputData", 0);
	}
}

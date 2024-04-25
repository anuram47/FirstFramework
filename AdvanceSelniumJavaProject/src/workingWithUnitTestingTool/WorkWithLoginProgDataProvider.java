package workingWithUnitTestingTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkWithLoginProgDataProvider {
	@DataProvider(name="loginData")
	public String[][] readLoginData() throws EncryptedDocumentException, IOException{

		File file = new File("./TestData/InputData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workBook = WorkbookFactory.create(fis);

		int numOfRows = workBook.getSheet("LoginInputData").getPhysicalNumberOfRows();
		int numOfCol = workBook.getSheet("LoginInputData").getRow(0).getPhysicalNumberOfCells();
		String [][] loginData= new String[numOfRows][numOfCol];
		for (int i = 0; i < numOfRows; i++) {

			for (int j = 0; j < numOfCol; j++) {
				loginData[i][j] = workBook.getSheet("LoginInputData").getRow(i).getCell(j).toString();
			}
		}
		return loginData;
	}

	@Test(dataProvider = "loginData")
	public void registerUser(String[] dataReg) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();

		driver.findElement(By.id("Email")).sendKeys(dataReg[0]);
		driver.findElement(By.id("Password")).sendKeys(dataReg[1]);
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		Thread.sleep(3000);
		driver.quit();

	}
}

package workingWithUnitTestingTool;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.UtilClass;

public class ToReadMultipleDataFromDataProvider {
	
	@Test(dataProvider = "login")
	public void run(String userName, String password) throws EncryptedDocumentException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String [] data = UtilClass.toReadSigleRowData("./TestData/InputData.xlsx","LoginInputData", 1);
		driver.get(data[0]);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@DataProvider(name="login")
	public String [][] dataSupply() throws EncryptedDocumentException, IOException {
		return UtilClass.toReadMultipleData("./TestData/InputData.xlsx","LoginInputMultiData");
	}
}

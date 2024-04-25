package workingwithpom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utility.UtilClass;

public class ToReadDataFromExcelUtility {

	@Test
	public void loginToApp() throws EncryptedDocumentException, IOException {
		UtilClass uc = new UtilClass();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = uc.readingDataFromExcel("./TestData/InputData.xlsx","LoginInputData", 1, 0);
		String emailId= uc.readingDataFromExcel("./TestData/InputData.xlsx","LoginInputData", 1, 1);
		String password= uc.readingDataFromExcel("./TestData/InputData.xlsx","LoginInputData", 1, 2);
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.getLoginLink().click();
		lp.getEmailTextbox().sendKeys(emailId);
		lp.getPasswordTextbox().sendKeys(password);
		lp.getLoginButton().click();
	}
}

package testng.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import workingWithUnitTestingTool.WorkingWithListener;
@Listeners(WorkingWithListener.class)
public class VerifyRegisterTestCase extends ReadRegisterTestCaseData{
	
	public static WebDriver driver ;
	@Test(dataProvider = "regData")
	public void registerUser(String[] dataReg) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		SoftAssert sa = new SoftAssert();
		
		driver.findElement(By.linkText("Register")).click();
		WebElement regiterPage = driver.findElement(By.xpath("//div[@class=\"page registration-page\"]"));
		boolean isRegisterLinkDisplayed = regiterPage.isDisplayed();
		sa.assertEquals(isRegisterLinkDisplayed, true);
		Reporter.log("User is able to see register link.",true);
		
		WebElement femaleGenderBtn = driver.findElement(By.id("gender-female"));
		WebElement maleGenderBtn = driver.findElement(By.id("gender-male"));
		boolean isGenderRadioBtnSelected = false;
		if(dataReg[0].equalsIgnoreCase("male")) {
			maleGenderBtn.click();
			isGenderRadioBtnSelected = maleGenderBtn.isSelected();
		}
		
		if(dataReg[0].equalsIgnoreCase("female")) {
			femaleGenderBtn.click();
			isGenderRadioBtnSelected = femaleGenderBtn.isSelected();
		}
		
		sa.assertEquals(isGenderRadioBtnSelected, true);
		Reporter.log("Gender is selected.",true);
		
		driver.findElement(By.id("FirstName")).sendKeys(dataReg[1]);
		String expectedFN = driver.findElement(By.id("FirstName")).getAttribute("value");
		sa.assertEquals(dataReg[1], expectedFN);
		Reporter.log("Entered first name.",true);
		
		driver.findElement(By.id("LastName")).sendKeys(dataReg[2]);
		String expectedLN = driver.findElement(By.id("LastName")).getAttribute("value");
		sa.assertEquals(dataReg[2], expectedLN);
		Reporter.log("Entered last name.",true);

		
		driver.findElement(By.id("Email")).sendKeys(dataReg[3]);
		
		String expectedEmail = driver.findElement(By.id("Email")).getAttribute("value");
		sa.assertEquals(dataReg[3], expectedEmail);
		Reporter.log("Entered email id.",true);
		
		driver.findElement(By.id("Password")).sendKeys(dataReg[4]);
		String expectedPwd = driver.findElement(By.id("Password")).getAttribute("value");
		sa.assertEquals(expectedPwd, expectedPwd);
		Reporter.log("Entered password.",true);
		
		driver.findElement(By.id("ConfirmPassword")).sendKeys(dataReg[5]);
		String expectedConfPwd = driver.findElement(By.id("ConfirmPassword")).getAttribute("value");
		sa.assertEquals(dataReg[5], expectedConfPwd);
		Reporter.log("Entered confirm password.",true);
		
		driver.findElement(By.id("register-button")).click();
		boolean isSuccessMesDisplayed =false;
		try {
			WebElement successMes = driver.findElement(By.xpath("//div[@class=\"result\"]"));
			isSuccessMesDisplayed=successMes.isDisplayed();
			Reporter.log("User creation is done successfully.", true);
			sa.assertEquals(isSuccessMesDisplayed, true);
			
		}catch (Exception e) {
			Reporter.log("User creation is failed - The specified email already exists.", true);
			sa.assertEquals(isSuccessMesDisplayed, false);
		}
		
		sa.assertAll();
		Thread.sleep(3000);
		driver.quit();
		
	}

}

package simpleProg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FTC_002_DWS {
	@Test
	public void registerUserWithInvalidData() throws Throwable {
		String actualUrl = "https://demowebshop.tricentis.com/";
		String emailId = "anuram47@gmail.com";
		String password = "test1234";
		String actuaFirstName = "Anushree";
		String actualLastName ="R";


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(actualUrl);
		String currentUrl = driver.getCurrentUrl();
		if (actualUrl.equals(currentUrl)) {
			Reporter.log("User is able to land on demowebshop", true);
		} else {
			Reporter.log("User is not able to land on demowebshop", true);
		}

		driver.findElement(By.linkText("Register")).click();
		WebElement regiterPage = driver.findElement(By.xpath("//div[@class=\"page registration-page\"]"));
		if(regiterPage.isDisplayed()) {
			Reporter.log("Register form is available for user.",true);
		}else {
			Reporter.log("Register form is not available for user.",true);
		}

		WebElement genderBtn = driver.findElement(By.id("gender-female"));
		genderBtn.click();
		if(genderBtn.isSelected()) {
			Reporter.log("Gender is selected.",true);
		}else {
			Reporter.log("Gender is not selected.",true);
		}

		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys(actuaFirstName);

		String actualFN = firstName.getAttribute("value");
		if(actuaFirstName.equals(actualFN)) {

			Reporter.log("Entered first name.",true);
		} else {
			Reporter.log("Unable to enter first name.",true);
		}

		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.sendKeys(actualLastName);

		String actualLN = lastName.getAttribute("value");
		if(actualLastName.equals(actualLN)) {

			Reporter.log("Entered last name.",true);
		} else {
			Reporter.log("Unable to enter last name.",true);
		}

		WebElement emailTextBox = driver.findElement(By.id("Email"));
		emailTextBox.sendKeys(emailId);

		String actualEmail = emailTextBox.getAttribute("value");
		if(actualEmail.equals(emailId)) {

			Reporter.log("Entered email id.",true);
		} else {
			Reporter.log("Unable to enter email id.",true);
		}

		WebElement passwordTextbox = driver.findElement(By.id("Password"));
		passwordTextbox.sendKeys(password);

		String actualPwd = passwordTextbox.getAttribute("value");
		if(actualPwd.equals(password)) {
			Reporter.log("Entered password.",true);
		} else {
			Reporter.log("Unable to enter password.",true);
		}

		WebElement confPasswordTextbox = driver.findElement(By.id("ConfirmPassword"));
		confPasswordTextbox.sendKeys(password);

		String actualConfPwd = confPasswordTextbox.getAttribute("value");
		if(actualConfPwd.equals(password)) {
			Reporter.log("Entered confirm password.",true);
		} else {
			Reporter.log("Unable to enter confirm password.",true);
		}

		WebElement regiterBtn = driver.findElement(By.id("register-button"));
		regiterBtn.click();
		WebElement failedMes = driver.findElement(By.xpath("//li[text()=\"The specified email already exists\"]"));
		if(failedMes.isDisplayed()) {
			Reporter.log("The specified email already exists.", true);
		} else {
			Reporter.log("Unexpected error occured.", true);
		}

		driver.quit();

	}

}

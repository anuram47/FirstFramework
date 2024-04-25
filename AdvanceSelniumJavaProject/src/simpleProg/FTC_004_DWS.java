package simpleProg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FTC_004_DWS {
	@Test
	public void loginWithInvalidEmail() {
		String actualUrl = "https://demowebshop.tricentis.com/";
		String actualTitle = "Demo Web Shop";
		String actualLoginUrl = "https://demowebshop.tricentis.com/login";
		String emailId = "anuram47";
		String password = "test1234";
		boolean actualCheckbox =true;
		
		//step1 
		WebDriver driver = new ChromeDriver();
		Reporter.log("User is able to open empty browser.",true);
		driver.manage().window().maximize();
		Reporter.log("User is able to maximize the browser.",true);
		
		//step2
		driver.get("https://demowebshop.tricentis.com/");
		String titleOfThePage = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		
		if(actualUrl.equals(currentUrl)) {
			Reporter.log("User is able to open demo web shop page",true);		
		} else {
			Reporter.log("User is not able to open demo web shop page",true);
		}
		
		if(actualTitle.equals(titleOfThePage)) {
			Reporter.log("Title is correct",true);
		}else {
			Reporter.log("Title is not correct",true);
			
		}
		//step 3
		driver.findElement(By.linkText("Log in")).click();
		String loginPageUrl = driver.getCurrentUrl();
		if(actualLoginUrl.equals(loginPageUrl)) {
			Reporter.log("User is able to land on login page",true);
		}else {
			Reporter.log("User is not able to work on login page",true);
		}
		//step4 
		WebElement emailTextbox = driver.findElement(By.id("Email"));
		emailTextbox.sendKeys(emailId);
		driver.findElement(By.id("Password")).click();
		WebElement emailAddVerificationMes = driver.findElement(By.xpath("//span[text()=\"Please enter a valid email address.\"]"));
		if(emailAddVerificationMes.isDisplayed()) {
			Reporter.log("Please enter a valid email address.",true);
			
		}else {
			Reporter.log("Unexpected error displayed.",true);
		}
		
		
		//step8
		driver.quit();

	}

}

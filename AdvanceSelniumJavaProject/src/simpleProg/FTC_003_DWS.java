package simpleProg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FTC_003_DWS {
	@Test
	public void loginWithValidUser() {
		String actualUrl = "https://demowebshop.tricentis.com/";
		String actualTitle = "Demo Web Shop";
		String actualLoginUrl = "https://demowebshop.tricentis.com/login";
		String emailId = "anuram47@gmail.com";
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
			Reporter.log("Title is correct");
		}else {
			Reporter.log("Title is not correct");
			
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
		String foundEmailValue = emailTextbox.getAttribute("value");
		if(emailId.equals(foundEmailValue)) {
			Reporter.log("User is able to send email id",true);
			
		}else {
			Reporter.log("User is not able to send email id",true);
		}
		//step5
		WebElement passwordTextbox = driver.findElement(By.id("Password"));
		passwordTextbox.sendKeys(password);
		String foundPasswordValue = emailTextbox.getAttribute("value");
		if(password.equals(foundPasswordValue)) {
			Reporter.log("User is able to send password",true);
			
		}else {
			Reporter.log("User is not able to send password",true);
		}
		
		//step 6
		WebElement rememberCheckbox = driver.findElement(By.name("RememberMe"));
		rememberCheckbox.click();
		boolean checkBox = rememberCheckbox.isSelected();
		if(actualCheckbox == checkBox) {
			Reporter.log("Check box is selected",true);
		}else {
			Reporter.log("checkbox is not selected.",true);
		}

		//step 7
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		WebElement logoutLink = driver.findElement(By.xpath("//a[text()=\"Log out\"]"));
		if(logoutLink.isDisplayed()) {
			Reporter.log("Login successful",true);
		}
		else {
			Reporter.log("Login not successful",true);
		}
		
		//step8
		driver.quit();

	}

}

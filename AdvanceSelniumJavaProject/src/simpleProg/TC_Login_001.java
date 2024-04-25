package simpleProg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_001 {

	public static void main(String[] args) {
		String actualUrl = "https://demowebshop.tricentis.com/";
		String actualTitle = "Demo Web Shop";
		String actualLoginUrl = "https://demowebshop.tricentis.com/login";
		String emailId = "anuram47@gmail.com";
		String password = "test1234";
		boolean actualCheckbox =true;
		
		
		//step1 
		WebDriver driver = new ChromeDriver();
		System.out.println("User is able to open empty browser.");
		driver.manage().window().maximize();
		System.out.println("User is able to maximize the browser.");
		
		//step2
		driver.get("https://demowebshop.tricentis.com/");
		String titleOfThePage = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		
		if(actualUrl.equals(currentUrl)) {
			System.out.println("User is able to open demo web shop page");		
		} else {
			System.out.println("User is not able to open demo web shop page");
		}
		
		if(actualTitle.equals(titleOfThePage)) {
			System.out.println("Title is correct");
		}else {
			System.out.println("Title is not correct");
			
		}
		//step 3
		driver.findElement(By.linkText("Log in")).click();
		String loginPageUrl = driver.getCurrentUrl();
		if(actualLoginUrl.equals(loginPageUrl)) {
			System.out.println("User is able to land on login page");
		}else {
			System.out.println("User is not able to work on login page");
		}
		//step4 
		WebElement emailTextbox = driver.findElement(By.id("Email"));
		emailTextbox.sendKeys(emailId);
		String foundEmailValue = emailTextbox.getAttribute("value");
		if(emailId.equals(foundEmailValue)) {
			System.out.println("User is able to send email id");
			
		}else {
			System.out.println("User is not able to send email id");
		}
		//step5
		WebElement passwordTextbox = driver.findElement(By.id("Password"));
		passwordTextbox.sendKeys(password);
		String foundPasswordValue = emailTextbox.getAttribute("value");
		if(password.equals(foundPasswordValue)) {
			System.out.println("User is able to send password");
			
		}else {
			System.out.println("User is not able to send password");
		}
		
		//step 6
		WebElement rememberCheckbox = driver.findElement(By.name("RememberMe"));
		rememberCheckbox.click();
		boolean checkBox = rememberCheckbox.isSelected();
		if(actualCheckbox == checkBox) {
			System.out.println("Check box is selected");
		}else {
			System.out.println("checkbox is not selected.");
		}

		//step 7
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		WebElement logoutLink = driver.findElement(By.xpath("//a[text()=\"Log out\"]"));
		if(logoutLink.isDisplayed()) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login not successful");
		}
		
		//step8
		driver.quit();
		
		
		
	}

}

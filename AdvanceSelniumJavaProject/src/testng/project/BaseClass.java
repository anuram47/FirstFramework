package testng.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	String actualURl = "https://demowebshop.tricentis.com/";
	String actualLoginUrl = "https://demowebshop.tricentis.com/login";
	String actualuserName = "anuram47@gmail.com";
	String actualPassword = "test1234";

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Report formation", true);
		Reporter.log("DataBase coonection start", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("Report formation stop", true);
		Reporter.log("Data base connection isclosed", true);
	}
	//@BeforeClass
	@BeforeTest
	public void browsersetUp() throws InterruptedException {
		driver = new ChromeDriver();
		Reporter.log("User is able to open empty browser", true);
		driver.manage().window().maximize();
		Reporter.log("User is able to maximize the browser", true);
		driver.get("https://demowebshop.tricentis.com/");
		String currentUrl = driver.getCurrentUrl();
		if (actualURl.equals(currentUrl)) {
			Reporter.log("User is able to land on demowebshop", true);
		} else {
			Reporter.log("User is not able to land on demowebshop", true);
		}
		Thread.sleep(3000);
	}
	//@AfterClass
	@AfterTest
	public void tearDownBrowser() {
		driver.quit();
		Reporter.log("User is able to quit the browser", true);
	}

	@BeforeMethod
	public void userLogin() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		String loginUrl = driver.getCurrentUrl();
		if (actualLoginUrl.equals(loginUrl)) {
			Reporter.log("User is able to land on login page", true);
		} else {
			Reporter.log("User is not able to land on login page", true);
		}

		WebElement emailTextBox = driver.findElement(By.id("Email"));
		emailTextBox.sendKeys(actualuserName);
		String emailData = emailTextBox.getAttribute("value");
		if (actualuserName.equals(emailData)) {
			Reporter.log("User is able to enetr valid data for emailTextBox", true);
		} else {
			Reporter.log("User is not able to enter valid data for emailTextBox", true);
		}

		WebElement pwdTextBox = driver.findElement(By.id("Password"));
		pwdTextBox.sendKeys(actualPassword);
		String pwdData = pwdTextBox.getAttribute("value");
		if (actualPassword.equals(pwdData)) {
			Reporter.log("User is able to enetr valid data for password text box", true);
		} else {
			Reporter.log("User is not able to enter valid data for password text box", true);
		}
		WebElement checkBox = driver.findElement(By.id("RememberMe"));
		checkBox.click();
		if (checkBox.isSelected()) {
			Reporter.log("User is able to click on CheckBOX", true);
		} else {
			Reporter.log("User is not able to clik on checkbox", true);
		}

		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
		loginButton.click();
		if (loginButton.isSelected()) {
			Reporter.log("User is able to click on login button", true);
		} else {
			Reporter.log("User is not able to click on login button", true);
		}
		Thread.sleep(3000);
		Reporter.log("User is able to login with valid data", true);
	}

	@AfterMethod
	public void userLogOut() {
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("User logout", true);
	}
}

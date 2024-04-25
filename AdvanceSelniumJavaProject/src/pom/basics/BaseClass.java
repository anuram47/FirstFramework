package pom.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
 
	public WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Report formation", true);
		Reporter.log("DataBase coonection start", true);
	}
	
	@BeforeTest
	public void browsersetUp() throws InterruptedException {
		driver = new ChromeDriver();
		Reporter.log("User is able to open empty browser", true);
		driver.manage().window().maximize();
		Reporter.log("User is able to maximize the browser", true);
		String actualURl = "https://demowebshop.tricentis.com/";
		driver.get(actualURl);
		String currentUrl = driver.getCurrentUrl();
		if (actualURl.equals(currentUrl)) {
			Reporter.log("User is able to land on demowebshop", true);
		} else {
			Reporter.log("User is not able to land on demowebshop", true);
		}
		Thread.sleep(3000);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Report formation stop", true);
		Reporter.log("Data base connection isclosed", true);
	}
}

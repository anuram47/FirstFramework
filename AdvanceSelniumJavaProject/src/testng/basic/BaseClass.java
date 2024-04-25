package testng.basic;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public WebDriver driver;
	String URL = "https://demowebshop.tricentis.com/";
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Report Formation", true);
	}

}

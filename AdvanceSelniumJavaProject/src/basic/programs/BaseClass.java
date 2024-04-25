package basic.programs;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;
	public String actualURL;  
	public String actualLoginUrl;
	public String emailId;
	public String password;
	public String actuaFirstName;
	public String actualLastName;
	
	@BeforeSuite
	public void readFromProperty() throws Throwable {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("./InputData.properties");
		pro.load(fis);

		actualURL = pro.getProperty("url");  
		actualLoginUrl = pro.getProperty("loginurl");
		emailId = pro.getProperty("emailid");
		password = pro.getProperty("password");
		actuaFirstName = pro.getProperty("firstName");
		actualLastName = pro.getProperty("lasname");
		
		Reporter.log("Data is loaded to variables");
	}
	
	@BeforeTest
	public void browsersetUp() throws InterruptedException {
		driver = new ChromeDriver();
		
		Reporter.log("User is able to open empty browser", true);
		driver.manage().window().maximize();
		Reporter.log("User is able to maximize the browser", true);
		driver.get(actualURL);
		String currentUrl = driver.getCurrentUrl();
		if (actualURL.equals(currentUrl)) {
			Reporter.log("User is able to land on demowebshop", true);
		} else {
			Reporter.log("User is not able to land on demowebshop", true);
		}
		Thread.sleep(3000);
	}
}

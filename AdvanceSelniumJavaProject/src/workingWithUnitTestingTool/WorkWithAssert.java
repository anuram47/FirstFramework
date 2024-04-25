package workingWithUnitTestingTool;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkWithAssert {

	String actualUurl = "https://demowebshop.tricentis.com/";
	String actualRegUrl = "https://demowebshop.tricentis.com/register";
	@Test
	public void openDemoWedShop() {
		WebDriver driver = new ChromeDriver();
		Reporter.log("User is able to open empty browser.", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		String currentUrl = driver.getCurrentUrl();
		Reporter.log(currentUrl,true);
		Assert.assertEquals(actualUurl, currentUrl);
		
		driver.findElement(By.linkText("Register")).click();
		String currentRegUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualRegUrl, currentRegUrl);
		driver.quit();
		
	}

}

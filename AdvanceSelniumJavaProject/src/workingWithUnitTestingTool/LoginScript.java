package workingWithUnitTestingTool;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(WorkingWithListener.class)
public class LoginScript{
	public static WebDriver driver;
	@Test
	public void login() {
		String actualUrl = "https://demowebshop.tricenti.com/";
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(actualUrl);
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, currentUrl);
		driver.quit();
	}
}

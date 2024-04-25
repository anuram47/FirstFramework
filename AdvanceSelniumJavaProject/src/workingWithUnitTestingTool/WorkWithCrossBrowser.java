package workingWithUnitTestingTool;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WorkWithCrossBrowser {
	WebDriver driver;
	
	@Parameters({"browserName","url"})
	@Test
	public void browserTest(@Optional("firefox")String browserName, @Optional("https://demowebshop.tricentis.com/")String url) {
		if(browserName.equals("chrome")) {
			driver =new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")){
			driver = new EdgeDriver();
		}else {
			System.out.println("browsername is invalid.");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.quit();
	}

}

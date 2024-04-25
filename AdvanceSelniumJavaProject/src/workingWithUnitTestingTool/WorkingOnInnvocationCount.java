package workingWithUnitTestingTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingOnInnvocationCount {
	@Test(invocationCount = 2 ,threadPoolSize =2 )
	public void run() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyundai.com/");
		//Thread.sleep(1000);
		driver.quit();
	}

}

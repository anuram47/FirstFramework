package workingWithUnitTestingTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWithTimeOut {

	@Test(timeOut = 2000)
	public void run() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyundai.com/");
		//Thread.sleep(3000);
		driver.quit();
	}
}

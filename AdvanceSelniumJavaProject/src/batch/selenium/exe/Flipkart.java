package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {
	@Test
	public void openFlipkart() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.quit();
	}
}

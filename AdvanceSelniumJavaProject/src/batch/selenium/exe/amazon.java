package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class amazon {
	@Test
	public void openAmazon() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.quit();
	}

}

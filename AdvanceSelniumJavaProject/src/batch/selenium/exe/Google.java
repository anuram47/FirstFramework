package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {

	@Test
	public void openGoogle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();
	}
}

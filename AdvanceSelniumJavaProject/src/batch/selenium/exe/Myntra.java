package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Myntra {
	@Test
	public void openMyntra() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.quit();
	}
}

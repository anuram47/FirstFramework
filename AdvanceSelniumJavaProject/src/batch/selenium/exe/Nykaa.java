package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Nykaa {

	@Test
	public void openNykaa() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.quit();
	}
}

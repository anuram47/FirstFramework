package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookMyShow {

	@Test
	public void openBookMyShow() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		driver.quit();
	}
}

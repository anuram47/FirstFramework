package batch.selenium.exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lakme {
	@Test
	public void openLakme() {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.lakmeindia.com/");
		driver.quit();
	}
}

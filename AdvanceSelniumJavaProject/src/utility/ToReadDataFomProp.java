package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToReadDataFomProp {
	@Test
	public void openDWS() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		UtilClass uc = new UtilClass();
		String url = uc.readDataFromPropFile("./InputData.properties", "url");

		driver.get(url);
	}

}

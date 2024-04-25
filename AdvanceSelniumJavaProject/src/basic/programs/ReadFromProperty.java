package basic.programs;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadFromProperty {

	public static void main(String[] args) throws Throwable {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("./InputData.properties");
		pro.load(fis);
		
		String actualUrl = pro.getProperty("url");
		System.out.println("URL is = "+actualUrl);
		WebDriver driver = new ChromeDriver();
		driver.get(actualUrl);

	}

}

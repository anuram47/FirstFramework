package testng.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import workingWithUnitTestingTool.LoginScript;

public class TestNGBaseClass_DWS {

	public WebDriver driver;
	public String actualURL;  
	public String actualLoginUrl;
	public String emailId;
	public String password;
	public String actuaFirstName;
	public String actualLastName;

	@BeforeSuite
	public void readFromProperty() throws Throwable {
		Properties pro = new Properties();
		FileInputStream fisp = new FileInputStream("./InputData.properties");
		pro.load(fisp);		

		actualURL = pro.getProperty("url"); 
		FileInputStream fis = new FileInputStream("./TestData/InputData.xlsx");
		  
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("RegisterInputData");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		
		emailId= cell.getStringCellValue();
		row = sheet.getRow(1);
		cell = row.getCell(1);
		actuaFirstName = cell.getStringCellValue();
		
		row = sheet.getRow(1);
		cell = row.getCell(2);
		actualLastName = cell.getStringCellValue();
		
		row = sheet.getRow(1);
		cell = row.getCell(3);
		password = cell.getStringCellValue();
		
		row = sheet.getRow(1);
		cell = row.getCell(4);
		password = cell.getStringCellValue();
		
	}
	
	@Parameters({"browserName","url"})
	public void browserTest(@Optional("firefox")String browserName, @Optional("https://demowebshop.tricentis.com/")String url) {
		if(browserName.equals("chrome")) {
			driver =new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")){
			driver = new EdgeDriver();
		}else {
			Reporter.log("browsername is invalid.");
		}
		Reporter.log("User is able to open empty browser", true);
		driver.manage().window().maximize();
		Reporter.log("User is able to maximize the browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		String currentUrl = driver.getCurrentUrl();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(url, currentUrl);
		sa.assertAll();
		Reporter.log("User is able to land on demowebshop", true);
	}
	
	@BeforeTest
	public void browsersetUp() throws InterruptedException {
		browserTest("chrome",actualURL);
	}
	
	@AfterTest
	public void takeScreenShotOfDWS() {
		LocalDateTime systemTime = LocalDateTime.now();
		String srnShotTime = systemTime.toString().replace(":", "-");
		TakesScreenshot screenshot = (TakesScreenshot)driver;		
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./PassedScreenshot/+"+srnShotTime+".png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


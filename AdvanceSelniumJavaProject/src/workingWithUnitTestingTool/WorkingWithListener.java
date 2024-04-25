package workingWithUnitTestingTool;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testng.project.VerifyRegisterTestCase;

public class WorkingWithListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() +" test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test is passed");
		LocalDateTime systemTime = LocalDateTime.now();
		System.out.println(systemTime);

		String srnShotTime = systemTime.toString().replace(":", "-");
		TakesScreenshot screenshot = (TakesScreenshot)VerifyRegisterTestCase.driver;		
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./PassedScreenshot/+"+srnShotTime+".png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+"Test is failed");
		LocalDateTime systemTime = LocalDateTime.now();
		System.out.println(systemTime);

		String srnShotTime = systemTime.toString().replace(":", "-");
		TakesScreenshot screenshot = (TakesScreenshot)VerifyRegisterTestCase.driver;		
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorscreen/+"+srnShotTime+".png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

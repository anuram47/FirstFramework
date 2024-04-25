package testng.project;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Tc_Demo_002_Test extends BaseClass {
	@Test
	public void validateThatUserIsAbleToClickOnShoppinfCart() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Thread.sleep(3000);
		Reporter.log("User is able to click on cart", true);

	}
}
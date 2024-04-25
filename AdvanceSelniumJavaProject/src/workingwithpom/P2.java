package workingwithpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class P2 extends BaseClass{
	@Test
	public void searchItem() throws InterruptedException {
		WebElement searchTextbox =  driver.findElement(By.id("small-searchterms"));
		searchTextbox.sendKeys("books");
		Thread.sleep(2000);
		driver.navigate().refresh();
		searchTextbox.sendKeys("computers");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}
}

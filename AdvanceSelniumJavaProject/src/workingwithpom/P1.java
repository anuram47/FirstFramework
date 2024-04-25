package workingwithpom;

import org.testng.annotations.Test;

public class P1 extends BaseClass{

	@Test
	public void searchItem() throws InterruptedException {
		BasePage bp = new BasePage(driver);
		bp.getSearchTextbox().sendKeys("books");
		Thread.sleep(2000);
		driver.navigate().refresh();
		bp.getSearchTextbox().sendKeys("computers");
		Thread.sleep(2000);
		bp.getSearchButton().click();
		
	}
}

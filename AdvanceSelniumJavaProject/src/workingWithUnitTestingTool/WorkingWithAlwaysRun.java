package workingWithUnitTestingTool;

import org.testng.annotations.Test;

public class WorkingWithAlwaysRun {

	@Test(priority = 1)
	public void openBrowser() {
		System.out.println("User is able to run");
	}
	@Test(priority = 2)
	public void enetrURL() {
		System.out.println("User ia able to enetr url");
	}
	
	@Test(alwaysRun = true)
	public void closeBrowser() {
		System.out.println("User is able to close the browser");
	}
	
	/*
	 * @Test(alwaysRun = false) public void withdrawMoney() {
	 * System.out.println("User is able to withdraw."); }
	 */
}

package workingWithUnitTestingTool;

import org.testng.annotations.Test;

public class WorkingWithPriority {

	final int a = 3;

	@Test(priority = a)
	public void register() {// tc_case_scr
		System.out.println("User is able to register");
	}

	@Test(priority = -2)
	public void login() {
		System.out.println("User is able to login");
	}

	@Test(priority = -3)
	public void searchBus() {
		System.out.println("User is able to search bus");
	}

	@Test(priority = -4)
	public void selDate() {
		System.out.println("User is able to select the date");
	}

	@Test(priority = 5)
	public void payment() {
		System.out.println("User is able to make a payment");
	}

	@Test(enabled = false)
	public void cnfmMsg() {
		System.out.println("User is able to get msg");
	}
}

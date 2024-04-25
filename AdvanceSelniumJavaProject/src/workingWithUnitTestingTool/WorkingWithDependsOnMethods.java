package workingWithUnitTestingTool;

import org.testng.annotations.Test;

public class WorkingWithDependsOnMethods {


	@Test
	public void register() {// tc_case_scr
		System.out.println("User is able to register");
	}

	@Test(dependsOnMethods = {"register","cnfmMsg"})
	public void login() {
		System.out.println("User is able to login");
	}

	@Test(dependsOnMethods ="login")
	public void searchBus() {
		System.out.println("User is able to search bus");
	}

	@Test(dependsOnMethods ="searchBus" ,priority = 3)
	public void selDate() {
		System.out.println("User is able to select the date");
	}

	@Test(dependsOnMethods = "selDate")
	public void payment() {
		System.out.println("User is able to make a payment");
	}

	@Test()
	public void cnfmMsg() {
		System.out.println("User is able to get msg");
	}

}

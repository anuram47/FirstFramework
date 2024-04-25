package workingWithUnitTestingTool;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithChronologicalOrder {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am before suite");
		System.out.println("DataBase coonection start");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am after suite");
		System.out.println("Data base connection isclosed");
	}

	@Test
	public void test() {
		System.out.println("I am test");
	}

	@Test
	public void run() {
		System.out.println("I am run");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am after test");

	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am after class");

	}
	@Test
	public void pass() {
		System.out.println("I am pass");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am before class");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am before method");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am after method");
	}
}

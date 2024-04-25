package testng.basic;

import org.testng.annotations.Test;

public class TestNgBasicConcepts {

	final int a =1;
	@Test(priority =a)
	public void register() {
		System.out.println("Register");
	}

	@Test(priority =-2)
	public void login() {
		System.out.println("Login");
	}
	@Test(priority =-3)
	public void selDate() {
		System.out.println("Select date");
		
	}
	@Test(priority =-4)
	public void selPlace() {
		System.out.println("select place");
	}
	@Test(priority =5)
	public void checkOut() {
		System.out.println("check out");
	}
	@Test(priority =6)
	public void logOut() {
		System.out.println("Log out form app");
	}
	
}

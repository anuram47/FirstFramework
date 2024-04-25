package workingwithpom;

import org.testng.annotations.Test;

public class LoginToApp extends BaseClass {

	@Test
	public void loginToApp() {
		LoginPage lp = new LoginPage(driver);
		lp.getLoginLink().click();
		lp.getEmailTextbox().sendKeys("anuram47@gmail.com");
		lp.getPasswordTextbox().sendKeys("test1234");
		lp.getLoginButton().click();
		
	}
}

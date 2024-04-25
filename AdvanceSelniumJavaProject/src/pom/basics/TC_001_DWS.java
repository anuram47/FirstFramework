package pom.basics;

import org.testng.annotations.Test;

public class TC_001_DWS extends BaseClass{
	@Test
	public void verifyRegisterForValidInput() {
		RegisterPage regPage = new RegisterPage(driver);
		
		regPage.getRegisterLink().click();
		regPage.getFemaleGenderRadioButton().click();
		regPage.getFisrtNameTextBox().sendKeys("Anu");
		regPage.getLastNameTextBox().sendKeys("Shree");
		regPage.getEmailIdTextBox().sendKeys("anuram456778@gmail.com");
		regPage.getPasswordTextBox().sendKeys("test1234");
		regPage.getConfirmPasswordTextBox().sendKeys("test1234");
		regPage.getRegisterButton().click();
	}
	
	
}

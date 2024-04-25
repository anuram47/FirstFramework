package testng.project;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_FTC_001_DWS extends RegBaseClass{
	@Test
	public void regiterUserWithValidData() {
		Reporter.log("trial done", true);
		whenIClickOnRFegiterLink();
		selectGender();
		whenIEnterFirstName();
		whenIEnterLastName();
		whenIEnterEmail();
		whenIEnterPassword();
		whenIEnterConfirmPassword();
		whenIClickOnRegisterBtn();
	}
	

}

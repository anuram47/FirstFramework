package basic.programs;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FTC_001 extends RegisterBaseClass{

	//@Test(ignore = "browsersetUp")
	public void verifyRegisterLink() {
		Reporter.log("Test is passed",true);
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

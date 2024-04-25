package testng.project;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.UtilClass;
import utility.UtilityMethods;
import workingWithUnitTestingTool.WorkingWithListener;

@Listeners(WorkingWithListener.class)
public class TestNG_FTC_003_DWS extends LoginBaseClass{
	@Test
	public void loginVeirificationForValidCredential() throws EncryptedDocumentException, IOException {
		Reporter.log("Test Started.....");
		LoginBasePage lbp = new LoginBasePage(driver);
		lbp.getLoginLink().click();
		boolean isEmailTextboxDisplaed = lbp.getEmailTextbox().isDisplayed();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(isEmailTextboxDisplaed, true);
		
		UtilClass uc = new UtilClass();
		UtilityMethods um = new UtilityMethods();
		String emailId= uc.readingDataFromExcel("./TestData/InputData.xlsx","LoginInputData", 1, 1);
		String password= uc.readingDataFromExcel("./TestData/InputData.xlsx","LoginInputData", 1, 2);
		
		lbp.getEmailTextbox().sendKeys(emailId);
		String foundEmailValue = um.getAttributeValue(lbp.getEmailTextbox(), "value");
		sa.assertEquals(emailId, foundEmailValue);
		
		lbp.getPasswordTextbox().sendKeys(password);
		String foundPasswordValue = um.getAttributeValue(lbp.getPasswordTextbox(),"value");
		sa.assertEquals(password, foundPasswordValue);
		
		
		lbp.getLoginButton().click();
		BasePage bp = new BasePage(driver);
		boolean isLogOutLinkDisplayed = bp.getLogoutLink().isDisplayed();
		sa.assertEquals(isLogOutLinkDisplayed, true);
		sa.assertAll();
	}

}

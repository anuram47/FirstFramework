package testng.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class RegBaseClass extends TestNGBaseClass_DWS{

	SoftAssert sa = new SoftAssert();
	public void whenIClickOnRFegiterLink() {
		driver.findElement(By.linkText("Register")).click();
		WebElement regiterPage = driver.findElement(By.xpath("//div[@class=\"page registration-page\"]"));
		boolean isRegisterLinkDisplayed = regiterPage.isDisplayed();
		sa.assertEquals(isRegisterLinkDisplayed, true);
		sa.assertAll();
		Reporter.log("User is able to see register link.",true);
	}

	public void selectGender() {
		WebElement genderBtn = driver.findElement(By.id("gender-female"));
		genderBtn.click();
		boolean isGenderRadioBtnSelected = genderBtn.isSelected();
		sa.assertEquals(isGenderRadioBtnSelected, true);
		sa.assertAll();
		Reporter.log("Gender is selected.",true);

	}

	public void whenIEnterFirstName(){
		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys(actuaFirstName);
		String actualFN = firstName.getAttribute("value");
		sa.assertEquals(actuaFirstName, actualFN);
		sa.assertAll();
		Reporter.log("Entered first name.",true);
	}

	public void whenIEnterLastName() {
		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.sendKeys(actualLastName);

		String actualLN = lastName.getAttribute("value");
		sa.assertEquals(actualLastName, actualLN);
		sa.assertAll();
		Reporter.log("Entered last name.",true);
	}

	public void whenIEnterEmail() {
		WebElement emailTextBox = driver.findElement(By.id("Email"));
		emailTextBox.sendKeys(emailId);

		String actualEmail = emailTextBox.getAttribute("value");
		sa.assertEquals(emailId, actualEmail);
		sa.assertAll();
		Reporter.log("Entered email id.",true);
	}

	public void whenIEnterPassword() {
		WebElement passwordTextbox = driver.findElement(By.id("Password"));
		passwordTextbox.sendKeys(password);

		String actualPwd = passwordTextbox.getAttribute("value");
		sa.assertEquals(password, actualPwd);
		sa.assertAll();
		Reporter.log("Entered password.",true);
		
	}
	public void whenIEnterConfirmPassword() {
		WebElement confPasswordTextbox = driver.findElement(By.id("ConfirmPassword"));
		confPasswordTextbox.sendKeys(password);

		String actualConfPwd = confPasswordTextbox.getAttribute("value");
		sa.assertEquals(password, actualConfPwd);
		sa.assertAll();
		Reporter.log("Entered confirm password.",true);
	}

	public void whenIClickOnRegisterBtn(){
		WebElement regiterBtn = driver.findElement(By.id("register-button"));
		regiterBtn.click();
		try {
			WebElement successMes = driver.findElement(By.xpath("//div[@class=\"result\"]"));
			boolean isSuccessMesDisplayed = successMes.isDisplayed();
			sa.assertEquals(isSuccessMesDisplayed, true);
			sa.assertAll();
			Reporter.log("User creation is done successfully.", true);
		}catch (Exception e) {
			Reporter.log("User creation is failed - The specified email already exists.", true);
		}
	}

}

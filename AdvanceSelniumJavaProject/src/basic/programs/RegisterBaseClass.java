package basic.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class RegisterBaseClass extends BaseClass{


	public void whenIClickOnRFegiterLink() {
		driver.findElement(By.linkText("Register")).click();
		WebElement regiterPage = driver.findElement(By.xpath("//div[@class=\"page registration-page\"]"));
		if(regiterPage.isDisplayed()) {
			Reporter.log("Register form is available for user.",true);
		}else {
			Reporter.log("Register form is not available for user.",true);
		}
	}

	public void selectGender() {
		WebElement genderBtn = driver.findElement(By.id("gender-female"));
		genderBtn.click();
		if(genderBtn.isSelected()) {
			Reporter.log("Gender is selected.",true);
		}else {
			Reporter.log("Gender is not selected.",true);
		}
	}

	public void whenIEnterFirstName(){
		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys(actuaFirstName);

		String actualFN = firstName.getAttribute("value");
		if(actuaFirstName.equals(actualFN)) {

			Reporter.log("Entered first name.",true);
		} else {
			Reporter.log("Unable to enter first name.",true);
		}
	}

	public void whenIEnterLastName() {
		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.sendKeys(actualLastName);

		String actualLN = lastName.getAttribute("value");
		if(actualLastName.equals(actualLN)) {

			Reporter.log("Entered last name.",true);
		} else {
			Reporter.log("Unable to enter last name.",true);
		}
	}

	public void whenIEnterEmail() {
		WebElement emailTextBox = driver.findElement(By.id("Email"));
		emailTextBox.sendKeys(emailId);

		String actualEmail = emailTextBox.getAttribute("value");
		if(actualEmail.equals(emailId)) {

			Reporter.log("Entered email id.",true);
		} else {
			Reporter.log("Unable to enter email id.",true);
		}
	}

	public void whenIEnterPassword() {
		WebElement passwordTextbox = driver.findElement(By.id("Password"));
		passwordTextbox.sendKeys(password);

		String actualPwd = passwordTextbox.getAttribute("value");
		if(actualPwd.equals(password)) {
			Reporter.log("Entered password.",true);
		} else {
			Reporter.log("Unable to enter password.",true);
		}
	}
	public void whenIEnterConfirmPassword() {
		WebElement confPasswordTextbox = driver.findElement(By.id("ConfirmPassword"));
		confPasswordTextbox.sendKeys(password);

		String actualConfPwd = confPasswordTextbox.getAttribute("value");
		if(actualConfPwd.equals(password)) {
			Reporter.log("Entered confirm password.",true);
		} else {
			Reporter.log("Unable to enter confirm password.",true);
		}
	}

	public void whenIClickOnRegisterBtn(){
		WebElement regiterBtn = driver.findElement(By.id("register-button"));
		regiterBtn.click();
		try {
			WebElement successMes = driver.findElement(By.xpath("//div[@class=\"result\"]"));
			if(successMes.isDisplayed()) {
				Reporter.log("User creation is done successfully.", true);
			}			
		}catch (Exception e) {
			Reporter.log("User creation is failed - The specified email already exists.", true);
		}
	}

}

package pom.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(id = "gender-male")
	private WebElement maleGenderRadioButton;
	
	@FindBy(id="gender-female")
	private WebElement femaleGenderRadioButton;
	
	@FindBy(id="FirstName")
	private WebElement fisrtNameTextBox;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextBox;
	
	@FindBy(id="Email")
	private WebElement emailIdTextBox;
	
	@FindBy(id="Password")
	private WebElement passwordTextBox;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(id="register-button")
	private WebElement registerButton;

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getMaleGenderRadioButton() {
		return maleGenderRadioButton;
	}

	public WebElement getFemaleGenderRadioButton() {
		return femaleGenderRadioButton;
	}

	public WebElement getFisrtNameTextBox() {
		return fisrtNameTextBox;
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getEmailIdTextBox() {
		return emailIdTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getConfirmPasswordTextBox() {
		return confirmPasswordTextBox;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
}

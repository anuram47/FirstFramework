package testng.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBasePage {
	public LoginBasePage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton ;
	
	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}
}

package testng.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
}

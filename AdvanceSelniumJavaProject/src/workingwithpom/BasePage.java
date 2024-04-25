package workingwithpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebElement getSearchTextbox() {
		return searchTextbox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="small-searchterms")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement searchButton;
	
	

}

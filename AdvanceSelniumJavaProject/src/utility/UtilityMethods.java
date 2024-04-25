package utility;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	WebDriver driver;

	/**
	 * If you want to call getTtile for verification
	 * @return the title of the current web site 
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 *  If you want to call getCurrent url for verification
	 * @return the current url of the web site
	 */

	public String getcurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * If you want to select a value by index
	 * @param selectElement by index
	 * @param index 
	 */

	public void selectByIndex(WebElement selectElement, int index) {
		Select sel = new Select(selectElement);
		sel.selectByIndex(index);

	}
	/**
	 * If you want to select a value by value
	 * @param selectElement
	 * @param value
	 */
	public void selectByValue(WebElement selectElement, String value) {
		Select sel = new Select(selectElement);
		sel.selectByValue(value);

	}

	/**
	 * If you want to select a value by visible text
	 * @param selectElement
	 * @param visibleText
	 */
	public void selectByVisibleText(WebElement selectElement, String visibleText) {
		Select sel = new Select(selectElement);
		sel.selectByVisibleText(visibleText);
	}


	/**
	 * If you want to deselect a value by index
	 * @param sdeelectElement by index
	 * @param index 
	 */

	public void deselectByIndex(WebElement deselectElement, int index) {
		Select sel = new Select(deselectElement);
		sel.deselectByIndex(index);

	}
	/**
	 * If you want to deselect a value by value
	 * @param deselectElement
	 * @param value
	 */
	public void deselectByValue(WebElement deselectElement, String value) {
		Select sel = new Select(deselectElement);
		sel.deselectByValue(value);

	}

	/**
	 * If you want to deselect a value by visible text
	 * @param deselectElement
	 * @param visibleText
	 */
	public void deselectByVisibleText(WebElement deselectElement, String visibleText) {
		Select sel = new Select(deselectElement);
		sel.deselectByVisibleText(visibleText);
	}
	/**
	 * If you want to get text of the webelement for verification
	 * @param webelement
	 * @return
	 */

	public String getText(WebElement webelement) {
		String text = webelement.getText();
		return text;
	}

	/**
	 * If you wan to get the attribute value for verification
	 * @param webelement
	 * @param value
	 * @return
	 */
	public String getAttributeValue(WebElement webelement, String value) {
		String attributeValue = webelement.getAttribute(value);
		return attributeValue;
	}

	/**
	 * If you want to drag and drop a webelement 
	 * @param drag
	 * @param drop
	 */
	public void dragAndDrop(WebElement drag, WebElement drop) {
		Actions act = new Actions(driver);
		act.clickAndHold(drag).release(drop).build().perform();
	}

	/**
	 * If you want to move to particular webelement to perform some mouse action
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * If you want to select value from autosuggestion 
	 * @param autoSuggestionItems
	 * @param itemToBeSelect
	 * @throws InterruptedException
	 */
	public void selectFromAutoSuggestion(List<WebElement> autoSuggestionItems, String itemToBeSelect) throws InterruptedException {
		for (WebElement list : autoSuggestionItems) {
			Thread.sleep(3000);
			String text = list.getText();
			if(text.contains(itemToBeSelect)) {
				list.click();
			}
		}
	}

	/**
	 * If you want to wait until the expected tilte to display
	 */
	public void explicitWaitMethodForTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(getTitle()));		
	}
	/**
	 * If you want to wait until the webelement to be clickable
	 * @param element
	 */
	public void explicitWaitMethodForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * If you want to wait until element to be selected
	 * @param element
	 */
	public void explicitWaitMethodForElementToBeSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String takeSreenShot(WebDriver driver) {
		String path = "./ScreenShots"+UtilityMethods.getCurrentTime()+".png";
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileHandler.copy(src, dest);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "."+path;
	}
	/**
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		LocalDateTime localDateTimeObj =  LocalDateTime.now();
		String name = localDateTimeObj.toString().replace(":", "-");
		return name;
		
		
	}

}

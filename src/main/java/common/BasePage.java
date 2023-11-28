package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriverWait explicitWait;
	public Actions action;
	public long timeout = GlobalContants.explicit_timeout;

	// constructor

	// getter
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public By getByXpath(String locator, String... params) {
		return By.xpath(String.format(locator, (Object[])params));
	}
	
	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));

	}

	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// Chuoi String co dinh, tinh~
	public By getByXpath(String locater) {
		return By.xpath(locater);
	}

	// Chuoi String khong co dinh, dong
	public WebElement getElement(WebDriver driver, String locater) {
		return driver.findElement(getByXpath(locater));
	}

	public void sendKeysToElement(WebDriver driver, String locater, String valueInput) {
		getElement(driver, locater).clear();
		getElement(driver, locater).sendKeys(valueInput);
	}

	public void clickToElement(WebDriver driver, String locater) {
		getElement(driver, locater).click();

	}

	public void clickAndSenkeyToElement(WebDriver driver, String locater, String valueInput) {
		getElement(driver, locater).click();
		getElement(driver, locater).sendKeys(valueInput);
	}

	public String getTextElement(WebDriver driver, String locater) {
		return getElement(driver, locater).getText();
	}

	public String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getValue(WebDriver driver, String locator) {
		WebElement webElement = getElement(driver, locator);
		String value = webElement.getAttribute("value");
		return value;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator, params)));
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
}

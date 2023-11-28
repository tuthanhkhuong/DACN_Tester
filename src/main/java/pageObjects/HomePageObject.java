package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	// constructor
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLogout() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_BUTTON);
		clickToElement(driver, HomePageUI.LOGOUT_BUTTON);
	}
	
	public void clickToLogin() {
		waitForElementVisible(driver, HomePageUI.LOGIN_BUTTON);
		clickToElement(driver, HomePageUI.LOGIN_BUTTON);
	}
}

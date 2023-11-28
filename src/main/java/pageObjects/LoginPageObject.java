package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextBox(String email) {
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isEmailErrorMessage(String value) {
		String message = getTextElement(driver, LoginPageUI.EMAIL_ERORR_MESSAGE);
		return message.equals(value);
	}

	public boolean isLoginErrorMessage(String value) {
		String message = getTextElement(driver, LoginPageUI.LOGIN_ERORR_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterdEmailErrorMessage(String value) {
		String message = getTextElement(driver, LoginPageUI.REGISTERED_EMAIL_ERROR_MESSAGE);
		return message.contains(value);
	}

	public void switchToWindowByID(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// ------------Nhap thong tin------------
	public void inputToRegisterEmailTextBox(String email) {
		sendKeysToElement(driver, RegisterPageUI.REGISTER_EMAIL_TEXTBOX, email);
	}

	public void inputToRegisterPasswordTextBox(String password) {
		sendKeysToElement(driver, RegisterPageUI.REGISTER_PASSWORD_TEXTBOX, password);
	}

	public void inputToRegisterConfirmPasswordTextBox(String password) {
		sendKeysToElement(driver, RegisterPageUI.REGISTER_CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToMaleRaido() {
		clickToElement(driver, RegisterPageUI.REGISTER_MALE_RADIO_BUTTON);
	}

	public void inputToRegisterFirstnameTextBox(String value) {
		sendKeysToElement(driver, RegisterPageUI.REGISTER_FIRST_NAME_TEXTBOX, value);
	}

	public void inputToRegisterLastnameTextBox(String value) {
		sendKeysToElement(driver, RegisterPageUI.REGISTER_LAST_NAME_TEXTBOX, value);
	}

	public void clickToRegisterDayOfBirth(String value) {
		clickAndSenkeyToElement(driver, RegisterPageUI.REGISTER_DAYOFBIRTH_DROPLIST, value);
	}

	public void clickToRegisterMonthOfBirth(String value) {
		clickAndSenkeyToElement(driver, RegisterPageUI.REGISTER_MONTHOFBIRTH_DROPLIST, value);
	}

	public void clickToRegisterYearOfBirth(String value) {
		clickAndSenkeyToElement(driver, RegisterPageUI.REGISTER_YEAROFBIRTH_DROPLIST, value);
	}

	public void inputToRegisterCompanyTextBox(String value) {
		sendKeysToElement(driver, RegisterPageUI.REGISTER_COMPANYNAME_TEXTBOX, value);
	}

	// ------------Click button------------
	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public void clickToRegisterSpan() {
		clickToElement(driver, RegisterPageUI.REGISTER_SPAN);
	}
	// ------------Verify Message------------

	public boolean isRegisterEmailTextBoxWithEmptyData(String value) {
		String message = getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterFirstNameTextBoxWithEmptyData(String value) {
		String message = getTextElement(driver, RegisterPageUI.REGISTER_FIRSTNAME_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterLastNameTextBoxWithEmptyData(String value) {
		String message = getTextElement(driver, RegisterPageUI.REGISTER_LASTNAME_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterEmailTextBoxWithIvalidData(String value) {
		String message = getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterEmailTextBoxWithExistsEmail(String value) {
		String message = getTextElement(driver, RegisterPageUI.EXISTS_EMAIL_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterPassTextBoxWithLess6Key(String value) {
		String message = getTextElement(driver, RegisterPageUI.REGISTER_PASSWORD_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterPassTextBoxWithUncorrectComfirm(String value) {
		String message = getTextElement(driver, RegisterPageUI.REGISTER_CONFIRM_PASSWORD_MESSAGE);
		return message.contains(value);
	}

	public boolean isRegisterSuccess(String value) {
		String message = getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return message.contains(value);
	}

}

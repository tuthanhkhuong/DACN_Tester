package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.RegisterPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// ------------Nhap thong tin------------

	// My Account Page
	public void ChangeEmailTextBox(String email) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_EMAIL_TEXTBOX, email);
	}

	public void changeMaleRaido() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_MALE_RADIO_BUTTON);
	}

	public void changeFeMaleRaido() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_FEMALE_RADIO_BUTTON);
	}

	public void changeFirstnameTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_FIRST_NAME_TEXTBOX, value);
	}

	public void changeLastnameTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_LAST_NAME_TEXTBOX, value);
	}

	public void changeDayOfBirth(String value) {
		clickAndSenkeyToElement(driver, MyAccountPageUI.MYACCOUNT_DAYOFBIRTH_DROPLIST, value);
	}

	public void changeMonthOfBirth(String value) {
		clickAndSenkeyToElement(driver, MyAccountPageUI.MYACCOUNT_MONTHOFBIRTH_DROPLIST, value);
	}

	public void changeYearOfBirth(String value) {
		clickAndSenkeyToElement(driver, MyAccountPageUI.MYACCOUNT_YEAROFBIRTH_DROPLIST, value);
	}

	public void changeCompanyTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_COMPANYNAME_TEXTBOX, value);
	}

	public void changeNewSelecter(String value) {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_NEWSELECTER_CHECKBOX);
	}

	// Login Page
	public void inputEmailTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, value);
	}

	public void inputPasswordTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.PASSWORD_TEXTBOX, value);
	}

	// Addresses Page
	public void addFirstNameTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_FIRSTNAME_TEXTBOX, value);
	}

	public void addLastNameTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_LASTNAME_TEXTBOX, value);
	}

	public void addEmailTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_EMAIL_TEXTBOX, value);
	}

	public void addCountryTextBox(String value) {
		clickAndSenkeyToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_COUNTRY_DROPLIST, value);
	}

	public void addStateTextBox(String value) {
		clickAndSenkeyToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_STATE_DROPLIST, value);
	}

	public void addCityTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_CITY_TEXTBOX, value);
	}

	public void addAddress1TextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_ADDRESS1_TEXTBOX, value);
	}

	public void addZipCodeTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_ZIPCODE_TEXTBOX, value);
	}

	public void addPhoneNumberTextBox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_PHONENUMBER_TEXTBOX, value);
	}

	public boolean isNewUpdateInfo(String locator, String value) {
		String message = getValue(driver, locator);
		return message.contains(value);
	}

	public boolean isNewUpdateAdrressInfo(String locator, String value) {
		String message = getTextElement(driver, locator);
		return message.contains(value);
	}

	// Change Password

	public void clickToChangePasswordLable() {
		clickToElement(driver, MyAccountPageUI.CHANGEPASSWORD_LABLE);
	}

	public void inputToOldPassWordTextbox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.CHANGEPASSWORD_ADDOLD_TEXTBOX, value);
	}

	public void inputToNewPassWordTextbox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.CHANGEPASSWORD_CREATENEWPASS_TEXTBOX, value);
	}

	public void inputToConfirmNewPasswordTextbox(String value) {
		sendKeysToElement(driver, MyAccountPageUI.CHANGEPASSWORD_CONFIRMPASS_TEXTBOX, value);
	}

	public void clickToChangePasswordButton() {
		clickToElement(driver, MyAccountPageUI.CHANGEPASSWORD_BUTTON);
	}

	public boolean isPasswordChange(String value) {
		String message = getTextElement(driver, MyAccountPageUI.PASSOWRD_CHANGED_ERROR);
		return message.contains(value);
	}

	public void clickToLogOutLable() {
		clickToElement(driver, MyAccountPageUI.LOGOUT_LABLE);
	}

	public void clickToLogInLable() {
		clickToElement(driver, MyAccountPageUI.LOGIN_LABLE);
	}

	public void clickToCloseSpanButton() {
		clickToElement(driver, MyAccountPageUI.SPAN_CLOSE_BUTTON);
	}

	// ------------Click button------------
	public void clickToSaveAccountButton() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_SAVE_BUTTON);
	}

	public void clickToSaveAddressesButton() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_SAVE_BUTTON);
	}

	public void clickToLoginButton() {
		clickToElement(driver, MyAccountPageUI.LOGIN_BUTTON);
	}

	public void clickToAddNewButton() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_ADDNEW_BUTTON);
	}

	public void clickToAddressesLabel() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_ADDRESSES_LABEL);
	}
	
	public void clickToMyAccountLabel() {
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_LINK);
	}

	public boolean isLoged(String value) {
		String message = getTextElement(driver, MyAccountPageUI.MYACCOUNT_LINK);
		return message.contains(value);
	}
	
	public boolean isSaveSuccessAccountMessage(String value) {
		String message = getTextElement(driver, MyAccountPageUI.MYACCOUNT_SUCCESS_MESSAGE);
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

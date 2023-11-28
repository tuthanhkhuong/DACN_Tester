package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// ------------Nhap thong tin------------
	public void inputToSearchTextBox(String value) {
		sendKeysToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public void clickToAdvancedSearch() {
		clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void clickToCategoryDropList(String value) {
		clickAndSenkeyToElement(driver, SearchPageUI.CATEGORY_DROPLIST, value);
	}

	public void clickToAutomaticallyCheckBox() {
		clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
	}

	// ----------- VERIFY MESSAGE -----------
	public boolean isSearchWithEmptyDataMessage(String value) {
		String message = getTextElement(driver, SearchPageUI.EMPTY_DATA_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isSearchWithInValidDataMessage(String value) {
		String message = getTextElement(driver, SearchPageUI.NO_VALIDDATA_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isVerifyProductHaveKey(String value) {
		List<WebElement> webElements = findElements(driver, SearchPageUI.SEARCH_PRODUCT_TITLE);
		boolean verify = true;
		for (WebElement w : webElements) {
			if (w.getText().contains(value)) {
				return verify = true;
			} else {
				return verify = false;
			}
		}
		return verify;
	}

}

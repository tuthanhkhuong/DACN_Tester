package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.SearchPageUI;
import pageUIs.WishListPageUI;

public class WishListPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchTextBox(String value) {
		sendKeysToElement(driver, WishListPageUI.WISHLIST_SEARCH_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		clickToElement(driver, WishListPageUI.WISHLIST_SEARCH_BUTTON);
	}

	public void clickToProduct() {
		clickToElement(driver, WishListPageUI.WISHLIST_SEARCH_LENOVO_TEXT);
	}
	
	public void clickToProductComuter() {
		clickToElement(driver, WishListPageUI.WISHLIST_SEARCH_COMPUTER_TEXT);
	}

	public void clickToAddToWishList() {
		clickToElement(driver, WishListPageUI.WISHLIST_ADDTO_BUTTON);
	}

	public void clickToWishListLabel() {
		clickToElement(driver, WishListPageUI.WISTHLIST_LABEL);
	}

	public void clickToCloseSpanMessage() {
		clickToElement(driver, WishListPageUI.WISTHLIST_CLOSE_SPAN_MESSAGE);
	}

	public void clickToAddToCartButton() {
		clickToElement(driver, WishListPageUI.WISTHLIST_ADDTO_CART_BUTTON);
	}

	public void clickToAddToWishListButton() {
		clickToElement(driver, WishListPageUI.WISTHLIST_COMPUTER_ADDTO_WISHLIST_BUTTON);
	}
	
	public void clickToHDD320GBRadioButton() {
		clickToElement(driver, WishListPageUI.WISTHLIST_COMPUTER_RADIO_320GB_BUTTON);
	}

	public void clickToAddToCartCheckBox() {
		clickToElement(driver, WishListPageUI.WISTHLIST_ADDTO_CART_CHECKBOX);
	}

	// ----------- VERIFY MESSAGE -----------
	public boolean isProductAddToWishListSuccess(String value) {
		String message = getTextElement(driver, WishListPageUI.WISTHLIST_PRODUCTNAME_TEXT);
		return message.contains(value);
	}

	public boolean isAddToWishListMessage(String value) {
		String message = getTextElement(driver, WishListPageUI.WISTHLIST_NOTIFICATION_MESSAGE);
		return message.contains(value);
	}

	public boolean isNoDataInWishListMessage(String value) {
		String message = getTextElement(driver, WishListPageUI.WISTHLIST_NODATA_TEXT);
		return message.contains(value);
	}

	public boolean isAddToCartMessage(String value) {
		String message = getTextElement(driver, WishListPageUI.WISTHLIST_ADDTO_CART_MESSAGE);
		return message.contains(value);
	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;
import pageUIs.SearchPageUI;
import pageUIs.ShoppingCartPageUI;
import pageUIs.WishListPageUI;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToShoppingCartLabel() {
		clickToElement(driver, ShoppingCartPageUI.SHOPPING_CART_LABEL);
	}

	public void clickToQuantityShoppingCartTextBox(String value) {
		sendKeysToElement(driver, ShoppingCartPageUI.SHOPPING_CART_QUANTITY_TEXTBOX, value);
	}

	public void clickToUpdateShoppingCartButton() {
		clickToElement(driver, ShoppingCartPageUI.SHOPPING_CART_UPDATE_BUTTON);
	}

	public void clickToRemoveProductShoppingCart() {
		clickToElement(driver, ShoppingCartPageUI.SHOPPING_CART_REMOVE_BUTTON);
	}

	// ----------- VERIFY MESSAGE -----------

	public boolean isUpdatedQuantityShoppingCart(String value) {
		String message = getTextElement(driver, ShoppingCartPageUI.SHOPPING_CART_QUANTITY_TEXTBOX);
		return message.contains(value);
	}

	public boolean isEmptyShoppingCart(String value) {
		String message = getTextElement(driver, ShoppingCartPageUI.SHOPPINGCART_EMPTY_MESSAGE);
		return message.contains(value);
	}
}

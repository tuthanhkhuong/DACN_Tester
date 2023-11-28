package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.LoginPageObject;
import pageObjects.SearchPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;

public class TS_06_ShoppingCart extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	WishListPageObject wishLishPage;
	ShoppingCartPageObject shoppingCartPage;

	public String email = "test@gmail.com";
	public String password = "7290612";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");

		loginPage = new LoginPageObject(driver);
		searchPage = new SearchPageObject(driver);
		wishLishPage = new WishListPageObject(driver);
		shoppingCartPage = new ShoppingCartPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_00_Login() {
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
	}

	
	//Cập nhật số lượng sản phẩm trong giỏ hàng
	@Test
	public void TC_01_UpdateShoppingCart() {
		shoppingCartPage.clickToShoppingCartLabel();
		shoppingCartPage.clickToQuantityShoppingCartTextBox("5");
		sleepInSecond(3000);
		
		shoppingCartPage.clickToUpdateShoppingCartButton();

		sleepInSecond(3000);
		shoppingCartPage.isUpdatedQuantityShoppingCart("5");
	}

	
	//Xóa sản phẩm khỏi giỏ hàng
	@Test
	public void TC_02_RemoveProductFormShoppingCart() {
		shoppingCartPage.clickToShoppingCartLabel();
		
		sleepInSecond(3000);
		shoppingCartPage.clickToRemoveProductShoppingCart();

		sleepInSecond(3000);
		Assert.assertTrue(shoppingCartPage.isEmptyShoppingCart("Your Shopping Cart is empty!"));
	}
}

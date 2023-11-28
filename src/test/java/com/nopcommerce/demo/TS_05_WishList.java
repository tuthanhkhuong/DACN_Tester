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
import pageObjects.WishListPageObject;

public class TS_05_WishList extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	WishListPageObject wishLishPage;

	public String email = "test@gmail.com";
	public String password = "7290612";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");

		loginPage = new LoginPageObject(driver);
		searchPage = new SearchPageObject(driver);
		wishLishPage = new WishListPageObject(driver);
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

	
	//Add sản phẩm vào trong wishlist
	@Test
	public void TC_01_AddProductToWishList() {
		wishLishPage.inputToSearchTextBox("lenovo");
		wishLishPage.clickToSearchButton();
		
		sleepInSecond(3000);
		wishLishPage.clickToProduct();

		sleepInSecond(3000);
		wishLishPage.clickToAddToWishList();
		
		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isAddToWishListMessage("The product has been added to your wishlist"));

		wishLishPage.clickToCloseSpanMessage();
		sleepInSecond(3000);

		driver.get("https://demo.nopcommerce.com/");
		wishLishPage.clickToWishListLabel();

		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isProductAddToWishListSuccess("Lenovo IdeaCentre 600 All-in-One PC"));
	}

	
	//Add sản phẩm từ wishlist vào giỏ hàng
	@Test
	public void TC_02_AddProductFromWishListToShoppingCart() {
		wishLishPage.clickToWishListLabel();
		wishLishPage.clickToAddToCartCheckBox();

		sleepInSecond(3000);
		wishLishPage.clickToAddToCartButton();
		
		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isProductAddToWishListSuccess("Lenovo IdeaCentre 600 All-in-One PC"));

		sleepInSecond(3000);
		wishLishPage.clickToWishListLabel();
		
		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isNoDataInWishListMessage("The wishlist is empty!"));
	}

}

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

public class TS_04_Search extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	SearchPageObject searchPage;

	public String email = "test@gmail.com";
	public String password = "7290612";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");

		loginPage = new LoginPageObject(driver);
		searchPage = new SearchPageObject(driver);

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
	
	
	//Tìm kiếm thông tin sai độ dài
	@Test
	public void TC_01_SearchWithEmptyData() {
		searchPage.openUrl(driver, "https://demo.nopcommerce.com/search");
		searchPage.refeshCurrentPage(driver);

		searchPage.inputToSearchTextBox("");
		searchPage.clickToSearchButton();

		sleepInSecond(3000);
		Assert.assertTrue(searchPage.isSearchWithEmptyDataMessage("Search term minimum length is 3 characters"));
	}

	
	//Tìm kiếm thông tin không có trong hệ thống
	@Test
	public void TC_02_SearchWithNoValidData() {
		searchPage.refeshCurrentPage(driver);

		searchPage.inputToSearchTextBox("Macbook Pro 2040");
		
		sleepInSecond(3000);
		searchPage.clickToSearchButton();

		sleepInSecond(3000);
		Assert.assertTrue(
				searchPage.isSearchWithInValidDataMessage("No products were found that matched your criteria"));
	}

	
	//Tìm thông tin có trên hệ thống
	@Test
	public void TC_03_SearchWithData() {
		searchPage.refeshCurrentPage(driver);

		searchPage.inputToSearchTextBox("Lenovo");
		sleepInSecond(3000);
		
		searchPage.clickToSearchButton();

		sleepInSecond(3000);
		Assert.assertTrue(searchPage.isVerifyProductHaveKey("Lenovo"));
	}

	
	//Tìm kiếm + filter thông tin không có trong hệ thống
	@Test
	public void TC_04_SearchWithAdvanceSearchWithParentCategories() {
		searchPage.refeshCurrentPage(driver);

		searchPage.inputToSearchTextBox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearch();
		searchPage.clickToCategoryDropList("Computers");
		sleepInSecond(5000);
		
		searchPage.clickToSearchButton();

		sleepInSecond(5000);
		Assert.assertTrue(
				searchPage.isSearchWithInValidDataMessage("No products were found that matched your criteria"));
	}

	
	//Tìm kiếm + filter thông tin có trong hệ thống
	@Test
	public void TC_05_SearchWithAdvanceSearchWithSubCategories() {
		searchPage.openUrl(driver, "https://demo.nopcommerce.com/search");
		searchPage.refeshCurrentPage(driver);

		searchPage.inputToSearchTextBox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearch();
		searchPage.clickToCategoryDropList("Computers");
		searchPage.clickToAutomaticallyCheckBox();
		sleepInSecond(5000);
		
		searchPage.clickToSearchButton();

		sleepInSecond(5000);
		Assert.assertFalse(searchPage.isVerifyProductHaveKey("Apple Macbook Pro"));
	}

}

package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.LoginPageObject;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;

	public String email = "test@gmail.com";
	public String emailwrong = "ftest@gmail.com";
	public String password = "abc123";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");

		loginPage = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	//Đăng nhập với email trống
	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPage.clickToLoginButton();
		
		
		sleepInSecond(3000);

		Assert.assertTrue(loginPage.isEmailErrorMessage("Please enter your email"));
	}

	//Đăng nhập với email sai định dạng
	@Test
	public void TC_02_LoginWithInvalidData() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextBox("abcd");
		
		sleepInSecond(3000);
		loginPage.clickToLoginButton();
		
		sleepInSecond(3000);
		Assert.assertTrue(loginPage.isEmailErrorMessage("Wrong email"));
	}

	
	//Đăng nhập với email chưa đăng ký
	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextBox(emailwrong);
		
		sleepInSecond(3000);
		loginPage.clickToLoginButton();

		sleepInSecond(3000);
		Assert.assertTrue(
				loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again"));
		Assert.assertTrue(loginPage.isLoginErrorMessage("No customer account found"));
	}

	//Đăng nhập với mật khẩu trống
	@Test
	public void TC_04_LoginWithRegisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox("");
		
		sleepInSecond(3000);
		loginPage.clickToLoginButton();

		sleepInSecond(3000);
		Assert.assertTrue(loginPage
				.isRegisterdEmailErrorMessage("Login was unsuccessful. Please correct the errors and try again"));
		Assert.assertTrue(loginPage.isRegisterdEmailErrorMessage("The credentials provided are incorrect"));
	}

	//Đăng nhập với mật khẩu sai
	@Test
	public void TC_05_LoginWithRegisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox("abcdef123555");
		sleepInSecond(3000);

		loginPage.clickToLoginButton();

		sleepInSecond(3000);
		Assert.assertTrue(loginPage
				.isRegisterdEmailErrorMessage("Login was unsuccessful. Please correct the errors and try again"));
		Assert.assertTrue(loginPage.isRegisterdEmailErrorMessage("The credentials provided are incorrect"));
	}

	
	//Để thành công đầu tiên
	
	//Đăng nhập thành công
	@Test
	public void TC_06_LoginWithRegisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(password);
		
		sleepInSecond(3000);

		loginPage.clickToLoginButton();

		String parentID = loginPage.getWindowHandle(driver);
		loginPage.switchToWindowByID(parentID);

		sleepInSecond(3000);
		Assert.assertEquals(loginPage.getPageTitle(driver), "nopCommerce demo store");
		driver.switchTo().window(parentID);
	}
}

package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.RegisterPageObject;

public class TS_01_Register extends BaseTest {
	
	WebDriver driver;
	RegisterPageObject registerPage;

	public String email = "finaltest@gmail.com";
	public String password = "Abcd1234";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register?returnUrl=%2F");

		/*
		 * System.setProperty("webdriver.chrome.driver", projectPath +
		 * "/browserDrivers/chromedriver.exe"); driver = new ChromeDriver(); //Can chinh
		 * khung cua so driver.manage().window().maximize();
		 * driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		 */

		registerPage = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	//Đăng ký với thông tin để trống
	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
		
		sleepInSecond(3000);

		//Kết quả mong muốn
		Assert.assertTrue(registerPage.isRegisterFirstNameTextBoxWithEmptyData("First name is required."));
		Assert.assertTrue(registerPage.isRegisterLastNameTextBoxWithEmptyData("Last name is required."));
		Assert.assertTrue(registerPage.isRegisterEmailTextBoxWithEmptyData("Email is required."));
		Assert.assertTrue(registerPage.isRegisterPassTextBoxWithLess6Key("Password is required."));
		Assert.assertTrue(registerPage.isRegisterPassTextBoxWithUncorrectComfirm("Password is required."));
	}

	//Đăng ký với email sai định dạng
	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.inputToRegisterEmailTextBox("abcd");
		
		sleepInSecond(3000);
		registerPage.clickToRegisterButton();
		
		sleepInSecond(3000);

		Assert.assertTrue(registerPage.isRegisterEmailTextBoxWithIvalidData("Wrong email"));
	}

	//Đăng ký tài khoản thành công (Thay doi gia tri Email moi lan dang ky)
	@Test
	public void TC_03_RegisterSuccess() {
		registerPage.refeshCurrentPage(driver);

		registerPage.clickToMaleRaido();
		registerPage.inputToRegisterFirstnameTextBox("AAA");
		registerPage.inputToRegisterLastnameTextBox("BBB");
		registerPage.clickToRegisterDayOfBirth("1");
		registerPage.clickToRegisterMonthOfBirth("May");
		registerPage.clickToRegisterYearOfBirth("3000");
		registerPage.inputToRegisterEmailTextBox(email);
		registerPage.inputToRegisterCompanyTextBox("none");
		registerPage.inputToRegisterPasswordTextBox(password);
		registerPage.inputToRegisterConfirmPasswordTextBox(password);

		sleepInSecond(3000);
		
		registerPage.clickToRegisterButton();
		
		sleepInSecond(3000);
		Assert.assertTrue(registerPage.isRegisterSuccess("Your registration completed"));
	}

	
	//Đăng ký tài khoản với email đã đăng ký
	@Test
	public void TC_04_RegisterWithExistsEmail() {
		registerPage.openUrl(driver, "https://demo.nopcommerce.com/register?returnUrl=%2F");
		registerPage.refeshCurrentPage(driver);

		registerPage.clickToMaleRaido();
		registerPage.inputToRegisterFirstnameTextBox("AAAA");
		registerPage.inputToRegisterLastnameTextBox("BBB");
		registerPage.clickToRegisterDayOfBirth("25");
		registerPage.clickToRegisterMonthOfBirth("May");
		registerPage.clickToRegisterYearOfBirth("2010");
		registerPage.inputToRegisterEmailTextBox(email);
		registerPage.inputToRegisterCompanyTextBox("none");
		registerPage.inputToRegisterPasswordTextBox(password);
		registerPage.inputToRegisterConfirmPasswordTextBox(password);
		
		sleepInSecond(3000);

		registerPage.clickToRegisterButton();
		sleepInSecond(3000);
		Assert.assertTrue(registerPage.isRegisterEmailTextBoxWithExistsEmail("The specified email already exists"));
	}

	
	//Đăng ký với mật khẩu sai độ dài
	@Test
	public void TC_05_RegisterWithPasswordLessThan6Keys() {
		registerPage.refeshCurrentPage(driver);
		registerPage.inputToRegisterPasswordTextBox("abc");
		
		sleepInSecond(3000);
		registerPage.clickToRegisterButton();

		sleepInSecond(3000);
		
		Assert.assertTrue(registerPage.isRegisterPassTextBoxWithLess6Key("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.isRegisterPassTextBoxWithLess6Key("must have at least 6 characters"));
	}

	//Đăng ký với xác nhận mật khẩu nhập không trùng
	@Test
	public void TC_06_RegisterWithPasswordLessThan6Keys() {
		registerPage.refeshCurrentPage(driver);
		registerPage.inputToRegisterPasswordTextBox(password);
		registerPage.inputToRegisterConfirmPasswordTextBox("abcd");
		
		sleepInSecond(3000);

		registerPage.clickToRegisterButton();
		
		sleepInSecond(3000);
		Assert.assertTrue(registerPage
				.isRegisterPassTextBoxWithUncorrectComfirm("The password and confirmation password do not match."));
	}
}

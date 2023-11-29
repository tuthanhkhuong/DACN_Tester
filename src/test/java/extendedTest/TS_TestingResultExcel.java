package extendedTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;
import utils.ExcelUtilLogin;
import utils.ExcelUtilResult;

public class TS_TestingResultExcel extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	WishListPageObject wishLishPage;
	ShoppingCartPageObject shoppingCartPage;
	MyAccountPageObject MyAccountPage;
	SearchPageObject searchPage;
	
	public String email = "nhuocquan@gmail.com";
	public String password = "Abcd123";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		wishLishPage = new WishListPageObject(driver);
		shoppingCartPage = new ShoppingCartPageObject(driver);
		homePage = new HomePageObject(driver);
		MyAccountPage = new MyAccountPageObject(driver);
		searchPage = new SearchPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	//-------------------------------Test case Pass---------------------------------
	@Test
	public void TC_01_DeleteCartExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
		
		// Đăng nhập thành công
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(password);
		
		//sleepInSecond(3000);

		loginPage.clickToLoginButton();

		String parentID = loginPage.getWindowHandle(driver);
		loginPage.switchToWindowByID(parentID);

		//sleepInSecond(3000);
		Assert.assertEquals(loginPage.getPageTitle(driver), "nopCommerce demo store");
		driver.switchTo().window(parentID);
		
		//Add sản phẩm vào trong wishlist
		wishLishPage.inputToSearchTextBox("lenovo");
		wishLishPage.clickToSearchButton();
		
		//sleepInSecond(3000);
		wishLishPage.clickToProduct();

		//sleepInSecond(3000);
		wishLishPage.clickToAddToWishList();
		
		//sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isAddToWishListMessage("The product has been added to your wishlist"));

		wishLishPage.clickToCloseSpanMessage();
		//sleepInSecond(3000);

		driver.get("https://demo.nopcommerce.com/");
		wishLishPage.clickToWishListLabel();

		//sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isProductAddToWishListSuccess("Lenovo IdeaCentre 600 All-in-One PC"));
		
		
		//Add sản phẩm từ wishlist vào giỏ hàng
		wishLishPage.clickToWishListLabel();
		wishLishPage.clickToAddToCartCheckBox();

		//sleepInSecond(3000);
		wishLishPage.clickToAddToCartButton();
		
		//sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isProductAddToWishListSuccess("Lenovo IdeaCentre 600 All-in-One PC"));

		//sleepInSecond(3000);
		wishLishPage.clickToWishListLabel();
		
		//sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isNoDataInWishListMessage("The wishlist is empty!"));
		
		//Xóa sản phẩm khỏi giỏ hàng
		shoppingCartPage.clickToShoppingCartLabel();
		
		//sleepInSecond(3000);
		shoppingCartPage.clickToRemoveProductShoppingCart();

		//sleepInSecond(3000);
		
		String messString = shoppingCartPage.getTextElement(driver,"//div[@class='no-data']" );
		if (messString.equals("Your Shopping Cart is empty!")) {
			ExcelUtilResult.setCellData("Passed", 1, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 1, 5);
		}
		
	}
	
	
	//-------------------------------Test case Fail---------------------------------
	@Test
	public void TC_02_LoginWithWrongPasswordExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
		
		homePage.clickToLogout();
		homePage.clickToLogin();
		
		// Đăng nhập
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox("0010239");
		loginPage.clickToLoginButton();
		
		sleepInSecond(3000);
		
		homePage = new HomePageObject(driver);
		String url = homePage.getCurrentPageUrl(driver);
		if (url.equals("https://demo.nopcommerce.com/")) {
			ExcelUtilResult.setCellData("Passed", 2, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 2, 5);
		}
		
	}
	
	@Test
	public void TC_03_UpdateProfileExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
		loginPage.refeshCurrentPage(driver);
		
		// Đăng nhập thành công
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		
//		sleepInSecond(3000);
		
		// Cập nhật Account
		MyAccountPage.clickToMyAccountLabel();
		MyAccountPage.changeFirstnameTextBox("Trung 123");
		MyAccountPage.clickToSaveAccountButton();
		
		sleepInSecond(3000);
		
		String messString = MyAccountPage.getTextElement(driver,"//p[@class='content']" );
		if (messString.equals("First name incorrect")) {
			ExcelUtilResult.setCellData("Passed", 3, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 3, 5);
		}
		
	}
	
	@Test
	public void TC_04_UpdateAddressExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
				
		// Cập nhật địa chỉ mới
		MyAccountPage.clickToAddressesLabel();
		MyAccountPage.clickToAddNewButton();
		
//		sleepInSecond(3000);
		
		MyAccountPage.addFirstNameTextBox("Thanh");
		MyAccountPage.addLastNameTextBox("Khuong");
		MyAccountPage.addEmailTextBox(email);
		MyAccountPage.addCountryTextBox("Viet Nam");
		MyAccountPage.addCityTextBox("Ho Chi Minh");
		MyAccountPage.addAddress1TextBox("3066/1 Le Thi Hoa");
		MyAccountPage.addZipCodeTextBox("71313");
		MyAccountPage.addPhoneNumberTextBox("0392543689");

		sleepInSecond(3000);
		
		MyAccountPage.clickToSaveAddressesButton();
		
//		sleepInSecond(3000);

		String messString = MyAccountPage.getTextElement(driver,"//p[@class='content']" );
		if (messString.equals("The new address has been added unsuccessfully")) {
			ExcelUtilResult.setCellData("Passed", 4, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 4, 5);
		}
	}
	
	@Test
	public void TC_05_SearchWithInvalidDataExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
		
		searchPage.openUrl(driver, "https://demo.nopcommerce.com/search");
		
		searchPage.inputToSearchTextBox("Lenovo@<>?");
		
//		sleepInSecond(3000);
		
		searchPage.clickToSearchButton();
		
//		sleepInSecond(3000);

		String messString = searchPage.getTextElement(driver,"//div[@class='no-result']" );
		if (messString.equals("Product names cannot contain special characters.")) {
			ExcelUtilResult.setCellData("Passed", 5, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 5, 5);
		}
	}

	@Test
	public void TC_06_AddProductToWishLishExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
		
		searchPage.openUrl(driver, "https://demo.nopcommerce.com/search");
		
		searchPage.inputToSearchTextBox("computer");
		searchPage.clickToSearchButton();
		
//		sleepInSecond(3000);
		
		wishLishPage.clickToProductComuter();
		wishLishPage.clickToHDD320GBRadioButton();
		wishLishPage.clickToAddToWishListButton();
		
//		sleepInSecond(3000);
		
		String messString = searchPage.getTextElement(driver,"//p[text()='Please select RAM']" );
		if (messString.equals("Please select RAM")) {
			ExcelUtilResult.setCellData("Passed", 6, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 6, 5);
		}
	}
	
	@Test
	public void TC_07_UpdateProductInShoppingCartExcelResult() throws IOException {
		ExcelUtilResult.setExcelFile("Auto");
		
		// Add sản phẩm lenovo vào wishlish
		wishLishPage.inputToSearchTextBox("lenovo");
		wishLishPage.clickToSearchButton();
		
//		sleepInSecond(3000);
		wishLishPage.clickToProduct();

//		sleepInSecond(3000);
		wishLishPage.clickToAddToWishList();
		
//		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isAddToWishListMessage("The product has been added to your wishlist"));

		wishLishPage.clickToCloseSpanMessage();
//		sleepInSecond(3000);

		driver.get("https://demo.nopcommerce.com/");
		wishLishPage.clickToWishListLabel();

//		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isProductAddToWishListSuccess("Lenovo IdeaCentre 600 All-in-One PC"));
		
		// Add sản phẩm lenovo từ wishlist vào shopping cart
		wishLishPage.clickToWishListLabel();
		wishLishPage.clickToAddToCartCheckBox();

//		sleepInSecond(3000);
		wishLishPage.clickToAddToCartButton();
		
//		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isProductAddToWishListSuccess("Lenovo IdeaCentre 600 All-in-One PC"));

//		sleepInSecond(3000);
		wishLishPage.clickToWishListLabel();
		
//		sleepInSecond(3000);
		Assert.assertTrue(wishLishPage.isNoDataInWishListMessage("The wishlist is empty!"));
		
		// Update số lượng trong shopping cart
		shoppingCartPage.clickToShoppingCartLabel();
		shoppingCartPage.clickToQuantityShoppingCartTextBox("năm");
//		sleepInSecond(3000);
		
		shoppingCartPage.clickToUpdateShoppingCartButton();

//		sleepInSecond(3000);
		
		String messString = shoppingCartPage.getTextElement(driver,"//input[@value='1']" );
		if (messString.equals("năm")) {
			ExcelUtilResult.setCellData("Passed", 7, 5);
		} else {
			ExcelUtilResult.setCellData("Failed", 7, 5);
		}
		
	}
	
}

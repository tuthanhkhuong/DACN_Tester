package extendedTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import utils.ExcelUtilLogin;
import utils.ExcelUtilRegister;

public class TS_DataDrivenExcel extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	@Test
	public void TC_01_RegisterWithExcelData() throws IOException {
		ExcelUtilRegister.setExcelFile("Auto");
		
		for(int i = 1; i <= ExcelUtilRegister.getRowCountInSheet(); i++) {
			String excelFirstName = ExcelUtilRegister.getCellData(i, 1);
			String excelLastName = ExcelUtilRegister.getCellData(i, 2);
			String excelEmail = ExcelUtilRegister.getCellData(i, 3);
			String excelPassword = ExcelUtilRegister.getCellData(i, 4);
			String excelConfirmPassword = ExcelUtilRegister.getCellData(i, 5);
			
//			registerPage.openUrl(driver, "https://demo.nopcommerce.com/register?returnUrl=%2F");
					
			registerPage.inputToRegisterFirstnameTextBox(excelFirstName);
			registerPage.inputToRegisterLastnameTextBox(excelLastName);
			registerPage.inputToRegisterEmailTextBox(excelEmail);
			registerPage.inputToRegisterPasswordTextBox(excelPassword);
			registerPage.inputToRegisterConfirmPasswordTextBox(excelConfirmPassword);
			
			//sleepInSecond(2000);
			
			registerPage.clickToRegisterButton();
			registerPage = new RegisterPageObject(driver);
			String url = registerPage.getCurrentPageUrl(driver);
			
			if (url.equals("https://demo.nopcommerce.com/registerresult/1?returnUrl=/")) {
				ExcelUtilRegister.setCellData("Passed", i, 6);
				registerPage.clickToRegisterSpan();
			} else {
				ExcelUtilRegister.setCellData("Failed", i, 6);
			}
		}
	}
	
	
	@Test
	public void TC_02_LoginWithExcelData() throws IOException {
		ExcelUtilLogin.setExcelFile("Auto");
		
		// Không chạy vòng lặp, chỉ duyệt 1 record cụ thể trong Sheet
//		String excelEmail = ExcelUtil.getCellData(1, 1);
//		String excelPassWord = ExcelUtil.getCellData(1, 2);
//		
//		loginPage.inputToEmailTextbox(excelEmail);
//		loginPage.inputToPasswordTextbox(excelPassWord);
//		loginPage.clickToLoginButton();
//		homePage = new HomePageObject(driver);
//		String url = homePage.getCurrentPageUrl(driver);
//		if (url.equals("https://demo.nopcommerce.com/")) {
//			ExcelUtil.setCellData("Passed", 1, 3);
//		} else {
//			ExcelUtil.setCellData("Failed", 1, 3);
//		}
		
		
		// Chạy vòng lặp, duyệt hết tất cả record trong Sheet
		for(int i = 1; i <= ExcelUtilLogin.getRowCountInSheet(); i++) {
			String excelEmail = ExcelUtilLogin.getCellData(i, 1);
			String excelPassWord = ExcelUtilLogin.getCellData(i, 2);
			
			loginPage.openUrl(driver, "https://demo.nopcommerce.com/login?returnUrl=%2F");
			
			loginPage.inputToEmailTextBox(excelEmail);
			loginPage.inputToPasswordTextBox(excelPassWord);
			
//			sleepInSecond(2000);
			
			loginPage.clickToLoginButton();
			homePage = new HomePageObject(driver);
			String url = homePage.getCurrentPageUrl(driver);
			
			if (url.equals("https://demo.nopcommerce.com/")) {
				ExcelUtilLogin.setCellData("Passed", i, 3);
				homePage.clickToLogout();
				homePage.clickToLogin();
			} else {
				ExcelUtilLogin.setCellData("Failed", i, 3);
			}
		}
	}
	
}

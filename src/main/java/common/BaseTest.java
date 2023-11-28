package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", projectPath +"/browserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", projectPath +"/browserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Can chinh khung cua so
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}
	
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
}

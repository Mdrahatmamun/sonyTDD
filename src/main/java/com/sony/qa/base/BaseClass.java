package com.sony.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sony.qa.common.CommonAction;
import com.sony.qa.object.HomePage;
import com.sony.qa.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	Configuration configuration = new Configuration(null);

	WebDriver driver;

	protected CommonAction cAction;
	protected HomePage hPage;

	@BeforeMethod

	public void setUp() {
		driver = localDriver("firefox");
		driver.get(configuration.getConfiguration("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout((Integer.parseInt(configuration.getConfiguration("pageloadWait"))),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait((Integer.parseInt(configuration.getConfiguration("implicitWait"))),
				TimeUnit.SECONDS);
		initClass();
	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		return driver;
	}

	private void initClass() {
		cAction = new CommonAction();
		hPage = new HomePage(driver, cAction);

	}

	protected WebDriver getDriver() {

		return driver;
	}

	@AfterMethod
	public void terminate() throws InterruptedException {
		Thread.sleep(6000);
		// driver.quit();

	}

}

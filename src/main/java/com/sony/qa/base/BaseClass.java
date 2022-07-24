package com.sony.qa.base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.sony.qa.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
	
	Configuration configuration=new Configuration(null);
	
	
	
	WebDriver driver;

	@Test
	public void setUp() {
	  driver = localDriver("firefox");
		driver.get(configuration.getConfiguration("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout((Integer.parseInt(configuration.getConfiguration("pageloadWait"))), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait((Integer.parseInt(configuration.getConfiguration("implicitWait"))),TimeUnit.SECONDS);
	
	}
	
	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();                                       
			
		}
		return driver;                    
	}
	public WebDriver getDriver() {
		return driver;
		
	}
	//@AfterTest
	public void closeDriver() {
		driver.quit();
		
	}
	

}

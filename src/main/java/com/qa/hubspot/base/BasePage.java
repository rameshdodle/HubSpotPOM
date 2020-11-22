package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;

	/**
	 * This method is used to initialize the driver on the basis of browser
	 * 
	 * @param browser
	 * @return driver
	 */

	public WebDriver init_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if (browser.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver=new SafariDriver();
		} else {
			System.out.println("Please provide the correct browser name...");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        // driver.get(prop.getProperty("url"));
		return driver;
	}

	/**
	 * This method is used to initialize the properties from config.properties
	 * file
	 * 
	 * @return prop
	 */
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"D:\\Selenium\\HubSpotPOM\\src\\main\\" + "java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

}

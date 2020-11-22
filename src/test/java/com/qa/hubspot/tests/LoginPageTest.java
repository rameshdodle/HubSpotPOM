package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest{
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.init_properties();
		driver=basePage.init_driver(prop);	
		loginPage=new LoginPage(driver);
	}
	@Test(priority=1)
	public void verifyLoginPageTitle(){
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login page title is :"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}
	
	@Test(priority=3)
	public void verifyLoginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*@AfterMethod
	public void quitBrowser(){
		driver.quit();
		
	}*/
}

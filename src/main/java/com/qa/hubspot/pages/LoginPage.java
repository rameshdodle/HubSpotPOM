package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage  extends BasePage{
	WebDriver driver;
	//1. page objects/By locators
	By email=By.id("username");
	By password=By.id("password");
	By loginButton=By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	
  //2. page class contructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	//3. page actions/methods
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isSignUpLinkExists(){
		return driver.findElement(signUpLink).isDisplayed();
	}
	public TasksPage doLogin(String username, String pwd){
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TasksPage(driver);
	}
			

}

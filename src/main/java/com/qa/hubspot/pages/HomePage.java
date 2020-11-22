package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	
	//Page Object/By locators
	By logo=By.xpath("//a[@id='nav-primary-home']//parent::li[@class='home link currentPage']");
	
	
	//Page class constructor
	public HomePage(WebDriver driver){
		this.driver=driver;	
	}
	

}

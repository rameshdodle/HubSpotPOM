package com.qa.hubspot.util;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HubSpotOTPHandle extends BasePage{
	WebDriver driver;
	public static final String ACCOUNT_SID="ACee7d6f967eea8e1c2dd128c6c849b634";
	public static final String AUTH_TOKEN="8b16d17531a89b7a5624bda0859c50a5";
	//Page Object/By locators
	
	
	
	//Page class constructor
	public HubSpotOTPHandle(WebDriver driver){
		this.driver=driver;
	}

}

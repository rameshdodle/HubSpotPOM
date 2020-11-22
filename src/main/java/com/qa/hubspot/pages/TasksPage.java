package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.hubspot.base.BasePage;

public class TasksPage extends BasePage{
	WebDriver driver;

	//Page Objects / By locators
	By tasksHeader=By.xpath("//h1[text()='Tasks']");
	By defaultFilterBy=By.xpath("(//span[@class='private-dropdown__item__label'])[1]");
	By creatTask=By.xpath("//i18n-string[text()='Create task']");
	
	//Page class constructor
	public TasksPage(WebDriver driver){
		this.driver=driver;	
	}
	
	//Page actions/methods
	public String getTasksPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyTasksPageHeader(){
		return driver.findElement(tasksHeader).isDisplayed();
	}
	public boolean verifyDefaultFilterBy(){
		return driver.findElement(defaultFilterBy).isDisplayed();
	}
	
	public boolean verifyCreateTaskButton(){
		return driver.findElement(creatTask).isEnabled();
	}

}

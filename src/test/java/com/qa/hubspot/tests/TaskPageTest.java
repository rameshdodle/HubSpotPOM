package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.TasksPage;

public class TaskPageTest extends BasePage {
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;
	Properties prop;
	TasksPage taskspage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		taskspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
	}

	@Test
	public void verifytasksPageTitleTest() {
		String title = taskspage.getTasksPageTitle();
		Assert.assertEquals(title, "Tasks");
	}

	/*@AfterMethod
	public void quitBrowser() {
		driver.quit();

	}*/

}

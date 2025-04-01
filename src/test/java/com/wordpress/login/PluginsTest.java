package com.wordpress.login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.PluginsPage;
import com.wordpress.pages.ThemesPage;

public class PluginsTest extends BaseTest {

	HomePage hPage;
	LoginPage loginPage;
	DashboardPage dashPage;
	ThemesPage themesPage;
	PluginsPage pluginsPage;

	@BeforeMethod
	public void setUp() {
		driver.get("https://wordpress.com/");
		hPage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		themesPage = new ThemesPage(driver);
		dashPage = new DashboardPage(driver);
		pluginsPage = new PluginsPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	public void loginToApplication() throws InterruptedException
	{
		hPage.clickOnLoginLink();
		loginPage.setUserName("murali22m@gmail.com");
		loginPage.clickOnContinueButton();
		loginPage.setPassword("Framework22$");
		loginPage.clickLoginButton();
		Thread.sleep(6000);
	}

	
	@Test
	public void testPluginsLoad() throws InterruptedException {

		loginToApplication();
		pluginsPage.ClickOnPluginsLink();
		Thread.sleep(3 * 1000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/plugins");

	}

	@Test
	public void searchPlugins() throws InterruptedException {

		loginToApplication();
		pluginsPage.ClickOnPluginsLink();
		pluginsPage.searchPlugins("gift cards");
		

	}



}

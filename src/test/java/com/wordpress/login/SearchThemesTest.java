package com.wordpress.login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.ThemesPage;

public class SearchThemesTest extends BaseTest {

	HomePage hPage;
	LoginPage loginPage;
	DashboardPage dashPage;
	ThemesPage themesPage;

	@BeforeMethod
	public void setUp() {
		driver.get("https://wordpress.com/");
		hPage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		themesPage = new ThemesPage(driver);
		dashPage = new DashboardPage(driver);
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
	public void testSearchThemes() throws InterruptedException {

		loginToApplication();
		dashPage.clickOnThemesLink();
		Thread.sleep(3 * 1000);
		themesPage.searchThemes("Farm Light");
		String resultThemeText = themesPage.getresultTheme();

		Assert.assertTrue(resultThemeText.toLowerCase().contains("farmlight"),
				"Expected themes related to 'FarmLight' but got: " + resultThemeText);

	}

	@Test
	public void testSearchThemeswithInvalidData() throws InterruptedException {
		loginToApplication();
		dashPage.clickOnThemesLink();
		Thread.sleep(3 * 1000);
		themesPage.searchThemes("Farm Light");
		String resultThemeText = themesPage.getresultTheme();

		Assert.assertTrue(resultThemeText.toLowerCase().contains("farmlight"),
				"Expected themes related to 'FarmLight' but got: " + resultThemeText);

	}

}

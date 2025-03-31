package com.wordpress.login;

import org.testng.annotations.Test;

import com.wordpress.pages.DashboardPage;
import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.ThemesPage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	

	HomePage hPage ;
	LoginPage loginPage;

	
	@BeforeMethod
	public void setUp()
	{
		driver.get("https://wordpress.com/");
		hPage = new HomePage(driver);
		loginPage = new LoginPage(driver);

		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void testLogin() throws InterruptedException {

		hPage.clickOnLoginLink();
				
		loginPage.setUserName("murali22m@gmail.com");		
		loginPage.clickOnContinueButton();
		loginPage.setPassword("Framework22$");
		loginPage.clickLoginButton();		
		System.out.println("testLogin is completed.");
		Thread.sleep(3*1000);
	
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://wordpress.com/sites";

        System.out.println("expectedUrl : " + expectedUrl);
        System.out.println("actualUrl : " + actualUrl);

        Assert.assertEquals(actualUrl, expectedUrl, "Login failed or URL mismatch after login");
        Assert.assertTrue(expectedUrl.equalsIgnoreCase(actualUrl),"Login URL is not correct");
	
	}
	
	@Test(dataProvider = "loginInvalidData")
	public void testLoginWithInvalidUserName(String userName,String errorMessage ) throws InterruptedException {


		hPage.clickOnLoginLink();
		loginPage.setUserName(userName);
		loginPage.clickOnContinueButton();
		Thread.sleep(3*1000);
	
		System.out.println("ErrorMessage : " + loginPage.getErrorMessage());
		Assert.assertEquals(loginPage.getErrorMessage(), errorMessage);
	
	}
	
	@DataProvider(name = "loginInvalidData")
	public Object[][] createData() {
	  return new Object[][] { new Object[] 
			  { "murali2@gmail.com","User does not exist. Would you like to create a new account?" },
			  { "murali2**","User does not exist. Would you like to create a new account?" },
			  { "@#!@#!@#","User does not exist. Would you like to create a new account?" },
			  { "","Please enter a username or email address." },
			  { "murali2@gmail","User does not exist. Would you like to create a new account?" },
			  { "murali2@yahoo.com","User does not exist. Would you like to create a new account?" },
			  };
	}

}
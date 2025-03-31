package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.ThemesPage;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUpParent()
	{
		driver = new FirefoxDriver();

	}
}

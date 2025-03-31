package com.wordpress.login;

import org.testng.annotations.Test;

import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginTest_BKP {
	WebDriver driver;
	HomePage hPage ;
	
	
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get("https://wordpress.com/");
		hPage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void testLogin() throws InterruptedException {

	
		hPage.clickOnLoginLink();
		WebElement userNameElement = driver.findElement(By.id("usernameOrEmail"));

		userNameElement.sendKeys("murali22m@gmail.com");

		WebElement continueButtonElement = driver.findElement(By.xpath("//button[@class='button form-button is-primary']"));
		continueButtonElement.click();

		WebElement passwordTextElement = driver.findElement(By.id("password"));
		passwordTextElement.sendKeys("Framework22$");

		WebElement LoginButtonElement = driver.findElement(By.xpath("//button[contains(text(), 'Log In')]"));
		LoginButtonElement.click();
		
		
		System.out.println("testLogin is completed.");
		Thread.sleep(6000);
	
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

		WebElement userNameElement = driver.findElement(By.id("usernameOrEmail"));

		userNameElement.sendKeys(userName);

		WebElement continueButtonElement = driver.findElement(By.xpath("//button[@class='button form-button is-primary']"));
		continueButtonElement.click();
		System.out.println("testLoginWithInvalidUserName is completed.");
		Thread.sleep(3*1000);
		
		WebElement ErrorMessageElement = driver.findElement(By.xpath("//div[@class='form-input-validation is-error has-icon']/span"));
		System.out.println("ErrorMessage : " + ErrorMessageElement.getText());
		
		Assert.assertEquals(ErrorMessageElement.getText(), errorMessage);
	
	}
	
	@DataProvider(name = "loginInvalidData")
	public Object[][] createData() {
	  return new Object[][] { new Object[] 
			  { "murali2@gmail.com","User does not exist. Would you like to create a new account?" },
			  { "murali2**","User does not exist. Would you like to create a new account?" },
			  { "@#!@#!@#","User does not exist. Would you like to create a new account?" },
			  { "","Please enter a username or email address" },
			  { "murali2@gmail","User does not exist. Would you like to create a new account?" },
			  };
	}

}
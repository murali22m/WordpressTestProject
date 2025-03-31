package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private String locator_userNameElement = "usernameOrEmail";
	private String locator_ErrorMessageElement = "//div[@class='form-input-validation is-error has-icon']/span";
	private String locator_continueButtonElement = "//button[@class='button form-button is-primary']";
	private String locator_passwordTextElement = "password";
	private String locator_LoginButtonElement = "//button[contains(text(), 'Log In')]";

	public LoginPage(WebDriver wd) {
		driver = wd;
	}

	public void setUserName(String userName) {
		WebElement userNameElement = driver.findElement(By.id(locator_userNameElement));
		userNameElement.clear();
		userNameElement.sendKeys(userName);

	}

	public String getErrorMessage() {
		WebElement ErrorMessageElement = driver.findElement(By.xpath(locator_ErrorMessageElement));
		return ErrorMessageElement.getText();

	}

	public void clickOnContinueButton() {
		WebElement continueButtonElement = driver.findElement(By.xpath(locator_continueButtonElement));
		continueButtonElement.click();
	}

	public void setPassword(String password) {
		WebElement passwordTextElement = driver.findElement(By.id(locator_passwordTextElement));
		passwordTextElement.clear();
		passwordTextElement.sendKeys(password);

	}

	public void clickLoginButton() {
		WebElement LoginButtonElement = driver.findElement(By.xpath(locator_LoginButtonElement));
		LoginButtonElement.click();
	}

}
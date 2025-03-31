package com.wordpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;

	private String locator_login_link = "Log in";

	public HomePage(WebDriver wd) {
		driver = wd;
	}

	public void clickOnLoginLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("clickOnLoginLink()");
		WebElement LoginElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator_login_link)));
		LoginElement.click();

	}

}

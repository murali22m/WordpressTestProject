package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ThemesPage {
	private WebDriver driver;

	private String searchElement = "//input[@role='searchbox']";
	private String resultThemeElement = "//span[text()='FarmLight']";


	public ThemesPage(WebDriver wd) {
		driver = wd;
	}

	public void searchThemes(String themeName) throws InterruptedException {
		WebElement searchBox = driver.findElement(By.xpath(searchElement));
		searchBox.sendKeys(themeName);

		Actions actions = new Actions(driver);
		actions.sendKeys(searchBox, Keys.ENTER).perform();

		Thread.sleep(3000);

		WebElement resultTheme = driver.findElement(By.xpath(resultThemeElement));
		String resultThemeText = resultTheme.getText();

		Assert.assertTrue(resultThemeText.toLowerCase().contains("farmlight"),
				"Expected themes related to 'FarmLight' but got: " + resultThemeText);
	}
	
	
	public String getresultTheme() {
		WebElement resultTheme = driver.findElement(By.xpath(resultThemeElement));
		String resultThemeText = resultTheme.getText();
		return resultThemeText;
		
	}

}

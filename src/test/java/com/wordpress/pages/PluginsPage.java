package com.wordpress.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PluginsPage {
	private WebDriver driver;

	private String pluginLinkElement = "//span[@data-e2e-sidebar='Plugins']";
	private String SearchPluginsElement = "//input[@role='searchbox']";
	private String resultPluginElement = "//div[@class=\"plugins-browser-item__title\"]";

	public PluginsPage(WebDriver wd) {
		driver = wd;
	}

	public void ClickOnPluginsLink() throws InterruptedException {

		WebElement pluginLink = driver.findElement(By.xpath(pluginLinkElement));
		pluginLink.click();

		Thread.sleep(3000);

	}
	
	public void searchPlugins(String pluginSearch) throws InterruptedException {
		
			
		WebElement searchPlugins = driver.findElement(By.xpath(SearchPluginsElement));
	
		searchPlugins.clear();
		searchPlugins.sendKeys(pluginSearch);
		Thread.sleep(1000);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(searchPlugins, Keys.ENTER).perform();
		Thread.sleep(3000);
		
	
		WebElement resultPlugin = driver.findElement(By.xpath(resultPluginElement));
		String resultPluginText = resultPlugin.getText();

		
		Assert.assertTrue(resultPluginText.toLowerCase().contains("gift cards"),
				"Expected plugin related to 'gift cards' but got: " + resultPluginText);
	}
	}
	

package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	private WebDriver driver;
	private String locator_thems_link = "//span[@class='sidebar__menu-link-text menu-link-text' and @data-e2e-sidebar='Themes']";

	public DashboardPage(WebDriver wd) {
		driver = wd;
	}

	public void clickOnThemesLink() {
		WebElement ThemesLinkElement = driver.findElement(By.xpath(locator_thems_link));
		ThemesLinkElement.click();
	}

}

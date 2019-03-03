package com.wallet.hub.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchedPage {

	WebDriver driver;
	public SearchedPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement AssertComponent()
	{
		return driver.findElement(By.xpath("//div[3]/div/section/div[3]/ol/li[1]/h3/a"));
	}
}

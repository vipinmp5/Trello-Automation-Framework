package com.wallet.hub.java.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionCreater {
	
    Actions action;
	public ActionCreater(WebDriver driver)
	{
		this.action=new Actions(driver);
		
	}
	
	public Actions performHoverHighlightClick(WebElement starContainer)
	{
		return this.action.moveToElement(starContainer);
	}
	
	public void highlightAndClick(WebElement star4, WebElement star5,WebElement startContainer)
	{
		Actions container=performHoverHighlightClick(startContainer);
		container.perform();
		container.moveToElement(star4).perform();
	    container.moveToElement(star5).click(star5).build().perform();
	}
	
	
	
	

}

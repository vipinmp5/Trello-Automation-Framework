package com.wallet.hub.java.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSInducer {
	
	
	
	public static WebDriver getNewRedirectHandle(WebDriver driver, String redirectionUrl)
	{
		String oldTab = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("var win = window.open(\"https://wallethub.com/profile/test_insurance_company/\", '_blank') "); 
	    //driver.get("https://wallethub.com/profile/test_insurance_company/");
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    driver.close();
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    
	    return driver;
	}
	
	public static WebDriver OpenUrlInNewTab(WebDriver driver, String url, String InnerHtml)
	{
	    // Define the script
	    String script = "var d=document,a=d.createElement('a');a.target='_blank';a.href='https://wallethub.com/join/login?redirect_to=https%3A%2F%2Fwallethub.com%2Fprofile%2Ftest_insurance_company%2F';a.innerHTML='Login';d.body.appendChild(a);return a;";
	    // Execute the JavaScript
	    WebElement element = (WebElement)((JavascriptExecutor)driver).executeScript(script);
	    // Click the new element
	    element.click();
	    ArrayList<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.close();
	    browserTabs.remove(0);
	    driver.switchTo().window(browserTabs.get(0));
	    
	    return driver;
	}
	
	
	public static String jsGetPageTitle(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	 public static String jsGetCurrentURL(WebDriver driver)
	 {
	        JavascriptExecutor js =(JavascriptExecutor)driver;
	        String currentUrl= js.executeScript("return document.URL;").toString();
	        return currentUrl;
     }
	
	 public static void JavaScriptElementClick(WebDriver driver)
	 {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 List<WebElement> elementToClick = driver.findElements(By.cssSelector(".remove"));
			 for(WebElement elements: elementToClick){
			 js.executeScript("arguments[0].scrollIntoView()", elements);
			 js.executeScript("arguments[0].click();", elements);
			 
	 }
  }
}
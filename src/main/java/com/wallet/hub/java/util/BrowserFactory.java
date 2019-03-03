package com.wallet.hub.java.util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	 private static HashMap<String, WebDriver> Drivers = new HashMap<String, WebDriver>();
     private static WebDriver driver;

     public static WebDriver getDriver(){  
             if (driver == null)
                 return null;
             return driver;
     }
    
     private static void setDriver(WebDriver driverVal){
             driver = driverVal;       
     }

     public static void InitBrowser(String browserName)
     {
         try
         {
             switch (browserName)
             {

                 case "Firefox":
                     if (getDriver() == null)
                     {

                         FirefoxProfile ffprofile = new FirefoxProfile();
                         ffprofile.setPreference("dom.webnotifications.enabled", "false");
                         FirefoxOptions options = new FirefoxOptions();
                         options.addArguments("--disable-notifications");
                         options.addArguments("--start-maximized");
                         driver = new FirefoxDriver(options);
                         setDriver(driver);
                         Drivers.put("Firefox", driver);
                     }
                     break;

                 case "IE":
                     if (getDriver() == null)
                     {
                         driver = new InternetExplorerDriver();
                         setDriver(driver);
                         Drivers.put("IE", driver);
                     }
                     break;

                 case "Chrome":
                     if (getDriver() == null)
                     {

                         ChromeOptions options = new ChromeOptions();
                         options.addArguments("--disable-notifications");
                         options.addArguments("--start-maximized");
                         driver = new ChromeDriver(options);
                         setDriver(driver);
                         Drivers.put("Chrome", driver);
                     }
                     break;
             }
         }
         catch(Exception e)
         {
        	 Log.fatal("Browser Initiate issue"+ e.getMessage());
         }
         
     }

     public static void LoadApplication(String url)
     {
    	 driver.get(url);
    	 Log.info("Url Loaded from BrowserFactory");
     }

     
     public static void CloseAllDrivers()
     {
         for ( String key:Drivers.keySet())
         {
             Drivers.get(key).close();
             Drivers.get(key).quit();
         }
     }
}

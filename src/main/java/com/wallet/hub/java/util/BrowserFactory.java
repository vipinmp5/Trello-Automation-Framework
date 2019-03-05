package com.wallet.hub.java.util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
     private static WebDriver driver;

     public static WebDriver getDriver(){  
             if (driver == null)
                 return null;
             return driver;
     }
    
     

     public static WebDriver InitBrowser(String browserName)
     {
         try
         {
             switch (browserName)
             {

                 case "Firefox":
                     if (getDriver() == null)
                     {
                    	 String userDirectory=System.getProperty("user.dir");
                    	 String geckopath=userDirectory+"\\Gecko\\";
                         FirefoxOptions options = new FirefoxOptions();
                         options.addArguments("--disable-notifications");
                         options.addArguments("--start-maximized");
                         System.setProperty("webdriver.gecko.driver", geckopath+"geckodriver.exe");
                         driver = new FirefoxDriver(options);
                     }
                     break;

                 case "IE":
                     if (getDriver() == null)
                     {
                         driver = new InternetExplorerDriver();
                     }
                     break;

                 case "Chrome":
                     if (getDriver() == null)
                     {
                    	 String userDirectory=System.getProperty("user.dir");
                    	 String chromePath=userDirectory+"\\Chrome\\";
                         ChromeOptions options = new ChromeOptions();
                         options.addArguments("--start-maximized");
                         options.addArguments("--no-sandbox");
                         System.setProperty("webdriver.chrome.driver", chromePath+"chromedriver.exe");
                         driver = new ChromeDriver(options);
                     }
                     break;
                     
             }
             
             return driver;
         }
         catch(Exception e)
         {
        	 Log.fatal("Browser Initiate issue"+ e.getMessage());
        	 return null;
         }
         
     }

     public static WebDriver LoadApplication(String url, String browser)
     {
    	 BrowserFactory.InitBrowser("Chrome");
    	 driver.get(url);
    	 Log.info("Url Loaded from BrowserFactory");
    	 return driver;
     }

}

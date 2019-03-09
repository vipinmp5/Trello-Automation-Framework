package com.wallet.hub.java.util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
    
     

     public static WebDriver InitBrowser(String browserName)
     {
    	 WebDriver driver=null;
    	 String userDirectory=System.getProperty("user.dir");
         try
         {
             switch (browserName)
             {

                 case "Firefox":
                    
                    	 String geckopath=userDirectory+"\\Gecko\\";
                         FirefoxOptions Firefoxoptions = new FirefoxOptions();
                         Firefoxoptions.addArguments("--disable-notifications");
                         Firefoxoptions.addArguments("--start-maximized");
                         System.setProperty("webdriver.gecko.driver", geckopath+"geckodriver.exe");
                         driver = new FirefoxDriver(Firefoxoptions);
                     break;

                 case "IE":
                        driver = new InternetExplorerDriver();
                     
                     break;

                 case "Chrome":
                         
                    	 String chromePath=userDirectory+"\\Chrome\\";
                         ChromeOptions options = new ChromeOptions();
                         options.addArguments("--start-maximized");
                         System.setProperty("webdriver.chrome.driver", chromePath+"chromedriver.exe");
                         driver = new ChromeDriver(options);
                     
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

     
}

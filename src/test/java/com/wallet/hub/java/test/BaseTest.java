package com.wallet.hub.java.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.wallet.hub.java.pages.BasePageGenerator;

public class BaseTest {
	
	 public WebDriver driver;
	    public WebDriverWait wait;
	    public BasePageGenerator page;

	    @BeforeSuite
	    public void setup () {
	       
	    	String geckoPath="./Gecko/";
			System.setProperty("webdriver.gecko.driver", geckoPath+"geckodriver.exe");
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile testprofile = profile.getProfile("Neo");
			testprofile.setPreference("dom.webnotifications.enabled", false);
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, testprofile);
			FirefoxOptions options = new FirefoxOptions(dc);
			driver=new FirefoxDriver(options);
			page=new BasePageGenerator(driver);
	    }

	    @AfterSuite
	    public void teardown () {
	        driver.quit();
	    }
	

}

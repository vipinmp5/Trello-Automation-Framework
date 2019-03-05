package com.wallet.hub.java.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.wallet.hub.java.pages.BasePageGenerator;
import com.wallet.hub.java.util.BrowserFactory;
import com.wallet.hub.java.util.PropertyManager;

public class BaseTest {
	
	 public WebDriver driver;
	    public WebDriverWait wait;
	    public BasePageGenerator page;

	    @BeforeClass
	    public void setup () {
	        String BaseUrl=PropertyManager.getInstance().getBaseUrl();
            driver=BrowserFactory.LoadApplication(BaseUrl, "Chrome");
			page=new BasePageGenerator(driver);
	    }
	   

	    @AfterClass
	    public void teardown () {
	        driver.quit();
	    }
	

}

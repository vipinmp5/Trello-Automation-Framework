package com.wallet.hub.java.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.wallet.hub.java.util.*;

public class BasePageGenerator {
	
	public WebDriver driver;
	public ObjectRepoUtility objrepo;
	
	public WebDriver getDriver(){  
		return BrowserFactory.getDriver();
     }

    private  void setDriver(WebDriver driverVal){
    	if (driver == null)
        {
            driver = BrowserFactory.getDriver();
        }
     }

    //Constructor
    public BasePageGenerator(WebDriver driver){
    	setDriver(driver);
    }
 
    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

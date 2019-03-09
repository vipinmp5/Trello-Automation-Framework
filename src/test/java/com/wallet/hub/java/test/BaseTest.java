package com.wallet.hub.java.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.wallet.hub.java.pages.BoardPage;
import com.wallet.hub.java.pages.CardEditPage;
import com.wallet.hub.java.pages.HomePage;
import com.wallet.hub.java.pages.TrelloHomePage;
import com.wallet.hub.java.pages.TrelloLoginPage;
import com.wallet.hub.java.util.BrowserFactory;
import com.wallet.hub.java.util.PropertyManager;

public class BaseTest {
	
	 public WebDriver driver;
	    public WebDriverWait wait;
	    public HomePage objHome;
	    public TrelloLoginPage objLogin;
	    public TrelloHomePage objTrelloHome;
	    public BoardPage objBoard;
	    public CardEditPage objCardEdit;
	    
	    @BeforeClass
	    public void setup () {
	        String BaseUrl=PropertyManager.getInstance().getBaseUrl();
            driver=BrowserFactory.InitBrowser("Chrome");
            objHome=new HomePage(driver);
            objLogin=new TrelloLoginPage(driver);
            objTrelloHome= new TrelloHomePage(driver);
            objBoard= new BoardPage(driver);
            objCardEdit= new CardEditPage(driver);
	    }
	   

	    @AfterClass
	    public void teardown () {
	        driver.quit();
	    }
	

}

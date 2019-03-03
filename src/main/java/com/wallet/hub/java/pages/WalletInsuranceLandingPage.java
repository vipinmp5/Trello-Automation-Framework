package com.wallet.hub.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wallet.hub.java.util.JSInducer;
import com.wallet.hub.java.util.Log;

public class WalletInsuranceLandingPage extends BasePage {
	
	public WalletInsuranceLandingPage(WebDriver driver)
	{
		super(driver);
	}
	
	 String landingPath = "test_insurance_company/";
	 
	  @FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	    public WebElement LoginPageLink;
	 
	
	    public WalletInsuranceLandingPage goToLandingPage (String baseUrl){
	        driver.get(baseUrl+landingPath);
	        return GetInstance(WalletInsuranceLandingPage.class);
	    }
	 
	    //Go to LoginPage
	    public WalletLoginPage goToLoginPage (){
	    	Log.info("In Page "+driver.getTitle());
	    	JSInducer.OpenUrlInNewTab(driver, LoginPageLink.getAttribute("href"), LoginPageLink.getAttribute("InnerHTML"));
	        return GetInstance(WalletLoginPage.class);
	    }

}

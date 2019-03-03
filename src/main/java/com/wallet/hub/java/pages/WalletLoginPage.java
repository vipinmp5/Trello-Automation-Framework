package com.wallet.hub.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wallet.hub.java.util.Log;

public class WalletLoginPage extends BasePage{
	
	public WalletLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@ng-model='fields.email']")
	public WebElement UserName;
	
	@FindBy(how=How.XPATH,using="//input[@ng-model='fields.password']")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using="//button[contains(@class,'btn blue')]")
	public WebElement LoginButton;
	
	public WalletInsuranceProfilePage LoginToWalletHub(String walletMail,String walletPassword)
	{
		Log.info("In Page "+driver.getTitle());
		writeText(UserName, walletMail);
		writeText(Password,walletPassword);
		click(LoginButton);
		return GetInstance(WalletInsuranceProfilePage.class);
	}
	
	


}

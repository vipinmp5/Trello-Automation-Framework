package com.wallet.hub.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wallet.hub.java.util.Log;

public class FacebookLoginPage extends BasePage
{
	public FacebookLoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(how=How.ID,using="email")
	public WebElement UserName;
	
	@FindBy(how=How.ID,using="pass")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using="//input[@value='Log In']")
	public WebElement LogIn;
	



	public FacebookHomePage LoginToFaceBookAccount(String facebookMail,String Password)
	{
		Log.info("In Page with title "+driver.getTitle());
		writeText(UserName, facebookMail);
		writeText(Password,Password);
		click(LogIn);
		 return GetInstance(FacebookHomePage.class);
	}
}



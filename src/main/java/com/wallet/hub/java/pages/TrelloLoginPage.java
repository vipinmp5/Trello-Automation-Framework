package com.wallet.hub.java.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.wallet.hub.java.util.Log;

public class TrelloLoginPage extends BasePage
{
	
	public TrelloLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	 
	  @FindBy(how = How.CSS, using = "input#user")
	    public WebElement userName;
	  
	  @FindBy(how = How.CSS, using = "input#user")
	    public WebElement password;
	  
	  @FindBy(how = How.CSS, using = "input#login")
	    public WebElement loginButton;
	  
	  
	  public TrelloLoginPage verifyLoginPage(String ProfileName)
	  {
		  try
		  {
			  Assert.assertEquals(driver.getTitle().contains("Log in to Trello"),true);
			  return GetInstance(TrelloLoginPage.class);
			  
		  }
		  catch(Exception e)
		  {
			  Log.fatal("Title Displayed is "+driver.getTitle()+" Exception "+ e.getMessage());
			  
			   return null;
		  }
		  
		   
	  }
	  
	  
	  public TrelloHomePage LoginToApplication(String emailVal, String passwordVal)
	  {
		  try
		  {
			  writeText(userName, emailVal);
			  writeText(password,passwordVal);
			  click(loginButton);
			  Log.info("Login To Trello using username: "+emailVal+" and password: "+passwordVal);
			  return GetInstance(TrelloHomePage.class);
			    
		  }
		  catch(Exception e)
		  {
			  Log.info("From Trello Login Page Thrown Exception: "+e.getMessage());
			  return null;
		  }
		  
	  }
	  
}




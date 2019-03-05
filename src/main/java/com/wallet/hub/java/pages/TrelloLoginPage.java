package com.wallet.hub.java.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.wallet.hub.java.util.Log;
import com.wallet.hub.java.util.ObjectRepoUtility;

public class TrelloLoginPage extends BasePage
{
	
	public TrelloLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	  
	  
	  public TrelloLoginPage verifyLoginPage()
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
	  
	  public void enterUsername(String email){
	     objrepo.enterTextJS("input#user", email);
	  }
	  
	  public void enterPassword(String passwordText){
		  objrepo.enterTextJS("input#password", passwordText);
		  }
	  
	  public void clickLoginButton(){
		     WebElement loginButton=objrepo.ConstructElementByCss("input#login");
		     loginButton.click();
		  }
	  
	  public TrelloHomePage LoginToApplication(String email, String passwordText)
	  {
		  try
		  {
			  
			  enterUsername(email);
			  enterPassword(passwordText);
			  clickLoginButton();
			  Log.info("Login To Trello using username: "+email+" and password: "+passwordText);
			  return GetInstance(TrelloHomePage.class);
			    
		  }
		  catch(Exception e)
		  {
			  Log.info("From Trello Login Page Thrown Exception: "+e.getMessage());
			  return null;
		  }
		  
	  }
	  
}



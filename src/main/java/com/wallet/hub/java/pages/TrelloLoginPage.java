package com.wallet.hub.java.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wallet.hub.java.util.Log;
import com.wallet.hub.java.util.ObjectRepoUtility;

public class TrelloLoginPage
{
	
ObjectRepoUtility objRepo;
	
	public TrelloLoginPage(WebDriver driver)
	{
		objRepo=new ObjectRepoUtility(driver);
	}

	  
	  public void enterUsername(String email){
		 objRepo.enterTextPlaceHolderTextbox("input#user", email);   
	  }
	  
	  public void enterPassword(String passwordText){
		  objRepo.enterTextPlaceHolderTextbox("input#password", passwordText);  
	  }
	  
	  public void clickLoginButton(){
		  objRepo.ConstructElementByCss("input#login").click();
	  }
	  
	  public void LoginToApplication(String email, String passwordText)
	  {
		  try
		  {
			  
			  enterUsername(email);
			  enterPassword(passwordText);
			  clickLoginButton();
			  Log.info("Login To Trello using username: "+email+" and password: "+passwordText);
			  
			    
		  }
		  catch(Exception e)
		  {
			  Log.info("From Trello Login Page Thrown Exception: "+e.getMessage());
		  }
		  
	  }
	  
}



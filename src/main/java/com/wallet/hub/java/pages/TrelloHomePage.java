
package com.wallet.hub.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.wallet.hub.java.util.Log;

public class TrelloHomePage extends BasePage {
	

	
	public TrelloHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = ".member-initials[title^=Vipin]")
    public WebElement ProfileName;
	
	@FindBy(how = How.XPATH, using = "//div[@class='wh-rating-choices-holder']/a[4]")
    public WebElement FourthStar;
	
	@FindBy(how = How.XPATH, using = "//div[@class='wh-rating-choices-holder']/a[5]")
    public WebElement FifthStar;
	
	
	 public TrelloHomePage verifyHomePage(String AvatarText)
	  {
		  try
		  {
			  Assert.assertEquals(ProfileName.getText(),AvatarText);
			  return GetInstance(TrelloHomePage.class);
			  
		  }
		  catch(Exception e)
		  {
			  Log.fatal("ProfileName Displayed is "+ProfileName.getText()+" Exception "+ e.getMessage());
			  
			   return null;
		  }
		  
		   
	  }
	
	
		

}

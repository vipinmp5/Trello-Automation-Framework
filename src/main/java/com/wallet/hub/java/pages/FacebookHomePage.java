package com.wallet.hub.java.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.wallet.hub.java.util.Log;

public class FacebookHomePage extends BasePage
{
	
	public FacebookHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	 
	  @FindBy(how = How.XPATH, using = "//a[@title='Profile']")
	    public WebElement profileName;
	  
	  @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Compose Post')]")
	    public WebElement ComposePost;
	  
	  @FindBy(how = How.XPATH, using = "//textarea[@name='xhpc_message']")
	    public WebElement PostTextArea;
	  
	  @FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Post')]")
	    public WebElement Post;
	  
	  @FindBy(how = How.XPATH, using = "//div[@id='timeline_composer_container']/div[2]//p")
	    public WebElement PostScreen;
	  
	  public FacebookHomePage verifyHomePage(String ProfileName)
	  {
		  try
		  {
			  Assert.assertEquals(profileName.getText(),ProfileName);
			  return GetInstance(FacebookHomePage.class);
			  
		  }
		  catch(Exception e)
		  {
			  Log.fatal("ProfileName Displayed is "+profileName.getText()+" Exception "+ e.getMessage());
			  
			   return null;
		  }
		  
		   
	  }
	  
	  public FacebookHomePage WallPost(String PostContent)
	  {
		  try
		  {
			  writeText(PostTextArea, PostContent);
			  Thread.sleep(3000);
			  click(Post);
			  Thread.sleep(3000);
			  Log.info("From Facebook HomePage Wall Post with Content: "+PostContent);
			  return GetInstance(FacebookHomePage.class);
			    
		  }
		  catch(Exception e)
		  {
			  Log.info("From Facebook Home Page Wall Post Exception: "+e.getMessage());
			  return null;
		  }
		  
	  }
	  
	  public String getLatestPostContentFromWall()
	  {
		  try
		  {
			  return readText(PostScreen);
		  }
		  catch(Exception e)
		  {
			  Log.info("Facebook HomePage getLatestPostContentFromWall Exception: "+e.getMessage());
			  return "";
		  }
		  
		 
		  
	  }
	  
	  
}




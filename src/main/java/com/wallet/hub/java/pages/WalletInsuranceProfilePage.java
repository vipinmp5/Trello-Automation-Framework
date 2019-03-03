package com.wallet.hub.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wallet.hub.java.util.Log;

public class WalletInsuranceProfilePage extends BasePage {
	

	
	public WalletInsuranceProfilePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "span.wh-rating.rating_4_5")
    public WebElement StarContainer;
	
	@FindBy(how = How.XPATH, using = "//div[@class='wh-rating-choices-holder']/a[4]")
    public WebElement FourthStar;
	
	@FindBy(how = How.XPATH, using = "//div[@class='wh-rating-choices-holder']/a[5]")
    public WebElement FifthStar;
	
	
	 public ReviewSubmissionPage mouseHoverTo4thStarAndClick5th()
	 {
			 	
		 Actions action = new Actions(driver);
         action.moveToElement(StarContainer).perform();
         action.moveToElement(FourthStar).pause(10000).perform();
         action.moveToElement(FifthStar).pause(1000).clickAndHold(FifthStar).build().perform();
         Log.info("Fifth star Clicked");
         return GetInstance(ReviewSubmissionPage.class);
         
	 }
		

}

package com.wallet.hub.java.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReviewSubmissionConfirmPage extends BasePage{
	
	
	public ReviewSubmissionConfirmPage(WebDriver driver)
	{
		super(driver);
	}
		
	
	@FindBy(how=How.XPATH, using = "//*[contains(text(),'Awesome!')]//a[text()=\"has been posted.\"]")
	public WebElement PostedLink;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,\"content small\")]/p")
	public WebElement ReviewContent;
	
	public String getReviewID()
	{
		String reviewUrl=PostedLink.getAttribute("href");
		
		String reviewId=StringUtils.substringAfterLast(reviewUrl, "#");
		
		return reviewId;
	}
	
	
	
	 public UserProfilePage goToProfilePage(String baseUrl,String userName)
     {
		driver.get(baseUrl+userName+"/reviews/");
        
        return GetInstance(UserProfilePage.class);
    
     }
	


}

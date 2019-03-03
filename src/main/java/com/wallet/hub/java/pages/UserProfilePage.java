package com.wallet.hub.java.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserProfilePage extends BasePage{
	
	public UserProfilePage(WebDriver driver)
	{
		super(driver);
	}
	
    @FindAll(@FindBy(how = How.CSS, using = "div.reviews div"))
	public List<WebElement> Reviews;
	 
	
	
	public String getReviewContent(String reviewID)
	{
		for(WebElement review : Reviews){
			if(review.getAttribute("id").equals(reviewID)) {
				return readText(review.findElement(By.xpath("//p")));
			}
		}
		
		return "";
	}
	
	
	  
	  
	
	 
	
	  

}

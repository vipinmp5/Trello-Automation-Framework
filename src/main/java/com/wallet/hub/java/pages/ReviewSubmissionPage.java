package com.wallet.hub.java.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wallet.hub.java.util.Log;

public class ReviewSubmissionPage extends BasePage {

	public ReviewSubmissionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "span.drop-arrow")
	public WebElement PolicyDropDownArrow;

	@FindAll(@FindBy(how = How.CSS, using = "ul.drop-el li"))
	public List<WebElement> PolicyList;

	@FindBy(how = How.XPATH, using = "//a[text()='Health']")
	public WebElement Health;

	@FindBy(how = How.XPATH, using = "//textarea[@id='review-content']")
	public WebElement ReviewTextArea;

	@FindBy(how = How.CSS, using = "input.btn.blue")
	public WebElement SubmitButton;


	public ReviewSubmissionPage SelectPolicy(String policyName) {
		

		click(PolicyDropDownArrow);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			return null;
		}

		for (WebElement policy : PolicyList) {
			if (policy.getText().equals(policyName)) {
				click(policy);
				return GetInstance(ReviewSubmissionPage.class);
			}
		}
		return GetInstance(ReviewSubmissionPage.class);

		
	}

	public ReviewSubmissionPage EnterReview(String Review) {
		writeText(ReviewTextArea, Review);
		try {
			Thread.sleep(3000);
			Log.info("Review Char Count is " + reviewCountDisplay().toString());
		} catch (InterruptedException e) {

			Log.info("Issue Thrown during " + e.getMessage());
			return null;
		}

		return GetInstance(ReviewSubmissionPage.class);

	}
	
	public ReviewSubmissionConfirmPage SubmitReview()
	{
		click(SubmitButton);
		return GetInstance(ReviewSubmissionConfirmPage.class);
	}

	

	public String starHighlighted() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (js
				.executeScript("return document.querySelectorAll('a.bf-icon-star').length")
				.toString());
	}

	public String reviewCountDisplay() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (js
				.executeScript("return document.querySelector('div.review-bottom>span>span').textContent.toNumber()")
				.toString());
	}
	
	
}

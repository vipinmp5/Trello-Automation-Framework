package com.wallet.hub.java.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectRepoUtility {
	WebDriver driver;
	private boolean acceptNextAlert = true;

	public ObjectRepoUtility(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}

	}

	public ObjectRepoUtility(WebElement frame, WebDriver driver) {
		if (driver == null) {
			this.driver = driver;

		}
		driver = driver.switchTo().frame(frame);
	}

	public void getURL(String baseURL) {
		driver.get(baseURL);
	}

	public WebElement constructXpathAttributeValue(String attr, String attrValue) {
		return driver.findElement(By.xpath(".//*[@" + attr + "='" + attrValue
				+ "']"));
	}

	public WebElement constructXpathTextElement(String attrValue) {
		return driver.findElement(By.xpath(".//*[contains(text(),'" + attrValue
				+ "')]"));
	}

	public WebElement constructXpathTagFollowedChildElement(String tag,
			String attrValue) {
		if(attrValue=="Computer"){
			WebElement element=driver.findElement(By.xpath(".//" + tag + "[contains(.,'"
					+ attrValue + "')]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
			
			return null;
		}
		return driver.findElement(By.xpath(".//" + tag + "[contains(.,'"
				+ attrValue + "')]"));
	}

	public WebElement constructXpathParentChildTagFollowChildElement(
			String parentTag, String childTag, String parentNonTextAttr,
			String parentNonTextAttrValue, String parentTextAttrValue,
			String childTextAttrValue) {
		return driver.findElement(By.xpath(".//" + parentTag + "[@"
				+ parentNonTextAttr + "='" + parentNonTextAttrValue
				+ "' and contains(.,'" + parentTextAttrValue + "')]//"
				+ childTag + "[contains(.,'" + childTextAttrValue + "')]"));
	}
	
	public WebElement constructXpathParentTagFollowChildElement(
			String parentTag, String parentAttr,
			String parentAttrValue, String childTextAttrValue) {
		return driver.findElement(By.xpath(".//" + parentTag + "[contains(@"
				+ parentAttr + ",'" + parentAttrValue
				+ "') and contains(.,'" + childTextAttrValue + "')]"));
	}

	public WebElement ConstructElementByCssTagAttributeValue(String tag,
			String atribute, String value) {
		return driver.findElement(By.cssSelector(tag + "[" + atribute + "="
				+ value + "]"));
	}

	public WebElement ConstructElementByCssTagAttributeContainsValue(
			String tag, String atribute, String value) {
		return driver.findElement(By.cssSelector(tag + "[" + atribute + "*="
				+ value + "]"));
	}

	public WebElement ConstructElementByCss(String selector) {
		return driver.findElement(By.cssSelector(selector));
	}

	public WebElement ConstructElementByxpath(String xpathQuery) {
		return driver.findElement(By.xpath(xpathQuery));
	}

	public List<WebElement> ConstructElementListByCss(String selector) {
		return driver.findElements(By.cssSelector(selector));
	}

	public void enterTextPlaceHolderTextbox(String elementAttributeorBy,
			String input) {
		WebElement textBoxIdentified = ConstructElementByCss(elementAttributeorBy);
		Actions actions = new Actions(driver);
		actions.moveToElement(textBoxIdentified);
		actions.click();
		actions.sendKeys(input);
		actions.build().perform();
	}

	public WebElement constructButton(String attr, String attrValue) {
		return driver.findElement(By.cssSelector("[" + attr + "='" + attrValue
				+ "']"));
	}

	public WebElement constructFrameByxpath(String att1, String attVal1,
			String att2, String attVal2) {
		return driver.findElement(By.xpath("//iframe[contains(@" + att1 + ", '"
				+ attVal1 + "') and contains(@" + att2 + ", '" + attVal2
				+ "')]"));
	}

	public Select dropDownSelect(String attrValue) {
		WebElement element = ConstructElementByCss("#" + attrValue);
		Select objSelect = new Select(element);
		return objSelect;
	}

	public void enterTextJS(String selector, String input) {
		String Query = "document.querySelector('" + selector + "').value='"
				+ input + "'";
		((JavascriptExecutor) driver).executeScript(Query);
	}
	
	public void attachAfile(String fileName){
		String baseDirectory=System.getProperty("user.dir");
    	String filepath=baseDirectory+"\\"+fileName;
    	driver.findElement(By.name("file")).sendKeys(filepath);
        
	}

	public WebElement autocompleteTextBox(String inputTxt, String atrrValue,
			String autoQuery) {
		try {

			WebElement inputText = ConstructElementByCss("#" + atrrValue);
			// wait.until(ExpectedConditions.elementToBeClickable(inputText));
			inputText.click();
			inputText.sendKeys(inputTxt);
			Thread.sleep(5000);
			WebElement autotext = ConstructElementByxpath(autoQuery);
			// wait.until(ExpectedConditions.elementToBeClickable(autotext));
			return autotext;

		}

		catch (Exception e) {
			Log.info("From page " + e.getMessage());
			return null;
		}

	}

	public String getUrlText() {
		return driver.getCurrentUrl();
	}

	public boolean IsElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean IsAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String CloseAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

}

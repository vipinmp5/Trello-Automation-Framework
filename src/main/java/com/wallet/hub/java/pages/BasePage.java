package com.wallet.hub.java.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallet.hub.java.util.JSUtilities;

public class BasePage extends BasePageGenerator {

 
    //Constructor
    public BasePage(WebDriver driver){
       super(driver);
    }
 
    WebDriverWait wait = new WebDriverWait(this.driver,20);
    
    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }
    
    public void hoverByAction (WebElement element) {
        //Asynchronous wait
    	JSUtilities.waitJQueryAngular();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    
    public void clickableBy (By by) {
        //Asynchronous wait
    	JSUtilities.waitJQueryAngular();
        //Explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void clickElement (WebElement element) {
        //Asynchronous wait
    	JSUtilities.waitJQueryAngular();
        //Explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }                                 

 
    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }
 
    //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }
 
    //Close popup if exists
    public void handlePopup (By by) throws InterruptedException {
        List<WebElement> popup = driver.findElements(by);
        if(!popup.isEmpty()){
            popup.get(0).click();
            Thread.sleep(200);
        }
    }
}


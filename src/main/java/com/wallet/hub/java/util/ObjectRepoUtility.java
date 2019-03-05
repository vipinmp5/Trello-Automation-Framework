package com.wallet.hub.java.util;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ObjectRepoUtility {
	WebDriver driver;
    private boolean acceptNextAlert = true;
    public ObjectRepoUtility(WebDriver driver)
    {
        if(this.driver==null)
        {
            this.driver = driver;
        }
        
    }
    
    public ObjectRepoUtility(WebElement frame)
    {
        if (driver == null)
        {
            driver = BrowserFactory.getDriver();
           
        }
        driver = driver.switchTo().frame(frame);
    }

    public WebElement constructTextBox(String attr, String attrValue)
    {
        return driver.findElement(By.xpath(".//*[@" + attr + "='" + attrValue + "']"));
    }

    public WebElement linksByCss(String selector)
    {
        return driver.findElement(By.cssSelector(selector));
    }

    public WebElement ConstructElementByCss(String selector)
    {
        return driver.findElement(By.cssSelector(selector));
    }

    public WebElement ConstructElementByxpath(String xpathQuery)
    {
        return driver.findElement(By.xpath(xpathQuery));
    }

    public List<WebElement> ConstructElementListByCss(String selector)
    {
        return driver.findElements(By.cssSelector(selector));
    }


    public WebElement constructButton(String attr, String attrValue)
    {
        return driver.findElement(By.cssSelector("[" + attr + "='" + attrValue + "']"));
    }

    public WebElement constructFrameByxpath(String att1, String attVal1, String att2, String attVal2)
    {
        return driver.findElement(By.xpath("//iframe[contains(@"+att1+", '"+attVal1+ "') and contains(@" + att2 + ", '" + attVal2 + "')]"));
    }

    public Select dropDownSelect(String attrValue)
    {
         WebElement element = ConstructElementByCss("#"+attrValue);
         Select objSelect = new Select(element);
        return objSelect;
    }
    
    public void enterTextJS(String selector, String input){
    	String Query="document.querySelector('"+selector+"').value='"+input+"'";
    	((JavascriptExecutor)driver).executeScript(Query);
    }


    public WebElement autocompleteTextBox(String inputTxt, String atrrValue, String autoQuery)
    {
        try
        {
           
            WebElement inputText = ConstructElementByCss("#" + atrrValue);
            //wait.until(ExpectedConditions.elementToBeClickable(inputText));
            inputText.click();
            inputText.sendKeys(inputTxt);
            Thread.sleep(5000);
            WebElement autotext = ConstructElementByxpath(autoQuery);
            //wait.until(ExpectedConditions.elementToBeClickable(autotext));
            return autotext;

        }


        catch (Exception e)
        {
            Log.info("From page "+e.getMessage());
            return null;
        }


    }

    public String getUrlText()
    {
       return driver.getCurrentUrl();
    }



    public boolean IsElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean IsAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    public String CloseAlertAndGetItsText()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert)
            {
                alert.accept();
            }
            else
            {
                alert.dismiss();
            }
            return alertText;
        }
        finally
        {
            acceptNextAlert = true;
        }
    }
    
    
}

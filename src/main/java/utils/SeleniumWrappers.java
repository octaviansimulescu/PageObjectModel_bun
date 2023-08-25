package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWrappers extends BaseTest{

    //webelement.click();

    public void click(By locator){
        System.out.println("Called method<click> on " + locator);
        try {
           // WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            returnWebElement(locator).click();
        }catch (StaleElementReferenceException e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = driver.findElement(locator);
            wait.until(ExpectedConditions.stalenessOf(element));
            element.click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public void sendKeys(By locator, String text){
        System.out.println("called method <sendkeys> on locator " + locator);
        try{
          //  WebElement element = driver.findElement(locator);
            waiForElementToBeVisible(locator);
            returnWebElement(locator).clear();
            returnWebElement(locator).sendKeys(text);
        }catch (Exception e){
            System.out.println();
        }
    }

    public void waiForElementToBeVisible(By locator){
        System.out.println("Called method <waitForElementToBeVisible");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           // WebElement element = driver.findElement(locator);
            wait.until(ExpectedConditions.visibilityOf(returnWebElement(locator)));
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public WebElement returnWebElement(By locator){
        return driver.findElement(locator);
    }


}

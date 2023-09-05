package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ScrollExample extends BaseTest {

   // @Test
    public void scrollExample() throws InterruptedException {
        //JS executor scroll

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy[0, 1000]");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy[0, -1000]");

        //action class scroll
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1000).perform();
        Thread.sleep(2000);
        actions.scrollByAmount(0, -1000).perform();
    }

   // @Test
    public void scrollToElement(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        WebElement signUpButton =driver.findElement(By.cssSelector("input[value='Sign Up']"));

        //scroll to element with JS
        //jse.executeScript("arguments[0].scrollIntoView()",signUpButton);

        //scroll to element with Actions
        //actions.moveToElement(signUpButton).perform();
        actions.scrollToElement(signUpButton).perform();

    }

    @Test
    public void scrollTopToBottom() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        //scroll down
        jse.executeScript("window.ScrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        //scroll top
        jse.executeScript("window.ScrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(3000);

        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
    }
}

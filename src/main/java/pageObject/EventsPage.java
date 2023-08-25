package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsPage {

    public WebDriver driver;
    public EventsPage(WebDriver driver){
        this.driver = driver;
    }

    public By festivalOfOldFilmsLink = By.linkText("Festival of Old Films");

    public void clickOnEvent(By locator){
        driver.findElement(locator).click();
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class WindowHandleExample extends BaseTest{

    @Test
    public void windowHandleTest() throws InterruptedException {
        app.menu.navigateTo(app.menu.eventsLink);
        app.events.clickOnEvent(app.events.festivalOfOldFilmsLink);

        app.click(app.menu.eventsLink);
        app.click(app.events.festivalOfOldFilmsLink);

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1000).perform();

        System.out.println("Current window :" + driver.getWindowHandle());
        app.genericEvent.clickMap();

        Thread.sleep(3000);
        System.out.println("Current window 2 :" + driver.getWindowHandle());

        System.out.println("ALL window :" + driver.getWindowHandles());

        List <String> browserTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTab.get(1));

        driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();

        System.out.println("Current window after switch:" + driver.getWindowHandle());

        Thread.sleep(3000);
        driver.close(); //-> inchde doar tabul curent
       // driver.quit(); ->  inchide browser indiferent de nr de ferestre deschise
        driver.switchTo().window(browserTab.get(0));

        System.out.println("Current window after tab close:" + driver.getWindowHandle());

    }

}

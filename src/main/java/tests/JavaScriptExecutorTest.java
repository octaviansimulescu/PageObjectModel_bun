package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import utils.BaseTest;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void example1(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.location='http://emag.ro'");
        //driver.get("http://emag.ro");
        //driver.navigate().to("http://emag.ro");

        //driver.navigate().back();
        jse.executeScript("window.history.go(-1)");
        driver.navigate().forward();
        jse.executeScript("window.history.forward(-1)");

        //Refresh browser
        //1
        driver.navigate().refresh();
        //2
        jse.executeScript("window.history.go(0)");
        //3
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
        driver.get(driver.getCurrentUrl());
    }

    @Test
    public void example2(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
  /*      //alternativa pentru click
        jse.executeScript("arguments[0].click",app.returnWebElement(app.menu.iconSearch));

        //alternativa pentru sendKeys
        jse.executeScript("arguments[0].value='Cooking'",app.returnWebElement(app.menu.searchField));

        //alternativa pentru click
        jse.executeScript("arguments[0].click",app.returnWebElement(app.menu.iconSearch));
        */
      /*  jse.executeScript("arguments[0].click();arguments[1].value='Cooking';arguments[0].click()"
                ,app.returnWebElement(app.menu.iconSearch),
                app.returnWebElement(app.menu.searchField));

       */
        jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");//document = dom

        jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
        jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");

        System.out.println(driver.getTitle());
        //alternativa pentru getTitle
        System.out.println("title: " +jse.executeScript("return document.title"));
        // trebuie sa pune return ca jse sa ne returneze ceva

        jse.executeScript("window.SchimbTitlul = function(){document.title = 'Alt titlu'"+
                "window.SchimbTitlul.call()");
        System.out.println("Title schimbat :" + jse.executeScript("return document.title"));

        //alternativa la hover
        String jsHover = "var obiect = document.createEvent('MouseEvent');"
                + "obiect.initMouseEvent('mouseover', true); arguments[0].dispatchEvent(obiect);";

        jse.executeScript(jsHover, app.returnWebElement(app.menu.blogLink) );
    }
}

package tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.Set;

public class CoockiesHandling extends BaseTest {

    @Test(priority = 1)
    public void getCookie(){
        System.out.println(driver.manage().getCookieNamed("PHPSESSID"));

        Cookie cookie = driver.manage().getCookieNamed("PHPSESSID");
        System.out.println(cookie);
    }

    @Test(priority = 2)
    public void addCookie(){

        Cookie cook = new Cookie("MyCookie", "My value");
        driver.manage().addCookie(cook);
        System.out.println("----------------------");
        System.out.println(driver.manage().getCookieNamed("MyCookie"));
    }

    @Test(priority = 3)
    public void getAllCookies(){
       Set<Cookie>allCookies = driver.manage().getCookies();
        System.out.println(allCookies);
    }

    @Test(priority=4)
    public void deleteCookieByName() {

        driver.manage().deleteCookieNamed("MyCookie");

        System.out.println("-----------------------------");
        Set<Cookie> allCookies= driver.manage().getCookies();
        System.out.println(allCookies);
    }

    @Test(priority = 5)
    public void deleteAllCookies() {

        driver.manage().deleteAllCookies();;

        System.out.println("-----------------------------");
        Set<Cookie> allCookies= driver.manage().getCookies();
        System.out.println(allCookies);


    }
}

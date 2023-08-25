package utils;

import pageObject.*;

public class BasePage extends SeleniumWrappers{
    public ContactPage contact = new ContactPage(driver);
    public MenuPage menu=new MenuPage(driver);
    public ShopPage shop = new ShopPage(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public EventsPage events = new EventsPage(driver);
    public GenericEventPage genericEvent = new GenericEventPage(driver);

}

package tests;

import org.testng.annotations.Test;
import pageObject.ContactPage;
import pageObject.MenuPage;
import utils.BaseTest;

public class FrameExample extends BaseTest {

    @Test(groups = "ProductFunctionality")
    public void zoomMapTest() throws InterruptedException{
        MenuPage menu = new MenuPage(driver);
        menu.navigateTo(menu.contactsLink);
        ContactPage contacts = new ContactPage(driver);
        contacts.zoomMap(contacts.zoomIn);

        app.menu.navigateTo(app.menu.contactsLink);
        app.contact.zoomMap(app.contact.zoomIn);

        Thread.sleep(3000);
    }
}

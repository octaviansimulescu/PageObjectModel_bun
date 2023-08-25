package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.MenuPage;
import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderBooksSearchTest extends BaseTest{

	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "bookNameDataProvider")
	public void searchBooksTest(String title, String picture) throws InterruptedException {
		
		MenuPage menu =  new MenuPage(driver);
		menu.search(title);
		
		Thread.sleep(2000);
		WebElement poza = driver.findElement
				(By.cssSelector("div[data-image*='"+picture+"']"));
		
		assertTrue(poza.isDisplayed());
	}
	
	
}

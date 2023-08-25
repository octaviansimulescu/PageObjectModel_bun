package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		}

	//MenuPage menu = new MenuPage(driver);
	
	//locatori
	//driver.findElement(By.cssSelector ("...."))
	public By contactsLink = By.linkText("CONTACTS");
	//WeBelement loginLInk =driver.findElement(By.cssSelector("li[class='menu_user_login']"));
	public By loginLink = By.cssSelector("li[class='menu_user_login']");
	public By shopLink =  By.linkText("BOOKS");
	public By blogLink =  By.linkText("BLOG");
	public By aboutLink =  By.linkText("ABOUT");
	public By blogSubMenuMasonry = By.xpath("//a[contains(text(), 'Masonry')]");
	public By blogSubMenuMasonrysubMenu = By.xpath("//a[contains(text(), 'Masonry 2')]");
	public By iconSearch = By.cssSelector("button[title='Open search']");
	public By searchField = By.cssSelector("input[class='search_field']");

	
	
	
	public void search(String text) {
		
		driver.findElement(iconSearch).click();
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(text);
		driver.findElement(iconSearch).click();

	}
	
	
	//metode specifice
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	
	public void hoverElement(By locator) {
		WebElement element =  driver.findElement(locator);
		Actions action =  new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	
	//MenuPage menu = new MenuPage(driver);
	//menu.navigateTo(menu.loginLink);
	//menu.navigateTo(menu.conatctsLink);

}

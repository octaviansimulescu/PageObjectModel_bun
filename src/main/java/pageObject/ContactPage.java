package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

	public WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By nameField = By.name("your-name");
	public By zoomIn = By.cssSelector("button[title='Zoom in']");
	public By zoomOut = By.cssSelector("button[title='Zoom in']");
	public By losAnglesMapFrame = By.xpath("//iframe[contains(@src, 'Los+Angeles')]");


	public void zoomMap(By locator){
		WebElement mapFrame = driver.findElement(losAnglesMapFrame);
		//driver.switchTo().frame(driver.findElement
	driver.switchTo().frame(mapFrame);

driver.findElement(locator).click();
	}
}

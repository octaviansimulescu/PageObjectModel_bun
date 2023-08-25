package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submit_button = By.cssSelector("input[class='submit_button']");
	public By loginSuccessMsg = By.cssSelector("div[class*='sc_infobox_style_success']");
	public By loginErrorMsg = By.cssSelector("div[class*='sc_infobox_style_error']");
	public By closeloginPopup = By.cssSelector("a[class='popup_close']");
	public By logoutButton = By.linkText("Logout");
	
	//metode
	public void loginInApp(String user, String pass) {
		driver.findElement(usernameField).clear();//sterge din input field
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(submit_button).click();
	}
	
	public void closePopUp() {
		driver.findElement(closeloginPopup).click();
	}
	
	public boolean loginMsgIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
	}
	
	public void logoutFromApp() {
		driver.findElement(logoutButton).click();
	}
	
}

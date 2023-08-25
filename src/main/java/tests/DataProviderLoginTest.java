package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.MenuPage;
import utils.BaseTest;

public class DataProviderLoginTest extends BaseTest {

	@DataProvider(name="loginTestData")
	public Object[][] loginTestData(){
		
	/*	String[] array =  new String[4];
		array[0] = "Ceva";
		System.out.println(array[0]);
		//String[] array =  {"ceva", null, null, null};
		String[][] array2 =  new String[2][3];
		array2[0][0] = "A";
		array2[0][1] = "B";
		array2[0][2] = "C";
		
		array2[1][0] = "D";
		array2[1][1] = "E";
		array2[1][2] = "F";
		//array2 = { {A, B, C}, {D, E, F} }
		*/
		
		Object[][] data =  new Object[4][3];
		data[0][0] = "TestUser"; 
		data[0][1] = "12345@67890";
		data[0][2] = true;
		
		data[1][0] = "userGresit"; 
		data[1][1] = "passGresit"; 
		data[1][2] = false;
		
		data[2][0] = "TestUser"; 
		data[2][1] = "12345@67890"; 
		data[2][2] = true;
		
		data[3][0] = "userGresit"; 
		data[3][1] = "passGresit"; 
		data[3][2] = false;
		
		return data;
	}
	
/*	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<Object>();
		list.add("String");
		list.add(123);
		list.add(true);
	
		for(Object elem : list) {
			System.out.println(elem);				
			}
			
		}*/
		
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username, String password, boolean success) {
		
		MenuPage menu =  new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp(username, password);
		
		if(success) {	
			assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMsg));
			login.logoutFromApp();
		}else {
			assertTrue(login.loginMsgIsDisplayed(login.loginErrorMsg));
			login.closePopUp();	
		}
		
	}
	
	
	
}

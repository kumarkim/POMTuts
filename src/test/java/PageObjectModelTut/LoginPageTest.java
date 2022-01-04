package PageObjectModelTut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FirstPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	
	LoginPage loginPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeTest()
	public void setup() {
		intiliazeDriver();
		loginPage = new FirstPage().clickOnLoginButton();
		
	}
	
	@AfterTest()
	public void teardown() {
		driver.quit();
		
	}
	
	@Test
	public void LoginTest() {
		String userName = configProp.getUsername();
		String pwd = configProp.getPassword();
		
		loginPage.login(userName, pwd);
	}

}

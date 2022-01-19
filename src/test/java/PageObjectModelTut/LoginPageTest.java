package PageObjectModelTut;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FirstPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	
	LoginPage loginPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setup() {
	System.out.println("Before test called for login Page test");
		intiliazeDriver();
		loginPage = new FirstPage().clickOnLoginButton();
		
	}
	
	@AfterMethod()
	public void teardown() {
		System.out.println("After test called for login Page test");
		driver.quit();
		
	}
	
	@Test
	public void LoginTest(Method method) {
		System.out.println("Method under test"+ method.getName());
		String userName = configProp.getUsername();
		String pwd = configProp.getPassword();
		HomePage homepage =loginPage.login(userName, pwd);	
	}
	

}

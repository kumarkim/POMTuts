package PageObjectModelTut;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.FirstPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	
	
	HomePageTest(){
		super();
	}
	
	@Parameters("browerName")
	@BeforeMethod
	public void setup(Method method,@Optional("firefox") String browserName) {

		String browser = browserName;
		System.out.println("Starting Driver :Before method called for :" + method.getName());
		String browserfromMaven = System.getProperty("browser");
		if (browserfromMaven != null) {
			System.out.println("Browser from maven=" + browserfromMaven);
			browser = browserfromMaven;
		}
		intiliazeDriver(browser);
		loginPage =new FirstPage().clickOnLoginButton();
		homePage =loginPage.login(configProp.getUsername(), configProp.getPassword());
	}
	
	@Test(enabled = false)
	public void verifyHomePageTitle() {
		String expectedTitle = "Cogmento CRM";
		Assert.assertEquals(driver.getTitle(), expectedTitle,"");
		
	}
	
	@Test(enabled = false)
	public void verifyCompnayName() {
		
		String expectedTitle = "ABC";
		String actualComanyName = homePage.getCompanyName();
		System.out.println(actualComanyName);
		Assert.assertEquals(actualComanyName, expectedTitle,"Company Name Mismatch");
	}
	
	@Test(enabled = true)
	public void clickOnContatsPage() {
		ContactsPage contactsPage = homePage.clickOnContacts();
		System.out.println("contactsPageTitle ="+contactsPage.getCnctPageTitle());
		String actualTitle = contactsPage.getCnctPageTitle();
		Assert.assertEquals(actualTitle, "Contacts","ContactsPageTitle didnot match");
	}
	
	@Test(enabled = true)
	public void retryFailedtestCase() {
		System.out.println("Retrying failed testcase");
		Assert.assertEquals("actual", "expected");
	}
	
	@AfterMethod
	public void tearDown(Method method) {
		System.out.println("After method called for "+ method.getName());
		driver.quit();
	}
  
}

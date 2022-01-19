package PageObjectModelTut;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FirstPage;
import com.qa.pages.LoginPage;
import com.qa.util.Config;
;

public class FirstPageTest extends TestBase {

	FirstPage firstpage;
	Config prop = Config.getInstance();

	public FirstPageTest() {
		super();

	}

	@BeforeMethod
	public void setup(Method method) {
		System.out.println("Starting Driver :Before method called for :"+method.getName());
		intiliazeDriver();
		firstpage = new FirstPage();
	}

	@Test(priority = 1, enabled =true)
	public void verifyFirstPageTitle(Method method) {
		System.out.println("Method under test"+ method.getName());
		String expectedtTitle = "#1 Free CRM customer relationship management software cloud";
		String actualTitle = firstpage.getFirstPageTitle();
		Assert.assertEquals(actualTitle, expectedtTitle);
	}

	@Test(priority = 2)
	public void clickSigninAndVerifyLoginpageTitle(Method method) {
		System.out.println("Method under test"+ method.getName());
		LoginPage loginPage = firstpage.clickOnLoginButton();
		String expectedTitle = "Cogmento CRM";
		String actualloginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualloginPageTitle, expectedTitle);
		
	}
	
	@Test(priority = 2)
	public void NegativeTest(Method method) {
		System.out.println("Method under test"+ method.getName());
		Assert.assertEquals("negative", "postive");
		
	}

	@AfterMethod
	public void tearDown(Method method) {
		
		System.out.println("Qutting Driver:After Method called"+method.getName());
		driver.quit();
	}
}

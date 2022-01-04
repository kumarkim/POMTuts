package PageObjectModelTut;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FirstPage;
import com.qa.pages.LoginPage;
import com.qa.util.Config;

public class FirstPageTest extends TestBase {

	FirstPage firstpage;
	Config prop = Config.getInstance();

	public FirstPageTest() {
		super();

	}

	@BeforeMethod
	public void test() {
		System.out.println("Before method called");
		intiliazeDriver();
		firstpage = new FirstPage();
	}

	@Test(priority = 1, enabled =true)
	public void verifyFirstPageTitle() {
		String expectedtTitle = "#1 Free CRM customer relationship management software cloud";
		String actualTitle = firstpage.getFirstPageTitle();
		Assert.assertEquals(actualTitle, expectedtTitle);
	}

	@Test(priority = 2)
	public void clickSigninAndVerifyLoginpageTitle() {
		LoginPage loginPage = firstpage.clickOnLoginButton();
		String expectedTitle = "Cogmento CRM";
		String actualloginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualloginPageTitle, expectedTitle);
		
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Thread=" + Thread.currentThread().getName());
		System.out.println("After Method called");
		driver.quit();
	}
}

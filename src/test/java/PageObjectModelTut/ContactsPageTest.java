package PageObjectModelTut;

import com.qa.base.TestBase;
import com.qa.pages.FirstPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.ExcelUtil;
import com.qa.pages.ContactsPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage cnctPage;
	
	
	public ContactsPageTest() {
		super();
		System.out.println("Constructing Contacts Page");
		
	}
	
	@BeforeMethod
	public void setup() {
		intiliazeDriver();
		FirstPage firstpage = new FirstPage();
		loginPage = firstpage.clickOnLoginButton();
		homePage =loginPage.login(configProp.getUsername(), configProp.getPassword());
		cnctPage = homePage.clickOnContacts();
	}
	
	@AfterMethod
	public void teadDown() {
		driver.quit();
	}
	
	@Test(enabled= false)
	public void verifyContactPageTitle() {
		String actualTitle = cnctPage.getCnctPageTitle();
		String expectedTitle = "Contacts";
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	
	@DataProvider(name ="CRMdata")
	public Object[][] getCRMData() {
		ExcelUtil util = new ExcelUtil();
		Object[][] data = null;
		try {
			data = util.getData("freeCrm");
		} catch (IOException e) {
			System.out.println("Unable to fetch data from excel sheet");
		}
		return data;
	}
	
	@Test(dataProvider="CRMdata")
	public void verifyClickonContactsIcon(String fname, String Lname, String status) throws InterruptedException {
		System.out.println("Testing click on Contacts Page");
		cnctPage.addNewContact(fname, Lname, status);
		System.out.println("ClickedOnAddContacts");
	}

}

package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.SeleniumUtils;

public class LoginPage extends TestBase {

	SeleniumUtils utils ;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement signIn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
		utils = SeleniumUtils.getInstance();
		
	}

	public void enterUsername(String userName) {
		
		selUtils.waituntilDocumentLoad(driver);
		selUtils.sendKeysUsingExplicitWait(email, driver, userName);
	
	}

	public void enterPwd(String pswd) {
		selUtils.waituntilDocumentLoad(driver);
		pwd.sendKeys(pswd);
	}
	
	public HomePage login(String userName, String Password) {
		selUtils.waituntilDocumentLoad(driver);
		System.out.println("Logging into HomePage");
		
		enterUsername(userName);
		enterPwd(Password);
		signIn.click();
		return new HomePage();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}

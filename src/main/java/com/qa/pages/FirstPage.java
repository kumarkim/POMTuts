package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FirstPage extends TestBase {

	@FindBy(xpath="//span[text()='Log In']")
	WebElement login;
	
	@FindBy(partialLinkText="https://register.freecrm.com/register/")
	WebElement signUp;
	
	public FirstPage(){
		super();
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnLoginButton(){
		login.click();
		return new LoginPage();
	}
	
	public String getFirstPageTitle(){
		return driver.getTitle();
	}
	
}

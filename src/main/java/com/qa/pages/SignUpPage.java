package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SignUpPage extends TestBase {

	public SignUpPage() {
		PageFactory.initElements(driver, SignUpPage.class);
	}
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	public void enterFirstName() {
		firstname.sendKeys("Kim");
	}
	
	public void enterUserName() {
		
	}

}

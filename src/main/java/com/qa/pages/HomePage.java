package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.annotations.SerializedName;
import com.qa.base.TestBase;
import com.qa.util.SeleniumUtils;

import bsh.This;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@id='top-header-menu']/b")
	WebElement compnayName;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contacts;

	public HomePage() {
		super();
		PageFactory.initElements(driver,this);
		System.out.println("Constructng page factory for homepage");

	}

	public String getHomepageTitle() {
		return driver.getTitle();
	}

	public String getCompanyName() {
	
		selUtils.explicitWaitfoElem(compnayName, driver);
		return compnayName.getText();
	}
	
	public ContactsPage clickOnContacts() {
		 contacts.click();
		return new ContactsPage();
	}
}

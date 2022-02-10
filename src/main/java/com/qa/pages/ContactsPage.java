package com.qa.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {
	//.ui.header.item.mb5.light-black
	@FindBy(css=".ui.header.item.mb5.light-black")
	WebElement cnctPageTitle;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contacts;
	
	@FindBy(linkText="/contacts/new")
	WebElement createContacts;
	
	@FindBy(xpath="//a[contains(@href,'/contacts/new')]/button")
	WebElement createContacts2;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(name="status")
	WebElement status;
	
	@FindBy(xpath="//span[text()='Active']")
	WebElement active;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveContacts;

	
	@FindBy(xpath = "a[contains(@href, 'contacts')]/following-sibling::button/i[contains(@class, 'inverted')]")
	WebElement addContactsIcon;

	
	public ContactsPage() {
		super();
		PageFactory.initElements(driver,this);	
		System.out.println("In the constructor");
	}
	
	public String getCnctPageTitle(){
		return cnctPageTitle.getText();
	}
	
	public void addNewContact(String fname, String lname, String status2) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(createContacts2).click().perform();
		addFirstname(fname);
		addLastName(lname);
		addStatus(status2);
		keywords.clickOnButton(saveContacts);
		Thread.sleep(5000);
	}

	private void addStatus(String statusActive) {
		keywords.clickOnButton(status);
		selUtils.explicitWaitfoElem(active, driver);
		keywords.clickOnButton(active);
		
	}

	private void addFirstname(String fname) {
		selUtils.explicitWaitfoElem(firstName, driver);
		keywords.sendKeys(firstName, fname);
	}

	private void addLastName(String lname) {
		selUtils.explicitWaitfoElem(lastName, driver);
		keywords.sendKeys(lastName, lname);
		
	}

}

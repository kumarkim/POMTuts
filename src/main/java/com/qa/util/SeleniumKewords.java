package com.qa.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumKewords {

	private SeleniumKewords() {
	}

	private static class ObjectHOLDER {
		private static SeleniumKewords instance = new SeleniumKewords();
	}
	
	public static SeleniumKewords getInstance() {
		return SeleniumKewords.ObjectHOLDER.instance;
		
	}
	
	public void clickOnButton(WebElement elem) {
		elem.click();
	}
	
	public void sendKeys(WebElement elem,String msg) {
		elem.sendKeys(msg);
	}
}
	
	

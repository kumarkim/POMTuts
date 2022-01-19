package com.qa.util;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class SeleniumUtils {

	private SeleniumUtils() {

	}

	private static class ObjectHolder {
		private static SeleniumUtils instance = new SeleniumUtils();
	}

	public static SeleniumUtils getInstance() {
		return ObjectHolder.instance;
	}

	public void sendKeysUsingExplicitWait(final WebElement elem, WebDriver driver, String msg) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver t) {
				ExpectedConditions.visibilityOf(elem);
				return elem;
			}
		}).sendKeys(msg);
	}

	public void explicitWaitfoElem(WebElement elem, WebDriver driver) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(elem));
		System.out.println("Explicity waiting for eleme to get over");
	}

	public void waituntilDocumentLoad(WebDriver driver) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);

		wait.until((d) -> {
			boolean some = ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
			return some;
		});

		System.out.println("wait over");
	}

	public void clickUsingJS(WebDriver driver, WebElement elem) {
		
		JavascriptExecutor exec = (JavascriptExecutor) driver ;
		exec.executeAsyncScript("arguments[0].click();", elem);
	}
}

/*
 * wait.until(new Function<WebDriver, Boolean>() {
 * 
 * @Override public Boolean apply(WebDriver webdriver) { ((JavascriptExecutor)
 * webdriver).executeScript("return document.readyState").equals("complete");
 * return true; } });
 */
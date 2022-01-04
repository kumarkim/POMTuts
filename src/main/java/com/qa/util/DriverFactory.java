package com.qa.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.constants.SeleniumConstants;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	Config prop = Config.getInstance();

	private DriverFactory() {

	}

	private static class ObjectHolder {
		private static DriverFactory instance = new DriverFactory();

	}

	public static DriverFactory getInstance() {
		return ObjectHolder.instance;
	}

	public void intiDriver(String localBrowser) {
		WebDriver driver = null;
		String browser = prop.getBrowser();
		if (browser.equals(SeleniumConstants.CHROME)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			tDriver.set(driver);
		}

		if (browser.equals(SeleniumConstants.FIREFOX)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			tDriver.set(driver);
		}

		driver.manage().timeouts().pageLoadTimeout(SeleniumConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Options opt = driver.manage();
		Timeouts timeout = opt.timeouts();
		timeout.implicitlyWait(SeleniumConstants.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}

	public synchronized WebDriver getDriver() {
		System.out.println("Driver started in thread:"+ Thread.currentThread().getName());
		return tDriver.get();

	}

}

package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.constants.SeleniumConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactoryOld {

	ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	Config prop = Config.getInstance();
	String url = "http://localhost:4444/wd/hub";

	private DriverFactoryOld() {

	}

	private static class ObjectHolder {
		private static DriverFactoryOld instance = new DriverFactoryOld();

	}

	public static DriverFactoryOld getInstance() {
		return ObjectHolder.instance;
	}

	public void intiDriver(String localBrowser) throws IOException {
		WebDriver driver = null;
		Boolean isRemote = prop.getRemote();
		String browser = prop.getBrowser();
		if (browser.equals(SeleniumConstants.CHROME)) {
			if (isRemote) {

			} else {
				String dPath = "./drivers/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", dPath);
				// WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			tDriver.set(driver);
		}

		if (browser.equals(SeleniumConstants.FIREFOX)) {
			if (isRemote) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(BrowserType.FIREFOX);
				driver = new RemoteWebDriver(new URL(url), capabilities);
			} else {
				String dPath = "./drivers/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", dPath);
				// WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			tDriver.set(driver);
		}

		driver.manage().timeouts().pageLoadTimeout(SeleniumConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Options opt = driver.manage();
		Timeouts timeout = opt.timeouts();
		timeout.implicitlyWait(SeleniumConstants.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}

	public synchronized WebDriver getDriver() {
		System.out.println("Driver started in thread:" + Thread.currentThread().getName());
		return tDriver.get();

	}

	
}

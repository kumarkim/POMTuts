package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.constants.SeleniumConstants;
import com.qa.util.Config;
import com.qa.util.DriverFactory;

public class TestBase {

	public static WebDriver driver;
	public static Config configProp;

	DriverFactory dFactoryInstance;

	public TestBase() {
		configProp = Config.getInstance();
	}

	public void intiliazeDriver() {
		dFactoryInstance = DriverFactory.getInstance();
		dFactoryInstance.intiDriver(SeleniumConstants.CHROME);
		driver = dFactoryInstance.getDriver();
		driver.get(configProp.getUrl());
	}
	
}

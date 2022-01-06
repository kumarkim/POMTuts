package com.qa.base;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.constants.SeleniumConstants;
import com.qa.util.Config;
import com.qa.util.DockerCompose;
import com.qa.util.DriverFactory;




public class TestBase {

	public static WebDriver driver;
	public static Config configProp;

	DriverFactory dFactoryInstance;

	public TestBase() {
		configProp = Config.getInstance();
	}

	public void intiliazeDriver() {
		try {
		dFactoryInstance = DriverFactory.getInstance();
		dFactoryInstance.intiDriver("");
		driver = dFactoryInstance.getDriver();
		driver.get(configProp.getUrl());
		}
		catch(Exception e) {
			System.out.println("Exception in intitializing Driver");
			System.out.println(e.getMessage());
		}
	}
	
	@BeforeSuite
	public void dockerComposeUp() {
		try {
			DockerCompose.startDocker();
		} catch (IOException | InterruptedException e) {
			System.out.println("Error in docker compose UP");
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void dockerComposeDown() {
		try {
			DockerCompose.stoptDocker();
		} catch (IOException | InterruptedException e) {
			System.out.println("Error in docker compose DOWN");
			e.printStackTrace();
		}
	}

	
}

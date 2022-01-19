package com.qa.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.constants.SeleniumConstants;
import com.qa.util.Config;
import com.qa.util.DockerCompose;
import com.qa.util.SeleniumUtils;

import AbstractDriverFactory.AbstractDriverFactory;

public class TestBase {

	public static WebDriver driver;
	public static Config configProp;
	String remptoteURL = "http://localhost:4444/wd/hub";
	Boolean remote;
	public SeleniumUtils selUtils;

	public TestBase() {
		configProp = Config.getInstance();
		remote = configProp.getRemote();
		selUtils = SeleniumUtils.getInstance();
	}

	public void intiliazeDriver() {
		try {
			String driverType = configProp.getBrowser();
			driver = new AbstractDriverFactory().creatDriver(driverType, remote, remptoteURL);
			driver.get(configProp.getUrl());
		} catch (Exception e) {
			System.out.println("Exception in intitializing Driver");
			System.out.println(e.getMessage());
		}
	}

	@BeforeSuite
	public void dockerComposeUp() {
		try {
			if (remote) {
				DockerCompose.startDocker();
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Error in docker compose UP");
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setups() {
		System.out.println("another before suite");
	}

	@AfterSuite
	public void dockerComposeDown() {
		try {
			if (remote) {
				DockerCompose.stoptDocker();
			}

		} catch (IOException | InterruptedException e) {
			System.out.println("Error in docker compose DOWN");
			e.printStackTrace();
		}
	}

}

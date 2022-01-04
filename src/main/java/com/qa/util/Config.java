package com.qa.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	
	Properties prop = null;
	private Config() {
		try {
		prop = new Properties();
		prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
		}
		catch(Exception e) {
			System.out.println("Unable to load properties file" + e.getMessage());
		}
	}
	private static class ObjectHolder{
		final static Config config = new Config();
	}
	public static Config getInstance() {
		return ObjectHolder.config;
	}
	
	public String getBrowser() {
		String browser =  (String) prop.get("browser");
		return browser;
	}
	
	public String getUrl() {
		String url =  (String) prop.get("url");
		return url;
	}
	
	public String getUsername() {
		String uName =  (String) prop.get("username");
		return uName;
	}
	
	public String getPassword() {
		String uName =  (String) prop.get("password");
		return uName;
	}
}

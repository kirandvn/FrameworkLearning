package com.learning.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class AppProperties {

	Properties prop;

	public AppProperties() {

		File src = new File("./Config/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Issue loading properties file" + e.getMessage());
		}
	}

	public String getBrowserFromProp() {
		String browser = prop.getProperty("browser");
		return browser;
	}

	public String getAppURLFromProp() {
		String appURL = prop.getProperty("appURL");
		return appURL;
	}
	
	public String getValueFromProp(String key) {
		String value = prop.getProperty(key);
		return value;
	}

}

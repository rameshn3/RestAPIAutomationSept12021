package com.qa.api.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public String readPropertyValue(String key) throws IOException {
		//Create Object for Properties class
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\api\\config\\config.properties");
			
			prop.load(fis);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}

		return prop.getProperty(key);

	}
	
	
	
}

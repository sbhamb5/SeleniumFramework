package com.appname.qa.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public ConfigReader() {
		prop = new Properties();
		try {
			InputStream ip = ConfigReader.class.getClassLoader()
					.getResourceAsStream("com\\appname\\qa\\config\\config.properties");
			prop.load(ip);
			ip.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String GetUserName() {
		return prop.getProperty("userName");
	}

	public String GetPassword() {
		return prop.getProperty("password");
	}

	public String GetDriverType() {
		return prop.getProperty("driver");
	}

	public String GetURL() {
		return prop.getProperty("URL");
	}

	public int GetimplicitlyWaitFor() {
		return Integer.parseInt(prop.getProperty("implicitlyWait"));
	}

}

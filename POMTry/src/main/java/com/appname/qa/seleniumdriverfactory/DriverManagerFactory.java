package com.appname.qa.seleniumdriverfactory;

import com.appname.qa.seleniumdrivers.ChromeDriverManager;
import com.appname.qa.seleniumdrivers.EdgeDriverManager;
import com.appname.qa.seleniumdrivers.FirefoxDriverManager;
import com.appname.qa.seleniumdrivers.HeadlessDriverManager;
import com.appname.qa.seleniumdrivers.IEDriverManager;

public class DriverManagerFactory {

	public static DriverManager GetManager(DriverType driverType) {
		DriverManager driverManager = null;
		switch (driverType) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case IE:
			driverManager = new IEDriverManager();
			break;
		case EDGE:
			driverManager = new EdgeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case HEADLESS:
			driverManager = new HeadlessDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}

}

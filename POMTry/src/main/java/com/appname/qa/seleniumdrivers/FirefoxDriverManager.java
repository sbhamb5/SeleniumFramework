package com.appname.qa.seleniumdrivers;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.appname.qa.seleniumdriverfactory.DriverManager;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void CreateDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
	}
}

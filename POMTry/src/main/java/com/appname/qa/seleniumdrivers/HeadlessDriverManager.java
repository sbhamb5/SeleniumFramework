package com.appname.qa.seleniumdrivers;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.appname.qa.seleniumdriverfactory.DriverManager;

public class HeadlessDriverManager extends DriverManager {

	@Override
	protected void CreateDriver() {
		if (driver == null) {
			driver = new HtmlUnitDriver();
		}
	}
}
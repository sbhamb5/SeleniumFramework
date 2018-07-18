package com.appname.qa.seleniumdrivers;

import org.openqa.selenium.edge.EdgeDriver;

import com.appname.qa.seleniumdriverfactory.DriverManager;

public class EdgeDriverManager extends DriverManager {

	@Override
	protected void CreateDriver() {
		if (driver == null) {
			driver = new EdgeDriver();
		}
	}

}

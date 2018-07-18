package com.appname.qa.seleniumdrivers;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.appname.qa.seleniumdriverfactory.DriverManager;

public class IEDriverManager extends DriverManager {

	@Override
	protected void CreateDriver() {
		if (driver == null) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
			options.enableNativeEvents();
			options.destructivelyEnsureCleanSession();
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

			driver = new InternetExplorerDriver(options);
		}
	}

}

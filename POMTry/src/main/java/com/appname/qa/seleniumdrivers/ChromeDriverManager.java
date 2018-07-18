package com.appname.qa.seleniumdrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.appname.qa.seleniumdriverfactory.DriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void CreateDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("testy-type");
			driver = new ChromeDriver(options);
		}
	}

}

package com.appname.qa.seleniumdriverfactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;

	protected abstract void CreateDriver();

	public WebDriver GetDriver() {
		if (driver == null) {
			CreateDriver();
		}
		return driver;
	}

	public void QuitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}

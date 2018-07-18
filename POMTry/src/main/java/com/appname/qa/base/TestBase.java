package com.appname.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.appname.qa.config.ConfigReader;
import com.appname.qa.seleniumdriverfactory.DriverManager;
import com.appname.qa.seleniumdriverfactory.DriverManagerFactory;
import com.appname.qa.seleniumdriverfactory.DriverType;

public class TestBase {
	protected static DriverManager driverManager;
	protected static WebDriver driver;

	protected static ConfigReader cReader;

	public TestBase() {
		cReader = new ConfigReader();

	}

	public static void initialize() {

		driverManager = DriverManagerFactory.GetManager(DriverType.valueOf(cReader.GetDriverType()));
		driver = driverManager.GetDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(cReader.GetimplicitlyWaitFor(), TimeUnit.SECONDS);

		driver.get(cReader.GetURL());
	}

}

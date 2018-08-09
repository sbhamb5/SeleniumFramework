package com.appname.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.config.ConfigReader;
import com.appname.qa.seleniumdriverfactory.DriverManager;
import com.appname.qa.seleniumdriverfactory.DriverManagerFactory;
import com.appname.qa.seleniumdriverfactory.DriverType;
import com.appname.steps.LoginSteps;

public class TestBase {
	protected static DriverManager driverManager;
	protected static WebDriver driver;
	protected static ConfigReader cReader;

	public static void initialize() {

		driverManager = DriverManagerFactory.GetManager(DriverType.valueOf(cReader.GetDriverType()));
		driver = driverManager.GetDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(cReader.GetimplicitlyWaitFor(), TimeUnit.SECONDS);

		driver.get(cReader.GetURL());
	}

	protected LoginSteps loginSteps;

	public TestBase() {
		cReader = new ConfigReader();
	}

	protected String GetPageMsg(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}

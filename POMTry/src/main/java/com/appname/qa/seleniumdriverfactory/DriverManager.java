package com.appname.qa.seleniumdriverfactory;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;
	protected abstract void CreateDriver();
	
	public void QuitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
		}		
	}
	
	public WebDriver GetDriver()
	{
		if (driver==null)
		{
			CreateDriver();
		}
		return driver;
	}

}

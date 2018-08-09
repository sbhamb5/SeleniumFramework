package com.appname.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	// Initializing the page objects
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

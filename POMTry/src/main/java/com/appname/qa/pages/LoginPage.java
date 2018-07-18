package com.appname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appname.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PAge Factory : Object Repository
	@FindBy(name = "email")
	WebElement txtUserName;

	@FindBy(name = "pass")
	WebElement txtPassword;

	@FindBy(id = "loginbutton")
	WebElement btnLogin;

	public String GetTitle() {
		return driver.getTitle();
	}

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login() {
		txtUserName.sendKeys(cReader.GetUserName());
		txtPassword.sendKeys(cReader.GetPassword());
		btnLogin.click();
	}

}

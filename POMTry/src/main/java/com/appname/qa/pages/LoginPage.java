package com.appname.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#edit-name[name='name']")
	public WebElement txtUserName;

	// Page Factory : Object Repository

	@FindBy(css = "#edit-pass[name='pass']")
	public WebElement txtPassword;

	@FindBy(css = "#edit-submit")
	public WebElement btnLogin;

	@FindBy(css = "div[class= 'alert alert-block alert-danger']")
	public WebElement errorMsg;

	@FindBy(css = "div[class= 'alert alert-block alert-success']")
	public WebElement successMsg;

	@FindBy(css = "a[href='/home/403160/user/password']")
	public WebElement tabRequestNewPassword;

	@FindBy(css = "label[for='edit-name']")
	public WebElement labelForUserName;

	@FindBy(css = "#edit-submit[value=\"E-mail new password\"]")
	WebElement btnNewLogin;

}

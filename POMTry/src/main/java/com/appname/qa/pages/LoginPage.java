package com.appname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory : Object Repository

	@FindBy(xpath = "//input[@name='email' and @class='inputtext']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@name='pass' and @class='inputtext']")
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(txtUserName)).sendKeys(cReader.GetUserName());
		wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(cReader.GetPassword());
		btnLogin.click();
	}

	public void login(String userName, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(txtUserName)).sendKeys(userName);
		wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
	}

}

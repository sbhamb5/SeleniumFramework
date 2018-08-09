package com.appname.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.LoginPage;
import com.appname.qa.pages.PageObjectManager;

public class LoginSteps extends TestBase {
	PageObjectManager pageObjectManager;
	LoginPage loginPage;

	public LoginSteps() {
		super();
		pageObjectManager = new PageObjectManager(driver);
		loginPage = pageObjectManager.getLoginPage();
	}

	public String GetErrorMsg() {
		return GetPageMsg(loginPage.errorMsg);
	}

	// public void login() {
	// WebDriverWait wait = new WebDriverWait(driver, 10);
	// System.out.println(loginPage.txtUserName.getTagName());
	// wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtUserName)).sendKeys(cReader.GetUserName());
	// wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtPassword)).sendKeys(cReader.GetPassword());
	// loginPage.btnLogin.click();
	// }

	public String GetSuccessMsg() {
		return GetPageMsg(loginPage.successMsg);
	}

	public void login(String userName, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtUserName)).sendKeys(userName);
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtPassword)).sendKeys(password);
		loginPage.btnLogin.click();
	}

	public void requestNewPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		loginPage.tabRequestNewPassword.click();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.labelForUserName));
		if (loginPage.labelForUserName.getText().contains("Username or e-mail address")) {
			wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtUserName)).sendKeys(cReader.GetEmail());
			loginPage.btnLogin.click();
		}
	}

}

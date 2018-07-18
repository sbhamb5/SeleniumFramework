package com.appname.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.LoginPage;

public class LoginTests extends TestBase {

	LoginPage loginPage;

	public LoginTests() {
		super();
	}

	@Test(priority = 1)
	public void verifyLogin() {
		loginPage.login();
	}

	@BeforeMethod
	public void beforeMethod() {
		initialize();
		loginPage = new LoginPage();
		System.out.println(loginPage.GetTitle());
		Assert.assertTrue(loginPage.GetTitle().contains("Facebook"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();

	}

}

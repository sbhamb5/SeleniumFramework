package com.appname.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.LoginPage;
import com.appname.qa.testdata.LoginDataModel;

public class LoginTests extends TestBase {

	LoginPage loginPage;

	public LoginTests() {
		super();
	}

	@Test(priority = 1, timeOut = 10000)
	public void verifyLogin() {
		loginPage.login();
	}

	@Test(priority = 1, dataProvider = "loginDataOject")
	public void verifyLoginDD(LoginDataModel loginData) {
		loginPage.login(loginData.getUserName(), loginData.getPassword());
		Assert.assertTrue(loginPage.GetTitle().contains("Facebook"));
	}

	@DataProvider(name = "loginDataOject")
	public Object[][] loginDataOject() {

		Object[][] data = new Object[3][2];

		data[0] = new Object[] { new LoginDataModel("user1", "Pass1") };
		data[1] = new Object[] { new LoginDataModel("user2", "Pass2") };
		data[2] = new Object[] { new LoginDataModel("user3", "Pass3") };

		return data;
	}

	@BeforeMethod
	public void beforeMethod() {
		initialize();
		loginPage = new LoginPage();
		System.out.println(loginPage.GetTitle());
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}

package com.appname.qa.tests;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.steps.LoginSteps;

public class LoginTests extends TestBase {

	// LoginSteps loginSteps;

	public LoginTests() {
		super();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		initialize();
		loginSteps = new LoginSteps();
	}

	private String generateRandomString() {
		String aToZ = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rand = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			int randIndex = rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}

	@Test(priority = 1)
	public void verifyInvalidLogin() {
		loginSteps.login(generateRandomString(), generateRandomString());
		Assert.assertTrue(loginSteps.GetErrorMsg().contains("Sorry, unrecognized username or password"));
	}

	@Test
	public void verifyRequestNewPassword() {
		loginSteps.requestNewPassword();
		Assert.assertTrue(
				loginSteps.GetSuccessMsg().contains("Further instructions have been sent to your e-mail address."));
	}

}

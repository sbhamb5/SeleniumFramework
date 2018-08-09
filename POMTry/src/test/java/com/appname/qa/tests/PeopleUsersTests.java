package com.appname.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.steps.DashBoardSteps;
import com.appname.steps.LoginSteps;
import com.appname.steps.PeopleUsersSteps;

public class PeopleUsersTests extends TestBase {
	DashBoardSteps dashBoardSteps;
	PeopleUsersSteps peopleUsersSteps;

	public PeopleUsersTests() {
		super();
	}

	@AfterMethod
	public void afterMethod() {
		// TODO : Delete the uploaded user
		driver.close();
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		initialize();
		loginSteps = new LoginSteps();
		dashBoardSteps = new DashBoardSteps();
		peopleUsersSteps = new PeopleUsersSteps();
	}

	@Test
	public void verifyImportParticipants() {
		loginSteps.login(cReader.GetUserName(), cReader.GetPassword());
		Assert.assertTrue(dashBoardSteps.getPageTitle().contains("My dashboard"));
		dashBoardSteps.openPeopleUsers();
		Assert.assertTrue(peopleUsersSteps.getPageTitle().contains("Users"));
		peopleUsersSteps.ImportParticipants();
		Assert.assertTrue(peopleUsersSteps.GetSuccessMsg().contains("Updated 1 user."));
	}

}

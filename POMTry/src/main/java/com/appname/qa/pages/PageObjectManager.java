package com.appname.qa.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	WebDriver driver;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	PeopleUsersPage peopleUsersPage;
	ImportParticipantsPage importParticipantsPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public DashBoardPage getDashBoardPage() {
		if (dashBoardPage == null) {
			dashBoardPage = new DashBoardPage(driver);
		}
		return dashBoardPage;
	}

	public ImportParticipantsPage getImportParticipantsPage() {
		if (importParticipantsPage == null) {
			importParticipantsPage = new ImportParticipantsPage(driver);
		}
		return importParticipantsPage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

	public PeopleUsersPage getPeopleUsersPage() {
		if (peopleUsersPage == null) {
			peopleUsersPage = new PeopleUsersPage(driver);
		}
		return peopleUsersPage;
	}

}

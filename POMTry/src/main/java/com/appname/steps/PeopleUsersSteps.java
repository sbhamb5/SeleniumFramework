package com.appname.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.ImportParticipantsPage;
import com.appname.qa.pages.PageObjectManager;
import com.appname.qa.pages.PeopleUsersPage;

public class PeopleUsersSteps extends TestBase {
	PageObjectManager pageObjectManager;
	PeopleUsersPage peopleUsersPage;
	ImportParticipantsPage importParticipantsPage;

	public PeopleUsersSteps() {
		super();
		pageObjectManager = new PageObjectManager(driver);
		peopleUsersPage = pageObjectManager.getPeopleUsersPage();
		importParticipantsPage = pageObjectManager.getImportParticipantsPage();
	}

	public String GetSuccessMsg() {
		return GetPageMsg(peopleUsersPage.successMsg);
	}

	public void ImportParticipants() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(peopleUsersPage.btnImportParticipants)).click();

		File fileToImport = new File("src\\main\\java\\com\\appname\\qa\\testdata\\Participants.csv");
		String path = fileToImport.getAbsolutePath();
		System.out.println(path);

		if (wait.until(ExpectedConditions.titleContains(("Import Participants")))) {
			importParticipantsPage.btnBrowse.click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.switchTo().activeElement().sendKeys(path);

			wait.until(ExpectedConditions.elementToBeClickable(importParticipantsPage.btnImport)).click();
		}

	}

}

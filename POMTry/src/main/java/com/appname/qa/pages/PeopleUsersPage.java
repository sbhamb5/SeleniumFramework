package com.appname.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PeopleUsersPage extends BasePage {

	public PeopleUsersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a[href='/home/403160/admin/people/import-participants']")
	public WebElement btnImportParticipants;

	@FindBy(css = "div[class= 'alert alert-block alert-success']")
	public WebElement successMsg;

}

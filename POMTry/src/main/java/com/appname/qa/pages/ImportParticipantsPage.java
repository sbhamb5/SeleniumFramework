package com.appname.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportParticipantsPage extends BasePage {

	public ImportParticipantsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#edit-feeds-feedsfilefetcher-upload")
	public WebElement btnBrowse;

	@FindBy(css = "span[class='input-group-btn'] input")
	public WebElement inpBrowseFile;

	@FindBy(css = "#edit-submit")
	public WebElement btnImport;

	@FindBy(css = "div[class='alert alert-block alert-success']")
	public WebElement successMsg;
}

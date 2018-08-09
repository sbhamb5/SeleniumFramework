package com.appname.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.DashBoardPage;
import com.appname.qa.pages.PageObjectManager;

public class DashBoardSteps extends TestBase {
	PageObjectManager pageObjectManager;
	DashBoardPage dashBoardPage;

	public DashBoardSteps() {
		super();
		pageObjectManager = new PageObjectManager(driver);
		dashBoardPage = pageObjectManager.getDashBoardPage();
	}

	public void clickOnSubMenu(String subMenu) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String xpathExpression = String.format("//a[text()='%s']", subMenu);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression))).click();
	}

	public void clickParentNav(String menu) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		String cssSelector = String.format("a[href='/home/403160/%s']", menu);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector))).click();
	}

	public void openPeopleUsers() {
		clickParentNav("people");
		clickOnSubMenu("Users");
	}

}

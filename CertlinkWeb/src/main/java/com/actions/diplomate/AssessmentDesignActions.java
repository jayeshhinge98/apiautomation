package com.actions.diplomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.google.common.base.CharMatcher;
import com.uielements.diplomate.DAssessmentDesignUI;
import com.uielements.diplomate.DDashboardUI;
import com.utilities.TestUtitlies;

public class AssessmentDesignActions {

	DDashboardUI dd = new DDashboardUI();
	CommonActions ca = new CommonActions();
	TestUtitlies tu = new TestUtitlies();
	DLoginAction dla = new DLoginAction();
	DAssessmentDesignUI ad = new DAssessmentDesignUI();

	public void assessmentDesign(WebDriver driver, WebDriverWait wait) {

		ca.clickOnElement(driver, ad.AssessmentDesignButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ad.CirclePercentage));
		ca.clickOnElement(driver, ad.ChooseElectiveButton);
		wait.until(ExpectedConditions.elementToBeClickable(ad.AddThisButton));
		ca.clickOnElement(driver, ad.AddThisButton);
		ca.clickOnElement(driver, ad.ChooseArticleButton);
		wait.until(ExpectedConditions.elementToBeClickable(ad.ArticleExpandButton));
		ca.clickOnElement(driver, ad.ArticleExpandButton);
		wait.until(ExpectedConditions.elementToBeClickable(ad.ArticleAddThisButton));
		ca.clickOnElement(driver, ad.ArticleAddThisButton);
		System.out.println("1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ad.RemoveAddedArticleButton));
		Assert.assertTrue(ca.isElementDisplayed(driver, ad.RemoveAddedArticleButton), "Article not added...!!");
		System.out.println("2");
		String percentage="";
		do// !ca.isElementPresent(driver,ad.WarningMessageOf100PercentCompleted))
		{
			System.out.println("3");
			ca.clickOnElement(driver, ad.ElectiveBlockIncrementButton);
			percentage=CharMatcher.digit().retainFrom(ca.getTextForLocator(driver, ad.CirclePercentage));
		} while (!percentage.equals("100"));
		System.out.println("4");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ad.BellIconForElective));
		System.out.println("5");
		Assert.assertTrue(driver.findElement(ad.LockAndSaveButton).isDisplayed(), "Assessment Design not locked to 100%");
		System.out.println("6");
		ca.clickOnElement(driver, ad.LockAndSaveButton);
	}

}

package com.uielements.diplomate;

import org.openqa.selenium.By;

public class DAssessmentDesignUI {
	
	public By AssessmentDesignButton=By.xpath("//div[@class='performance-block dashBoard-block white-bg']/div/div[2]/a[2]/div[contains(text(),'Design Assessment')]");
	public By ChooseElectiveButton=By.xpath("//*[@id='electives-prompt-choose-div']/div[1]/a");
	public By ChooseArticleButton=By.id("btn-choose-article");
	public By AddThisButton=By.xpath("//div[@class='assessment-elective electives-list show']/div/div/div/div/div/a[@class='button-border-green add-elective']");
	public By ElectiveBlockIncrementButton=By.xpath("//div[@id='selected-elective-block']/div/div[2]/div[2]/span[2]");
	public By ElectiveBlockDecrementButton=By.xpath("//div[@id='selected-elective-block']/div/div[2]/div[2]/span[1]");
	public By ArticleExpandButton=By.xpath("//div[@class='accordion-row-container optional-articel-block-container']/div/div/div/span[1]/span[1]");
	public By ArticleAddThisButton=By.xpath("//*[@class='assessment-articles articles-list show']//a[@class='button-border-green add-article']");
	public By ArticleExpanded=By.xpath("//*[@class='accordion-title-row row expanded']");
	public By RemoveAddedArticleButton=By.xpath("//p[@class='added-article show']/following-sibling::a");
	public By WarningMessageOf100PercentCompleted=By.xpath("//div[@class='notifyjs-metro-base notifyjs-metro-warning']/div[2]/div[2]");
	public By BellIconForElective=By.xpath("//*[@id='panel-electives' and @class='panel-msg']/span");
	public By LockAndSaveButton=By.xpath("//a[contains(text(),'Lock & Save')]");
	public By RemoveElectiveBlock=By.className("//a[@class='remove-elective']");
	public By CirclePercentage=By.className("donut-inner-circle");
	public By ElectivePercentageSelected=By.xpath("//div[@id='selected-elective-block']/div/div/div/p[@class='assessment-percent']");
	public By ConfirmDesignPopUp=By.xpath("//div[@class='overlay'  and @id='modal-assessment-confirm']");
	public By ConfirmDesignPopUpConfirmButton=By.xpath("//div[@class='overlay'  and @id='modal-assessment-confirm']//a[@id='btnSaveLock']");
	public By ConfirmDesignPopUpCancelButton=By.xpath("//div[@class='overlay'  and @id='modal-assessment-confirm']//a[@class='button-background red button-cancel']");
	

}

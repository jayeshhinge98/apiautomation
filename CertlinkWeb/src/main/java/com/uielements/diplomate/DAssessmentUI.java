package com.uielements.diplomate;

import org.openqa.selenium.By;

public class DAssessmentUI {
	
	public By BeginAssessmentButton=By.className("button-background green");
	//public By BeginAssessmentButton2=By.xpath("//div[contains(text(),'Begin Assessment')]");
	public By NumberOfQuestionsRemainingPopUp=By.id("beginResumeAssMsg");
	public By ContinueOnPopUpButton=By.xpath("//button[@id='btnStartAssessment']");
	public By ClosePopUpButton=By.xpath("//div[@id='confirmStartAssessmentModal']/div/div/div/button[2]");
	public By QuestionDetailsPopUp=By.xpath("//div[@class='modal fade in']/div/div/div/h2");
	public By QuestionDetailsPopUpCancelButton=By.xpath("//div[@class='modal fade in']/div/div/div/button[2]");
	public By QuestionDetailsPopUpProceedButton=By.xpath("//div[@class='modal fade in']/div/div/div/button[3]");
	public By SelectOption(int option) {
		return By.xpath("//div[@id='AnswerOptionContainer']/div["+option+"]/span[1]");
	}
	//public By SubmitAnswer=By.xpath("//div[@id='AnswerOptionContainer']/div/span[contains(text(),'Choose An Answer Above')]");
	public By SubmitAnswerButton=By.id("btnSubmitItemAnswer");
	//div[@id='confidence-relevance-modal']//div[@class='row']/div/div/div/label
	

}

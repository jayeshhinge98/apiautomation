package com.uielements.practice_admin;

import org.openqa.selenium.By;

public class DashboardUI {

	// Author: Jayesh Hinge
	// Unit: ABFM
	
	// Below is unique xpath for all tour guide close button
	public By TourGuideCloseButton=By.xpath("//*[@id='SliderApp']/button/span[1]");
	public By PROModuleButton=By.xpath("//*[@id='root']//div[2]//span[@title='Patient Reported Outcomes']");
	// If above xpath didn't work
	public By PROModuleButtonFullPath=By.xpath("//*[@id='root']/div/div/div/div/div/div[2]/div/div/div/div/div/ul/div[6]/div[1]/span");
	
	// Patient browser 
	// PRO Tracker 
	public By PatientBrowser=By.xpath("//span[text()='Patient Browser']");
	public By DashboardHeaderText=By.xpath("//h2[contains(@class,'fi-subheader__title')]");
	public By PatientNameSearchField=By.xpath("//div[contains(@class,'fig-Name')]//input[contains(@class,'MuiInputBase')]");
	public By MRNSearchField=By.xpath("//div[contains(@class,'fig-mrn')]//input[contains(@class,'MuiInputBase')]");
	public By EmailIdSearchField=By.xpath("//div[contains(@class,'fig-EmailId')]//input[contains(@class,'MuiInputBase')]");
	public By QuestionnaireSearchField=By.xpath("//div[contains(@class,'fig-QuestionnaireDisplayName')]//input[contains(@class,'MuiInputBase')]");
	
	
	// Author: Shrinivas Turekar
	
	
	
}

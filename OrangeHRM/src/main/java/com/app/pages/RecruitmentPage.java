package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.app.BasePage.TestBase;

public class RecruitmentPage extends TestBase{
	@FindBy(xpath = "//b[text()='Recruitment']")
	WebElement recruitment_Btn;
	@FindBy(xpath="//input[@type='text']")
	WebElement candidate_txt;
	@FindBy(xpath = "//input[@id='candidateSearch_fromDate']")
	WebElement from_Date;
	@FindBy(xpath = "//input[@id='candidateSearch_toDate']")
	WebElement to_Date;
	@FindBy(xpath = "//input[@id='btnSrch']")
	WebElement Search_Btn;
	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}
	public String ValidaterecruitmentPageTitle() {
		return driver.getTitle();
	}
	
	public void search_Recruitment(String name,String From_date,String To_Date) {
		recruitment_Btn.click();
		candidate_txt.sendKeys(name);
		from_Date.sendKeys(From_date);
		to_Date.sendKeys(To_Date);
		Search_Btn.click();
	}
	
	
	

}

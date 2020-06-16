package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.app.BasePage.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement username_Txt;
	@FindBy(xpath = "//input[@name='txtPassword']")
	WebElement password_Txt;
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement submit_Btn;
	@FindBy(tagName = "a")
	WebElement elements;
	@FindBy(xpath = "//a[@class='firstLevelMenu']")
	WebElement Admin_Btn;
	@FindBy(xpath = "//table[@id='resultTable']")
	WebElement Table_Data;
	public LoginPage() {
	PageFactory.initElements(driver,this);
	}
	public String validateDashBoardTitle() {
		return driver.getTitle();
	}
	public RecruitmentPage login(String un,String pwd) {
	 username_Txt.sendKeys(un);
	 password_Txt.sendKeys(pwd);
	 submit_Btn.click();
	 System.out.println("No.of Element :"+elements);
	 Admin_Btn.click();
	 System.out.println("Table Data :"+Table_Data.getText());
	 return new RecruitmentPage();
	}
	
	
	
	

}

package com.app.testcases;

import org.testng.annotations.Test;

import com.app.BasePage.TestBase;
import com.app.pages.LoginPage;
import com.app.pages.RecruitmentPage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RecruitmentTest extends TestBase {
	LoginPage loginpage;
	RecruitmentPage recruitmentpage;
  @BeforeClass
  public void setUp() {
	  TestBase.Initalization();
  }
  @Test
  public void Login() {
	  loginpage=new LoginPage();
	  loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
  }
  @Test
  public void recruitment() {
	  recruitmentpage=new RecruitmentPage();
	  recruitmentpage.search_Recruitment(prop.getProperty("candidatename"), prop.getProperty("FromDate"),prop.getProperty("ToDate"));
  }
  public void verifyRecruitmentTitle() {
	   recruitmentpage.ValidaterecruitmentPageTitle();
  }
 
  @AfterClass
  public void quit() {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.quit();
  }

}

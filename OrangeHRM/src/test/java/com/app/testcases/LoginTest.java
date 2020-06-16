package com.app.testcases;

import org.testng.annotations.Test;

import com.app.BasePage.TestBase;
import com.app.pages.LoginPage;
import com.app.pages.RecruitmentPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTest extends TestBase {
	LoginPage loginpage;
	RecruitmentPage recruitmentpage;
  @BeforeClass
  public void setUp() {
	  TestBase.Initalization();
  }
  @Test
  public void f() {
	  loginpage=new LoginPage();
	  recruitmentpage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
  }
  @Test
  public void verifyTitle() {
	  loginpage.validateDashBoardTitle();
  }
  
  @AfterClass
  public void quit() {
	  try {
		Thread.sleep(5000);
		driver. quit();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }

}

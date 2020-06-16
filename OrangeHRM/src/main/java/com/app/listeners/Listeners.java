package com.app.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.app.BasePage.TestBase;

public class Listeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test Start Running :"+arg0.getMethod().getMethodName());

	}
	public void onTestSKipped(ITestResult arg0) {
		Reporter.log("Test Skipped :"+arg0.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Test Successfully Running :"+arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpledate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName=arg0.getName();
		if(arg0.isSuccess()) {
			File SourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String directoryPath=(new File(System.getProperty("user.dir")).getAbsolutePath()+"src/main/java/com/app");
			File targetPath = new File((String)directoryPath+"/passedscreens/"+methodName+""+simpledate.format(cal.getTime())+".png");
			try {
				FileHandler.copy(SourcePath, SourcePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Test is Failed :"+arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpledate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName=arg0.getName();
		if(!arg0.isSuccess()) {
			File SourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String directoryPath=(new File(System.getProperty("user.dir")).getAbsolutePath()+"./src/main/java/com/app");
			File targetPath = new File((String)directoryPath+"/failedscreens/"+methodName+""+simpledate.format(cal.getTime())+".png");
			try {
				FileHandler.copy(SourcePath, SourcePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

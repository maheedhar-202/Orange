package com.app.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryListener implements IAnnotationTransformer{
	public void transformer(ITestAnnotation arg0,Class arg1,Constructor arg2,Method arg3) {
		IRetryAnalyzer r=arg0.getRetryAnalyzer();
		if(r==null) {
			arg0.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);
		}
	}

}

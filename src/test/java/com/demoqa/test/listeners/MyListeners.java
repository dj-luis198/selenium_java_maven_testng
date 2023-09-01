package com.demoqa.test.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestStart(ITestResult result) {

        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ITestListener.super.onTestSuccess(result);
    }
    
}

package com.demoqa.test.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSuccess(result);
    }
    
}

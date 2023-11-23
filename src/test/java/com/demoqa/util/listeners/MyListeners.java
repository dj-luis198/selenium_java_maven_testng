package com.demoqa.util.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoqa.base.BaseClass;
import com.demoqa.util.ExtentReportGenerator;

public class MyListeners extends BaseClass implements ITestListener {

    ExtentReports report = ExtentReportGenerator.getExtentReport();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    ExtentTest eTest;

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        eTest = report.createTest(testName);
        extentTest.set(eTest);
        extentTest.get().assignCategory(result.getMethod().getGroups());
        extentTest.get().info(result.getMethod().getDescription());
        String groups[] = result.getMethod().getGroups();
        Boolean flag = false;
        for (String group : groups) {
            if (group.equals("API")) {
                flag = true;
            }
        }
        if (!flag) {
            extentTest.get().assignDevice(result.getTestContext().getCurrentXmlTest().getParameter("browser"));
        }else {
            extentTest.get().assignDevice("API");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.PASS, testName + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        String testName = result.getMethod().getMethodName();
        Object testObject = result.getMethod();
        Class<?> clazz = result.getTestClass().getRealClass().getSuperclass().getSuperclass();

        try {
            driver = (WebDriver) clazz.getMethod("getDriver").invoke(testObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(takesScreenshot(testName, driver), testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.FAIL, testName + "test fail");
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.SKIP, testName + "test skipped");
    }
}

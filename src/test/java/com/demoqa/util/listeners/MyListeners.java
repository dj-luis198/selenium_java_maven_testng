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
        System.out.println("---------- test started: " + testName + " ----------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.PASS, testName + " got successfully executed");
        System.out.println("\u001B[32mGreen test passed: " + testName );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        String testName = result.getMethod().getMethodName();
        String testNameScreen = result.getMethod().getMethodName()+result.getTestContext().getCurrentXmlTest().getParameter("browser"); 
        Object testObject = result.getMethod();
        Class<?> clazz = result.getTestClass().getRealClass().getSuperclass().getSuperclass();

        try {
            driver = (WebDriver) clazz.getMethod("getDriver").invoke(testObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(takesScreenshot(testNameScreen, driver), testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.FAIL, testName + "test fail");
        extentTest.get().fail(result.getThrowable());
        System.out.println("\u001B[31mRed test failed: " + testName);
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        System.out.println("\u001B[31mRed test failed with timeout: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.SKIP, testName + "test skipped");
        extentTest.get().skip(result.getThrowable());
        System.out.println("\u001B[33mYellow test skipped: " + testName);
    }
}

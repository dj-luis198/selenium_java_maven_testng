package com.demoqa.util.listeners;
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
    String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
    String testName = result.getMethod().getMethodName();
    String divice = System.getProperty("os.name")+"-"+ System.getProperty("os.version")+"-"+System.getProperty("os.arch");
    
    eTest = report.createTest(testName);
    extentTest.set(eTest);
    extentTest.get().assignCategory(result.getMethod().getGroups());
    extentTest.get().info(result.getMethod().getDescription());
    
    boolean flag = false;
    for (String group : result.getMethod().getGroups()) {
        if (group.equals("API")) {
            flag = true;
            break;
        }
    }
    
    if (!flag) {
        extentTest.get().assignDevice(divice+"-"+browser);
    } else {
        browser = "API";
        extentTest.get().assignDevice(divice+"-"+browser);
    }
    
    System.out.println("\u001B[35m---------- test started: " + testName + " browser:" + browser + " ----------\u001B[0m");
}

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.PASS, testName + " got successfully executed");
        System.out.println("\u001B[32m test passed: " + testName + "\u001B[0m");
    }

@Override
public void onTestFailure(ITestResult result) {
    String testName = result.getMethod().getMethodName();
    String testNameScreen = result.getMethod().getMethodName() +
            result.getTestContext().getCurrentXmlTest().getParameter("browser");
    Object testObject = result.getMethod();

    Class<?> clazz = result.getTestClass().getRealClass().getSuperclass().getSuperclass();
    if(clazz != null) {
        try {
            WebDriver driver = (WebDriver) clazz.getMethod("getDriver").invoke(testObject);
            extentTest.get().addScreenCaptureFromPath(takesScreenshot(testNameScreen, driver), testName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    extentTest.get().log(Status.FAIL, testName + "test fail");
    extentTest.get().fail(result.getThrowable());

    System.out.println("\u001B[31m test failed: " + testName + "\u001B[0m");
    System.out.println("\u001B[31m" + result.getThrowable() + "\u001B[0m");
}

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        System.out.println("\u001B[31m test failed with timeout: " + result.getMethod().getMethodName()+ "\u001B[0m");
        System.out.println("\u001B[31m"+result.getThrowable()+"\u001B[0m");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.SKIP, testName + "test skipped");
        extentTest.get().skip(result.getThrowable());
        System.out.println("\u001B[33m test skipped: " + testName+ "\u001B[0m");
        System.out.println("\u001B[33m"+result.getThrowable()+"\u001B[0m");
    }
}

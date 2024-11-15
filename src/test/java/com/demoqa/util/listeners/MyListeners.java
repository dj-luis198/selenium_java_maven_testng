package com.demoqa.util.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoqa.base.BaseClass;
import com.demoqa.util.AnsiColorUtils;
import com.demoqa.util.ExtentReportGenerator;

public class MyListeners extends BaseClass implements ITestListener {

    private static Logger logger = LogManager.getLogger(MyListeners.class);

    ExtentReports report = ExtentReportGenerator.getExtentReport();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    ExtentTest eTest;

    @Override
    public void onTestStart(ITestResult result) {
        MyRetryAnalyzer retryAnalyzer = (MyRetryAnalyzer) result.getMethod().getRetryAnalyzer(result);
        if (retryAnalyzer != null) {
            retryAnalyzer.resetCounter();
        }
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        String testName = result.getMethod().getMethodName();
        String divice = System.getProperty("os.name") + "-" + System.getProperty("os.version") + "-"
                + System.getProperty("os.arch");

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
            extentTest.get().assignDevice(divice + "-" + browser);
        } else {
            browser = "API";
            extentTest.get().assignDevice(divice + "-" + browser);
        }
        logger.info(AnsiColorUtils.applyPurple("--- Started: " + testName + " brw:" + browser + " ---"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.get().log(Status.PASS, testName + " got successfully executed");
        logger.info(AnsiColorUtils.applyGreen("test passed: " + testName));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("ingresando al  onTestFailure");
        if (result.getMethod().getRetryAnalyzer(result) != null) {
            System.out.println("failure: If !=Null "+result.getMethod().getRetryAnalyzer(result));
            MyRetryAnalyzer retryAnalyzer = (MyRetryAnalyzer) result.getMethod().getRetryAnalyzer(result);
            System.out.println("Failure: retryAnalyzer "+retryAnalyzer.retry(result));
            if (retryAnalyzer.retry(result)) {
                System.out.println("Failure: ingreso al if ahora retorna "+retryAnalyzer);
                result.setStatus(ITestResult.SKIP);
                logger.warn(AnsiColorUtils.applyYellow("Retrying test: " + result.getMethod().getMethodName()));
                return;
            }
        }
                String testName = result.getMethod().getMethodName();
                System.out.println("Failure: el test sera fail "+testName);
                String testNameScreen = result.getMethod().getMethodName() + result.getTestContext().getCurrentXmlTest().getParameter("browser");
                Object testObject = result.getMethod();
                Class<?> clazz = result.getTestClass().getRealClass().getSuperclass().getSuperclass();
                if (clazz != null) {
                    try {
                        WebDriver driver = (WebDriver) clazz.getMethod("getDriver").invoke(testObject);
                        extentTest.get().addScreenCaptureFromPath(takesScreenshot(testNameScreen, driver), testName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                extentTest.get().log(Status.FAIL, testName + " test failed");
                extentTest.get().fail(result.getThrowable());
                logger.error(AnsiColorUtils.applyRed("test failed: " + testName + "\n" + result.getThrowable()));

            }



    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        logger.error(AnsiColorUtils.applyRed(
                "test failed with timeout: " + result.getMethod().getMethodName() + "\n" + result.getThrowable()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("ingresando al  onTestSkipped");
        if (result.getMethod().getRetryAnalyzer(result) != null) {
            System.out.println("If !=Null "+result.getMethod().getRetryAnalyzer(result));
            MyRetryAnalyzer retryAnalyzer = (MyRetryAnalyzer) result.getMethod().getRetryAnalyzer(result);
            System.out.println("retryAnalyzer "+retryAnalyzer.retry(result));
            if (retryAnalyzer.retry(result)) {
                System.out.println("ingreso al if ahora retorna "+retryAnalyzer);
                return; // No registrar el test como omitido si se va a reintentar
            }
        }
        String testName = result.getMethod().getMethodName();
        System.out.println("el test sera skipeado "+testName);
        extentTest.get().log(Status.SKIP, testName + " test skipped");
        extentTest.get().skip(result.getThrowable());
        logger.warn(AnsiColorUtils.applyYellow("test skipped: " + testName + "\n" + result.getThrowable()));
    }
    }

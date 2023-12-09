package com.demoqa.util.listeners;

import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class MyReRunConfig implements IConfigurable {

    @Override
    public void run(IConfigureCallBack callBack, ITestResult testResult) {
        callBack.runConfigurationMethod(testResult);
        if (testResult.getThrowable() != null) {
            for (int i = 0; i <= 1; i++) {
                System.err.println("Retrying " + parseType(testResult) + " method : " +
                        testResult.getMethod().getQualifiedName());
                callBack.runConfigurationMethod(testResult);
                if (testResult.getThrowable() == null) {
                    break;
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static String parseType(ITestResult testResult) {
        ITestNGMethod method = testResult.getMethod();
        if (method.isBeforeSuiteConfiguration()) {
            return "@BeforeSuite";
        }
        if (method.isAfterSuiteConfiguration()) {
            return "@AfterSuite";
        }
        if (method.isBeforeTestConfiguration()) {
            return "@BeforeTest";
        }
        if (method.isAfterTestConfiguration()) {
            return "@AfterTest";
        }
        if (method.isBeforeGroupsConfiguration()) {
            return "@BeforeGroup";
        }
        if (method.isAfterGroupsConfiguration()) {
            return "@AfterGroup";
        }
        if (method.isBeforeClassConfiguration()) {
            return "@BeforeClass";
        }
        if (method.isAfterClassConfiguration()) {
            return "@AfterClass";
        }
        if (method.isBeforeMethodConfiguration()) {
            return "@BeforeMethod";
        }
        return "@AfterMethod";
    }

}

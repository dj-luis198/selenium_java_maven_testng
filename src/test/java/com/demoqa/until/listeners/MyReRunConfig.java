package com.demoqa.until.listeners;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class MyReRunConfig implements IConfigurable {

    private static final int MAX_RETRIES = 2;
    private static final int MAX_WAIT_TIME = 60; // 120 segundos

    @Override
    public void run(IConfigureCallBack callBack, ITestResult testResult) {
        callBack.runConfigurationMethod(testResult);
        if (testResult.getThrowable() != null) {
            for (int i = 0; i < MAX_RETRIES; i++) {
                System.err.println("Retrying " + parseType(testResult) + " method : " +
                        testResult.getMethod().getQualifiedName());
                Future<?> future = scheduleRetry(callBack, testResult);
                try {
                    future.get(MAX_WAIT_TIME, TimeUnit.SECONDS);
                } catch (TimeoutException e) {
                    System.err.println("Retry timed out. Cancelling retry.");
                    future.cancel(true);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Future<?> scheduleRetry(IConfigureCallBack callBack, ITestResult testResult) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        return executorService.schedule(() -> callBack.runConfigurationMethod(testResult), MAX_WAIT_TIME,
                TimeUnit.SECONDS);
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

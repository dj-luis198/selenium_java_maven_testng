package com.demoqa.base;

import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestMethod extends BaseClass {

    @BeforeMethod
    public void setUp() {
        init();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        close();
        Thread.sleep(Duration.ofSeconds(3));
        quit();
    }
}

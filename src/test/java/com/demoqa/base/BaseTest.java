package com.demoqa.base;

import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest extends BaseClass {

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        init(browser);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        close();
        Thread.sleep(Duration.ofSeconds(3));
        quit();
    }
}

package com.demoqa.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends BaseClass {

    @BeforeClass
    @Parameters(value = { "browser" })
    public void setUp(@Optional("chrome") String browser) {
        init(browser);
    }

    @AfterClass
    public void tearDown() {
        quit();
    }
}

package com.demoqa.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demoqa.util.listeners.MyReRunConfig;

public class BaseTest extends MyReRunConfig{

    
    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome")String browser) {
        BaseClass.init(browser);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        BaseClass.quit();
    }
}

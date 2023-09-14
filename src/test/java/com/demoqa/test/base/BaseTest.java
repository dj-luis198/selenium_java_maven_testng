package com.demoqa.test.base;

import java.time.Duration;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


import com.demoqa.base.BaseClass;

public class BaseTest extends BaseClass {

    @BeforeClass
    public void setUp() {
        init();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        close();
        Thread.sleep(Duration.ofSeconds(3));
        quit();
    }
}

package com.demoqa.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.demoqa.base.BaseClass;

public class BaseTest extends BaseClass{

    @BeforeTest
    public void setUp(){
            init();	
    }

    @AfterTest
    public void tearDown() {	
	quit();	
	}	
    
}

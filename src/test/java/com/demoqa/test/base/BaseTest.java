package com.demoqa.test.base;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.demoqa.base.BaseClass;

public class BaseTest extends BaseClass{

    @BeforeMethod
    public void setUp(){
            init();	
    }

    @AfterMethod
    public void tearDown() {	
	quit();	
	}    
}

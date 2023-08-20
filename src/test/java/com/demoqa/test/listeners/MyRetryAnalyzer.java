package com.demoqa.test.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
     int counter=0;
      int retryLimit=2;

    @Override
    public boolean retry(ITestResult result) {
     if(counter<retryLimit){
        counter++;
        return true;
     }
        return false;
    }
    
}

package com.demoqa.util.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.demoqa.util.AnsiColorUtils;

public class MyRetryAnalyzer implements IRetryAnalyzer {

   private int counter = 0;
   private static final int retryLimit = 1;

   private static Logger logger = LogManager.getLogger(MyRetryAnalyzer.class);

   @Override
   public boolean retry(ITestResult result) {
      if (counter < retryLimit) {
         counter++;
         logger.warn(AnsiColorUtils
               .applyYellow("Fail Test: " + result.getMethod().getMethodName() + " Retry number: " + counter + " de 1"));
         return true;
      } else {
         counter = 0;
      return false;
      }
   }
}

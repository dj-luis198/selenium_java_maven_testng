package com.demoqa.test.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
   int counter = 0;
   int retryLimit = 1;

   @Override
   public boolean retry(ITestResult result) {
      if (counter < retryLimit) {
         System.out.println("---------------------------------------------------------");
         System.out.println("fallo de prueba context: " + result.getTestContext());
         System.out.println("fallo de prueba: " + result.getMethod().getMethodName());
         counter++;
         System.out.println("intento no: " + counter + " de 1");
         System.out.println("----------------------------------------------------------");
         return true;
      }
      return false;
   }

}

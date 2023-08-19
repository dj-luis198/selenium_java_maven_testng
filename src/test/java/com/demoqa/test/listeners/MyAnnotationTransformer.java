package com.demoqa.test.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer{

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(com.demoqa.test.listeners.MyRetryAnalyzer.class);
    }
    
}

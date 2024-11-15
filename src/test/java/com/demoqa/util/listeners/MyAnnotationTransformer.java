package com.demoqa.util.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer {

    @SuppressWarnings("rawtypes")
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (annotation.getRetryAnalyzerClass() == null) {
            System.out.println("si funciona transform");
            annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
        }
    }
}

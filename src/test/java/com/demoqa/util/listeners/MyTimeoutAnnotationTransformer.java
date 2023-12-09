package com.demoqa.util.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTimeoutAnnotationTransformer implements IAnnotationTransformer {
    @SuppressWarnings("rawtypes")
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Verifica si el método es un BeforeMethod
        if (testMethod.getName().startsWith("before")) {
            annotation.setTimeOut(10000);
        }
    }
}
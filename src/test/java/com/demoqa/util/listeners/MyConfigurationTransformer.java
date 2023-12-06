package com.demoqa.util.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;

public class MyConfigurationTransformer implements IAnnotationTransformer {
    @SuppressWarnings("rawtypes")
    @Override
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setTimeOut(10);
    }
    
}

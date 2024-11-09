package com.demoqa.util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
    static ExtentReports report;

    public static ExtentReports getExtentReport(){
        report = new ExtentReports();
        File extentReportFile= new File(System.getProperty("user.dir")+"/ExtentReports/index.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        sparkReporter.config().setDocumentTitle("DEMOQA");
        sparkReporter.config().setReportName("DEMOQA Reports");
        report.attachReporter(sparkReporter);
        report.setSystemInfo("Tester","Daniel Farias");
        report.setSystemInfo("os", "windows");
        report.setSystemInfo("browser", "chrome, firefox, edge");
        return report;

    }
    
}

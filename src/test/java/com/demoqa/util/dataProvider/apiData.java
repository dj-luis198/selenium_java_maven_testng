package com.demoqa.util.dataProvider;

import com.demoqa.util.XLUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class apiData {
    XLUtility excel;

    @DataProvider(name = "bookUserData", parallel = false)
    public String[][] postBooksUserTest() throws IOException {
        excel = new XLUtility();
        String path = "src/test/resources/excel/bookUserData.xlsx";
        String[][] data = excel.readData(path);
        return data;
    }

    @DataProvider(name = "bookUsercol2Data", parallel = false)
    public String[][] dataTest() throws IOException {
        excel = new XLUtility();
        String path = "src/test/resources/excel/bookUserData.xlsx";
        String[][] data = excel.readData(path, 2);
        return data;
    }

    @DataProvider(name = "bookUsercol3Data", parallel = false)
    public String[][] authTest() throws IOException {
        excel = new XLUtility();
        String path = "src/test/resources/excel/bookUserData.xlsx";
        String[][] data = excel.readData(path, 3);
        return data;
    }

    @DataProvider(name = "bookUsercol4Data", parallel = false)
    public String[][] dataUserTest() throws IOException {
        excel = new XLUtility();
        String path = "src/test/resources/excel/bookUserData.xlsx";
        String[][] data = excel.readData(path,4);
        return data;
    }

    @DataProvider(name = "bookUsercol5Data", parallel = false)
    public String[][] deleteBookData() throws IOException {
        excel = new XLUtility();
        String path = "src/test/resources/excel/bookUserData.xlsx";
        String[][] data = excel.readData(path,5);
        return data;
    }

    @DataProvider(name = "bookUserSimplecol5Data", parallel = false)
    public String[] dataBookTest() throws IOException {
        excel = new XLUtility();
        String path = "src/test/resources/excel/bookUserData.xlsx";
        String[] data = excel.readSimpleData(path,5);
        return data;
    }
}

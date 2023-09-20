package com.demoqa.util.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.XLUtility;

public class bookStoreE2EData {
     XLUtility readExcel = new XLUtility();

    @DataProvider(name = "bookStoreE2E",parallel = false)
    public String[][] bookStoreE2E() throws IOException {
        String path = "src/test/resources/excel/bookStoreE2E.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }
}

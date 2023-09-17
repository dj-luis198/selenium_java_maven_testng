package com.demoqa.util.dataProvider.DatePicker;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.XLUtility;

public class DatePickerData {
    XLUtility readExcel = new XLUtility();

    @DataProvider(name = "DatePickerData", parallel = false)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/DatePickerData.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }
}

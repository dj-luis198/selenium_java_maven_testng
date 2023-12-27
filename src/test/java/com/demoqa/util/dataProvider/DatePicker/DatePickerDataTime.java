package com.demoqa.util.dataProvider.DatePicker;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.XLUtility;

public class DatePickerDataTime {
    XLUtility readExcel = new XLUtility();

    @DataProvider(name = "DatePickerDataTime", parallel = true)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/DatePickerDataTime.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }
}

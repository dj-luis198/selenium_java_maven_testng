package com.demoqa.test.dataProvider.DatePicker;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.ReadExcel;

public class DatePickerData {
    ReadExcel readExcel = new ReadExcel();

    @DataProvider(name = "DatePickerData", parallel = false)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/DatePickerData.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }
}

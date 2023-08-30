package com.demoqa.test.dataProvider.DatePicker;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.ReadExcel;

public class DatePickerDataTime {
    ReadExcel readExcel = new ReadExcel();

    @DataProvider(name = "DatePickerDataTime", parallel = true)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/DatePickerDataTime.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }
}

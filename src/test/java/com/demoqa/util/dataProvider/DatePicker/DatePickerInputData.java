package com.demoqa.util.dataProvider.DatePicker;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.ReadExcel;

public class DatePickerInputData {
    ReadExcel readExcel = new ReadExcel();

    @DataProvider(name = "DatePickerInputData", parallel = false)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/DatePickerInputData.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }

    
}

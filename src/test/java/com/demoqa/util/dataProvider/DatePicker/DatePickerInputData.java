package com.demoqa.util.dataProvider.DatePicker;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.XLUtility;

public class DatePickerInputData {
    XLUtility readExcel = new XLUtility();

    @DataProvider(name = "DatePickerInputData", parallel = true)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/DatePickerInputData.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }

    
}

package com.demoqa.test.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.ReadExcel;

public class AutoCompleteData {
    ReadExcel readExcel = new ReadExcel();

    @DataProvider(name = "MultipleSelecColorData", parallel = true)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/MultiSelect.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }

}

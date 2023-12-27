package com.demoqa.util.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.demoqa.util.XLUtility;

public class AutoCompleteData {
    XLUtility readExcel = new XLUtility();

    @DataProvider(name = "MultipleSelecColorData", parallel = true)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/MultiSelect.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }

}

package com.demoqa.util.dataProvider;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import com.demoqa.util.XLUtility;

public class SliderData {
    XLUtility readExcel = new XLUtility();

    @DataProvider(name = "SliderData",parallel = false)
    public String[][] dataTest() throws IOException {
        String path = "src/test/resources/excel/SliderData.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }
}

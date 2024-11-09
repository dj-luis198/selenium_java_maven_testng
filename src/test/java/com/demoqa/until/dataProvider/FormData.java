package com.demoqa.until.dataProvider;

import org.testng.annotations.DataProvider;

import com.demoqa.util.CSVFileReader;

public class FormData {

    @DataProvider(name = "FormData",parallel = false)
    public String[][] dataTest() {
        String path = "src/test/resources/csv/formData.csv";
        String delimiter = ",";
        String[][] data = CSVFileReader.readCSV( path, delimiter);
        return data;
    }
    
}

package com.demoqa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public String[][] readData(String path) throws IOException {
            File excelFile = new File(path).getAbsoluteFile();
            FileInputStream fis = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCell = sheet.getRow(0).getLastCellNum();
            String[][] data = new String[noOfRows - 1][noOfCell];
            for (int i = 0; i < noOfRows - 1; i++) {
                for (int j = 0; j < noOfCell; j++) {
                    DataFormatter df = new DataFormatter();
                    data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
                }
            }
            workbook.close();
            fis.close();
            return data;
        }
    }
//para leer
/*@DataProvider
    public String[][] dataTest() throws IOException {
        String path= "src/test/resources/excel/nuevoejemplo.xlsx";
        String[][] data = readExcel.readData(path);
        return data;
    }*/
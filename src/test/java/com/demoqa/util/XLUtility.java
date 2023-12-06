package com.demoqa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

public String[] readSimpleData(String path, int col) throws IOException {
    try (FileInputStream fis = new FileInputStream(new File(path).getAbsoluteFile());
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        String[] data = new String[noOfRows - 1];

        for (int i = 0; i < noOfRows - 1; i++) {
            DataFormatter df = new DataFormatter();
            data[i] = df.formatCellValue(sheet.getRow(i + 1).getCell(col));
        }

        return data;
    }
}

public String[][] readData(String path, int colI, int colT) throws IOException {
    try (FileInputStream fis = new FileInputStream(path);
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[noOfRows - 1][colT];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = colI; j < colT; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        return data;
    }
}

public String[][] readData(String path,int col) throws IOException {
    try (FileInputStream fis = new FileInputStream(path);
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[noOfRows - 1][col];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < col; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        return data;
    }
}

public String[][] readData(String path) throws IOException {
    File excelFile = new File(path).getAbsoluteFile();
    try (FileInputStream fis = new FileInputStream(excelFile);
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
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
        return data;
    }
}

public void setCellData(String path, int rownum, int colnum, String data) throws IOException {
    try (FileInputStream fis = new FileInputStream(path);
         XSSFWorkbook workbook = new XSSFWorkbook(fis);
         FileOutputStream fos = new FileOutputStream(path)) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(rownum + 1);
        XSSFCell cell = row.getCell(colnum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }
}
}
// para leer
/*
 * @DataProvider
 * public String[][] dataTest() throws IOException {
 * String path= "src/test/resources/excel/nuevoejemplo.xlsx";
 * String[][] data = readExcel.readData(path);
 * return data;
 * }
 */
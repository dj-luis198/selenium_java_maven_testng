package com.demoqa.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader {

    public static String[][] readCSV(String filePath, String delimiter) {
        String[][] data = null;
        BufferedReader reader;
        String line;
        int rows = 0;
        int cols = 0;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            // Contar el número de filas y columnas en el archivo CSV
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (cols == 0) {
                    cols = values.length;
                }
                rows++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Inicializar la matriz de cadenas con el tamaño adecuado
            data = new String[rows][cols];
            // Volver a leer el archivo y llenar la matriz de cadenas
            reader = new BufferedReader(new FileReader(filePath));
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (int col = 0; col < cols; col++) {
                    data[row][col] = values[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}

// para leer
/*
 * @DataProvider
 * public String[][] dataTest() throws IOException {
 * String path= "src/test/resources/excel/nuevoejemplo.csv";
 * String delimiter = ";";
 * String[][] data = CSVFileReader.readCSV( filePath, delimiter);
 * return data;
 * }
 */

package com.bayamp.pleasanton2020.data.utils;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVDataReaderString {
    private static CSVReader reader;
    private static String path = ".//src//test//resources//data//webmail//";
    private static Object[][] mydata;

    private static void getData(String filename) {
        filename = path + filename;
        try {
            reader = new CSVReader(new FileReader(filename), ',', '\'', 1);
            List<String[]> myEntries = reader.readAll();
            mydata = new Object[myEntries.size()][myEntries.get(0).length];
            for (int i = 0; i < myEntries.size(); i++) {
                for (int j = 0; j < myEntries.get(0).length; j++) {
                    mydata[i][j] = myEntries.get(i)[j];
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[][] getCSVData(String filename) {
        getData(filename);
        return mydata;
    }
}

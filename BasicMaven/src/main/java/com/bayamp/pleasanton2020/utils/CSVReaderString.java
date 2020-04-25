package com.bayamp.pleasanton2020.utils;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderString {
    private final String CSVFILE_PATH = "src/test/resources/data/login/";
    private static Object[][] mydata = null;
    private static void getMyData (String filename) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filename), ',', '/', 1);
            List<String[]> myEntries = csvReader.readAll();
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
        getMyData(filename);
        return mydata;
    }
}

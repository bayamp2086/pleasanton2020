package com.bayamp.pleasanton2020.data.utils;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVDataReader {
    private static CSVReader reader = null;
    private static Object[][] myData = null;
    private static String path = ".\\src\\test\\resources\\data\\";

    private static void getData(String filename) {
        String[] lines = null;
        try {
            filename = path + filename;
            CSVReader reader = new CSVReader(new FileReader(filename), ';', '\'', 1);
           String [] columnsline= reader.readNext();
            System.out.println(columnsline.length);
            List<String[]> myEntries = reader.readAll();
            myData = new Object[myEntries.size()][2];
            for (int i = 0; i < myEntries.size(); i++) {
                myData[i][0] = myEntries.get(i)[0].split(" ");
                myData[i][1] = myEntries.get(i)[1].split(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[][] getMyCSVData(String filename) {
        getData(filename);
        return myData;
    }
}
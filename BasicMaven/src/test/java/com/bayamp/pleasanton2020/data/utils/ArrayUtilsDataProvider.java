package com.bayamp.pleasanton2020.data.utils;

import org.testng.annotations.DataProvider;

public class ArrayUtilsDataProvider{

        @DataProvider(name="getCSVData")
        public static Object[][] getCSVData(){
                return CSVDataReader.getMyCSVData("arrayutilsreversearray-testdata.csv");
        }
}
package com.bayamp.pleasanton2020.data.utils;

import org.testng.annotations.DataProvider;

public class WebMailUtilsDataProvider {

    @DataProvider(name = "getValidUserLoginsData")
    public static Object[][] getCSVData() {
        return CSVDataReaderString.getCSVData("valid_userlogins.csv");
    }

    @DataProvider(name = "getInvalidUserLogins")
    public static Object[][] getCSVdata() {
        return CSVDataReaderString.getCSVData("invalid_userlogins.csv");
    }

}

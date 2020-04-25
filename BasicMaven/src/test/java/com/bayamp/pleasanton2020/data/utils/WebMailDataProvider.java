package com.bayamp.pleasanton2020.data.utils;

import com.bayamp.pleasanton2020.utils.CSVReaderString;
import com.bayamp.pleasanton2020.utils.PropertyUtils;
import org.testng.annotations.DataProvider;

public class WebMailDataProvider {
    @DataProvider(name="validlogintest")
    public Object[][] getMyLoginCSVData(){
        return CSVReaderString.getCSVData(PropertyUtils.getProperty("loginsuccesscsvdatafilepath"));
    }
    @DataProvider(name="invalidLogintest")
    public Object[][] getinvalidLogintestdata(){
        return CSVReaderString.getCSVData(PropertyUtils.getProperty("logininvalidusrlogincsvdatafilepath"));
    }
}

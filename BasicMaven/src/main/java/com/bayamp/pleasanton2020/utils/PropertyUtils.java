package com.bayamp.pleasanton2020.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    private static final String CONFIG_PROPERTY_FILE_PATH = "src//main//resources//config//env.properties";
    public static Properties prop = null;

    public static String getProperty(String propertyName) {
        if (prop == null) {
            try {
                System.out.println(CONFIG_PROPERTY_FILE_PATH);
                FileInputStream inputStream = new FileInputStream(new File(CONFIG_PROPERTY_FILE_PATH));
                prop = new Properties();
                prop.load(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(propertyName);
    }

}

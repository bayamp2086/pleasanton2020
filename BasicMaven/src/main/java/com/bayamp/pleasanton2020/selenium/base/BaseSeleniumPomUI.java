package com.bayamp.pleasanton2020.selenium.base;

import com.bayamp.pleasanton2020.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSeleniumPomUI {

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chrome//chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PropertyUtils.getProperty("app_url"));
        return driver;
    }

}

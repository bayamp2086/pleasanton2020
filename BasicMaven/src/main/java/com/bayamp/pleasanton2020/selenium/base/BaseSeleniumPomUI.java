package com.bayamp.pleasanton2020.selenium.base;

import com.bayamp.pleasanton2020.selenium.pageobjects.locators.WebMailPageLocators;
import com.bayamp.pleasanton2020.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseSeleniumPomUI {
    WebDriver driver;

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chrome//chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PropertyUtils.getProperty("app_url"));
        return driver;
    }

//@AfterTest


}

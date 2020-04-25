package com.bayamp.pleasanton2020.selenium.pageobjects;

import com.bayamp.pleasanton2020.selenium.pageobjects.locators.WebMailPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WebMailPage {
    public static WebDriver driver;

    public WebMailPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isLogOutBtnExits() {

        try {
            if (driver.findElement(WebMailPageLocators.LOGOUT_BUTTON_XPATH).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }catch ( NoSuchElementException e ){
            return false;
        }

    }
}

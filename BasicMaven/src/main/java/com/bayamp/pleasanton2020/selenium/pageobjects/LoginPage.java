package com.bayamp.pleasanton2020.selenium.pageobjects;

import com.bayamp.pleasanton2020.selenium.pageobjects.locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   private static WebDriver  driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebMailPage login(String useremail,String passwd){
        driver.findElement(LoginPageLocators.LOGIN_EMAIL_FIELD_CSS_LOCATOR).sendKeys(useremail);
        driver.findElement(LoginPageLocators.LOGIN_PASSWD_FIELD_CSS_LOCATOR).sendKeys(passwd);
        driver.findElement(LoginPageLocators.LOGIN_SUBMIT_BUTTON_XPATH_LOCATOR).click();
        WebMailPage webMailPage = new WebMailPage(driver);
        return webMailPage;

    }

}

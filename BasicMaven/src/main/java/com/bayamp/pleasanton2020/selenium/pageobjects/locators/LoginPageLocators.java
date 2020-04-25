package com.bayamp.pleasanton2020.selenium.pageobjects.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By LOGIN_EMAIL_FIELD_CSS_LOCATOR=By.cssSelector("#user");
    public static final By LOGIN_PASSWD_FIELD_CSS_LOCATOR=By.cssSelector("#pass");
    public static final By LOGIN_SUBMIT_BUTTON_XPATH_LOCATOR=By.xpath("//button[@type='submit']");
}

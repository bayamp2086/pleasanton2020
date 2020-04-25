package com.bayamp.pleasanton2020.selenium.webmail.tests;

import com.bayamp.pleasanton2020.selenium.base.BaseSeleniumPomUI;
import com.bayamp.pleasanton2020.selenium.pageobjects.LoginPage;
import com.bayamp.pleasanton2020.selenium.pageobjects.WebMailPage;
import com.bayamp.pleasanton2020.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseSeleniumPomUI {



    @Test
    public void validSuccessLogin() {
        WebDriver driver = getDriver();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(PropertyUtils.getProperty("user"),PropertyUtils.getProperty("passwd"));
        Assert.assertTrue(WebMailPage.isLogOutBtnExits());
    }
}
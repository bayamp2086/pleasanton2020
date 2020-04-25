package com.bayamp.pleasanton2020.selenium.webmail.tests;

import com.bayamp.pleasanton2020.data.utils.WebMailDataProvider;
import com.bayamp.pleasanton2020.selenium.base.BaseSeleniumPomUI;
import com.bayamp.pleasanton2020.selenium.pageobjects.LoginPage;
import com.bayamp.pleasanton2020.selenium.pageobjects.WebMailPage;
import com.bayamp.pleasanton2020.selenium.pageobjects.locators.WebMailPageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseSeleniumPomUI {
    private WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        driver = getDriver();
    }

   // @AfterMethod
    public void logOut() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(WebMailPageLocators.LOGOUT_BUTTON_XPATH).click();
    }
    @AfterTest
    public  void closeBrowser(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.close();
    }

    @Test(dataProvider = "validlogintest", dataProviderClass = WebMailDataProvider.class)
    public void validSuccessLogin(String username, String passwd) {

        LoginPage loginPage = new LoginPage(driver);
        //loginPage.login(PropertyUtils.getProperty("user"),PropertyUtils.getProperty("passwd"));
        loginPage.login(username, passwd);
        Assert.assertTrue(WebMailPage.isLogOutBtnExits());
        driver.findElement(WebMailPageLocators.LOGOUT_BUTTON_XPATH).click();
    }

    @Test(dataProvider = "invalidLogintest",dataProviderClass = WebMailDataProvider.class)
    public  void invalidUserLogin(String username,String passwd){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username, passwd);
        Assert.assertFalse(WebMailPage.isLogOutBtnExits());
    }
}
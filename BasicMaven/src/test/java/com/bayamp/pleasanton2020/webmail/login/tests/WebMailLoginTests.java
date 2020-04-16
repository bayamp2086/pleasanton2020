package com.bayamp.pleasanton2020.webmail.login.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebMailLoginTests {
    private WebDriver driver;
    private String app_url = new String("http://webmail.bayamp.com/");
    private String user_by_id = new String("user");
    private String user_by_css=new String("#user");
    private String passwd_by_id = new String("pass");
    private String passed_by_css=new String("#pass");
    /*  private String userid = new String("user1@bayamp.com");
        private String passwd = new String("user1");*/
    private String submit_xpath = new String("//button[@type='submit']");
    private String logout_xpath = new String("//span[@id='lblLogout']");
    private String login_page_title=new String("Webmail Login");

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    @Test(dataProvider = "getsuccessloginuserData",dataProviderClass= DataProviderForData.class)
    public void testLoginSuccess(String userid, String passwd) {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chrome//chromedriver.exe");
        driver = new ChromeDriver();
        Reporter.log("Lauching the web mail application");
        driver.get(app_url);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Reporter.log("Enter user email: "+userid);
        driver.findElement(By.id(user_by_id)).sendKeys(userid);
        Reporter.log("Enter user password: "+passwd);
        driver.findElement(By.id(passwd_by_id)).sendKeys(passwd);
        Reporter.log("Click onthe Log In button");
        driver.findElement(By.xpath(submit_xpath)).click();
        Reporter.log("Verifying if the logout button exit");
        Assert.assertTrue(isElementExists(logout_xpath));
        driver.findElement(By.xpath(logout_xpath)).click();
    }

    public boolean isElementExists(String xpath) {
        int numOfElements = driver.findElements(By.xpath(xpath)).size();
        if (numOfElements == 0) {
            return false;
        } else {
            return true;
        }
    }
}

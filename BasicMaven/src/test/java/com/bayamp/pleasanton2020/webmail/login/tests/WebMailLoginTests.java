package com.bayamp.pleasanton2020.webmail.login.tests;

import com.bayamp.pleasanton2020.data.utils.WebMailUtilsDataProvider;
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
    private String user_by_css = new String("#user");
    private String passwd_by_id = new String("pass");
    private String passed_by_css = new String("#pass");
    private String submit_xpath = new String("//button[@type='submit']");
    private String logout_xpath = new String("//span[@id='lblLogout']");
    private String login_page_title = new String("Webmail Login");

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    /**
     *
     * Automation testcases for the successfull login with valid user logins
     * TC12 in test rail
     */

    @Test(dataProvider = "getValidUserLoginsData", dataProviderClass = WebMailUtilsDataProvider.class)
    public void testLoginSuccess(String userid, String passwd) {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chrome//chromedriver.exe");
        driver = new ChromeDriver();
        Reporter.log("Lauching the web mail application");
        driver.get(app_url);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Reporter.log("Enter user email: " + userid);
        driver.findElement(By.id(user_by_id)).sendKeys(userid);
        Reporter.log("Enter user password: " + passwd);
        driver.findElement(By.id(passwd_by_id)).sendKeys(passwd);
        Reporter.log("Click on the Log In button");
        driver.findElement(By.xpath(submit_xpath)).click();
        Reporter.log("Verifying if the logout button exit" + isElementExists(logout_xpath));
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
    /**
     *
     * Automation testcases for the unsuccessfull login with invalid user logins
     * TC13 in test rail
     */
    @Test(dataProvider = "getInvalidUserLogins", dataProviderClass = WebMailUtilsDataProvider.class)
    public void invalidLogins(String userid, String passwd, String expectedResults) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chrome//chromedriver.exe");
        driver = new ChromeDriver();
        Reporter.log("Launching the Application Url: " + app_url);
        driver.get(app_url);
        Reporter.log("Entering the User id: " + userid);
        driver.findElement(By.cssSelector(user_by_css)).sendKeys(userid);
        Reporter.log("Entering the password: " + passwd);
        driver.findElement(By.cssSelector(passed_by_css)).sendKeys(passwd);
        Reporter.log("Click onthe Log In button");
        driver.findElement(By.xpath(submit_xpath)).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("expectedResults: " + expectedResults);
        Reporter.log("Asserting : " );
        Reporter.log("Acutal Result: " + driver.getTitle() );
        Reporter.log(" expected Results: " + login_page_title);
        Assert.assertEquals(driver.getTitle(), login_page_title);
        Thread.sleep(30000);
    }
}

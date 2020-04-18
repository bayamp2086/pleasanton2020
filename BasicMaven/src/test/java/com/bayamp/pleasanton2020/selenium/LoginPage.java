package com.bayamp.pleasanton2020.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {
    private static final String APP_URL = "http://webmail.bayamp.com";
    private static WebDriver driver;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;

    @BeforeClass
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }

    @Test

    public void positiveLoginTest() throws InterruptedException {
        String expectedUserEmail = "user1@bayamp.com";
        String expectedLogOutText = "Logout";
        Reporter.log("Login to application URL: " + APP_URL, true);
        driver.get(APP_URL);
        Reporter.log("UserId:user1@bayamp.com; Password:user1", true);
        driver.findElement(By.cssSelector("#user")).sendKeys("user1@bayamp.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("user1");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        // driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        // To Synchronize with the delay in the application loading the pages
        // Thread.sleep(30000);//hard wait of 30secs
        WebDriverWait wait = new WebDriverWait(driver, 30);// max of 30 secs
        //   wait.until(ExpectedConditions.visibilityOf(userField));
        submitButton.click();
        Reporter.log("Checking Username and LogoutText for Passing TestCase");
        String actualUserEmail = driver.findElement(By.id("lblUserNameTxt")).getText();
        String actualLogOutText = driver.findElement(By.id("lblLogout")).getText();
        Assert.assertEquals(actualUserEmail, expectedUserEmail);
        Assert.assertEquals(actualLogOutText, expectedLogOutText);
        Reporter.log("End Of TestCase", true);

    }

    @Test
    public void negativeLoginTest1() {
        String actualUrl = "http://webmail.bayamp.com/login/";
        String actualTitle = "Webmail Login";
        Reporter.log("Login to application URL: " + APP_URL, true);
        driver.get(APP_URL);
        Reporter.log("UserId:user12@bayamp.com; Password:user1", true);
        driver.findElement(By.cssSelector("#user")).sendKeys("user12@bayamp.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("user1");
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        String expectedUrl = driver.getCurrentUrl();
        String expectedTitle = driver.getTitle();
        Reporter.log("Checking URL and PageTitle for Passing TestCase");
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        //driver.close();
    }


    @Test
    public void negativeLoginTest2() {
        String expectedMessage = "The login is invalid.";
        Reporter.log("Login to application URL: " + APP_URL, true);
        driver.get(APP_URL);
        Reporter.log("UserId:pnjmurali; Password:user1234", true);
        driver.findElement(By.cssSelector("#user")).sendKeys("pnjmurali");
        driver.findElement(By.cssSelector("#pass")).sendKeys("user1234");
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        String actualMessage = driver.findElement(By.id("login-status-message")).getText();
        Reporter.log("Checking ErrorMessage for Passing TestCase");
        Assert.assertEquals(actualMessage, expectedMessage);

    }


    @Test
    public void negativeLoginTest3() {
        String expectedMessage = "You must specify a username to log in.";
        Reporter.log("Login to application URL: " + APP_URL, true);
        driver.get(APP_URL);
        Reporter.log("UserId:blank;", true);
        driver.findElement(By.cssSelector("#user")).sendKeys("");
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Reporter.log("Checking ErrorMessage for Passing TestCase");
        String actualMessage = driver.findElement(By.id("login-status-message")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }


    @Test
    public void negativeLoginTest4() {
        String actualUrl = "http://webmail.bayamp.com/login/";
        String actualTitle = "Webmail Login";
        Reporter.log("Login to application URL: " + APP_URL, true);
        driver.get(APP_URL);
        Reporter.log("UserId:user1@bayamp.com; Password:user41", true);
        driver.findElement(By.cssSelector("#user")).sendKeys("user1@bayamp.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("user41");
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        String expectedUrl = driver.getCurrentUrl();
        String expectedTitle = driver.getTitle();
        Reporter.log("Checking URL and PageTitle for Passing TestCase");
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}








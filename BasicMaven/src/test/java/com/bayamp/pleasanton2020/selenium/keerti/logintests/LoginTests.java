package com.bayamp.pleasanton2020.selenium.keerti.logintests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {

    private static final String APP_URL = "http://webmail.bayamp.com";
    private static WebDriver driver;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;

    @BeforeMethod
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver");
        driver = new ChromeDriver();}
    @AfterMethod
    public void closeDriver() {
        driver.close();
        driver.quit();}

    @DataProvider(name = "LoginTestCase")
    public Object[][] getData() {
        Object[][] mydata1 = {{"user1@bayamp.com", "user1"}, {"user1@bayamp.com", "user1"}};
        return mydata1;}
        
    @Test(dataProvider = "LoginTestCase", priority =1)
    public void HappyPathLoginTest(String userEmail, String userPassword) {
        String expectedUserEmail = "user1@bayamp.com";
        //String expectedLogOutText = "Logout";
        Reporter.log("Login to application URL: " + APP_URL);
        driver.get(APP_URL);
        userField = driver.findElement(By.cssSelector("#user"));
        passwordField = driver.findElement(By.cssSelector("#pass"));
        submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);// max of 30 secs
        wait.until(ExpectedConditions.visibilityOf(userField));
        userField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        submitButton.click();
        String actualUserEmail = driver.findElement(By.id("lblUserNameTxt")).getText();
        Assert.assertEquals(actualUserEmail, userEmail);}

    @DataProvider(name = "LoginNegativeTest")
    public Object[][] getData1() {
        Object[][] mydata1 = {{"", ""}};
        return mydata1;}

    @Test(dataProvider = "LoginNegativeTest", priority = 2)
    public void negativeLoginTestCase(String actualUserEmail, String actualPassword) throws Exception {
        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userField.sendKeys(actualUserEmail);
        passwordField.sendKeys(actualPassword);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);// max of 30 secs
        wait.until(ExpectedConditions.visibilityOf(userField));
        String expectedValiation = "You must specify a username to log in.";
        // By divElement = By.xpath("//div[@id='login-status-message']");
        WebElement errorMessageWebElement = driver.findElement(By.id("login-status-message"));
        String valueOfTheMessage = errorMessageWebElement.getText();
        System.out.println(valueOfTheMessage);
        Assert.assertEquals(valueOfTheMessage, expectedValiation);}

    @DataProvider(name = "InvalidEmailTest")
    public Object[][] getdata() {
        Object[][] mydata = {{"user@bayamp.com", "user1"}};
        return mydata;}

    @Test(dataProvider = "InvalidEmailTest")
    public void invalidEmailTestCase(String invalidEmail, String validPassword) {
        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userField.sendKeys(invalidEmail);
        passwordField.sendKeys(validPassword);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);// max of 30 secs
       // wait.until(ExpectedConditions.visibilityOf(userField));
        String actualResult = driver.getTitle();
        String expectedResult = "Webmail Login";
        Assert.assertEquals(actualResult, expectedResult);
    }
    @DataProvider(name="InavlidEmailFormat")
    public Object[][] getdata1(){
        Object[][] mydata2={{"user1@bayamp.com.","user1"}};
        return mydata2;
    }
    @Test(dataProvider = "InavlidEmailFormat", priority = 4)
    public void invalidEmailFormatTestCase(String invalidEmail, String validPassword)
    {
        driver.get(APP_URL);
        userField=driver.findElement(By.cssSelector("#user"));
        passwordField=driver.findElement(By.cssSelector("#pass"));
        submitButton=driver.findElement(By.cssSelector("button[type='submit']"));
        userField.sendKeys(invalidEmail);
        passwordField.sendKeys(validPassword);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);// max of 30 secs
       // wait.until(ExpectedConditions.visibilityOf(userField));
        WebElement actualVal=driver.findElement(By.xpath("//div[@id='login-status-message']"));
        String actualResult= actualVal.getText();
        System.out.println(actualVal);
        String expectedResult="The submitted username is invalid.";
        Assert.assertEquals(actualResult,expectedResult);}
}








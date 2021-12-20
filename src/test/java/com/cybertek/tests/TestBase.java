package com.cybertek.tests;

import com.cybertek.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;
    protected Faker faker = new Faker();
    protected Actions actions;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown(){

    //    Driver.closeDriver();
    }

}

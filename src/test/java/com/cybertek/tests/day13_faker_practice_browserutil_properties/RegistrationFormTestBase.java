package com.cybertek.tests.day13_faker_practice_browserutil_properties;
// parent class for RegistrationFormTest
// Created by: Shamsiye


import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class RegistrationFormTestBase {

    String url = "http://practice.cybertekschool.com/registration_form";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);


    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }




}

package com.cybertek.homework;

import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.SmartBearUtils;
import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LibraryTask1_2_3 {

    String url = "http://library2.cybertekschool.com/login.html";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void librarySoftwareLinkVerification() {


        WebElement username = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        BrowserUtils.sleep(2);
        username.sendKeys("librarian13@library ");


        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        password.sendKeys("9rf6axdD" + Keys.ENTER);


    }





}

package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC_FacebookIncorrectLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("user name");

        driver.findElement(By.id("pass")).sendKeys("password" + Keys.ENTER);

        //  driver.findElement(By.name("login")).click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String actTitle = driver.getTitle();
        String expTitle = "Log into Facebook";

        if (actTitle.equals(expTitle)) {
            System.out.println("Title is matched");
        } else {
            System.out.println("Title is dismatched");
        }

        driver.quit();


    }
}

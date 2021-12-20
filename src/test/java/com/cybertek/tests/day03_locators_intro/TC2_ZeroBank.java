package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_ZeroBank {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

       String actLftText =driver.findElement(By.className("brand")).getText();

        String expLftText="Zero Bank";

        if (actLftText.equals(expLftText)){
            System.out.println("text matched");
        }else {
            System.out.println("text dismatched");
        }
















    }
}

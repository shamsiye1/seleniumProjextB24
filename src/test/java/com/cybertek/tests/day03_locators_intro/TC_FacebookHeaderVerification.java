package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FacebookHeaderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        System.out.println(driver.findElement(By.tagName("h2")).getText());

        String actHeader = driver.findElement(By.tagName("h2")).getText();

        String expHeader = "联系你我，分享生活，尽在 Facebook";

        if (actHeader.equals(expHeader)) {
            System.out.println("Title is matched");
        } else {
            System.out.println("Title is dismatched!!!");
        }

        driver.quit();


    }
}

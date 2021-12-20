package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_FacebookTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.facebook.com");

        System.out.println(driver.getTitle());

        String expTitle = "Facebook - 登录或注册";
        if (driver.getTitle().equals(expTitle)) {
            System.out.println("Title match");
        } else {
            System.out.println("Title dismatched");
        }


        driver.close();


    }
}

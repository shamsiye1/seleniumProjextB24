package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC6_ZeroBankheaderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        String expHeaderText = "Log in to ZeroBank";

        String actualHeaderText = driver.findElement(By.tagName("h3")).getText();

        if (actualHeaderText.equals(expHeaderText)) {
            System.out.println("Header text is matched");
        } else {
            System.out.println("Header text is Dismatched!!");
        }

        String expLftTopText = "Zero Bank";


    }
}

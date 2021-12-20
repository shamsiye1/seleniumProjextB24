package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_EtsySearchTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.etsy.com/ca/");

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);

        driver.findElement(By.linkText("Christmas Shop")).click();

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        String expHeaderTitle = "Holiday Shop";

        String actHeaderTitle = driver.findElement(By.tagName("h1")).getText();

        if (actHeaderTitle.equals(expHeaderTitle)) {
            System.out.println("Title was matched");
        } else {
            System.out.println("Title was dismatched");
        }

        driver.quit();


    }
}

package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC4_GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://google.com");

        // locate and type "apple" to google search
       // driver.findElement(By.name("q")).sendKeys("apple");

        //locate and click on search bottom
        // driver.findElement(By.name("btnK")).click();

        // another way to  type "apple" to google search
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        String expTitle = "apple";

        if (driver.getTitle().startsWith(expTitle)) {
            System.out.println("PASSED: Title match");
        } else {
            System.out.println("FAILED: Title mismatch");
        }


//        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.quit();


    }
}

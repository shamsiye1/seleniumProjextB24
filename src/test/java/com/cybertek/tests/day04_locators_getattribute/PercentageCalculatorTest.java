package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PercentageCalculatorTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

//        - launch browser, maximize
//                - navigate to https://www.calculator.net/
//        - Click on Percentage Calculator


//                - Print the result "Result: 24000"
//                - close browser
        driver.get("https://www.calculator.net/");

        driver.findElement(By.linkText("Percentage Calculator")).click();
        String expTitle = "Percentage Calculator";
        String actTitle = driver.getTitle();
        //                - Verify current title is "Percentage Calculator"
        if (actTitle.equals(expTitle)) {
            System.out.println("verification passed!!");
        } else {
            System.out.println("FAILED!!!");
        }
//                - Enter 20% of 120000 and click enter (using Keys.ENTER)
        driver.findElement(By.id("cpar1")).sendKeys("20");
        driver.findElement(By.id("cpar2")).sendKeys("120000" + Keys.ENTER);

        //- Print the result "Result: 24000"

        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // tagName is here not a unique so we can use classname
        //System.out.println(driver.findElement(By.tagName("h2")).getText());

        System.out.println(driver.findElement(By.className("h2result")).getText());

        Thread.sleep(5000);
        driver.quit();


    }


}

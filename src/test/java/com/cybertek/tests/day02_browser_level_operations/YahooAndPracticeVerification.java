package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooAndPracticeVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
          // maximize the screen
     //   driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        String expectedTitle="Yahoo";

        System.out.println("Printed title: "+driver.getTitle());

        if (driver.getTitle().contains(expectedTitle)){
            System.out.println("Test case passed");
        }else {
            System.out.println("Test case Failed!!");
        }

        System.out.println("================================");

        driver.navigate().to("http://practice.cybertekschool.com");

        // maximize the screen
      //  driver.manage().window().fullscreen();

        String expectedTitleCybertek= "cybertekschool";
        if (expectedTitleCybertek.equals(driver.getTitle())){
            System.out.println("Test case passed!");
        }else {
            System.out.println("Test case Failed!!!");
        }

        String expectedUrl= "http://practice.cybertekschool.com/";

        if (expectedTitleCybertek.equals(driver.getCurrentUrl())){
            System.out.println("Title verification Passed!!");
        }else {
            System.out.println("verification failed");
        }
      //  driver.quit();















    }
}

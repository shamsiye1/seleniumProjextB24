package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String googleUrl="https://google.com";

        driver.get("https://google.com");

    //    driver.findElements(By.name("Gmail"));

     //   driver.navigate().to("https://mail.google.com/mail/&amp;ogbl");

     // Find gmail link and click on it
    // driver.findElement(By.linkText("Gmail")).click();

        driver.findElement(By.partialLinkText("mail")).click();


     // verify title contains/ starts with gmail

        String expectedTitle="Gmail";
//        String actualTitle= driver.getTitle(); also we can use variable to store the value

        if (driver.getTitle().startsWith(expectedTitle)){ //or  driver.getTitle().contains(expectedTitle)
            System.out.println("verification passed!");
        }else {
            System.out.println("verification failed!!!");
        }

        driver.navigate().back();

        String expectedGoogleTitle="Google";

        if (driver.getTitle().equals(expectedGoogleTitle)){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!!!");
        }




       driver.quit();


























    }
}

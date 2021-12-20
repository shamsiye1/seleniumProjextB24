package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1. set up browser driver

        WebDriverManager.chromedriver().setup();

        //2. open browser ,create object
        WebDriver driver = new ChromeDriver();

        //3. navigate to tesla homepage
        driver.get("https://www.tesla.com/");

        // navigate back.  similar to clicking back button
        // on the browser

        driver.navigate().back();

        // sleep method, in order to pause the code few second.
        Thread.sleep(2000);

        // navigate forward
        driver.navigate().forward();

        Thread.sleep(2000);

        // for refreshes the page,
        // similar to clicking on refresh icon on the browser
        driver.navigate().refresh();

        Thread.sleep(2000);

        // it accepts url, and navigates to that url
        // navigate to etsy homepage
        driver.navigate().to("https://www.bestbuy.com");

        // print title of the page
        System.out.println("Current title: "+driver.getTitle());

        // close the browser
        driver.quit();



    }
}

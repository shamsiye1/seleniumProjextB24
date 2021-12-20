package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        //1. set up browser driver
        // method
        WebDriverManager.chromedriver().setup();

        //2. open the browser. Create object of chromeDriver class
        // interface
        WebDriver driver= new ChromeDriver();
        /*  same like below
         List<Integer> nums=new ArrayList<>();
          */
        // Goto google homepage
        driver.get("https://www.google.com");















    }
}

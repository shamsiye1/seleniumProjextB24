package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {
    public static void main(String[] args) {
//        Locate the search field and assign to WebElement variable
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //     org.openqa.selenium.WebElement searchField = driver.findElement(By.name("q"));

            driver.get("https://google.com");

            WebElement searchField= driver.findElement(By.name("q"));

        System.out.println("Class value= "+ searchField.getAttribute("class"));

        System.out.println("max length = "+searchField.getAttribute("maxlength"));

        searchField.sendKeys("wooden spoon");

        // read the value that is in the search field.
        System.out.println("current value = "+ searchField.getAttribute("value"));

        System.out.println("name: "+ searchField.getAttribute("class"));


    }
}

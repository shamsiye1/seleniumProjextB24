package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword_CSS_Test {
    public static void main(String[] args) throws InterruptedException {
        String url="http://practice.cybertekschool.com/forgot_password";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='text']"));

        emailField.sendKeys("abc@gmail.com");

        Thread.sleep(1000);

        emailField.clear();
        emailField.sendKeys("second@gmail.com");

        for (int i=3; i<10; i++){
            Thread.sleep(1000);
            emailField.clear();
            emailField.sendKeys("stuent"+i+"@gmail.com");

        }
    }
}

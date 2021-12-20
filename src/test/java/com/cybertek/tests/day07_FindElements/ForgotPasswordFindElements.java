package com.cybertek.tests.day07_FindElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ForgotPasswordFindElements {
    public static void main(String[] args) throws InterruptedException {

        String appUrl = "http://practice.cybertekschool.com/forgot_password";

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get(appUrl);

        List<WebElement> links = driver.findElements(By.xpath("//a"));


        System.out.println("count of links " + links.size());
        System.out.println("first link: " + links.get(0).getText());
        System.out.println("Second link: " + links.get(1).getText());

        for (WebElement eachElement : links) {
            System.out.println(eachElement.getText() + " ");
        }

        for(WebElement link: links){
            System.out.println(link.getAttribute("href"));
        }

        // click on home link at index 1
        links.get(1).click();





        Thread.sleep(3000);
        driver.quit();


    }
}

package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearUtils {

    public static void loginToSmartBear(WebDriver driver) {

        WebElement username = driver.findElement(By.name("ctl00$MainContent$username"));
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }

    public static void verifyOrder(WebDriver driver, String name) {
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody//tr/td[2]"));
        boolean result = false;
        for (WebElement eachName : nameList) {
            if (eachName.getText().equals(name)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "name is not in the list");
    }

    public static void printNamesAndCities(WebDriver driver) {

        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody//tr/td[2]"));

        List<WebElement> cityList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[7]"));

        for (int i = 0; i < nameList.size(); i++) {

            System.out.println("Name" + (i + 1) + ": " + nameList.get(i).getText() + " , City" + (i + 1) + ": " + cityList.get(i).getText());

        }

    }


}

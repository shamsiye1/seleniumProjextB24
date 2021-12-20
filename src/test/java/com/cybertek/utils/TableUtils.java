package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TableUtils {

    //PRACTICE #4: Method: verifyOrder
    //• Create a method named verifyOrder in TableUtils class.
    //• Method takes WebDriver object and String(name).
    //• Method should verify if given name exists in orders.
    //• This method should simply accepts a name(String), and assert whether
    //given name is in the list or not.
    //• Create a new TestNG test to test if the method is working as expected.

    public static void verifyOrder(WebDriver driver, String name) {

        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='table1']/tbody//td[2]"));

        boolean result = false;
        for (WebElement eachName : nameList) {

            if (eachName.getText().equals(name)) {

                result = true;
                return;
            }


        }
        Assert.assertTrue(result, "name isn't in the list");

    }

    public static void printNamesAndEmails(WebDriver driver) {
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='table1']/tbody//td[2]"));
        List<WebElement> emailList = driver.findElements(By.xpath("//table[@id='table1']/tbody//td[3]"));

        for (int i = 0; i < nameList.size(); i++) {

            System.out.println("Name"+(i+1)+": " + nameList.get(i).getText() + ", Email"+(i+1)+": " + emailList.get(i).getText());

        }


    }

}

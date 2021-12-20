package com.cybertek.tests.day07_FindElements;

import com.cybertek.utils.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddAndRemoveElements {

    public static void main(String[] args) throws InterruptedException {

//        TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
//        1. Open Chrome browser
//        2. Go to http://practice.cybertekschool.com/add_remove_elements
        String appUrl = "http://practice.cybertekschool.com/add_remove_elements/";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get(appUrl);

//        3. Click to “Add Element” button 50 times

        //<button onclick="addElement()">Add Element</button>
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 1; i <= 50; i++) {
            Thread.sleep(1000);
            addButton.click();
        }
//        4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("Count of delete Buttons = " + deleteButtons.size());

        if (deleteButtons.size() == 50) {
            System.out.println("PASS: 50 buttons successfully");
        } else {
            System.out.println("FAILED: cannot add 50 buttons");

        }

        // use for each methods with lambda expression
        deleteButtons.forEach(deleteBtn -> deleteBtn.click());

//        5. Click to ALL “Delete” buttons to delete them.
        // run find elements for delete buttons again and see if it is 0

        //        6. Verify “Delete” button is NOT displayed after clicking.
        deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));


        if (deleteButtons.isEmpty()) {
            System.out.println("PASS: all buttons deleted");

        } else {
            System.out.println("FAIL: could not delete all 50 buttons");
        }

        driver.quit();

    }


}

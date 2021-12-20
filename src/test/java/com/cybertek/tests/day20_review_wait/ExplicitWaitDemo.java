package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitDemo extends TestBase {

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement triggerBtn = driver.findElement(By.xpath("//button[.='Start']"));

        triggerBtn.click();

        WebElement inputName = driver.findElement(By.xpath("//input[@id='username']"));
        // in order to use explicit wait you need to create "wait" object
        WebDriverWait wait = new WebDriverWait(driver, 10); // constructor expects parameters
        // Driver object  2. waiting time

        //give condition for the element that you are waiting for, for this case element that i am waiting for is user name

        wait.until(ExpectedConditions.visibilityOf(inputName));

        inputName.sendKeys("hellow");

        // when we comment out implicit wait to observe sychronization problem
        // ElementNoInteractableException: element not interactable
    }

    @Test
    public void dynamicControlWait() {

        driver.get("http://practice.cybertekschool.com/dynamic_controls");



        WebElement clickBtn = driver.findElement(By.xpath("//button[.='Enable']"));
        clickBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@type='text']"))));

        WebElement unclickBtn = driver.findElement(By.xpath("//button[.='Disable']"));
        unclickBtn.click();
     //  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().fullName())));
    }


}

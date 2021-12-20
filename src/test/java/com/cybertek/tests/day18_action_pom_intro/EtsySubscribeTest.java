package com.cybertek.tests.day18_action_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class EtsySubscribeTest extends TestBase {

    @Test
    public void etsySubscribeTest() {

        driver.get(ConfigurationReader.getProperty("etsy.url"));

//      Goto Etsy homepage
//Scroll down
//Generate random email and enter into subscribe box
//Click on Subscribe
//Verify "Great! We've sent you an email to confirm your subscription." is displayed
        BrowserUtils.sleep(1);

        WebElement emailBox = driver.findElement(By.id("email-list-signup-email-input"));
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true)", emailBox);   // I created scroll Method on BrowserUtils

        BrowserUtils.scrollDown(emailBox);

        //Faker faker = new Faker();  // faker object already created by TestBase class, since then we don't need to create new faker object when we extends TestBase class.
        emailBox.sendKeys(faker.internet().emailAddress() + Keys.ENTER);
        BrowserUtils.sleep(1);

        WebElement successMsg = driver.findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        System.out.println(successMsg.getText());
        assertEquals(successMsg.getText(), "Great! We've sent you an email to confirm your subscription.");

    }






}

package com.cybertek.tests.day10_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingAlertsTest {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/javascript_alerts";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void jsAlertsTest() {
        //click on Informational/warning alert link
        //<button class="btn btn-primary" onclick="jsAlert()">Click for JS Alert</button>
        WebElement infoAlertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        infoAlertLink.click();


        // switch to alert and click on ok
        Alert infoAlert = driver.switchTo().alert();
        System.out.println("Alert text: " + infoAlert.getText());

        infoAlert.accept();


    }

    @Test
    public void confirmAlertTest() {
        //<button class="btn btn-primary" onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement confirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirm.click();

        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("confirm alert text: " + confirmAlert.getText());

        Assert.assertEquals(confirmAlert.getText(),"I am a JS Confirm", "text is not match");
        confirmAlert.dismiss(); // cancel

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}

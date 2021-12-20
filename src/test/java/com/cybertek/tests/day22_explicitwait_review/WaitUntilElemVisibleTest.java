package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitUntilElemVisibleTest extends TestBase {

    @Test
    public void waitForWebDriverElem() {

        driver.get(ConfigurationReader.getProperty("seleniumPractice.url"));
        WebElement startTimer = driver.findElement(By.xpath("//button[@onclick='timedText()']"));

        startTimer.click();

        //
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='WebDriver']")));

        System.out.println("WebDriver is now visible");

        wait.until(ExpectedConditions.textToBe(By.id("demo"), "WebDriver"));


    }


    @Test
    public void cheapInternetSpeedTest() {

        driver.get(ConfigurationReader.getProperty("speedtest.url"));

        WebDriverWait wait = new WebDriverWait(driver, 60);

        //  WebElement findingLabel = driver.findElement(By.xpath("//a[.='Rogers Wireless']"));
        // wait.until(ExpectedConditions.invisibilityOf(findingLabel));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Change Server")));

        WebElement goBtn = driver.findElement(By.xpath("//span[@class='start-text']"));
        goBtn.click();

        WebElement circle = driver.findElement(By.xpath("//canvas[@class='gauge-speed-text']"));
        wait.until(ExpectedConditions.visibilityOf(circle));

        wait.until(ExpectedConditions.invisibilityOf(circle));

        System.out.println("canvas dissapeared");


    }





}

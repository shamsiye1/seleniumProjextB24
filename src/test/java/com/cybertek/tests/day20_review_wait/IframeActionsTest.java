package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class IframeActionsTest extends TestBase {

    @Test
    public void task(){

        driver.get(ConfigurationReader.getProperty("doubleclick.url"));

        //  switch to iframe
        driver.switchTo().frame("iframeResult");

        WebElement textForDoubleClick = driver.findElement(By.id("demo"));

        // already have my actions object
        BrowserUtils.sleep(1); // static way
        actions.doubleClick(textForDoubleClick).perform();
        BrowserUtils.sleep(1);

        String expStyle = "red";
        String actStyle = textForDoubleClick.getAttribute("style");

        assertTrue(actStyle.contains(expStyle));




    }
    

}

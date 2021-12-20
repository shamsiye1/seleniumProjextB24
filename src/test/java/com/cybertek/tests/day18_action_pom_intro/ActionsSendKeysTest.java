package com.cybertek.tests.day18_action_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ActionsSendKeysTest extends TestBase {

    @Test
    public void scrollWithKeysTest() {

        driver.get(ConfigurationReader.getProperty("practice.base.url"));
        WebElement cbSchoolLink = driver.findElement(By.linkText("Cybertek School"));
        actions.moveToElement(cbSchoolLink).perform();

        // Actions class can also be used to automate keyboard key presses.
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    @Test
    public void rightClickTest(){

        driver.get(ConfigurationReader.getProperty("practice.base.url"));

        // how to right click using selenium? // can use Actions
        WebElement A_BTesting = driver.findElement(By.linkText("A/B Testing"));

        actions.contextClick(A_BTesting).perform();
        BrowserUtils.sleep(1);

        actions.contextClick(A_BTesting).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(A_BTesting, Keys.ENTER).perform();





    }





}

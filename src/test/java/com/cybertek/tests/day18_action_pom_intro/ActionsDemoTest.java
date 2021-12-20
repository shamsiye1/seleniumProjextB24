package com.cybertek.tests.day18_action_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsDemoTest extends TestBase {

    @Test
    public void hoverElementTest() {

        driver.get(ConfigurationReader.getProperty("hover.url"));
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));

        // create Actions class object to be able to hover over image
        //  Actions actions = new Actions(driver); //this action already declared by TestBase class, so here i just directly use

        //hover over img1          // perform() method means (do it).
        actions.moveToElement(img1).perform();

        List<WebElement> imgList = driver.findElements(By.xpath("//img"));
        for (WebElement eachImg : imgList) {
            BrowserUtils.sleep(1);
            actions.moveToElement(eachImg).perform();
        }

    }

    @Test
    public void googleFeelingLuckBtnHoverTest() {
        driver.get(ConfigurationReader.getProperty("google.url"));

        WebElement searchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
        WebElement luckyBtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnI']"));

        //  Actions actions = new Actions(driver);  // this action declaring actions object step actually automatically done by TestBase class,
        actions.moveToElement(searchBtn).perform();
        BrowserUtils.sleep(1);
        actions.moveToElement(luckyBtn).perform();

        for (int i = 0; i < 5; i++) {
            BrowserUtils.sleep(1);
            actions.moveToElement(searchBtn).perform();

            actions.moveToElement(luckyBtn).perform();
        }

    }


}

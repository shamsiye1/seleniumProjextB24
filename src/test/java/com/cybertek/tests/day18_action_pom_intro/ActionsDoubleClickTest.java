package com.cybertek.tests.day18_action_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsDoubleClickTest extends TestBase {

    @Test
    public void doubleClickForColorChange(){

        driver.get(ConfigurationReader.getProperty("doubleclick.url"));

        //switch to iframe
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.id("demo"));

        System.out.println("text = " + text.getText());
// this line combines creating object of Actions class then calling doubleClick method into single statement
        actions.doubleClick(text).perform();

        System.out.println( "text: "+ text.getAttribute("style"));
      //  Assert.assertTrue(text.getAttribute("syle"));



    }


}

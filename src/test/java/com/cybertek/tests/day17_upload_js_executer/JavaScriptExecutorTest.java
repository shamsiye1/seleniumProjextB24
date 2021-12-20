package com.cybertek.tests.day17_upload_js_executer;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends TestBase {

    @Test
    public void alertExampleTest(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // make window pop up alert tab
        //running javascript alert command
        js.executeScript("alert('omg what are you doing!!!')");

        BrowserUtils.sleep(1);

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text = "+alert.getText());
        alert.accept();
    }

    @Test
    public void scrollTest(){
    driver.get(ConfigurationReader.getProperty("scroll.url"));
   BrowserUtils.sleep(1);

    JavascriptExecutor js = (JavascriptExecutor) driver;
                                           // +5000 for scroll downPage
    js.executeScript("window.scrollBy(0, 5000)");

    for (int i = 0; i < 10; i++){
        BrowserUtils.sleep(1);
        js.executeScript("window.scrollBy(0, 15000)");

    }
                                          // -10000 for scroll upPage
    js.executeScript("window.scrollBy(0,-10000)");

    }

    @Test
    public void scrollTeslaTest(){

        driver.get("https://www.etsy.com/ca/");
        BrowserUtils.sleep(1);
        WebElement targetPage = driver.findElement(By.xpath("//h1[.='The Holiday Shop']"));

        // cast the driver to JavaScriptExecutor interface:
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // run js command
        js.executeScript("arguments[0].scrollIntoView(true)", targetPage);


    }

    @Test
    public void setValueUsingJSTest(){

        driver.get("https://www.etsy.com/ca/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='baby lamp'",searchBox);


    }


}

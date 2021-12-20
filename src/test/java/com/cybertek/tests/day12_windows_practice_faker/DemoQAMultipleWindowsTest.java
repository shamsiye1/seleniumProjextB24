package com.cybertek.tests.day12_windows_practice_faker;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoQAMultipleWindowsTest {

    String url = "https://demoqa.com/browser-windows";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void newWindowTest() throws InterruptedException {
        /*
        click on new window button
        switch to new window
        locate and print the message
        close the new window
        go back to main window

         */

        WebElement newWindowBtn = driver.findElement(By.cssSelector("button[id='windowButton']"));
        newWindowBtn.click();

        Thread.sleep(1000);
        // driver.close(); // close currently active window
        // driver.quit(); // closes all opened windows in same session

        Set<String> windowHandlesSet = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle(); // store current window handle

        for (String windowHandle : windowHandlesSet) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }

        }

        WebElement header = driver.findElement(By.cssSelector("#sampleHeading"));  //in CSS the # ==> id
        System.out.println("Header text: " + header.getText());

        Thread.sleep(1000);
        driver.close(); // only close current window

        // go back to parent window
        driver.switchTo().window(parentWindowHandle);
        System.out.println(driver.getTitle());
    }


}

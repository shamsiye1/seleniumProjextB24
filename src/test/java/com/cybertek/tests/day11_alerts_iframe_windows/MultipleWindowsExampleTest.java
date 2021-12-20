package com.cybertek.tests.day11_alerts_iframe_windows;

import com.cybertek.utils.WebDriverFactory;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowsExampleTest {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/windows";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }


    @Test
    public void windowsTest() {
        // get window handle of current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Window handle: " + mainWindowHandle);

        //click on new window
        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = " + windowHandles.size());
        System.out.println("windowHandles = " + windowHandles);

        // loop and switch to different window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            System.out.println("current window title: " + driver.getTitle());
        }

        WebElement h3Elem = driver.findElement(By.xpath("//h3"));
        System.out.println("h3 header text on new page = " + h3Elem.getText());

        // go back to main window/ parent window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("title after switching back to main window: " + driver.getTitle());


    }

    @Test
    public  void demoQaMultipleWindows(){
        driver.get("https://demoqa.com/browser-windows");

        WebElement newTab = driver.findElement(By.xpath("//button[@id='tabButton']"));
        WebElement  newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));

        newTab.click();
        newWindow.click();
        newWindowMessage.click();

        System.out.println("Title of main page: "+driver.getTitle());

        //store parent window handle id in a variable:
        String parentWindowHandle = driver.getWindowHandle();

        //store all window handle ids in to a Set
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("total window count: "+allWindowHandles.size());

        allWindowHandles.forEach(window -> {
            System.out.println("Switching to "+window);
            driver.switchTo().window(window);
            System.out.println("current window title: "+driver.getTitle());

        });


    }







}

package com.cybertek.tests.day09_testNG_dropdowns;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DropDownTests {

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Setting up WebDriver...");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);


    }

    @Test
    public void simpleDropDownTest(){
        //locate Select element
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        // create Select class object
        Select simpleDropDown= new Select(dropDown);
        simpleDropDown.selectByVisibleText("Option 1");

    }



    @Test
    public void titleTest(){
        System.out.println("Title of the page: "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice","actual and expect title wa s not match");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing browser");
        driver.quit();
    }




}

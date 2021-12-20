package com.cybertek.tests.day10_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUsedCarSearchTest {

    String url = "https://www.cargurus.com";
    WebDriver driver; // can use in every method

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(url);

    }

    @Test
    public void searchForMinivanTest() {
        String expTitle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
        Assert.assertEquals(driver.getTitle(), expTitle, "not in the correct page");

        //select Toyota
        Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));
        make.selectByVisibleText("Toyota");

        //select Sienna
        //
        Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect")));
        model.selectByValue("d308");

        //type zip code ex: 22101
        WebElement zipcode = driver.findElement(By.xpath("(//input[@name='zip'])[1]"));
        zipcode.sendKeys("22101");

        //print currently selected options of make and model
        System.out.println("Selected Make = " + make.getFirstSelectedOption().getText());
        System.out.println("Selected Model = " + model.getFirstSelectedOption().getText());

        //search bottom locate
        WebElement searchButton = driver.findElement(By.id("dealFinderForm_0"));
        searchButton.click();

        WebElement resultCount = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
        System.out.println("Result Count = " + resultCount.getText());

        //assert that count is more than 0
        int count = Integer.parseInt(resultCount.getText());
        Assert.assertTrue(count > 0, "invalid counting");


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}

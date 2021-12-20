package com.cybertek.homework;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarsDotComUserCarSearchTest {
    WebDriver driver;
    String url = "https://www.cars.com/";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test(priority = 1)
    public void defaultValuesTest() {
        //  System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com", "title was not match");

        WebElement carsIcon = driver.findElement(By.xpath("//img[@class='header-logo header-logo__img']"));
        Assert.assertTrue(carsIcon.isDisplayed(), "icon not displayed");

        Select newUsedCar = new Select(driver.findElement(By.id("make-model-search-stocktype")));
        newUsedCar.selectByVisibleText("New & used cars");
        Assert.assertEquals(newUsedCar.getFirstSelectedOption().getText(), "New & used cars", "first text isn't matching");

        Select make = new Select(driver.findElement(By.xpath("//select[@id='makes']")));
        make.selectByValue("mitsubishi");
        Assert.assertEquals(make.getFirstSelectedOption().getText(), "Mitsubishi");

        Select model = new Select(driver.findElement(By.name("models[]")));
        model.selectByVisibleText("Outlander");
        Assert.assertEquals(model.getFirstSelectedOption().getText(), "Outlander");

        Select price = new Select(driver.findElement(By.id("make-model-max-price")));
        price.selectByVisibleText("No max price");
        assertEquals(price.getFirstSelectedOption().getText(), "No max price");

        Select distance = new Select(driver.findElement(By.id("make-model-maximum-distance")));
        distance.selectByValue("20");
        assertEquals(distance.getFirstSelectedOption().getText(), "20 miles");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        //  System.out.println(zipcode.getAttribute("value")+ " equal with 14174");
        assertEquals(zipcode.getAttribute("value"), "14174");

    }

    @Test(priority = 2)
    public void usedTeslaSearchTest() throws InterruptedException {

        Select newOrUsed = new Select(driver.findElement(By.id("make-model-search-stocktype")));
        newOrUsed.selectByVisibleText("Used cars");

        Select make = new Select(driver.findElement(By.xpath("//select[@id='makes']")));
        make.selectByVisibleText("Tesla");

        Select model = new Select(driver.findElement(By.name("models[]")));
        model.selectByVisibleText("Model 3");

        Select price = new Select(driver.findElement(By.id("make-model-max-price")));
        price.selectByVisibleText("$50,000");

        Select distance = new Select(driver.findElement(By.id("make-model-maximum-distance")));
        distance.selectByValue("200");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        Thread.sleep(2000);
        zipcode.clear();
        zipcode.sendKeys("22102" + Keys.ENTER);
        // Thread.sleep(2000);

        // new page
        WebElement pageHeader = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        // System.out.println(pageHeader.getText());
        assertTrue(pageHeader.getText().contains("Tesla Model 3"), "header page don't contain tesla model 3");

        WebElement result = driver.findElement(By.xpath("(//span[@class='total-filter-count'])[2]"));
        //  System.out.println(result.getText());

        char[] resultArray = result.getText().toCharArray();
        String digitResult = "";
        for (char each : resultArray) {
            if (Character.isDigit(each)) {
                digitResult += each;

            }
        }


        int resultNum = Integer.parseInt(digitResult);
        // System.out.println(resultNum);
        assertTrue(resultNum > 200 && resultNum < 500, "result doesn't match");

        WebElement model3CheckBox = driver.findElement(By.xpath("//*[@id='model_tesla-model_3']"));
        Thread.sleep(2000);
        // System.out.println(model3CheckBox.getAttribute("checked"));
        assertTrue(model3CheckBox.isSelected());
        //   driver.findElement(By.xpath("//*[@id='model_tesla-model_3']/..")).click();


        //   System.out.println("model3CheckBox = " + model3CheckBox.getAttribute("checked"));


        WebElement modelSCheckBox = driver.findElement(By.xpath("//input[@id='model_tesla-model_s']"));
        assertFalse(modelSCheckBox.isSelected());

    }

    @Test(priority = 3)
    public void usedTeslaAdvancedSearchTest() throws InterruptedException {

        WebElement advancedSearchButton = driver.findElement(By.linkText("Advanced search"));
        advancedSearchButton.click();

        WebElement headerText = driver.findElement(By.className("sds-heading--1"));
        assertTrue(headerText.isDisplayed());

        Select distance = new Select(driver.findElement(By.id("desktop-location-select")));
        distance.selectByValue("500");

        Select newOrUsed = new Select(driver.findElement(By.xpath("//select[@id='desktop-stock-type-select']")));
        newOrUsed.selectByVisibleText("Used");

        Select make = new Select(driver.findElement(By.xpath("//select[@id='desktop-make_select']")));
        make.selectByVisibleText("Tesla");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='desktop-location-zip']"));
        zipcode.clear();
        Thread.sleep(1000);
        zipcode.sendKeys("22102");
        Thread.sleep(1000);

        List<WebElement> models = driver.findElements(By.xpath("//label[contains(@for,'desktop_tesla-model')]"));
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(500);
        for (WebElement model : models) {
            model.click();
            Thread.sleep(1000);
        }


        WebElement matchesButton = driver.findElement(By.xpath("//button[@class='sds-button desktop-form-button']"));
        matchesButton.click();

        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("zip=22102"));
        Thread.sleep(500);
        assertTrue(driver.findElement(By.xpath("//option[@value='best_match_desc']")).isDisplayed());

        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='sort-dropdown']")));
        sortBy.selectByVisibleText("Lowest price");

        //<h2 class="title">2013 Tesla Model S Base</h2>
        WebElement carTitle = driver.findElement(By.xpath("//div[@id='vehicle-cards-container']/div[2]//*[contains(text(),'Tesla Model')]"));
        System.out.println("Car title is: " + carTitle.getText());

//<div class="mileage">86,657 mi.</div>
        WebElement mileage = driver.findElement(By.xpath("//div[@id='vehicle-cards-container']/div[2]//*[contains(text(),'mi.')]"));
        System.out.println("Mileage: " + mileage.getText());

        //<span class="primary-price">$29,900</span>
        WebElement price = driver.findElement(By.xpath("//*[@id='vehicle-cards-container']/div[2]//span[contains(text(),'$')]"));
        System.out.println("Price: " + price.getText());


    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

package com.cybertek.homework.testCase2;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.OfficeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewPlaceOrderTest extends TestBase {

    int expPrice;

    @Test
    public void placeOrder() {

        //gets Url OF THE PAGE;
        driver.get(ConfigurationReader.getProperty("webOrder.url"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(OfficeUtils.getLink("Laptops")));

        // adding laptops sony vaio i7
        expPrice += OfficeUtils.addProduct("Laptops", "Sony vaio i7");

        BrowserUtils.sleep(1);
        //adding iphone
        expPrice += OfficeUtils.addProduct("Phones", "Iphone 6 32gb");

        //adding monitor
        expPrice += OfficeUtils.addProduct("Monitors", "Apple monitor 24");

        System.out.println(expPrice);

        OfficeUtils.getLink("Cart").click();

        OfficeUtils.getDeleteBtn("Iphone 6 32gb").click();

        BrowserUtils.sleep(1);

        WebElement placeOrderBtn = driver.findElement(By.xpath("//button[.='Place Order']"));
        placeOrderBtn.click();


        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys(faker.name().fullName());

        WebElement country = driver.findElement(By.xpath("//input[@id='country']"));
        country.sendKeys(faker.country().name());

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys(faker.address().cityName());

        WebElement creditCard = driver.findElement(By.xpath("//input[@id='card']"));
        creditCard.sendKeys(faker.finance().creditCard());

        WebElement month = driver.findElement(By.xpath("//input[@id='month']"));
        month.sendKeys("05");

        WebElement year = driver.findElement(By.xpath("//input[@id='year']"));
        year.sendKeys("2020");

        WebElement purchaseBtn = driver.findElement(By.xpath("//button[.='Purchase']"));
        purchaseBtn.click();


    }


}

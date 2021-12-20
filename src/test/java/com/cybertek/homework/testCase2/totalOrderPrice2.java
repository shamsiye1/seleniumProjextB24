package com.cybertek.homework.testCase2;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class totalOrderPrice2 {

    String url = "https://www.demoblaze.com/index.html#";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void totalOrderPriceCalculator_2() throws InterruptedException {

        WebElement laptop = driver.findElement(By.xpath("//a[.='Laptops']"));
        laptop.click();
        Thread.sleep(3000);
        WebElement sonyLink = driver.findElement(By.linkText("Sony vaio i7"));
        sonyLink.click();

        WebElement addCartButton = driver.findElement(By.xpath("//a[.='Add to cart']"));
        addCartButton.click();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        alert.accept();

        Thread.sleep(1000);

        WebElement homepage = driver.findElement(By.xpath("(//a[@id='nava'])"));

        homepage.click();
        Thread.sleep(2000);

        WebElement phones = driver.findElement(By.xpath("//a[.='Phones']"));
        phones.click();
        Thread.sleep(2000);

        WebElement iphone32 = driver.findElement(By.xpath("//a[.='Iphone 6 32gb']"));
        iphone32.click();

        WebElement addCart1 = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
        addCart1.click();

        Thread.sleep(2000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        WebElement backToCart = driver.findElement(By.id("cartur"));
        backToCart.click();

        WebElement totalPrice = driver.findElement(By.id("totalp"));
        Thread.sleep(2000);
        System.out.println("total price: " + totalPrice.getText());
        System.out.println("total price: " + totalPrice.isDisplayed());
      int total = Integer.parseInt(totalPrice.getText());
        System.out.println(total);

        WebElement laptopPrice = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tr/td[3]"));
        int laptopPriceInt = Integer.parseInt(laptopPrice.getText());

        WebElement iphonePrice = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tr[2]/td[3]"));
        int  iphonePriceInt = Integer.parseInt(iphonePrice.getText());

        Assert.assertEquals(total, iphonePriceInt+laptopPriceInt,"does not equal to 1580");


    }




}

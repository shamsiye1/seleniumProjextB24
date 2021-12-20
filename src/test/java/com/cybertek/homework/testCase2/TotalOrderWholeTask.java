package com.cybertek.homework.testCase2;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TotalOrderWholeTask extends TestBase {

    @Test
    public void webSiteOrderConfirmation() {

        driver.get(ConfigurationReader.getProperty("webOrder.url"));

        WebElement laptop = driver.findElement(By.xpath("//a[.='Laptops']"));
        laptop.click();
        BrowserUtils.sleep(2);
        WebElement sonyLink = driver.findElement(By.linkText("Sony vaio i7"));
        sonyLink.click();

        WebElement addCartButton = driver.findElement(By.xpath("//a[.='Add to cart']"));
        addCartButton.click();

        BrowserUtils.sleep(2);
        Alert alert = driver.switchTo().alert();

        alert.accept();

        BrowserUtils.sleep(2);

        WebElement homepage = driver.findElement(By.xpath("(//a[@id='nava'])"));

        homepage.click();
        BrowserUtils.sleep(2);

        WebElement phones = driver.findElement(By.xpath("//a[.='Phones']"));
        phones.click();
        BrowserUtils.sleep(2);

        WebElement iphone32 = driver.findElement(By.xpath("//a[.='Iphone 6 32gb']"));
        iphone32.click();

        WebElement addCart1 = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
        addCart1.click();

        BrowserUtils.sleep(2);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        WebElement backToHomepage = driver.findElement(By.xpath("//a[@class='nav-link']"));
        backToHomepage.click();


        WebElement monitor = driver.findElement(By.linkText("Monitors"));
        monitor.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");

        WebElement mac = driver.findElement(By.linkText("Apple monitor 24"));
        mac.click();

        BrowserUtils.sleep(2);

        WebElement addCart3 = driver.findElement(By.xpath("//a[.='Add to cart']"));
        addCart3.click();

        BrowserUtils.sleep(2);
        Alert alert3 = driver.switchTo().alert();
        alert3.accept();


        WebElement backToCart = driver.findElement(By.id("cartur"));
        backToCart.click();

        BrowserUtils.sleep(2);
        //  js.executeScript("window.scrollBy(0,10000)");

        System.out.println(getDeleteBtn("Iphone 6 32gb").getText());
       // getDeleteBtn("Iphone 6 32gb").click();

      WebElement delete = getDeleteBtn("Iphone 6 32gb");


//        WebElement placeOrderBtn = driver.findElement(By.className("btn btn-success"));
//        placeOrderBtn.click();

    }

    public WebElement getDeleteBtn(String deleteItem) {

        String deleteBtnXpath = "//*[contains(text(),'" + deleteItem + "')]/../td[.='Delete']/a";
        return driver.findElement(By.xpath(deleteBtnXpath));
    }


}

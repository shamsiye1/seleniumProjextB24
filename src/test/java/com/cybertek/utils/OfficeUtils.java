package com.cybertek.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfficeUtils {

    static Alert alert; // declare a static alert object   // why we do it static because we use this object in static method


    public static WebElement getLink(String linkName) {

        return Driver.getDriver().findElement(By.partialLinkText(linkName));

    }

    // addProduct (String category, String product), return an integer value which is product price
    // also add the product to my Cart

    public static int addProduct(String categoryName, String productName) {

        getLink(categoryName).click();
        getLink(productName).click();

        // getting the product's price
        WebElement priceContainer = Driver.getDriver().findElement(By.xpath("//h3"));
        int productsPrice = Integer.parseInt(priceContainer.getText().substring(1, 4));

        // click on add to cart
        getLink("Add to cart").click();

        BrowserUtils.sleep(2);
        alert = Driver.getDriver().switchTo().alert();  // initialize the object
        alert.accept();
        getLink("Home").click();

        return productsPrice;
    }

    public static WebElement getDeleteBtn(String deleteItem) {

        String deleteBtnXpath = "//*[contains(text(),'" + deleteItem + "')]/../td[.='Delete']/a";
        return Driver.getDriver().findElement(By.xpath(deleteBtnXpath));
    }

    public static void fillForm(){









    }





}





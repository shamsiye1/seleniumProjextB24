package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class CheckBoxesWithImplicitWait {
    public static void main(String[] args) {

        String appUrl = "http://practice.cybertekschool.com/checkboxes";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(appUrl);

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox1.click();

        // uncheck sechond checkbox
        //<input type="checkbox" name="checkbox2" id="box2" checked="">
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        checkbox2.click();

        if (!checkbox2.isSelected()) {
            System.out.println("checkbox is not checked");
            checkbox2.click();

        } else {
            System.out.println("checkbox is checked");
        }


    }
}

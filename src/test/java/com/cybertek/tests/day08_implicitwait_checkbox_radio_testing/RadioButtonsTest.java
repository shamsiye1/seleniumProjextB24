package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //<input type="radio" id="blue" name="color" checked="">
        WebElement blue = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));

        if (!blue.isSelected()) {
            System.out.println("not selected");
            blue.click();
        } else {
            System.out.println("test passed!!");
        }

//       <input type="radio" id="water_polo" name="sport">
        WebElement waterPolo = driver.findElement(By.id("water_polo"));
        if (!waterPolo.isSelected()) {
            System.out.println("selected by code");
            waterPolo.click();

        } else {
            System.out.println("test pass");
        }

        //find all radio buttons

        List<WebElement> radioButtons= driver.findElements(By.xpath("//input[@type='radio']"));

        //print the count
        System.out.println(radioButtons.size());

        // click one by one, waiting 1 second   //we can use isEnabled method to check if element is active/disabled
        for (WebElement eachButton: radioButtons){
            if(eachButton.isEnabled()){
                eachButton.click();
            }

            Thread.sleep(1000);
        }











    }
}

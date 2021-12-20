package com.cybertek.tests.day07_FindElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationFormInputFields {

    public static void main(String[] args) {

        String appUrl = "https://form.jotform.com/213106431512137";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get(appUrl);


        List<WebElement> inputFields = driver.findElements(By.cssSelector("input[type='text']"));

        System.out.println(inputFields.size());

        inputFields.forEach(eachInput -> eachInput.sendKeys("wooden spoon"));

        for (WebElement eachInput : inputFields) {

            if (eachInput.isDisplayed()) {
                eachInput.sendKeys("wooden spoon");
            }

        }

        for (int i = 0; i < inputFields.size() - 1; i++) {
            inputFields.get(i).sendKeys("wooden spoon");
        }


        driver.quit();


    }


}
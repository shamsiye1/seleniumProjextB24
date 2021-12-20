package com.cybertek.homework;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MerriamWebster_FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.merriam-webster.com/ ");

//        3. Print out the texts of all links

        List<WebElement> totalTextLinks = driver.findElements(By.cssSelector("a"));

        for (WebElement eachLink : totalTextLinks) {
            System.out.println(eachLink.getText());
        }

        System.out.println(totalTextLinks.size());

        //        4. Print out how many link is missing text

        List missingTextList = new ArrayList();

        for (WebElement eachLink : totalTextLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                missingTextList.add(eachLink);
            }
        }
        System.out.println(missingTextList.size() + " link is missing text");

        List hasText = new ArrayList();

        for (WebElement eachLink : totalTextLinks) {
            if (eachLink.getText() != null || !eachLink.getText().isEmpty()) {
                hasText.add(eachLink);
            }
        }
        System.out.println(hasText + " links has text");
//        5. Print out how many link has text


        System.out.println(totalTextLinks.size() - missingTextList.size() + " has text");


//        6. Print out how many total link
        System.out.println(totalTextLinks.size() + " total links is Web");

        Thread.sleep(3000);
        driver.quit();


    }
}

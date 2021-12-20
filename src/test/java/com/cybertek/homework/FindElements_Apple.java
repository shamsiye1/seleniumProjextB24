package com.cybertek.homework;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindElements_Apple {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

//        3. Click to iPhone
        //<a class="ac-gn-link ac-gn-link-iphone" href="/ca/iphone/" data-analytics-title="iphone">
        //					<span class="ac-gn-link-text">iPhone</span>
        //				</a>
        WebElement iphoneButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iphoneButton.click();

//        4. Print out the texts of all links
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
        }
        System.out.println(allLinks.size());

        // 5. Print out how many link is missing text
        List list = new ArrayList();
        for (WebElement eachLink : allLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {

                list.add(eachLink);
            }
        }
        System.out.println(list.size() + " links is missing text");

//        6. Print out how many link has text
        List<WebElement> hasText = new ArrayList<>();

        for (WebElement eachLink : allLinks) {
            if (eachLink.getText() != null || !eachLink.getText().isEmpty()) {
                hasText.add(eachLink);
            }

        }
        System.out.println(hasText.size() + " links has text");
//        7. Print out how many total link
        System.out.println("Total link number is " + allLinks.size());


        Thread.sleep(3000);
        driver.quit();
    }
}

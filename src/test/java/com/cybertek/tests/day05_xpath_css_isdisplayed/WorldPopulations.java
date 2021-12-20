package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.awt.windows.ThemeReader;

public class WorldPopulations {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.worldometers.info/world-population/");

        Thread.sleep(4000);


        WebElement currentPop= driver.findElement(By.xpath("//div[@class='maincounter-number']"));
    //    WebElement currentPop= driver.findElement(By.className("maincounter-number"));
        System.out.println(currentPop.getText());

        for (int i=1; i <=10; i++){

            Thread.sleep(1000);
            System.out.println(i+" - "+currentPop.getText());
        }
      driver.quit();
    }
}

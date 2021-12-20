package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P3_AmazonCSSPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        String appUrl="https://www.amazon.com";
        driver.manage().window().maximize();

        driver.get(appUrl);

        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="搜索">

        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("dior body milk"+ Keys.ENTER);

       // driver.findElement(By.cssSelector("input[value='go']"));  // this way also work

        String expTitle="dior body milk";
        String actTitle=driver.getTitle();

        if (actTitle.contains(expTitle)){
            System.out.println(driver.getTitle()+" is matched with expected title");
        }else {
            System.out.println("result don't match");
        }

//  <input type="text" id="twotabsearchtextbox" value="dior body milk" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="搜索">

        driver.findElement(By.cssSelector("input[value='dior body milk']")).clear();

        driver.findElement(By.cssSelector("input[autocomplete='off']")).sendKeys("iphone13 wooden spoon case"+Keys.ENTER);

















        Thread.sleep(5000);
       // driver.close();

    }
}

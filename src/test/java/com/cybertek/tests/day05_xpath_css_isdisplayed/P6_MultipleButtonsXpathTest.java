package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_MultipleButtonsXpathTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        WebElement button1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button1.click();
        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='button2()']"));
        button2.click();
        System.out.println(button1.getText());
        System.out.println(button2.getText());

        WebElement resultMSG = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(resultMSG.getText());

        WebElement result = driver.findElement(By.xpath("//h4[@class='h4']"));

        System.out.println(result.getText());

        //Locate button2 using xpath and check if it is currently displayed on the page, then click oon it
        //<button class="btn btn-primary" onclick="button3()" id="button_btn324">Button 3</button>
        WebElement button3 = driver.findElement(By.xpath("//button[text()='Button 3']"));
        // or we write like this: //button[.()='Button 3']

        if (button3.isDisplayed()) {
            System.out.println("PASS: Button3 is displayed");
            button3.click();
        } else {
            System.out.println("FAILED!! Button2 is not displayed");
        }


        Thread.sleep(5000);
        driver.quit();


    }
}
